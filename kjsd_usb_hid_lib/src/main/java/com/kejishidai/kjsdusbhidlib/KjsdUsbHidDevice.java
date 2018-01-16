package com.kejishidai.kjsdusbhidlib;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import java.util.Arrays;
import java.util.Locale;

/**
 * Created by stephen on 2018/1/16.
 */

public class KjsdUsbHidDevice {

    private static KjsdUsbHidDevice kjsd_usb_hid_device_instance;

    private enum DeviceType { KJSD_USB_HID_KEYBOARD, KJSD_USB_HID_MOUSE};
    private KjsdUsbHidKeyboard kjsd_usb_hid_keyboard = null;

    private static final String SP_USB_HID_LANGUAGE_KEY = "KjsdUsbKeyboardLanguage";

    //获取USB HID设备实例，支持多线程环境下使用
    public static KjsdUsbHidDevice getInstance()
    {
        if(kjsd_usb_hid_device_instance == null)
        {
            synchronized(KjsdUsbHidDevice.class){
                if(kjsd_usb_hid_device_instance == null){
                    kjsd_usb_hid_device_instance = new KjsdUsbHidDevice(KjsdUsbHidDevice.DeviceType.KJSD_USB_HID_KEYBOARD);
                }
            }
        }
        return kjsd_usb_hid_device_instance;
    }

    private KjsdUsbHidDevice(DeviceType device_type)
    {
        if(device_type == KjsdUsbHidDevice.DeviceType.KJSD_USB_HID_KEYBOARD)
        {
            kjsd_usb_hid_keyboard = new KjsdUsbHidKeyboard_en_US();
        }
    }

    //同步打开USB HID键盘设备
    public synchronized boolean openDevice()
    {
        if(kjsd_usb_hid_keyboard != null)
        {
            return kjsd_usb_hid_keyboard.openKeyboard();
        }
        return false;
    }

    //同步向USB HID键盘设备发送键盘描述字符串，该字符串表示键盘的一次输入，修饰符和同时按下的键采用空格进行分隔
    //示例："a"表示按下a键，"left-shit a"表示同时按下左侧shift键和a键，"capslock"表示按下大写锁定键，"right-ctrl right-shift right-alt"表示同时按下右侧ctrl shift和alt键
    public synchronized boolean sendKey(String key)
    {
        if(kjsd_usb_hid_keyboard != null)
        {
            return kjsd_usb_hid_keyboard.sendKey(key);
        }
        return false;
    }

    //调试过程中使用用于获取当前输入字符串对应的键盘扫描码数组
    public synchronized byte[] getScancode(String key)
    {
        byte[] result = new byte[8];
        Arrays.fill(result, (byte)0xFF);
        if(kjsd_usb_hid_keyboard != null)
        {
            result = kjsd_usb_hid_keyboard.getScancode(key);
        }
        return result;
    }

    //同步关闭USB HID键盘设备
    public synchronized boolean closeDevice()
    {
        if(kjsd_usb_hid_keyboard != null)
        {
            return kjsd_usb_hid_keyboard.closeKeyboard();
        }
        return false;
    }

    //预留用于支持不同语言类型的键盘，获取当前键盘的语言类型，目前仅支持"en_US美式键盘"
    private synchronized KjsdUsbHidKeyboardLangType.Language getKeyboardLanguage(Context context)
    {
        String prefLangStr = PreferenceManager.getDefaultSharedPreferences(context).getString(SP_USB_HID_LANGUAGE_KEY, "en_US");
        if(prefLangStr.equals("null")){
            prefLangStr = Locale.getDefault().toString();
        }
        KjsdUsbHidKeyboardLangType.Language language;
        try{
            language = KjsdUsbHidKeyboardLangType.Language.valueOf(prefLangStr);
        }catch(IllegalArgumentException e){
            language = KjsdUsbHidKeyboardLangType.Language.en_US;
        }
        return language;
    }

    //预留用于支持不同语言类型的键盘，设置当前键盘的语言类型，目前仅支持"en_US美式键盘"
    private synchronized boolean setKeyboardLanguage(Context context, KjsdUsbHidKeyboardLangType.Language language)
    {
        if(kjsd_usb_hid_keyboard != null)
        {
            SharedPreferences.Editor spEditor = PreferenceManager.getDefaultSharedPreferences(context).edit();
            spEditor.putString(SP_USB_HID_LANGUAGE_KEY, language.toString());
            spEditor.apply();
            return true;
        }
        return false;
    }
}

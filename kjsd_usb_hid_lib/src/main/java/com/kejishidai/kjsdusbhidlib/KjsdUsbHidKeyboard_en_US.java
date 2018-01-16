package com.kejishidai.kjsdusbhidlib;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by stephen on 2018/1/16.
 */

public class KjsdUsbHidKeyboard_en_US extends KjsdUsbHidKeyboard{

    protected FileOutputStream usb_hid_keyboard_device = null;

    public KjsdUsbHidKeyboard_en_US()
    {
        keyboardDevicePath = "/dev/hidg0";

        keyboardModifier.put("left-ctrl", new Byte((byte)0x01));
        keyboardModifier.put("right-ctrl", new Byte((byte)0x10));
        keyboardModifier.put("left-shift", new Byte((byte)0x02));
        keyboardModifier.put("right-shift", new Byte((byte)0x20));
        keyboardModifier.put("left-alt", new Byte((byte)0x04));
        keyboardModifier.put("right-alt", new Byte((byte)0x40));
        keyboardModifier.put("left-meta", new Byte((byte)0x08));
        keyboardModifier.put("right-meta", new Byte((byte)0x80));

        keyboardValue.put(null,new Byte((byte)0x00));
        keyboardValue.put("a",new Byte((byte)0x04));
        keyboardValue.put("b",new Byte((byte)0x05));
        keyboardValue.put("c",new Byte((byte)0x06));
        keyboardValue.put("d",new Byte((byte)0x07));
        keyboardValue.put("e",new Byte((byte)0x08));
        keyboardValue.put("f",new Byte((byte)0x09));
        keyboardValue.put("g",new Byte((byte)0x0a));
        keyboardValue.put("h",new Byte((byte)0x0b));
        keyboardValue.put("i",new Byte((byte)0x0c));
        keyboardValue.put("j",new Byte((byte)0x0d));
        keyboardValue.put("k",new Byte((byte)0x0e));
        keyboardValue.put("l",new Byte((byte)0x0f));
        keyboardValue.put("m",new Byte((byte)0x10));
        keyboardValue.put("n",new Byte((byte)0x11));
        keyboardValue.put("o",new Byte((byte)0x12));
        keyboardValue.put("p",new Byte((byte)0x13));
        keyboardValue.put("q",new Byte((byte)0x14));
        keyboardValue.put("r",new Byte((byte)0x15));
        keyboardValue.put("s",new Byte((byte)0x16));
        keyboardValue.put("t",new Byte((byte)0x17));
        keyboardValue.put("u",new Byte((byte)0x18));
        keyboardValue.put("v",new Byte((byte)0x19));
        keyboardValue.put("w",new Byte((byte)0x1a));
        keyboardValue.put("x",new Byte((byte)0x1b));
        keyboardValue.put("y",new Byte((byte)0x1c));
        keyboardValue.put("z",new Byte((byte)0x1d));
        keyboardValue.put("1",new Byte((byte)0x1e));
        keyboardValue.put("2",new Byte((byte)0x1f));
        keyboardValue.put("3",new Byte((byte)0x20));
        keyboardValue.put("4",new Byte((byte)0x21));
        keyboardValue.put("5",new Byte((byte)0x22));
        keyboardValue.put("6",new Byte((byte)0x23));
        keyboardValue.put("7",new Byte((byte)0x24));
        keyboardValue.put("8",new Byte((byte)0x25));
        keyboardValue.put("9",new Byte((byte)0x26));
        keyboardValue.put("0",new Byte((byte)0x27));
        keyboardValue.put("return",new Byte((byte)0x28));
        keyboardValue.put("enter",new Byte((byte)0x28));
        keyboardValue.put("esc",new Byte((byte)0x29));
        keyboardValue.put("escape",new Byte((byte)0x29));
        keyboardValue.put("bckspc",new Byte((byte)0x2a));
        keyboardValue.put("backspace",new Byte((byte)0x2a));
        keyboardValue.put("tab",new Byte((byte)0x2b));
        keyboardValue.put("space",new Byte((byte)0x2c));
        keyboardValue.put("minus",new Byte((byte)0x2d));
        keyboardValue.put("dash",new Byte((byte)0x2d));
        keyboardValue.put("equals",new Byte((byte)0x2e));
        keyboardValue.put("equal",new Byte((byte)0x2e));
        keyboardValue.put("lbracket",new Byte((byte)0x2f));
        keyboardValue.put("rbracket",new Byte((byte)0x30));
        keyboardValue.put("backslash",new Byte((byte)0x31));
        keyboardValue.put("hash",new Byte((byte)0x32));
        keyboardValue.put("number",new Byte((byte)0x32));
        keyboardValue.put("semicolon",new Byte((byte)0x33));
        keyboardValue.put("quote",new Byte((byte)0x34));
        keyboardValue.put("backquote",new Byte((byte)0x35));
        keyboardValue.put("tilde",new Byte((byte)0x35));
        keyboardValue.put("comma",new Byte((byte)0x36));
        keyboardValue.put("period",new Byte((byte)0x37));
        keyboardValue.put("stop",new Byte((byte)0x37));
        keyboardValue.put("slash",new Byte((byte)0x38));
        keyboardValue.put("caps-lock",new Byte((byte)0x39));
        keyboardValue.put("capslock",new Byte((byte)0x39));
        keyboardValue.put("f1",new Byte((byte)0x3a));
        keyboardValue.put("f2",new Byte((byte)0x3b));
        keyboardValue.put("f3",new Byte((byte)0x3c));
        keyboardValue.put("f4",new Byte((byte)0x3d));
        keyboardValue.put("f5",new Byte((byte)0x3e));
        keyboardValue.put("f6",new Byte((byte)0x3f));
        keyboardValue.put("f7",new Byte((byte)0x40));
        keyboardValue.put("f8",new Byte((byte)0x41));
        keyboardValue.put("f9",new Byte((byte)0x42));
        keyboardValue.put("f10",new Byte((byte)0x43));
        keyboardValue.put("f11",new Byte((byte)0x44));
        keyboardValue.put("f12",new Byte((byte)0x45));
        keyboardValue.put("print",new Byte((byte)0x46));
        keyboardValue.put("scroll-lock",new Byte((byte)0x47));
        keyboardValue.put("scrolllock",new Byte((byte)0x47));
        keyboardValue.put("pause",new Byte((byte)0x48));
        keyboardValue.put("insert",new Byte((byte)0x49));
        keyboardValue.put("home",new Byte((byte)0x4a));
        keyboardValue.put("pageup",new Byte((byte)0x4b));
        keyboardValue.put("pgup",new Byte((byte)0x4b));
        keyboardValue.put("del",new Byte((byte)0x4c));
        keyboardValue.put("delete",new Byte((byte)0x4c));
        keyboardValue.put("end",new Byte((byte)0x4d));
        keyboardValue.put("pagedown",new Byte((byte)0x4e));
        keyboardValue.put("pgdown",new Byte((byte)0x4e));
        keyboardValue.put("right",new Byte((byte)0x4f));
        keyboardValue.put("left",new Byte((byte)0x50));
        keyboardValue.put("down",new Byte((byte)0x51));
        keyboardValue.put("up",new Byte((byte)0x52));
        keyboardValue.put("num-lock",new Byte((byte)0x53));
        keyboardValue.put("numlock",new Byte((byte)0x53));
        keyboardValue.put("kp-divide",new Byte((byte)0x54));
        keyboardValue.put("kp-multiply",new Byte((byte)0x55));
        keyboardValue.put("kp-minus",new Byte((byte)0x56));
        keyboardValue.put("kp-plus",new Byte((byte)0x57));
        keyboardValue.put("kp-enter",new Byte((byte)0x58));
        keyboardValue.put("kp-return",new Byte((byte)0x58));
        keyboardValue.put("kp-1",new Byte((byte)0x59));
        keyboardValue.put("kp-2",new Byte((byte)0x5a));
        keyboardValue.put("kp-3",new Byte((byte)0x5b));
        keyboardValue.put("kp-4",new Byte((byte)0x5c));
        keyboardValue.put("kp-5",new Byte((byte)0x5d));
        keyboardValue.put("kp-6",new Byte((byte)0x5e));
        keyboardValue.put("kp-7",new Byte((byte)0x5f));
        keyboardValue.put("kp-8",new Byte((byte)0x60));
        keyboardValue.put("kp-9",new Byte((byte)0x61));
        keyboardValue.put("kp-0",new Byte((byte)0x62));
        keyboardValue.put("kp-period",new Byte((byte)0x63));
        keyboardValue.put("kp-stop",new Byte((byte)0x63));
        keyboardValue.put("application",new Byte((byte)0x65));
        keyboardValue.put("power",new Byte((byte)0x66));
        keyboardValue.put("kp-equals",new Byte((byte)0x67));
        keyboardValue.put("kp-equal",new Byte((byte)0x67));
        keyboardValue.put("f13",new Byte((byte)0x68));
        keyboardValue.put("f14",new Byte((byte)0x69));
        keyboardValue.put("f15",new Byte((byte)0x6a));
        keyboardValue.put("f16",new Byte((byte)0x6b));
        keyboardValue.put("f17",new Byte((byte)0x6c));
        keyboardValue.put("f18",new Byte((byte)0x6d));
        keyboardValue.put("f19",new Byte((byte)0x6e));
        keyboardValue.put("f20",new Byte((byte)0x6f));
        keyboardValue.put("f21",new Byte((byte)0x70));
        keyboardValue.put("f22",new Byte((byte)0x71));
        keyboardValue.put("f23",new Byte((byte)0x72));
        keyboardValue.put("f24",new Byte((byte)0x73));
        keyboardValue.put("execute",new Byte((byte)0x74));
        keyboardValue.put("help",new Byte((byte)0x75));
        keyboardValue.put("menu",new Byte((byte)0x76));
        keyboardValue.put("select",new Byte((byte)0x77));
        keyboardValue.put("cancel",new Byte((byte)0x78));
        keyboardValue.put("redo",new Byte((byte)0x79));
        keyboardValue.put("undo",new Byte((byte)0x7a));
        keyboardValue.put("cut",new Byte((byte)0x7b));
        keyboardValue.put("copy",new Byte((byte)0x7c));
        keyboardValue.put("paste",new Byte((byte)0x7d));
        keyboardValue.put("find",new Byte((byte)0x7e));
        keyboardValue.put("mute",new Byte((byte)0x7f));
        keyboardValue.put("volume-up",new Byte((byte)0x80)); // These are multimedia keys, they will not work on standard keyboard, they need a different USB descriptor
        keyboardValue.put("volume-down",new Byte((byte)0x81));
    }

    public boolean openKeyboard(){
        boolean result = false;
        if(keyboardDevicePath != null && !keyboardDevicePath.isEmpty()){
            if(usb_hid_keyboard_device != null){
                try{
                    usb_hid_keyboard_device.close();
                }catch (IOException e){
                    result = false;
                    return result;
                }
            }
            try {
                usb_hid_keyboard_device = new FileOutputStream(keyboardDevicePath, true);
            }catch (FileNotFoundException e){
                result = false;
                return result;
            }
            result = true;
        }
        return result;
    }

    public boolean sendKey(String key){
        byte[] emptyScanCode = new byte[8];
        byte[] scanCode = getScancode(key);
        if(scanCode != null && !Arrays.equals(scanCode, emptyScanCode)){
            return sendScancode(scanCode);
        }else{
            return false;
        }
    }

    public boolean closeKeyboard(){
        boolean result = true;
        if(usb_hid_keyboard_device != null){
            try{
                usb_hid_keyboard_device.close();
            }catch (IOException e){
                result = false;
            }
        }
        return result;
    }

    protected boolean clearKeyboard()
    {
        boolean result = false;
        byte[] scanCode = new byte[8];
        if(usb_hid_keyboard_device != null){
            try{
                usb_hid_keyboard_device.write(scanCode);
                result = true;
            }catch (IOException e){
                result = false;
            }
        }
        return result;
    }

    protected boolean sendScancode(byte[] scanCode)
    {
        boolean result = false;
        if(usb_hid_keyboard_device != null){
            try{
                usb_hid_keyboard_device.write(scanCode);
                clearKeyboard();
                result = true;
            }catch (IOException e){
                result = false;
            }
        }
        return result;
    }

    public byte[] getScancode(String key){
        byte[] scanCode = new byte[8];
        if(key != null && !key.isEmpty()){
            int scanCodeDataIndex = 2;
            StringTokenizer st = new StringTokenizer(key);
            while(st.hasMoreTokens()){
                String tokenKey = st.nextToken();
                Byte tokenData = null;
                if((tokenData = keyboardModifier.get(tokenKey)) != null) {
                    scanCode[0] |= tokenData.byteValue();
                }else if((tokenData = keyboardValue.get(tokenKey)) != null && scanCodeDataIndex < 8){
                    scanCode[scanCodeDataIndex] = tokenData.byteValue();
                    scanCodeDataIndex++;
                    if(scanCodeDataIndex >= 8)
                        break;
                }else{
                    Arrays.fill(scanCode, (byte)0x0);
                    break;
                }
            }
        }
        return scanCode;
    }
}

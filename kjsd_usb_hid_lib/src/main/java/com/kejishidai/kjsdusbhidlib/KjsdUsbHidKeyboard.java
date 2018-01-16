package com.kejishidai.kjsdusbhidlib;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by stephen on 2018/1/15.
 */

public abstract class KjsdUsbHidKeyboard{

    protected String keyboardDevicePath = null;
    protected Map<String, Byte> keyboardModifier= new HashMap<String, Byte>();
    protected Map<String, Byte> keyboardValue= new HashMap<String, Byte>();

    public abstract boolean openKeyboard();
    public abstract byte[] getScancode(String key);
    public abstract boolean sendKey(String key);
    public abstract boolean closeKeyboard();
}

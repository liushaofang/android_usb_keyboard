package com.kejishidai.kjsdusbhiddevice;

import android.app.Activity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.kejishidai.kjsdusbhidlib.KjsdUsbHidDevice;

public class KjsdUsbHidDemoActivity extends Activity implements View.OnClickListener{

    private EditText etInputKeyDesc = null;
    private Button btnOpenHid = null;
    private Button btnSendKey = null;
    private Button btnCloseHid = null;
    private Button btnExitApp = null;
    private TextView tvInputDetails = null;
    private KjsdUsbHidDevice kjsdUsbHidDevice = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
        setContentView(R.layout.activity_kjsd_usb_hid_demo);
        getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE,R.layout.title_kjsd_usb_hid_demo);

        etInputKeyDesc = (EditText)findViewById(R.id.EtInputKeyDesc);
        btnOpenHid = (Button)findViewById(R.id.BtnOpenHid);
        btnSendKey = (Button)findViewById(R.id.BtnSendKey);
        btnCloseHid = (Button)findViewById(R.id.BtnCloseHid);
        btnExitApp = (Button)findViewById(R.id.BtnExitApp);
        tvInputDetails = (TextView) findViewById(R.id.TvInputDetails);
        tvInputDetails.setMovementMethod(ScrollingMovementMethod.getInstance());

        kjsdUsbHidDevice.getInstance().openDevice();

        btnOpenHid.setOnClickListener(this);
        btnSendKey.setOnClickListener(this);
        btnCloseHid.setOnClickListener(this);
        btnExitApp.setOnClickListener(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        kjsdUsbHidDevice.getInstance().closeDevice();
    }

    @Override
    public void onClick(View v) {
        boolean result = false;
        String strDisplayText = "";
        if(v.getId() == R.id.BtnOpenHid){
            result = kjsdUsbHidDevice.getInstance().openDevice();
            if(result) {
                strDisplayText = "设备打开成功.\n";
            }else{
                strDisplayText = "设备打开失败.\n";
            }
            tvInputDetails.append(strDisplayText);
        }else if(v.getId() == R.id.BtnSendKey){
            String strInputKeyDesc = etInputKeyDesc.getText().toString();
            byte[] baScancode = kjsdUsbHidDevice.getInstance().getScancode(strInputKeyDesc);
            strDisplayText = "扫描码："+getHexString(baScancode);
            result = kjsdUsbHidDevice.getInstance().sendKey(strInputKeyDesc);
            if(result){
                strDisplayText += "发送成功.\n";
            }else{
                strDisplayText += "发送失败.\n";
            }
            tvInputDetails.append(strDisplayText);
            int tvInputDetailsOffset = tvInputDetails.getLineCount() * tvInputDetails.getLineHeight();
            if(tvInputDetailsOffset > tvInputDetails.getHeight()){
                tvInputDetails.scrollTo(0, tvInputDetailsOffset - tvInputDetails.getHeight());
            }
        }else if(v.getId() == R.id.BtnCloseHid){
            result = kjsdUsbHidDevice.getInstance().closeDevice();
            if(result) {
                strDisplayText = "设备关闭成功.\n";
            }else{
                strDisplayText = "设备关闭失败.\n";
            }
            tvInputDetails.append(strDisplayText);
        }else if(v.getId() == R.id.BtnExitApp){
            this.finish();
        }
    }

    protected String getHexString(byte[] scancode)
    {
        String strResult = " ";
        for(int index = 0; index < scancode.length; index++){
            String btValue = Integer.toString(scancode[index] & 0xFF);
            if(btValue.length() == 1){
                btValue = "0"+btValue;
            }
            strResult += btValue + " ";
        }
        return strResult;
    }
}

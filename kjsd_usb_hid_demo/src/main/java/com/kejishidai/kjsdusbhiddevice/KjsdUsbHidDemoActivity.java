package com.kejishidai.kjsdusbhiddevice;

import android.app.Activity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.kejishidai.kjsdusbhidlib.KjsdUsbHidDevice;

public class KjsdUsbHidDemoActivity extends Activity implements View.OnClickListener{

    private EditText etInputKeyDesc = null;
    private Button btnSendKey = null;
    private TextView tvInputDetails = null;
    private KjsdUsbHidDevice kjsdUsbHidDevice = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kjsd_usb_hid_demo);

        etInputKeyDesc = (EditText)findViewById(R.id.EtInputKeyDesc);
        btnSendKey = (Button)findViewById(R.id.BtnSendKey);
        tvInputDetails = (TextView) findViewById(R.id.TvInputDetails);
        tvInputDetails.setMovementMethod(ScrollingMovementMethod.getInstance());

        kjsdUsbHidDevice.getInstance().openDevice();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        kjsdUsbHidDevice.getInstance().closeDevice();
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.BtnSendKey){
            String strInputKeyDesc = etInputKeyDesc.getText().toString();
            byte[] baScancode = kjsdUsbHidDevice.getInstance().getScancode(strInputKeyDesc);
            String strDisplayText = "扫描码："+getHexString(baScancode);
            boolean result = kjsdUsbHidDevice.getInstance().sendKey(strInputKeyDesc);
            if(result){
                strDisplayText = "发送成功.\n";
            }else{
                strDisplayText = "发送失败.\n";
            }
            tvInputDetails.append(strDisplayText);
            int tvInputDetailsOffset = tvInputDetails.getLineCount() * tvInputDetails.getLineHeight();
            if(tvInputDetailsOffset > tvInputDetails.getHeight()){
                tvInputDetails.scrollTo(0, tvInputDetailsOffset - tvInputDetails.getHeight());
            }
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

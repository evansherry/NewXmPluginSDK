package com.xiaomi.xmplugindemo;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.evan.dialog.IBottomDialog;
import com.xiaomi.smarthome.common.ui.dialog.MLAlertDialog;
import com.xiaomi.smarthome.device.api.XmPluginBaseActivity;

/**
 * Created by Evan on 2018/3/21.
 */

public class TestDialogActivity extends XmPluginBaseActivity {

    private static final String TAG = "TestDialogActivity";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_dialog);
        View titleBar = findViewById(R.id.title_bar);
        mHostActivity.setTitleBarPadding(titleBar);

        Log.e(TAG,"time :"+System.currentTimeMillis());
        View view = View.inflate(activity(), R.layout.dialog_bottom, null);
        Log.e(TAG, "inflate time :"+System.currentTimeMillis());

        findViewById(R.id.btn_mlart).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mlart_dialog();
            }
        });

        findViewById(R.id.btn_dialog).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
            }
        });

    }


    public void showDialog() {
        new IBottomDialog(activity())
                .setTitleText(R.string.cancel_set_timer)
                .setSubTitle(getText(R.string.are_you_sure_give_up_operate))
                .setNegative(getText( R.string.cancel), null)
                .setPositive(getText( R.string.give_up_modify), null)
                .show();
    }

    public void mlart_dialog(){
        new MLAlertDialog.Builder(activity())
                .setView(View.inflate(activity(),R.layout.dialog_bottom,null))
                .show();

    }
}

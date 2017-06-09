package modle.test.com.testmodle;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import modle.test.com.baselibrary.AppConfig;
import modle.test.com.baselibrary.BaseActivity;
import modle.test.com.baselibrary.utils.ToastUtil;


public class MainActivity extends BaseActivity {


    TextView tip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tip = (TextView) findViewById(R.id.tip);
        findViewById(R.id.btnOrderManager).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getStartActivityIntent(AppConfig.OrderManagerModuleActivity);
                try {
                    startActivityForResult(intent, 1);
                } catch (ActivityNotFoundException e) {
                    e.printStackTrace();
                    ToastUtil.showToast(getApplicationContext(), "该功能尚未开放");
                }
            }
        });

        findViewById(R.id.btnPointManager).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = getStartActivityIntent(AppConfig.PointManagerModuleActivity);
                try {
                    startActivityForResult(intent2, 1);
                } catch (ActivityNotFoundException e) {
                    e.printStackTrace();
                    ToastUtil.showToast(getApplicationContext(), "该功能尚未开放");
                }
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK) {
            if (data.hasExtra(AppConfig.ORDER_INTENT_VALUE)) {
                tip.setText(data.getStringExtra(AppConfig.ORDER_INTENT_VALUE));
            }
        }
    }
}

package keno.android.ui.sample;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import keno.android.ui.sample.contans.TabConfig;
import sdk.pendo.io.Pendo;

/**
 * Description:
 * Author: keno
 * CreateDate: 2020/2/3 10:21
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnConstraintActivity, getBtnConstraintTab, btnLoginDemo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Pendo.PendoInitParams pendoParams = new Pendo.PendoInitParams();
        pendoParams.setVisitorId("YZ Android VisitorId");
        pendoParams.setAccountId("YZ Android AccountId");

        //send Visitor Level Data
        Map<String, String> userData = new HashMap<>();
        userData.put("age", "YZ Android age");
        userData.put("country", "YZ Android country");
        pendoParams.setUserData(Collections.unmodifiableMap(userData));

        //send Account Level Data
        Map<String, String> accountData = new HashMap<>();
        accountData.put("Tier", "YZ Android Tier");
        accountData.put("Size", "YZ Android Size");
        pendoParams.setAccountData(Collections.unmodifiableMap(accountData));

        String pendoAppKey = "eyJhbGciOiJSUzI1NiIsImtpZCI6IiIsInR5cCI6IkpXVCJ9.eyJkYXRhY2VudGVyIjoidXMiLCJrZXkiOiJmMGJmYzA2NjZiZjViNWQ5MTExNGI2ZmZjMDQ5YjZlMjY3MDY1MTg2M2Q4Y2JmZDExNDIxMzZiNTRkMGZhNjhkOWE3MjZkNzIwYmFkZWExYmUyM2MxNDNjZTNlNmQxYTlmYzliZjFiMzkzMTM0NGZjODgyYzFmYjU3NjZmYzdmNjE5YTQzMjczMDEzZWYwNDAyMjhjZjRiOWQ4MzA1NWVkLjIzMGNmMjk2Yjc4Yjg0MjkwN2YyZGExZDM2OWRkMjJmLjhmYTRhYjI2YTM0MmFkZTVhZGQxMzU0Y2ZmOGM2MDgzMTM5YTA4YzcwZDIxMmM5MjU1Zjk5Mjk1OWNmYjQyODQifQ.WcsdpFMDPXn7xSfMXnhOYYy96mqd25BpYKgcv5MhUBw08MZN-kTArmy98-aKgwo8bGdqAnZu3thKF3Gf6owx0vL6wEyrR680ujjt7COuR-uQaigcc0yLOcw2oC6fsrwxiHsDgnWFnoCxG5TkKGVGVHNmqzJDqyWt_5PAlA5iRdw";
        Pendo.initSDK(
                this,
                pendoAppKey,
                pendoParams);

        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        getBtnConstraintTab = findViewById(R.id.btn_constraintlayout_tab);
        btnConstraintActivity = findViewById(R.id.btn_constraintlayout_demo);
        btnLoginDemo = findViewById(R.id.btn_practice_demo);

        getBtnConstraintTab.setOnClickListener(this);
        btnConstraintActivity.setOnClickListener(this);
        btnLoginDemo.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_constraintlayout_tab:
                String[] titleArrs = {
                        TabConfig.RelativeLayout,
                        TabConfig.LinearLayout,
                        TabConfig.PercentLayout,
                        TabConfig.MarginGone,
                        TabConfig.Circle,
                        TabConfig.ChainLine,
                        TabConfig.Align,
                        TabConfig.Barrier,
                        TabConfig.Group,
                        TabConfig.Placeholder
                };
                MainTabActivity.start(this, titleArrs);
                break;
            case R.id.btn_constraintlayout_demo:
                startActivity(new Intent(this, ConstraintLayoutDemoActivity.class));
                break;
            case R.id.btn_practice_demo:
                String[] titlePracticeArrs = {
                        TabConfig.Login,
                        TabConfig.Clock,
                        TabConfig.Error
                };
                MainTabActivity.start(this, titlePracticeArrs);
                break;
        }
    }
}

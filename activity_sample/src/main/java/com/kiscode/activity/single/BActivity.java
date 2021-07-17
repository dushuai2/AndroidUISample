package com.kiscode.activity.single;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;

import com.kiscode.activity.BaseActionBarActivity;
import com.kiscode.activity.R;

/**
 * Description:
 * Author: keno
 * Date : 2021/3/24 10:36
 **/
public class BActivity extends BaseActionBarActivity {
    public static void start(Context context) {
        Intent intent = new Intent(context, BActivity.class);
        //即将启动的Activity 如果在当前任务栈内则直接从栈内拿出放在栈顶复用
        intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        context.startActivity(intent);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.i(TAG, "onNewIntent in BActivity");
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);
    }

    public void next(View view) {
        CActivity.start(this);
    }
}
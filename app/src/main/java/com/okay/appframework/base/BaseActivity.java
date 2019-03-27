package com.okay.appframework.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;


import butterknife.ButterKnife;
import butterknife.Unbinder;


/**
 * @author qiaodong
 */
public abstract class BaseActivity extends Activity {
    protected Context mContext;
    private Unbinder mUnBinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentView());
        mUnBinder = ButterKnife.bind(this);
        mContext = this;
        initTitleBar();
        initView();
        initData();
        initListener();

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    protected void initTitleBar() {

    }

    protected abstract int getContentView();

    protected void initData() {
    }

    protected void initView() {
    }

    protected void initListener() {
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mUnBinder != null) {
            mUnBinder.unbind();
        }
    }
}

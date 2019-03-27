package com.okay.appframework.mvc.controller;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.okay.appframework.R;
import com.okay.appframework.base.BaseActivity;
import com.okay.appframework.mvc.model.LoginModel;

import butterknife.BindView;

/**
 * author : Qiaodong
 * e-mail : qiaodong@okay.cn
 * date   : 2019/3/262:40 PM
 * <p>
 * desc   :
 */
public class MvcActivity extends BaseActivity {

    @BindView(R.id.et_username)
    EditText mEtUserName;

    @BindView(R.id.et_password)
    EditText mEtPassword;

    @BindView(R.id.bt_login)
    Button mBtLogin;

    @BindView(R.id.tv_result)
    TextView mTvResult;

    @BindView(R.id.tv_loading)
    TextView mTvLoading;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getContentView() {
        return R.layout.activity_common;
    }

    @Override
    protected void initListener() {
        super.initListener();
        mBtLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName = mEtUserName.getText().toString().trim();
                String password = mEtPassword.getText().toString().trim();
                mTvLoading.setVisibility(View.VISIBLE);
                mTvResult.setVisibility(View.GONE);

                //属于model部分
                //model与view直接进行了交互。
                //使得职责划分不明显
                //MVC中Activity属于c层，但是因为xml的方式比较弱，在activity又需要进行view的初始化以及各种控制操作。
                LoginModel.getInstance().login(userName, password, new LoginModel.LoginListener() {
                    @Override
                    public void onSuccess() {
                        mTvResult.setText("success mvc");
                        mTvResult.setVisibility(View.VISIBLE);
                        mTvLoading.setVisibility(View.GONE);
                    }

                    @Override
                    public void onFail() {
                        mTvResult.setText("fail mvc ");
                        mTvResult.setVisibility(View.VISIBLE);
                        mTvLoading.setVisibility(View.GONE);
                    }
                });
            }
        });
    }
}

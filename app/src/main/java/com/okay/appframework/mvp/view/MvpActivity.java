package com.okay.appframework.mvp.view;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.okay.appframework.R;
import com.okay.appframework.mvp.base.BaseMvpActivity;
import com.okay.appframework.mvp.contract.LoginContract;
import com.okay.appframework.mvp.presenter.LoginPresenter;

import butterknife.BindView;

/**
 * author : Qiaodong
 * e-mail : qiaodong@okay.cn
 * date   : 2019/3/263:42 PM
 * <p>
 * desc   :
 */
public class MvpActivity extends BaseMvpActivity<LoginPresenter> implements LoginContract.IView {

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
    protected LoginPresenter setPresenter() {
        return new LoginPresenter(this);
    }

    @Override
    protected int getContentView() {
        return R.layout.activity_common;
    }

    @Override
    protected void initListener() {
        super.initListener();
        //model与view之间的交互由presenter来完成。model与view之间不能直接通讯
        //MVP中，Activity的职责是View，负责view的初始化，已经各种显示操作。
        //简化activity的职责
        mBtLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mTvLoading.setVisibility(View.VISIBLE);
                mTvResult.setText("");
                mPresenter.login(mEtUserName.getText().toString().trim(), mEtPassword.getText().toString().trim());
            }
        });
    }

    @Override
    public void onSuccess() {
        super.onSuccess();
        mTvLoading.setVisibility(View.GONE);
        mTvResult.setText("success mvp");
    }

    @Override
    public void onFail() {
        super.onFail();
        mTvLoading.setVisibility(View.GONE);
        mTvResult.setText("fail mvp");
    }
}

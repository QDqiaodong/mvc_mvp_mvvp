package com.okay.appframework.mvp.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.okay.appframework.base.BaseActivity;

/**
 * author : Qiaodong
 * e-mail : qiaodong@okay.cn
 * date   : 2019/3/264:14 PM
 * <p>
 * desc   :
 */
public abstract class BaseMvpActivity<P extends BaseContract.IBasePresenter> extends BaseActivity implements BaseContract.IBaseView {

    protected P mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = setPresenter();
    }

    protected abstract P setPresenter();

    @Override
    protected int getContentView() {
        return 0;
    }

    @Override
    public void onSuccess() {

    }

    @Override
    public void onFail() {

    }
}

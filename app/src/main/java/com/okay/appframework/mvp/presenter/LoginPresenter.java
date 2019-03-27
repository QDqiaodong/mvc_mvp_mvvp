package com.okay.appframework.mvp.presenter;

import com.okay.appframework.mvp.base.BasePresenter;
import com.okay.appframework.mvp.contract.LoginContract;
import com.okay.appframework.mvp.model.LoginModel;

/**
 * author : Qiaodong
 * e-mail : qiaodong@okay.cn
 * date   : 2019/3/264:18 PM
 * <p>
 * desc   :
 */
public class LoginPresenter extends BasePresenter<LoginContract.IView> implements LoginContract.IPresenter<LoginContract.IView> {

    public LoginPresenter(LoginContract.IView loginView) {
        super(loginView);
    }

    @Override
    public void login(String name, String password) {
        LoginModel.getInstance().login(name, password, new LoginModel.LoginListener() {
            @Override
            public void onSuccess() {
                mView.onSuccess();
            }

            @Override
            public void onFail() {
                mView.onFail();
            }
        });
    }
}

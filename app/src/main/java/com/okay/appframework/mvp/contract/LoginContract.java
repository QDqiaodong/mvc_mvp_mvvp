package com.okay.appframework.mvp.contract;

import com.okay.appframework.mvp.base.BaseContract;

/**
 * author : Qiaodong
 * e-mail : qiaodong@okay.cn
 * date   : 2019/3/264:20 PM
 * <p>
 * desc   :
 */
public interface LoginContract extends BaseContract {

    interface IView extends BaseContract.IBaseView {

    }

    interface IPresenter<V extends BaseContract.IBaseView> extends BaseContract.IBasePresenter<V> {
        void login(String name, String password);
    }
}

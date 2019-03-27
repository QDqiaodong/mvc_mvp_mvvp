package com.okay.appframework.mvp.base;

/**
 * author : Qiaodong
 * e-mail : qiaodong@okay.cn
 * date   : 2019/3/263:56 PM
 * <p>
 * desc   :
 */
public interface BaseContract {

    interface IBaseView {
        void onSuccess();

        void onFail();
    }

    interface IBasePresenter<V> {
        void attachView(V v);

        void detachView();
    }
}

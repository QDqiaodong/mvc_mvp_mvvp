package com.okay.appframework.mvp.base;

/**
 * author : Qiaodong
 * e-mail : qiaodong@okay.cn
 * date   : 2019/3/264:11 PM
 * <p>
 * desc   :
 */
public class BasePresenter<V extends BaseContract.IBaseView> implements BaseContract.IBasePresenter<V> {

    protected V mView;

    public BasePresenter(V v) {
        attachView(v);
    }

    @Override
    public void attachView(V v) {
        this.mView = v;
    }

    @Override
    public void detachView() {
        this.mView = null;
    }
}

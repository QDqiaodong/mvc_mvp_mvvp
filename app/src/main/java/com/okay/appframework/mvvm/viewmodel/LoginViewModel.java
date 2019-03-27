package com.okay.appframework.mvvm.viewmodel;

import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;

import com.okay.appframework.mvvm.model.LoginModel;

/**
 * author : Qiaodong
 * e-mail : qiaodong@okay.cn
 * date   : 2019/3/265:29 PM
 * <p>
 * desc   : ViewModel是数据模型和Presenter的结合。只进行业务逻辑的处理。通过官方的DataBinding，
 * 数据发生变化时，UI将自动更新。
 * viewModel层不再持有view的引用，更加解耦合。
 */
public class LoginViewModel {

    public final ObservableField<String> userName = new ObservableField<>();
    public final ObservableField<String> password = new ObservableField<>();
    public final ObservableField<String> result = new ObservableField<>();
    public final ObservableBoolean loading = new ObservableBoolean(false);

    public LoginViewModel() {

    }

    public void login(String userName, String password) {
        loading.set(true);
        result.set("");
        LoginModel.getInstance().login(userName, password, new LoginModel.LoginListener() {
            @Override
            public void onSuccess() {
                loading.set(false);
                result.set("success mvvm");
            }

            @Override
            public void onFail() {
                loading.set(false);
                result.set("fail mvvm");
            }
        });
    }
}

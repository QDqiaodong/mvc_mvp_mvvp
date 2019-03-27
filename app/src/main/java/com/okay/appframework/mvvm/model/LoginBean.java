package com.okay.appframework.mvvm.model;

import android.databinding.BaseObservable;

/**
 * author : Qiaodong
 * e-mail : qiaodong@okay.cn
 * date   : 2019/3/262:42 PM
 * <p>
 * desc   :
 */
public class LoginBean extends BaseObservable {
    public String userName;
    public String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

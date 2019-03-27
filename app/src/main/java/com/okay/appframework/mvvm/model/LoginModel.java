package com.okay.appframework.mvvm.model;

import android.os.AsyncTask;
import android.util.Log;

/**
 * author : Qiaodong
 * e-mail : qiaodong@okay.cn
 * date   : 2019/3/263:16 PM
 * <p>
 * desc   :
 */
public class LoginModel {

    private static LoginModel instance;

    private LoginModel() {
    }

    public static LoginModel getInstance() {
        if (instance == null) {
            synchronized (LoginModel.class) {
                if (instance == null) {
                    instance = new LoginModel();
                }
            }
        }
        return instance;
    }

    public void login(final String name, final String password, final LoginListener listener) {
        AsyncTask<Void, Void, Boolean> asyncTask = new AsyncTask<Void, Void, Boolean>() {

            @Override
            protected Boolean doInBackground(Void... voids) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                if ("okay".equals(name) && "123".equals(password)) {
                    return true;
                } else {
                    return false;
                }
            }

            @Override
            protected void onPostExecute(Boolean result) {
                super.onPostExecute(result);
                Log.d("qd", "onPostExecute result=" + result);
                if (listener != null) {
                    if (result) {
                        listener.onSuccess();
                    } else {
                        listener.onFail();
                    }
                }
            }
        };
        asyncTask.execute();
    }


    public interface LoginListener {
        void onSuccess();

        void onFail();
    }
}

package com.okay.appframework.mvvm.view;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.hardware.display.DisplayManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;

import com.okay.appframework.R;
import com.okay.appframework.databinding.ActivityMvvmBinding;
import com.okay.appframework.mvvm.model.LoginBean;
import com.okay.appframework.mvvm.viewmodel.LoginViewModel;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * author : Qiaodong
 * e-mail : qiaodong@okay.cn
 * date   : 2019/3/265:26 PM
 * <p>
 * desc   :
 */
public class MvvmActivity extends AppCompatActivity {
    private Unbinder mUnBinder;
    private ActivityMvvmBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mUnBinder = ButterKnife.bind(this);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_mvvm);
        // 创建ViewModel
        final LoginViewModel mViewModel = new LoginViewModel();
        // 绑定View和ViewModel
        binding.setViewModel(mViewModel);


        LoginBean loginBean = new LoginBean();
        binding.setBean(loginBean);

    }

    /**
     * 获取屏幕宽度
     *
     * @return
     */
    public  int getScreenWidth(boolean isShowInMainSceen) {
        if (isShowInMainSceen) {
            return getResources().getDisplayMetrics().widthPixels;
        } else {
            return getEPDDisplayMetrics().widthPixels;
        }
    }

    /**
     * 获取屏幕高度
     *
     * @return
     */
    public int getScreenHeight(boolean isShowInMainSceen) {
        if (isShowInMainSceen) {
            return getResources().getDisplayMetrics().heightPixels;
        } else {
            return getEPDDisplayMetrics().heightPixels;
        }
    }

    private DisplayMetrics getEPDDisplayMetrics() {
        DisplayManager displayManager = (DisplayManager)getSystemService(Context.DISPLAY_SERVICE);
        Display[] presentationDisplays = displayManager.getDisplays();
        Display display;
        if (presentationDisplays.length > 1) {
            display = presentationDisplays[1];
        } else {
            display = presentationDisplays[0];
        }
        DisplayMetrics metrics = new DisplayMetrics();
        display.getRealMetrics(metrics);
        Log.d("qd","widthPixels=" + metrics.widthPixels + " heightPixels=" + metrics.heightPixels
                + " density=" + metrics.density + " " + " densityDpi=" + metrics.densityDpi);
        return metrics;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mUnBinder != null) {
            mUnBinder.unbind();
        }
        if (binding != null) {
            binding.unbind();
        }
    }
}

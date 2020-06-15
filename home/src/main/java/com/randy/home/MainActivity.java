package com.randy.home;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.randy.home.databinding.ActivityMainBinding;
import com.randy.home.viewmodel.MViewModel;

/**
 * @author randy
 */
@Route(path = "/home/main")
public class MainActivity extends AppCompatActivity {
    Fragment fragment = (Fragment) ARouter.getInstance().build("/find/findfragment").navigation();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        //  最新版本  extends ViewModel
        MViewModel mainViewModel = new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(MViewModel.class);
        // 绑定工作
        binding.setVm(mainViewModel);
        // 建立感应
        binding.setLifecycleOwner(this);
    }

}

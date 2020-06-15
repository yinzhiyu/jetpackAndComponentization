package com.randy.home;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.randy.home.databinding.ActivityCallBinding;
import com.randy.home.databinding.ActivityMainBinding;
import com.randy.home.viewmodel.CallViewModel;


/**
 * TODO 传统方式的
 *
 * 功能越多，下面的缺点就越大
 *
 * 1.Activity 或 Fragment 是大管家，代码脓肿
 *
 * 2.Activity 要处理逻辑
 *
 * 3.Activity 要处理Model数据  UI 数据， 不仅管理了 却又管不好（横竖屏切换 数据丢失）
 *
 * 4.Activity 要实时刷新UI，例如：更新TextView
 *
 * 5.Activity 如果横竖屏切换 会丢失数据（号码数据一定会丢失的）
 *
 * 6.焊死
 *
 * ...... 等等
 *
 * TODO JetPack 来重构代码    单一职责原则（一件事情）  管理 绑定
 * Android刚出来的时候 问题 （第三方框架）
 *
 */
public class CallActivity extends AppCompatActivity {

    private ActivityCallBinding binding;
    private CallViewModel callViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_call);

        // 如果不吧 VM交给我们的 DataBInding 无法关联起来

        // 旧版本
        // mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);

        // 最新版本  extends AndroidViewModel
        callViewModel = new ViewModelProvider(this, new ViewModelProvider.AndroidViewModelFactory(getApplication())).get(CallViewModel.class);

        //  最新版本  extends ViewModel
        // mainViewModel = new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(MainViewModel.class);

        // 绑定工作
        binding.setVm(callViewModel);

        // 建立感应
        binding.setLifecycleOwner(this);

    }

}

package com.randy.home.viewmodel;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
// 管理我们的 Activity  Ui  Data
public class CallViewModel extends /* 没有环境 ViewModel*/  AndroidViewModel {

    // 我们的UI Data 在哪里 ？
    // 传统方式的 数据
    // private String phoneInfo = "";  // 能够感应吗？  不能

    private MutableLiveData<String> phoneInfo ; // 能够感应吗？ 能

    // 定义我们的环境
    private Context context;

    public CallViewModel(@NonNull Application application) {
        super(application);
        this.context = application;
    }

    // 对外部暴漏的数据
    public MutableLiveData<String> getPhoneInfo() {
        if (phoneInfo == null) {
            phoneInfo = new MutableLiveData<>();

            // 默认值
            phoneInfo.setValue("");
        }
        return phoneInfo;
    }

    /**
     * 输入
     * @param number
     */
    public void appendNumber(String number) {
        phoneInfo.setValue(phoneInfo.getValue() + number); // +=
    }

    /**
     * 删除
     */
    public void backspaceNumber() {
        int length = phoneInfo.getValue().length();
        if (length > 0) {
            phoneInfo.setValue(phoneInfo.getValue().substring(0, phoneInfo.getValue().length() - 1));
        }
    }

    /**
     * 清空
     */
    public void clear() {
        phoneInfo.setValue("");
    }

    /**
     * 拨号
     */
    public void callPhone() {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:" + phoneInfo.getValue()));
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK); // 非Activity启动必须标记，否则报错
        context.startActivity(intent);
    }
}


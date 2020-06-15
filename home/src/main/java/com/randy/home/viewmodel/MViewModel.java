package com.randy.home.viewmodel;

import androidx.lifecycle.ViewModel;

import com.alibaba.android.arouter.launcher.ARouter;

public class MViewModel extends ViewModel {


    /**
     * 跳转 find
     */
    public void navigationFind() {
        ARouter.getInstance().build("/find/find").navigation();
    }

    /**
     * 跳转 home
     */
    public void navigationHome() {
        ARouter.getInstance().build("/home/home").withString("home", "randy").navigation();
    }

    /**
     * 跳转 chat
     */
    public void navigationChat() {
        ARouter.getInstance().build("/chat/chat").navigation();
    }

    /**
     * 跳转 mine
     */
    public void navigationMine() {
        ARouter.getInstance().build("/mine/mine").withString("name", "randy").withInt("age", 18).navigation();
    }
/*
XIEGEZHUSHI
 */
}
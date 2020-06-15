package com.randy.home;

import android.content.Context;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.randy.commonlib.HomeExportService;

@Route(path = "/home/HomeService", name = "测试服务")
public class HomeService implements HomeExportService {
    @Override
    public String sayHello(String s) {
        return "HomeService say hello to " + s;
    }

    @Override
    public void init(Context context) {

    }
}

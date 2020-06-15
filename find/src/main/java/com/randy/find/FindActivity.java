package com.randy.find;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.randy.commonlib.GpsEngine;


/**
 * @author randy
 */
@Route(path = "/find/find")
public class FindActivity extends AppCompatActivity {
    @Autowired
    public String find;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find);
        // 被观察者 和 观察者 关联
        getLifecycle().addObserver(GpsEngine.getInstance());
        ARouter.getInstance().inject(this);
        TextView xxx = findViewById(R.id.find_tv_find);
        xxx.setText("find：" + find);
    }
    /**
     * 跳转 findfragment
     */
    public void navigationFindFragment() {
        ARouter.getInstance().build("/chat/chat").withString("chat", "randy").navigation();
    }
}

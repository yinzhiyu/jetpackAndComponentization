package com.randy.mine;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;

/**
 * @author randy
 */
@Route(path = "/mine/mine")
public class MineActivity extends AppCompatActivity {
    @Autowired
    public String name;
    @Autowired
    public int age;
    @Autowired
    public String mine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mine);
        ARouter.getInstance().inject(this);
        TextView xxx = findViewById(R.id.tv_mine);
        xxx.setText("姓名:" + name + "，年龄：" + age + "，mine：" + mine);
    }
}

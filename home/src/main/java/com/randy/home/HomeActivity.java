package com.randy.home;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;

/**
 * @author randy
 */
@Route(path = "/home/home")
public class HomeActivity extends AppCompatActivity {
    @Autowired
    public String home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ARouter.getInstance().inject(this);
        TextView xxx = findViewById(R.id.home);
        xxx.setText("home：" + home);
    }
}

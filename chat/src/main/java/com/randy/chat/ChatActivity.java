package com.randy.chat;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.randy.commonlib.HomeExportService;

/**
 * @author randy
 */
@Route(path = "/chat/chat")
public class ChatActivity extends AppCompatActivity {
    @Autowired(name = "/home/HomeService")
    public HomeExportService homeExportService;
    @Autowired
    public String chat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        ARouter.getInstance().inject(this);
        TextView toast = findViewById(R.id.toast);
        toast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ChatActivity.this, homeExportService.sayHello("小四") + "姓名:" + chat, Toast.LENGTH_SHORT).show();
            }
        });
    }
}

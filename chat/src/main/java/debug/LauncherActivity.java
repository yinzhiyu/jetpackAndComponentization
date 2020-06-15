package debug;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;

/**
 * @author randy
 */
@Route(path = "/chat/launcher")
public class LauncherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ARouter.getInstance().inject(this);
        request();
//        Intent intent = new Intent(this, TargetActivity.class);
//        intent.putExtra("name", "avcd");
//        intent.putExtra("syscode", "023e2e12ed");
//        startActivity(intent);
        navigationChat();
        finish();
    }
    //申请读写权限
    private void request() {
//        AndPermission.with(this)
//                .requestCode(110)
//                .permission(Manifest.permission.WRITE_EXTERNAL_STORAGE,
//                        Manifest.permission.CAMERA, Manifest.permission.READ_PHONE_STATE)
//                .callback(this)
//                .start();
    }

    /**
     * 跳转 chat
     */
    public void navigationChat() {
        ARouter.getInstance().build("/chat/chat").withString("chat", "randy").navigation();
    }
}

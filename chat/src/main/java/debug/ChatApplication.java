package debug;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;

import static com.randy.commonlib.BuildConfig.DEBUG;

/**
 * @author randy
 */
public class ChatApplication extends Application {
    private static ChatApplication mApp;

    public static ChatApplication getInstance() {
        return mApp;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mApp = this;
        if (DEBUG) {           // These two lines must be written before init, otherwise these configurations will be invalid in the init process
            ARouter.openLog();     // Print log
            ARouter.openDebug();   // Turn on debugging mode (If you are running in InstantRun mode, you must turn on debug mode! Online version needs to be closed, otherwise there is a security risk)
        }
        ARouter.init(mApp); // As early as possible, it is recommended to initialize in the Application
    }
}

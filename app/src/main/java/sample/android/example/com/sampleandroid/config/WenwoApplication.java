package sample.android.example.com.sampleandroid.config;

import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by sanghwan on 2017. 3. 14..
 */

public class WenwoApplication extends Application {
    private static Context mContext;
    public static boolean DEBUG = false;
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
        Realm.init(this);
        this.DEBUG = isDebuggable(this);
    }

    public static Context getContext() {
        return mContext;
    }

    private boolean isDebuggable(Context context) {
        boolean debuggable = false;

        PackageManager pm = context.getPackageManager();
        try {
            ApplicationInfo appinfo = pm.getApplicationInfo(context.getPackageName(), 0);
            debuggable = (0 != (appinfo.flags & ApplicationInfo.FLAG_DEBUGGABLE));
        } catch (PackageManager.NameNotFoundException e) {
            /* debuggable variable will remain false */
        }

        return debuggable;
    }

}

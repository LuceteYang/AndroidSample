package sample.android.example.com.sampleandroid.common;

/**
 * Created by sanghwan on 2017. 3. 17..
 */


import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.telephony.TelephonyManager;
import android.util.TypedValue;
import android.view.Gravity;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.UUID;
import java.util.regex.Pattern;



public class SHelper {
    public static void toast(final Context context, final String string){

        if(context!=null) {
            ((Activity) context).runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(context, string, Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    public static void toastCenter(final Context context, final String string){

        if(context!=null) {
            ((Activity) context).runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast toast = Toast.makeText(context, string, Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                }
            });
        }
    }
    public static String getUUID(Context context){

        final TelephonyManager tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);

        final String tmDevice, tmSerial, androidId;
        tmDevice = "" + tm.getDeviceId();
        tmSerial = "" + tm.getSimSerialNumber();
        androidId = "" + android.provider.Settings.Secure.getString(context.getContentResolver(), android.provider.Settings.Secure.ANDROID_ID);

        UUID deviceUuid = new UUID(androidId.hashCode(), ((long)tmDevice.hashCode() << 32) | tmSerial.hashCode());
        String deviceId = deviceUuid.toString();
        return deviceId;
    }

    /**
     *
     * @param day :일 수
     * @return 년, 월, 일 에 해당하는 텍스트로 변환
     */
    public static String DayToMonth(int day){
        if(day<=30)
            return day + "일";
        else if(day<= 30*12){
            return day / 30 + "개월";
        }else {
            return day / 30 / 12 + "년";
        }
    }

    public static String DayToMonth1(int day){
        day = -day;
        if(day<=30)
            return day + "일";
        else if(day<= 30*12){
            return day / 30 + "개월";
        }else {
            return day / 30 / 12 + "년";
        }
    }

    /**
     * 앱에서 사용하고 있는 버전 코드를 가져온다.
     * @param context
     * @return
     */
    public static int getVersionCode(Context context){
        try {
            PackageInfo i = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            return i.versionCode;
        } catch(PackageManager.NameNotFoundException e) { }

        return 0;
    }

    /**
     * @param num
     * @return
     */
    public static String comma(int num){
        DecimalFormat df = new DecimalFormat("#,##0");

        return df.format(num);
    }

    public static boolean isEmail(String email) {
        if (email==null) return false;
        boolean b = Pattern.matches("[\\w\\~\\-\\.]+@[\\w\\~\\-]+(\\.[\\w\\~\\-]+)+", email.trim());
        return b;
    }


    /**
     * 현재 디스플레이 화면에 비례한 DP단위를 픽셀 크기로 반환합니다.
     *
     * @return 변환된 값 (pixel)
     */
    public static int DpToPixcel(Context context, int _padding) {
        float padding = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, _padding, context.getResources().getDisplayMetrics());
        return ((int) padding);
    }

    /**
     * 앱에서 사용하고 있는 버전 코드를 가져온다.
     *
     * @param context
     * @return
     */
    public static String getVersionName(Context context) {
        try {
            PackageInfo i = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            return i.versionName;
        } catch (PackageManager.NameNotFoundException e) {
        }

        return null;
    }

}
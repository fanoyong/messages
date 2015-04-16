package android.fanoyong.com.msg;


import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.fanoyong.com.msg.receiver.MmsReceiver;
import android.fanoyong.com.msg.receiver.SmsReceiver;
import android.util.Log;

public class util {
    private static final String TAG = "Util";
    public static void enableReceiver(Context context) {
        Log.d(TAG, "enable broadcast receivers");
        ComponentName smsReceiverComponent = new ComponentName(context, SmsReceiver.class);
        ComponentName mmsReceiverComponent = new ComponentName(context, MmsReceiver.class);
        PackageManager pm = context.getPackageManager();
        pm.setComponentEnabledSetting(
                smsReceiverComponent,
                PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
                PackageManager.DONT_KILL_APP);
        pm.setComponentEnabledSetting(
                mmsReceiverComponent,
                PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
                PackageManager.DONT_KILL_APP);
    }

    public static void disableReceiver(Context context) {
        Log.d(TAG, "disable broadcast receivers");
        ComponentName smsReceiverComponent = new ComponentName(context, SmsReceiver.class);
        ComponentName mmsReceiverComponent = new ComponentName(context, MmsReceiver.class);
        PackageManager pm = context.getPackageManager();
        pm.setComponentEnabledSetting(
                smsReceiverComponent,
                PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
                PackageManager.DONT_KILL_APP);
        pm.setComponentEnabledSetting(
                mmsReceiverComponent,
                PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
                PackageManager.DONT_KILL_APP);
    }
}

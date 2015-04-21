package android.fanoyong.com.msg;


import android.app.Notification;
import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.fanoyong.com.msg.receiver.MmsReceiver;
import android.fanoyong.com.msg.receiver.SmsReceiver;
import android.util.Log;

public class util {
    private static final String TAG = "MSG-Util";

    public static void showFirstRunNotification(Context context) {
        Log.d(TAG, "show first time notification");
        String title = context.getString(R.string.noti_title_first_run);
        String body = context.getString(R.string.noti_body_first_run);
        String summary = context.getString(R.string.noti_summary_first_run);
        long when = System.currentTimeMillis();

        Notification.BigTextStyle bigTextStyle = new Notification.BigTextStyle();
        bigTextStyle.bigText(body)
                .setSummaryText(summary)
                .setBigContentTitle(title);

        Notification.Builder builder = new Notification.Builder(context);
        builder.setContentTitle(title)
                .setContentText(body)
                .setSmallIcon(R.drawable.ic_first_time)
                .setWhen(when)
                .setAutoCancel(true)
                .setStyle(bigTextStyle);

        NotificationManager nm = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        nm.notify(0, builder.build());
    }

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

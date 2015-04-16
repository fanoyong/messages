package android.fanoyong.com.msg.ui;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.fanoyong.com.msg.util;
import android.os.Bundle;
import android.provider.Telephony;
import android.util.Log;

public class ComposerActivity extends Activity {

    private static final String TAG = "ComposerActivity";
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);
        mContext = this;
//        util.enableReceiver(mContext);
    }

    @Override
    protected void onResume() {
        super.onResume();
        final String msgPackage = getPackageName();
        String defaultSmsPackage = Telephony.Sms.getDefaultSmsPackage(mContext);
        Log.d(TAG, "packageName=" + msgPackage + " defaultSmsPackage=" + defaultSmsPackage);
        if (defaultSmsPackage == null || !defaultSmsPackage.equals(msgPackage)) {
            AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
            DialogInterface.OnClickListener ocl = new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Intent intent = new Intent(Telephony.Sms.Intents.ACTION_CHANGE_DEFAULT);
                    intent.putExtra(Telephony.Sms.Intents.EXTRA_PACKAGE_NAME, msgPackage);
                    startActivity(intent);
                }
            };
            Log.v(TAG, "show AlertDialog");
            builder.setTitle("Not default")
                    .setMessage("Do you want to make MSG as default?")
                    .setPositiveButton("OK", ocl)
                    .setNegativeButton("Cancel", null).create().show();
        } else {
//            util.disableReceiver(mContext);
        }
    }

}

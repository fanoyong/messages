package android.fanoyong.com.msg.ui;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.provider.Telephony;
import android.view.View;

public class ComposerActivity extends Activity {

    private Context mContext;

    @Override
    protected void onCreate() {
        super.onCreate();
        mContext = this;
    }

    @Override
    protected void onResume() {
        super.onResume();

        final String myPackageName = getPackageName();
        if (!Telephony.Sms.getDefaultSmsPackage(this).equals(myPackageName)) {
            AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
            AlertDialog al = builder.setTitle("Not default")
                    .setMessage("Do you want to make MSG as default?")
                    .setPositiveButton("OK")
                    .setNegativeButton("Cancel").create();
            al.setOnDismissListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Intent intent = new Intent(Telephony.Sms.Intents.ACTION_CHANGE_DEFAULT);
                    intent.putExtra(Telephony.Sms.Intents.EXTRA_PACKAGE_NAME, myPackageName);
                    startActivity(intent);
                }

                );
            });
        }
    }
}

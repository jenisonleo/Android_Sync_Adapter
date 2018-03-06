package com.jenisontv.jenison_3631.test;

import android.accounts.Account;
import android.content.AbstractThreadedSyncAdapter;
import android.content.ContentProviderClient;
import android.content.Context;
import android.content.SyncResult;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by jenison-3631 on 02/03/18.
 */

public class SyncAdapter extends AbstractThreadedSyncAdapter {
    public SyncAdapter(Context context, boolean autoInitialize) {
        super(context, autoInitialize);
    }

    public SyncAdapter(Context context, boolean autoInitialize, boolean allowParallelSyncs) {
        super(context, autoInitialize, allowParallelSyncs);
    }

    @Override
    public void onPerformSync(Account account, Bundle extras, String authority, ContentProviderClient provider, SyncResult syncResult) {
        Log.e("sync requested"," ");
        Looper.prepare();
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(getContext(),"requested sync",Toast.LENGTH_LONG).show();
            }
        });
    }
}

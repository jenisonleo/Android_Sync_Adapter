package com.jenisontv.jenison_3631.test;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by jenison-3631 on 02/03/18.
 */

public class SyncService extends Service{
    private static SyncAdapter sSyncAdapter = null;
    private static final Object sSyncAdapterLock = new Object();


    @Override
    public void onCreate() {
        Toast.makeText(getApplicationContext(),"sync service started",Toast.LENGTH_LONG).show();
        Log.e("on create", "service");
        synchronized (sSyncAdapterLock) {
            if (sSyncAdapter == null) {
                sSyncAdapter = new SyncAdapter(getApplicationContext(), true);
            }
        }
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.e("service", "on bind");
        return sSyncAdapter.getSyncAdapterBinder();
    }
}

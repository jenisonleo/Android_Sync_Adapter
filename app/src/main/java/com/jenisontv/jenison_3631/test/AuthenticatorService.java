package com.jenisontv.jenison_3631.test;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by jenison-3631 on 05/03/18.
 */

public class AuthenticatorService extends Service {


    private StubAutheticator mAuthenticator;

    @Override
    public void onCreate() {
        mAuthenticator = new StubAutheticator(this);

    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return mAuthenticator.getIBinder();
    }
}

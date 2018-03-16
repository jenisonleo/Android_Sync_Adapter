package com.jenisontv.jenison_3631.test;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.app.Service;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.SyncInfo;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Account account=new Account("JENISON","zoho.com");
        ContentResolver.setSyncAutomatically(account,"com.jenisontv.jenison_3631.test.provider",true);
        getContentResolver().registerContentObserver(Uri.parse("content://com.jenisontv.jenison_3631.test.provider"),true,observer);
    }

    public void read(View view) {
        Bundle bundle=new Bundle();
        bundle.putString("hai from", "jenison");
        Account account=new Account("JENISON","zoho.com");
        AccountManager accountManager = (AccountManager)getSystemService(ACCOUNT_SERVICE);
        if(accountManager.addAccountExplicitly(account,null,null)){
            Log.e("account added"," ");
        }else {
            Log.e("account already exists"," ");
        }
        ContentResolver.requestSync(account,"com.jenisontv.jenison_3631.test.provider",bundle);
    }

    public void write(View view) {

    }
    private ContentObserver observer=new ContentObserver(new Handler(Looper.getMainLooper())) {
        @Override
        public boolean deliverSelfNotifications() {
            return super.deliverSelfNotifications();
        }

        @Override
        public void onChange(boolean selfChange) {
            Toast.makeText(MainActivity.this,"jenisonCde",Toast.LENGTH_LONG).show();
            super.onChange(selfChange);
        }

        @Override
        public void onChange(boolean selfChange, Uri uri) {
            super.onChange(selfChange, uri);
        }
    };
}

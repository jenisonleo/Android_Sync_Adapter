package com.jenisontv.jenison_3631.test;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.ContentResolver;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Account account=new Account("JENISON","zoho.com");
        ContentResolver.setSyncAutomatically(account,"com.jenisontv.jenison_3631.test.provider",true);
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
}

package com.nst.iptvsmarterstvbox.miscelleneious.chromecastfeature.castserver;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import j7.a;
import j7.b;
import java.io.File;
import java.io.IOException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class CastServerService extends Service {
    public a a;

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onDestroy() {
        Log.i("HTTPSERVICE", "Destroying httpService");
        this.a.p();
        super.onDestroy();
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        Log.i("HTTPSERVICE", "Creating and starting httpService");
        super.onCreate();
        b bVar = new b(intent.getStringExtra("127.0.0.1"), 8080, new File(intent.getStringExtra(".")), false);
        this.a = bVar;
        try {
            bVar.o();
            return 2;
        } catch (IOException e) {
            Log.i("HTTPSERVICE", "IOException: " + e.getMessage());
            return 2;
        }
    }
}

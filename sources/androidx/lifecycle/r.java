package androidx.lifecycle;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class r extends Service implements p {
    public final H a = new H(this);

    public j getLifecycle() {
        return this.a.a();
    }

    public IBinder onBind(Intent intent) {
        this.a.b();
        return null;
    }

    public void onCreate() {
        this.a.c();
        super.onCreate();
    }

    public void onDestroy() {
        this.a.d();
        super.onDestroy();
    }

    public void onStart(Intent intent, int i) {
        this.a.e();
        super.onStart(intent, i);
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        return super.onStartCommand(intent, i, i2);
    }
}

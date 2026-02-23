package q5;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class x implements ServiceConnection {
    public final /* synthetic */ y a;

    public /* synthetic */ x(y yVar, w wVar) {
        this.a = yVar;
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        y.f(this.a).d("ServiceConnectionImpl.onServiceConnected(%s)", componentName);
        this.a.c().post(new u(this, iBinder));
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        y.f(this.a).d("ServiceConnectionImpl.onServiceDisconnected(%s)", componentName);
        this.a.c().post(new v(this));
    }
}

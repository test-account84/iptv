package B6;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class h {
    public final Context a;
    public Runnable e;
    public boolean f;
    public boolean c = false;
    public final BroadcastReceiver b = new b(this, null);
    public Handler d = new Handler();

    public final class b extends BroadcastReceiver {
        public b() {
        }

        public static /* synthetic */ void a(b bVar, boolean z) {
            bVar.b(z);
        }

        public final /* synthetic */ void b(boolean z) {
            h.b(h.this, z);
        }

        public void onReceive(Context context, Intent intent) {
            if ("android.intent.action.BATTERY_CHANGED".equals(intent.getAction())) {
                h.a(h.this).post(new i(this, intent.getIntExtra("plugged", -1) <= 0));
            }
        }

        public /* synthetic */ b(h hVar, a aVar) {
            this();
        }
    }

    public h(Context context, Runnable runnable) {
        this.a = context;
        this.e = runnable;
    }

    public static /* synthetic */ Handler a(h hVar) {
        return hVar.d;
    }

    public static /* synthetic */ void b(h hVar, boolean z) {
        hVar.f(z);
    }

    public void c() {
        e();
        if (this.f) {
            this.d.postDelayed(this.e, 300000L);
        }
    }

    public void d() {
        e();
        i();
    }

    public final void e() {
        this.d.removeCallbacksAndMessages((Object) null);
    }

    public final void f(boolean z) {
        this.f = z;
        if (this.c) {
            c();
        }
    }

    public final void g() {
        if (this.c) {
            return;
        }
        this.a.registerReceiver(this.b, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        this.c = true;
    }

    public void h() {
        g();
        c();
    }

    public final void i() {
        if (this.c) {
            this.a.unregisterReceiver(this.b);
            this.c = false;
        }
    }
}

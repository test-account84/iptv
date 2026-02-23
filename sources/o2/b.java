package O2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class b {
    public final Context a;
    public final a b;
    public boolean c;

    public final class a extends BroadcastReceiver implements Runnable {
        public final b a;
        public final Handler c;

        public a(Handler handler, b bVar) {
            this.c = handler;
            this.a = bVar;
        }

        public void onReceive(Context context, Intent intent) {
            if ("android.media.AUDIO_BECOMING_NOISY".equals(intent.getAction())) {
                this.c.post(this);
            }
        }

        public void run() {
            if (b.a(b.this)) {
                this.a.t();
            }
        }
    }

    public interface b {
        void t();
    }

    public b(Context context, Handler handler, b bVar) {
        this.a = context.getApplicationContext();
        this.b = new a(handler, bVar);
    }

    public static /* synthetic */ boolean a(b bVar) {
        return bVar.c;
    }

    public void b(boolean z) {
        boolean z2;
        if (z && !this.c) {
            this.a.registerReceiver(this.b, new IntentFilter("android.media.AUDIO_BECOMING_NOISY"));
            z2 = true;
        } else {
            if (z || !this.c) {
                return;
            }
            this.a.unregisterReceiver(this.b);
            z2 = false;
        }
        this.c = z2;
    }
}

package b8;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class b extends BroadcastReceiver {
    public a a;

    public interface a {
        void c();

        void e();
    }

    public b(a aVar) {
        this.a = aVar;
    }

    public void onReceive(Context context, Intent intent) {
        if (c.b(context)) {
            this.a.e();
        } else {
            this.a.c();
        }
    }
}

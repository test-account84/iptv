package i7;

import android.content.Context;
import android.content.Intent;
import com.nst.iptvsmarterstvbox.miscelleneious.chromecastfeature.castserver.CastServerService;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class c {
    public final Context a;

    public c(Context context) {
        this.a = context;
    }

    public void a(String str, String str2) {
        Intent intent = new Intent(this.a, CastServerService.class);
        intent.putExtra("127.0.0.1", str);
        intent.putExtra(".", str2);
        this.a.startService(intent);
    }

    public void b() {
        this.a.stopService(new Intent(this.a, CastServerService.class));
    }
}

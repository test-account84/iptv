package g7;

import android.app.Activity;
import android.os.Handler;
import mbanje.kurt.fabbutton.FabButton;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class l {
    public final FabButton c;
    public final Activity d;
    public int a = 0;
    public Handler b = new Handler();
    public boolean e = false;

    public l(FabButton fabButton, Activity activity) {
        this.c = fabButton;
        this.d = activity;
    }

    public boolean a() {
        return this.e;
    }

    public void b() {
        this.c.d(true);
        this.e = true;
    }

    public void c() {
        this.c.d(false);
        this.e = false;
    }
}

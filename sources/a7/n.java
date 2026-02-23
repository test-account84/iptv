package a7;

import android.content.Context;
import android.widget.Toast;
import java.lang.ref.WeakReference;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class n {
    public static WeakReference b;
    public static n c;
    public Toast a;

    public n(Context context) {
        b = new WeakReference(context);
    }

    public static n a(Context context) {
        if (c == null || b.get() == null) {
            c = new n(context);
        }
        return c;
    }

    public void b(int i) {
        c(((Context) b.get()).getResources().getString(i));
    }

    public void c(String str) {
        Toast toast = this.a;
        if (toast == null) {
            this.a = Toast.makeText((Context) b.get(), str, 0);
        } else {
            toast.setText(str);
            this.a.setDuration(0);
        }
        this.a.show();
    }
}

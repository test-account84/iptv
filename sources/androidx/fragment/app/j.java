package androidx.fragment.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class j extends g {
    public final Activity a;
    public final Context c;
    public final Handler d;
    public final int e;
    public final m f;

    public j(Activity activity, Context context, Handler handler, int i) {
        this.f = new n();
        this.a = activity;
        this.c = (Context) O.h.g(context, "context == null");
        this.d = (Handler) O.h.g(handler, "handler == null");
        this.e = i;
    }

    public Activity e() {
        return this.a;
    }

    public Context f() {
        return this.c;
    }

    public Handler g() {
        return this.d;
    }

    public abstract void h(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    public abstract Object i();

    public abstract LayoutInflater j();

    public void k(Fragment fragment, String[] strArr, int i) {
    }

    public abstract boolean l(Fragment fragment);

    public abstract boolean m(String str);

    public void n(Fragment fragment, Intent intent, int i, Bundle bundle) {
        if (i != -1) {
            throw new IllegalStateException("Starting activity with a requestCode requires a FragmentActivity host");
        }
        E.b.startActivity(this.c, intent, bundle);
    }

    public void o(Fragment fragment, IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) {
        if (i != -1) {
            throw new IllegalStateException("Starting intent sender with a requestCode requires a FragmentActivity host");
        }
        D.b.n(this.a, intentSender, i, intent, i2, i3, i4, bundle);
    }

    public abstract void p();

    public j(e eVar) {
        this(eVar, eVar, new Handler(), 0);
    }
}

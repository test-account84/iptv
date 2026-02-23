package t4;

import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import java.util.Locale;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class b {
    public final String a;
    public final boolean b;
    public boolean c;
    public final String d;

    public b(String str) {
        this(str, null);
    }

    public void a(String str, Object... objArr) {
        if (i()) {
            Log.d(this.a, h(str, objArr));
        }
    }

    public void b(Throwable th, String str, Object... objArr) {
        if (i()) {
            Log.d(this.a, h(str, objArr), th);
        }
    }

    public void c(String str, Object... objArr) {
        Log.e(this.a, h(str, objArr));
    }

    public void d(Throwable th, String str, Object... objArr) {
        Log.e(this.a, h(str, objArr), th);
    }

    public void e(String str, Object... objArr) {
        Log.i(this.a, h(str, objArr));
    }

    public void f(String str, Object... objArr) {
        Log.w(this.a, h(str, objArr));
    }

    public void g(Throwable th, String str, Object... objArr) {
        Log.w(this.a, h(str, objArr), th);
    }

    public final String h(String str, Object... objArr) {
        if (objArr.length != 0) {
            str = String.format(Locale.ROOT, str, objArr);
        }
        return !TextUtils.isEmpty(this.d) ? String.valueOf(this.d).concat(String.valueOf(str)) : str;
    }

    public final boolean i() {
        if (Build.TYPE.equals("user")) {
            return false;
        }
        if (this.c) {
            return true;
        }
        return this.b && Log.isLoggable(this.a, 3);
    }

    public b(String str, String str2) {
        com.google.android.gms.common.internal.r.h(str, "The log tag cannot be null or empty.");
        this.a = str;
        this.b = str.length() <= 23;
        this.c = false;
        this.d = TextUtils.isEmpty((CharSequence) null) ? null : String.format("[%s] ", new Object[]{null});
    }
}

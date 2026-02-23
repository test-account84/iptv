package k6;

import android.text.TextUtils;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class p {
    public static final long b = TimeUnit.HOURS.toSeconds(1);
    public static final Pattern c = Pattern.compile("\\AA[\\w-]{38}\\z");
    public static p d;
    public final n6.a a;

    public p(n6.a aVar) {
        this.a = aVar;
    }

    public static p c() {
        return d(n6.b.b());
    }

    public static p d(n6.a aVar) {
        if (d == null) {
            d = new p(aVar);
        }
        return d;
    }

    public static boolean g(String str) {
        return c.matcher(str).matches();
    }

    public static boolean h(String str) {
        return str.contains(":");
    }

    public long a() {
        return this.a.a();
    }

    public long b() {
        return TimeUnit.MILLISECONDS.toSeconds(a());
    }

    public long e() {
        return (long) (Math.random() * 1000.0d);
    }

    public boolean f(l6.d dVar) {
        return TextUtils.isEmpty(dVar.b()) || dVar.h() + dVar.c() < b() + b;
    }
}

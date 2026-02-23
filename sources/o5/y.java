package O5;

import O5.z;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import java.util.Locale;
import java.util.UUID;
import java.util.regex.Pattern;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class y implements z {
    public static final Pattern g = Pattern.compile("[^\\p{Alnum}]");
    public static final String h = Pattern.quote("/");
    public final A a;
    public final Context b;
    public final String c;
    public final k6.h d;
    public final u e;
    public z.a f;

    public y(Context context, String str, k6.h hVar, u uVar) {
        if (context == null) {
            throw new IllegalArgumentException("appContext must not be null");
        }
        if (str == null) {
            throw new IllegalArgumentException("appIdentifier must not be null");
        }
        this.b = context;
        this.c = str;
        this.d = hVar;
        this.e = uVar;
        this.a = new A();
    }

    public static String c() {
        return "SYN_" + UUID.randomUUID().toString();
    }

    public static String e(String str) {
        if (str == null) {
            return null;
        }
        return g.matcher(str).replaceAll("").toLowerCase(Locale.US);
    }

    public static boolean k(String str) {
        return str != null && str.startsWith("SYN_");
    }

    public synchronized z.a a() {
        z.a b;
        if (!n()) {
            return this.f;
        }
        L5.f.f().i("Determining Crashlytics installation ID...");
        SharedPreferences s = i.s(this.b);
        String string = s.getString("firebase.installation.id", (String) null);
        L5.f.f().i("Cached Firebase Installation ID: " + string);
        if (this.e.d()) {
            String d = d();
            L5.f.f().i("Fetched Firebase Installation ID: " + d);
            if (d == null) {
                d = string == null ? c() : string;
            }
            b = d.equals(string) ? z.a.a(l(s), d) : z.a.a(b(d, s), d);
        } else {
            b = k(string) ? z.a.b(l(s)) : z.a.b(b(c(), s));
        }
        this.f = b;
        L5.f.f().i("Install IDs: " + this.f);
        return this.f;
    }

    public final synchronized String b(String str, SharedPreferences sharedPreferences) {
        String e;
        e = e(UUID.randomUUID().toString());
        L5.f.f().i("Created new Crashlytics installation ID: " + e + " for FID: " + str);
        sharedPreferences.edit().putString("crashlytics.installation.id", e).putString("firebase.installation.id", str).apply();
        return e;
    }

    public String d() {
        try {
            return (String) W.f(this.d.getId());
        } catch (Exception e) {
            L5.f.f().l("Failed to retrieve Firebase Installation ID.", e);
            return null;
        }
    }

    public String f() {
        return this.c;
    }

    public String g() {
        return this.a.a(this.b);
    }

    public String h() {
        return String.format(Locale.US, "%s/%s", new Object[]{m(Build.MANUFACTURER), m(Build.MODEL)});
    }

    public String i() {
        return m(Build.VERSION.INCREMENTAL);
    }

    public String j() {
        return m(Build.VERSION.RELEASE);
    }

    public final String l(SharedPreferences sharedPreferences) {
        return sharedPreferences.getString("crashlytics.installation.id", (String) null);
    }

    public final String m(String str) {
        return str.replaceAll(h, "");
    }

    public final boolean n() {
        z.a aVar = this.f;
        return aVar == null || (aVar.d() == null && this.e.d());
    }
}

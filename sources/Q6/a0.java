package q6;

import android.text.TextUtils;
import android.util.Log;
import java.util.regex.Pattern;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class a0 {
    public static final Pattern d = Pattern.compile("[a-zA-Z0-9-_.~%]{1,900}");
    public final String a;
    public final String b;
    public final String c;

    public a0(String str, String str2) {
        this.a = d(str2, str);
        this.b = str;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 1 + String.valueOf(str2).length());
        sb.append(str);
        sb.append("!");
        sb.append(str2);
        this.c = sb.toString();
    }

    public static a0 a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] split = str.split("!", -1);
        if (split.length != 2) {
            return null;
        }
        return new a0(split[0], split[1]);
    }

    public static String d(String str, String str2) {
        if (str != null && str.startsWith("/topics/")) {
            Log.w("FirebaseMessaging", String.format("Format /topics/topic-name is deprecated. Only 'topic-name' should be used in %s.", new Object[]{str2}));
            str = str.substring(8);
        }
        if (str == null || !d.matcher(str).matches()) {
            throw new IllegalArgumentException(String.format("Invalid topic name: %s does not match the allowed format %s.", new Object[]{str, "[a-zA-Z0-9-_.~%]{1,900}"}));
        }
        return str;
    }

    public static a0 f(String str) {
        return new a0("S", str);
    }

    public String b() {
        return this.b;
    }

    public String c() {
        return this.a;
    }

    public String e() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof a0)) {
            return false;
        }
        a0 a0Var = (a0) obj;
        return this.a.equals(a0Var.a) && this.b.equals(a0Var.b);
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.q.c(this.b, this.a);
    }
}

package z1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class d {
    public static final Pattern b = Pattern.compile("ApolloCacheReference\\{(.*)\\}");
    public final String a;

    public d(String str) {
        this.a = str;
    }

    public static boolean a(String str) {
        return b.matcher(str).matches();
    }

    public static d b(String str) {
        Matcher matcher = b.matcher(str);
        if (matcher.find() && matcher.groupCount() == 1) {
            return new d(matcher.group(1));
        }
        throw new IllegalArgumentException("Not a cache reference: " + str + " Must be of the form:ApolloCacheReference{%s}");
    }

    public String c() {
        return this.a;
    }

    public String d() {
        return String.format("ApolloCacheReference{%s}", new Object[]{this.a});
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || d.class != obj.getClass()) {
            return false;
        }
        String str = this.a;
        String str2 = ((d) obj).a;
        return str != null ? str.equals(str2) : str2 == null;
    }

    public int hashCode() {
        String str = this.a;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String toString() {
        return this.a;
    }
}

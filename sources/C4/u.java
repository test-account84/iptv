package c4;

import d4.k0;
import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class u extends j {
    public static final Pattern h = Pattern.compile("^(.+)\\.(\\d+)\\.(\\d+)\\.v1\\.exo$", 32);
    public static final Pattern i = Pattern.compile("^(.+)\\.(\\d+)\\.(\\d+)\\.v2\\.exo$", 32);
    public static final Pattern j = Pattern.compile("^(\\d+)\\.(\\d+)\\.(\\d+)\\.v3\\.exo$", 32);

    public u(String str, long j2, long j3, long j4, File file) {
        super(str, j2, j3, j4, file);
    }

    public static u j(File file, long j2, long j3, m mVar) {
        File file2;
        String k;
        CharSequence name = file.getName();
        if (name.endsWith(".v3.exo")) {
            file2 = file;
        } else {
            File q = q(file, mVar);
            if (q == null) {
                return null;
            }
            file2 = q;
            name = q.getName();
        }
        Matcher matcher = j.matcher(name);
        if (!matcher.matches() || (k = mVar.k(Integer.parseInt((String) d4.a.e(matcher.group(1))))) == null) {
            return null;
        }
        long length = j2 == -1 ? file2.length() : j2;
        if (length == 0) {
            return null;
        }
        return new u(k, Long.parseLong((String) d4.a.e(matcher.group(2))), length, j3 == -9223372036854775807L ? Long.parseLong((String) d4.a.e(matcher.group(3))) : j3, file2);
    }

    public static u l(File file, long j2, m mVar) {
        return j(file, j2, -9223372036854775807L, mVar);
    }

    public static u n(String str, long j2, long j3) {
        return new u(str, j2, j3, -9223372036854775807L, null);
    }

    public static u o(String str, long j2) {
        return new u(str, j2, -1L, -9223372036854775807L, null);
    }

    public static File p(File file, int i2, long j2, long j3) {
        return new File(file, i2 + "." + j2 + "." + j3 + ".v3.exo");
    }

    public static File q(File file, m mVar) {
        String str;
        String name = file.getName();
        Matcher matcher = i.matcher(name);
        if (matcher.matches()) {
            str = k0.w1((String) d4.a.e(matcher.group(1)));
        } else {
            matcher = h.matcher(name);
            str = matcher.matches() ? (String) d4.a.e(matcher.group(1)) : null;
        }
        if (str == null) {
            return null;
        }
        File p = p((File) d4.a.i(file.getParentFile()), mVar.f(str), Long.parseLong((String) d4.a.e(matcher.group(2))), Long.parseLong((String) d4.a.e(matcher.group(3))));
        if (file.renameTo(p)) {
            return p;
        }
        return null;
    }

    public u i(File file, long j2) {
        d4.a.g(this.e);
        return new u(this.a, this.c, this.d, j2, file);
    }
}

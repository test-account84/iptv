package K3;

import O2.l1;
import d4.k0;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class w {
    public static final w c = new w(0, -9223372036854775807L);
    public static final Pattern d = Pattern.compile("npt[:=]([.\\d]+|now)\\s?-\\s?([.\\d]+)?");
    public final long a;
    public final long b;

    public w(long j, long j2) {
        this.a = j;
        this.b = j2;
    }

    public static String b(long j) {
        return k0.D("npt=%.3f-", Double.valueOf(j / 1000.0d));
    }

    public static w d(String str) {
        long parseFloat;
        Matcher matcher = d.matcher(str);
        com.google.android.exoplayer2.source.rtsp.h.a(matcher.matches(), str);
        String group = matcher.group(1);
        com.google.android.exoplayer2.source.rtsp.h.a(group != null, str);
        long parseFloat2 = ((String) k0.j(group)).equals("now") ? 0L : (long) (Float.parseFloat(group) * 1000.0f);
        String group2 = matcher.group(2);
        if (group2 != null) {
            try {
                parseFloat = (long) (Float.parseFloat(group2) * 1000.0f);
                com.google.android.exoplayer2.source.rtsp.h.a(parseFloat >= parseFloat2, str);
            } catch (NumberFormatException e) {
                throw l1.c(group2, e);
            }
        } else {
            parseFloat = -9223372036854775807L;
        }
        return new w(parseFloat2, parseFloat);
    }

    public long a() {
        return this.b - this.a;
    }

    public boolean c() {
        return this.b == -9223372036854775807L;
    }
}

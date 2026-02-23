package d3;

import d4.k0;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import q3.a;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class r {
    public static final Pattern c = Pattern.compile("^ [0-9a-fA-F]{8} ([0-9a-fA-F]{8}) ([0-9a-fA-F]{8})");
    public int a = -1;
    public int b = -1;

    public boolean a() {
        return (this.a == -1 || this.b == -1) ? false : true;
    }

    public final boolean b(String str) {
        Matcher matcher = c.matcher(str);
        if (!matcher.find()) {
            return false;
        }
        try {
            int parseInt = Integer.parseInt((String) k0.j(matcher.group(1)), 16);
            int parseInt2 = Integer.parseInt((String) k0.j(matcher.group(2)), 16);
            if (parseInt <= 0 && parseInt2 <= 0) {
                return false;
            }
            this.a = parseInt;
            this.b = parseInt2;
            return true;
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    public boolean c(q3.a aVar) {
        for (int i = 0; i < aVar.f(); i++) {
            a.b e = aVar.e(i);
            if (e instanceof v3.e) {
                v3.e eVar = (v3.e) e;
                if ("iTunSMPB".equals(eVar.d) && b(eVar.e)) {
                    return true;
                }
            } else if (e instanceof v3.j) {
                v3.j jVar = (v3.j) e;
                if ("com.apple.iTunes".equals(jVar.c) && "iTunSMPB".equals(jVar.d) && b(jVar.e)) {
                    return true;
                }
            } else {
                continue;
            }
        }
        return false;
    }

    public boolean d(int i) {
        int i2 = i >> 12;
        int i3 = i & 4095;
        if (i2 <= 0 && i3 <= 0) {
            return false;
        }
        this.a = i2;
        this.b = i3;
        return true;
    }
}

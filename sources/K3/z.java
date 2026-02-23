package K3;

import K3.a;
import K3.y;
import O2.l1;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class z {
    public static final Pattern a = Pattern.compile("([a-z])=\\s?(.+)");
    public static final Pattern b = Pattern.compile("([\\x21\\x23-\\x27\\x2a\\x2b\\x2d\\x2e\\x30-\\x39\\x41-\\x5a\\x5e-\\x7e]+)(?::(.*))?");
    public static final Pattern c = Pattern.compile("(\\S+)\\s(\\S+)\\s(\\S+)\\s(\\S+)");

    public static void a(y.b bVar, a.b bVar2) {
        try {
            bVar.n(bVar2.j());
        } catch (IllegalArgumentException | IllegalStateException e) {
            throw l1.c(null, e);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x019e, code lost:
    
        continue;
     */
    /* JADX WARN: Removed duplicated region for block: B:116:0x00e9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static K3.y b(java.lang.String r12) {
        /*
            Method dump skipped, instructions count: 558
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: K3.z.b(java.lang.String):K3.y");
    }

    public static a.b c(String str) {
        Matcher matcher = c.matcher(str);
        if (!matcher.matches()) {
            throw l1.c("Malformed SDP media description line: " + str, null);
        }
        try {
            return new a.b((String) d4.a.e(matcher.group(1)), Integer.parseInt((String) d4.a.e(matcher.group(2))), (String) d4.a.e(matcher.group(3)), Integer.parseInt((String) d4.a.e(matcher.group(4))));
        } catch (NumberFormatException e) {
            throw l1.c("Malformed SDP media description line: " + str, e);
        }
    }
}

package A7;

import android.content.Context;
import android.util.Base64;
import com.nst.iptvsmarterstvbox.model.database.LiveStreamDBHandler;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class a {
    public LiveStreamDBHandler a;
    public HashMap b = new HashMap();

    public final String a(String str) {
        return Base64.encodeToString(str.getBytes(StandardCharsets.UTF_8), 0).replace("\n", "");
    }

    public String b(InputStream inputStream) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder sb = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    inputStream.close();
                    return sb.toString();
                }
                sb.append(readLine + "\n");
            }
        } catch (Exception unused) {
            return "";
        }
    }

    public String c(InputStream inputStream, Context context) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String str = "";
            do {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                if ((readLine.contains("http://") && !readLine.contains("tvg-logo")) || (readLine.contains("https://") && !readLine.contains("tvg-logo"))) {
                    str = readLine;
                }
            } while (str.equals(""));
            inputStream.close();
            return str;
        } catch (Exception unused) {
            return "";
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:1034:0x1e20  */
    /* JADX WARN: Removed duplicated region for block: B:1095:0x1fde  */
    /* JADX WARN: Removed duplicated region for block: B:1156:0x219c  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x011a A[Catch: Exception -> 0x00fd, TRY_LEAVE, TryCatch #27 {Exception -> 0x00fd, blocks: (B:321:0x00e7, B:323:0x00ed, B:15:0x011a), top: B:320:0x00e7 }] */
    /* JADX WARN: Removed duplicated region for block: B:384:0x08c4 A[PHI: r13 r14 r25 r68
      0x08c4: PHI (r13v27 java.lang.String) = (r13v26 java.lang.String), (r13v28 java.lang.String) binds: [B:386:0x08c2, B:382:0x08b1] A[DONT_GENERATE, DONT_INLINE]
      0x08c4: PHI (r14v42 java.lang.String) = (r14v41 java.lang.String), (r14v43 java.lang.String) binds: [B:386:0x08c2, B:382:0x08b1] A[DONT_GENERATE, DONT_INLINE]
      0x08c4: PHI (r25v29 java.util.ArrayList) = (r25v28 java.util.ArrayList), (r25v30 java.util.ArrayList) binds: [B:386:0x08c2, B:382:0x08b1] A[DONT_GENERATE, DONT_INLINE]
      0x08c4: PHI (r68v9 java.util.ArrayList) = (r68v8 java.util.ArrayList), (r68v10 java.util.ArrayList) binds: [B:386:0x08c2, B:382:0x08b1] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:396:0x0a80  */
    /* JADX WARN: Removed duplicated region for block: B:445:0x0c24  */
    /* JADX WARN: Removed duplicated region for block: B:486:0x0dc4  */
    /* JADX WARN: Removed duplicated region for block: B:547:0x0fa8  */
    /* JADX WARN: Removed duplicated region for block: B:607:0x118e  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0256 A[Catch: Exception -> 0x023e, TRY_ENTER, TRY_LEAVE, TryCatch #113 {Exception -> 0x023e, blocks: (B:300:0x01fc, B:302:0x0202, B:305:0x0209, B:66:0x02af, B:72:0x02dd, B:77:0x0302, B:79:0x0312, B:82:0x031c, B:84:0x0322, B:85:0x0330, B:86:0x0334, B:87:0x0319, B:88:0x033d, B:90:0x0348, B:92:0x0353, B:94:0x035b, B:279:0x0361, B:69:0x02ca, B:307:0x0226, B:60:0x0256, B:62:0x0282, B:293:0x029b, B:298:0x026f, B:290:0x0288, B:296:0x025c), top: B:299:0x01fc, inners: #46, #67 }] */
    /* JADX WARN: Removed duplicated region for block: B:668:0x135e  */
    /* JADX WARN: Removed duplicated region for block: B:729:0x1530  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x02e3  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0302 A[Catch: Exception -> 0x023e, TryCatch #113 {Exception -> 0x023e, blocks: (B:300:0x01fc, B:302:0x0202, B:305:0x0209, B:66:0x02af, B:72:0x02dd, B:77:0x0302, B:79:0x0312, B:82:0x031c, B:84:0x0322, B:85:0x0330, B:86:0x0334, B:87:0x0319, B:88:0x033d, B:90:0x0348, B:92:0x0353, B:94:0x035b, B:279:0x0361, B:69:0x02ca, B:307:0x0226, B:60:0x0256, B:62:0x0282, B:293:0x029b, B:298:0x026f, B:290:0x0288, B:296:0x025c), top: B:299:0x01fc, inners: #46, #67 }] */
    /* JADX WARN: Removed duplicated region for block: B:790:0x1700  */
    /* JADX WARN: Removed duplicated region for block: B:851:0x18d2  */
    /* JADX WARN: Removed duplicated region for block: B:912:0x1aa4  */
    /* JADX WARN: Removed duplicated region for block: B:973:0x1c62  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean d(java.io.InputStream r71, android.content.Context r72) {
        /*
            Method dump skipped, instructions count: 10212
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: A7.a.d(java.io.InputStream, android.content.Context):boolean");
    }
}

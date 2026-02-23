package W1;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class j {
    public final q2.e a = new q2.e(1000);

    public String a(S1.c cVar) {
        String str;
        synchronized (this.a) {
            str = (String) this.a.g(cVar);
        }
        if (str == null) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
                cVar.a(messageDigest);
                str = q2.h.l(messageDigest.digest());
            } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            synchronized (this.a) {
                this.a.k(cVar, str);
            }
        }
        return str;
    }
}

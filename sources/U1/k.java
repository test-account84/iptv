package U1;

import java.security.MessageDigest;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class k implements S1.c {
    public final String a;
    public final S1.c b;

    public k(String str, S1.c cVar) {
        this.a = str;
        this.b = cVar;
    }

    public void a(MessageDigest messageDigest) {
        messageDigest.update(this.a.getBytes("UTF-8"));
        this.b.a(messageDigest);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        k kVar = (k) obj;
        return this.a.equals(kVar.a) && this.b.equals(kVar.b);
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }
}

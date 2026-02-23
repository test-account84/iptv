package F3;

import android.net.Uri;
import d4.b0;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class i {
    public final long a;
    public final long b;
    public final String c;
    public int d;

    public i(String str, long j, long j2) {
        this.c = str == null ? "" : str;
        this.a = j;
        this.b = j2;
    }

    public i a(i iVar, String str) {
        String c = c(str);
        if (iVar != null && c.equals(iVar.c(str))) {
            long j = this.b;
            if (j != -1) {
                long j2 = this.a;
                if (j2 + j == iVar.a) {
                    long j3 = iVar.b;
                    return new i(c, j2, j3 != -1 ? j + j3 : -1L);
                }
            }
            long j4 = iVar.b;
            if (j4 != -1) {
                long j5 = iVar.a;
                if (j5 + j4 == this.a) {
                    return new i(c, j5, j != -1 ? j4 + j : -1L);
                }
            }
        }
        return null;
    }

    public Uri b(String str) {
        return b0.e(str, this.c);
    }

    public String c(String str) {
        return b0.d(str, this.c);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || i.class != obj.getClass()) {
            return false;
        }
        i iVar = (i) obj;
        return this.a == iVar.a && this.b == iVar.b && this.c.equals(iVar.c);
    }

    public int hashCode() {
        if (this.d == 0) {
            this.d = ((((527 + ((int) this.a)) * 31) + ((int) this.b)) * 31) + this.c.hashCode();
        }
        return this.d;
    }

    public String toString() {
        return "RangedUri(referenceUri=" + this.c + ", start=" + this.a + ", length=" + this.b + ")";
    }
}

package q0;

import android.text.TextUtils;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class i implements c {
    public String a;
    public int b;
    public int c;

    public i(String str, int i, int i2) {
        this.a = str;
        this.b = i;
        this.c = i2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        return (this.b < 0 || iVar.b < 0) ? TextUtils.equals(this.a, iVar.a) && this.c == iVar.c : TextUtils.equals(this.a, iVar.a) && this.b == iVar.b && this.c == iVar.c;
    }

    public int hashCode() {
        return O.c.b(this.a, Integer.valueOf(this.c));
    }
}

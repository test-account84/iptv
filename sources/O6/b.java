package o6;

import com.google.android.gms.common.internal.q;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class b {
    public String a;

    public b(String str) {
        this.a = str;
    }

    public boolean equals(Object obj) {
        if (obj instanceof b) {
            return q.b(this.a, ((b) obj).a);
        }
        return false;
    }

    public int hashCode() {
        return q.c(this.a);
    }

    public String toString() {
        return q.d(this).a("token", this.a).toString();
    }
}

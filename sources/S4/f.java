package s4;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class f {
    public int a;
    public int b;
    public int c;
    public int d;
    public int e;
    public boolean f;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return this.a == fVar.a && this.b == fVar.b && this.c == fVar.c && this.d == fVar.d && this.e == fVar.e && this.f == fVar.f;
    }

    public final int hashCode() {
        return com.google.android.gms.common.internal.q.c(Integer.valueOf(this.a), Integer.valueOf(this.b), Integer.valueOf(this.c), Integer.valueOf(this.d), Integer.valueOf(this.e), Boolean.valueOf(this.f));
    }
}

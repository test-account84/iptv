package s4;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class c {
    public final int a;
    public final int b;
    public final boolean c;

    public c(int i, int i2, boolean z) {
        this.a = i;
        this.b = i2;
        this.c = z;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof c) && this.a == ((c) obj).a;
    }

    public final int hashCode() {
        return Integer.valueOf(this.a).hashCode();
    }
}

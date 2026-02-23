package j$.util.stream;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
final class Z1 extends a2 {
    public final void accept(Object obj) {
        this.b++;
    }

    public final Object get() {
        return Long.valueOf(this.b);
    }

    public final void h(U1 u1) {
        this.b += ((a2) u1).b;
    }
}

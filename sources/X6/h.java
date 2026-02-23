package x6;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class h extends i {
    public final i c;

    public h(i iVar) {
        super(iVar.d(), iVar.a());
        this.c = iVar;
    }

    public byte[] b() {
        byte[] b = this.c.b();
        int d = d() * a();
        byte[] bArr = new byte[d];
        for (int i = 0; i < d; i++) {
            bArr[i] = (byte) (255 - (b[i] & 255));
        }
        return bArr;
    }

    public byte[] c(int i, byte[] bArr) {
        byte[] c = this.c.c(i, bArr);
        int d = d();
        for (int i2 = 0; i2 < d; i2++) {
            c[i2] = (byte) (255 - (c[i2] & 255));
        }
        return c;
    }

    public i e() {
        return this.c;
    }

    public boolean f() {
        return this.c.f();
    }

    public i g() {
        return new h(this.c.g());
    }
}

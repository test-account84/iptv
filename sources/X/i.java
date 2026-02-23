package x;

import java.util.Arrays;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class i extends e implements h {
    public e[] w0 = new e[4];
    public int x0 = 0;

    public void b(e eVar) {
        if (eVar == this || eVar == null) {
            return;
        }
        int i = this.x0 + 1;
        e[] eVarArr = this.w0;
        if (i > eVarArr.length) {
            this.w0 = (e[]) Arrays.copyOf(eVarArr, eVarArr.length * 2);
        }
        e[] eVarArr2 = this.w0;
        int i2 = this.x0;
        eVarArr2[i2] = eVar;
        this.x0 = i2 + 1;
    }

    public void c() {
        this.x0 = 0;
        Arrays.fill(this.w0, (Object) null);
    }

    public void a(f fVar) {
    }
}

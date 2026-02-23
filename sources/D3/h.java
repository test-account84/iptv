package d3;

import O2.z0;
import d3.w;
import d4.M;
import java.io.EOFException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class h implements w {
    public final byte[] a = new byte[4096];

    public /* synthetic */ int a(b4.k kVar, int i, boolean z) {
        return v.a(this, kVar, i, z);
    }

    public /* synthetic */ void b(M m, int i) {
        v.b(this, m, i);
    }

    public void c(M m, int i, int i2) {
        m.V(i);
    }

    public int e(b4.k kVar, int i, boolean z, int i2) {
        int read = kVar.read(this.a, 0, Math.min(this.a.length, i));
        if (read != -1) {
            return read;
        }
        if (z) {
            return -1;
        }
        throw new EOFException();
    }

    public void d(z0 z0Var) {
    }

    public void f(long j, int i, int i2, int i3, w.a aVar) {
    }
}

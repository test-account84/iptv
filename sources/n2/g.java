package n2;

import n2.f;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class g implements d {
    public final f.a a;
    public c b;

    public g(f.a aVar) {
        this.a = aVar;
    }

    public c a(boolean z, boolean z2) {
        if (z || !z2) {
            return e.c();
        }
        if (this.b == null) {
            this.b = new f(this.a);
        }
        return this.b;
    }
}

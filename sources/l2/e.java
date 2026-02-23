package l2;

import Z1.l;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class e implements f {
    public final l a;
    public final i2.c c;
    public final b d;

    public e(l lVar, i2.c cVar, b bVar) {
        if (lVar == null) {
            throw new NullPointerException("ModelLoader must not be null");
        }
        this.a = lVar;
        if (cVar == null) {
            throw new NullPointerException("Transcoder must not be null");
        }
        this.c = cVar;
        if (bVar == null) {
            throw new NullPointerException("DataLoadProvider must not be null");
        }
        this.d = bVar;
    }

    public S1.b b() {
        return this.d.b();
    }

    public i2.c d() {
        return this.c;
    }

    public S1.f e() {
        return this.d.e();
    }

    public S1.e f() {
        return this.d.f();
    }

    public S1.e g() {
        return this.d.g();
    }

    public l h() {
        return this.a;
    }
}

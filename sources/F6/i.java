package f6;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class i implements c6.h {
    public boolean a = false;
    public boolean b = false;
    public c6.d c;
    public final f d;

    public i(f fVar) {
        this.d = fVar;
    }

    public final void a() {
        if (this.a) {
            throw new c6.c("Cannot encode a second value in the ValueEncoderContext");
        }
        this.a = true;
    }

    public c6.h add(String str) {
        a();
        this.d.d(this.c, str, this.b);
        return this;
    }

    public void b(c6.d dVar, boolean z) {
        this.a = false;
        this.c = dVar;
        this.b = z;
    }

    public c6.h add(boolean z) {
        a();
        this.d.j(this.c, z, this.b);
        return this;
    }
}

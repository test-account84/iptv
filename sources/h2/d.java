package h2;

import U1.l;
import java.io.OutputStream;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class d implements S1.f {
    public final S1.f a;
    public final S1.f b;
    public String c;

    public d(S1.f fVar, S1.f fVar2) {
        this.a = fVar;
        this.b = fVar2;
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public boolean a(l lVar, OutputStream outputStream) {
        a aVar = (a) lVar.get();
        l a = aVar.a();
        return a != null ? this.a.a(a, outputStream) : this.b.a(aVar.b(), outputStream);
    }

    public String getId() {
        if (this.c == null) {
            this.c = this.a.getId() + this.b.getId();
        }
        return this.c;
    }
}

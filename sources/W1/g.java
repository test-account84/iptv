package W1;

import U1.l;
import W1.h;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class g extends q2.e implements h {
    public h.a e;

    public g(int i) {
        super(i);
    }

    public /* bridge */ /* synthetic */ l a(S1.c cVar, l lVar) {
        return (l) super.k(cVar, lVar);
    }

    public void b(int i) {
        if (i >= 60) {
            c();
        } else if (i >= 40) {
            m(h() / 2);
        }
    }

    public /* bridge */ /* synthetic */ l d(S1.c cVar) {
        return (l) super.l(cVar);
    }

    public void e(h.a aVar) {
        this.e = aVar;
    }

    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public int i(l lVar) {
        return lVar.getSize();
    }

    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public void j(S1.c cVar, l lVar) {
        h.a aVar = this.e;
        if (aVar != null) {
            aVar.b(lVar);
        }
    }
}

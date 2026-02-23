package M4;

import java.util.Iterator;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class s implements Iterator {
    public final Iterator a;
    public final /* synthetic */ t c;

    public s(t tVar) {
        this.c = tVar;
        this.a = t.I(tVar).keySet().iterator();
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public final String next() {
        return (String) this.a.next();
    }

    public final boolean hasNext() {
        return this.a.hasNext();
    }

    public final void remove() {
        throw new UnsupportedOperationException("Remove not supported");
    }
}

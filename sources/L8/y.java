package l8;

import java.util.Iterator;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public abstract class y implements Iterator, x8.a {
    public abstract long b();

    public /* bridge */ /* synthetic */ Object next() {
        return Long.valueOf(b());
    }

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}

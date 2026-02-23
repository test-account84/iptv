package p4;

import android.util.LruCache;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class c0 extends LruCache {
    public final /* synthetic */ d a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c0(d dVar, int i) {
        super(i);
        this.a = dVar;
    }

    public final /* bridge */ /* synthetic */ void entryRemoved(boolean z, Object obj, Object obj2, Object obj3) {
        Integer num = (Integer) obj;
        if (z) {
            com.google.android.gms.common.internal.r.m(this.a.g);
            this.a.g.add(num);
        }
    }
}

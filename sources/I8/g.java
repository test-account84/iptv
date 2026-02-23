package I8;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public abstract class g {
    public static final f a(int i, e eVar, w8.l lVar) {
        if (i == -2) {
            return new d(eVar == e.SUSPEND ? f.a.a() : 1, eVar, lVar);
        }
        if (i != -1) {
            return i != 0 ? i != Integer.MAX_VALUE ? (i == 1 && eVar == e.DROP_OLDEST) ? new l(lVar) : new d(i, eVar, lVar) : new m(lVar) : eVar == e.SUSPEND ? new q(lVar) : new d(1, eVar, lVar);
        }
        if (eVar == e.SUSPEND) {
            return new l(lVar);
        }
        throw new IllegalArgumentException("CONFLATED capacity cannot be used with non-default onBufferOverflow".toString());
    }

    public static /* synthetic */ f b(int i, e eVar, w8.l lVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        if ((i2 & 2) != 0) {
            eVar = e.SUSPEND;
        }
        if ((i2 & 4) != 0) {
            lVar = null;
        }
        return a(i, eVar, lVar);
    }
}

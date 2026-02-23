package M6;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class i extends k {
    public static final k[] b = new k[0];
    public final k[] a;

    public i(Map map) {
        Collection collection = map == null ? null : (Collection) map.get(x6.e.POSSIBLE_FORMATS);
        boolean z = (map == null || map.get(x6.e.ASSUME_CODE_39_CHECK_DIGIT) == null) ? false : true;
        ArrayList arrayList = new ArrayList();
        if (collection != null) {
            if (collection.contains(x6.a.EAN_13) || collection.contains(x6.a.UPC_A) || collection.contains(x6.a.EAN_8) || collection.contains(x6.a.UPC_E)) {
                arrayList.add(new j(map));
            }
            if (collection.contains(x6.a.CODE_39)) {
                arrayList.add(new c(z));
            }
            if (collection.contains(x6.a.CODE_93)) {
                arrayList.add(new d());
            }
            if (collection.contains(x6.a.CODE_128)) {
                arrayList.add(new b());
            }
            if (collection.contains(x6.a.ITF)) {
                arrayList.add(new h());
            }
            if (collection.contains(x6.a.CODABAR)) {
                arrayList.add(new a());
            }
            if (collection.contains(x6.a.RSS_14)) {
                arrayList.add(new N6.e());
            }
            if (collection.contains(x6.a.RSS_EXPANDED)) {
                arrayList.add(new O6.d());
            }
        }
        if (arrayList.isEmpty()) {
            arrayList.add(new j(map));
            arrayList.add(new c());
            arrayList.add(new a());
            arrayList.add(new d());
            arrayList.add(new b());
            arrayList.add(new h());
            arrayList.add(new N6.e());
            arrayList.add(new O6.d());
        }
        this.a = (k[]) arrayList.toArray(b);
    }

    public x6.o c(int i, D6.a aVar, Map map) {
        for (k kVar : this.a) {
            try {
                return kVar.c(i, aVar, map);
            } catch (x6.n unused) {
            }
        }
        throw x6.k.a();
    }

    public void reset() {
        for (k kVar : this.a) {
            kVar.reset();
        }
    }
}

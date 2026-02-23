package x6;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class j implements m {
    public static final m[] c = new m[0];
    public Map a;
    public m[] b;

    public o a(c cVar) {
        e(null);
        return c(cVar);
    }

    public o b(c cVar, Map map) {
        e(map);
        return c(cVar);
    }

    public final o c(c cVar) {
        m[] mVarArr = this.b;
        if (mVarArr != null) {
            for (m mVar : mVarArr) {
                try {
                    return mVar.b(cVar, this.a);
                } catch (n unused) {
                }
            }
        }
        throw k.a();
    }

    public o d(c cVar) {
        if (this.b == null) {
            e(null);
        }
        return c(cVar);
    }

    public void e(Map map) {
        this.a = map;
        boolean z = map != null && map.containsKey(e.TRY_HARDER);
        Collection collection = map == null ? null : (Collection) map.get(e.POSSIBLE_FORMATS);
        ArrayList arrayList = new ArrayList();
        if (collection != null) {
            boolean z2 = collection.contains(a.UPC_A) || collection.contains(a.UPC_E) || collection.contains(a.EAN_13) || collection.contains(a.EAN_8) || collection.contains(a.CODABAR) || collection.contains(a.CODE_39) || collection.contains(a.CODE_93) || collection.contains(a.CODE_128) || collection.contains(a.ITF) || collection.contains(a.RSS_14) || collection.contains(a.RSS_EXPANDED);
            if (z2 && !z) {
                arrayList.add(new M6.i(map));
            }
            if (collection.contains(a.QR_CODE)) {
                arrayList.add(new U6.a());
            }
            if (collection.contains(a.DATA_MATRIX)) {
                arrayList.add(new G6.a());
            }
            if (collection.contains(a.AZTEC)) {
                arrayList.add(new y6.b());
            }
            if (collection.contains(a.PDF_417)) {
                arrayList.add(new Q6.b());
            }
            if (collection.contains(a.MAXICODE)) {
                arrayList.add(new K6.a());
            }
            if (z2 && z) {
                arrayList.add(new M6.i(map));
            }
        }
        if (arrayList.isEmpty()) {
            if (!z) {
                arrayList.add(new M6.i(map));
            }
            arrayList.add(new U6.a());
            arrayList.add(new G6.a());
            arrayList.add(new y6.b());
            arrayList.add(new Q6.b());
            arrayList.add(new K6.a());
            if (z) {
                arrayList.add(new M6.i(map));
            }
        }
        this.b = (m[]) arrayList.toArray(c);
    }

    public void reset() {
        m[] mVarArr = this.b;
        if (mVarArr != null) {
            for (m mVar : mVarArr) {
                mVar.reset();
            }
        }
    }
}

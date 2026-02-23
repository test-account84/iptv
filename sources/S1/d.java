package S1;

import U1.l;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class d implements g {
    public final Collection a;
    public String b;

    public d(g... gVarArr) {
        if (gVarArr.length < 1) {
            throw new IllegalArgumentException("MultiTransformation must contain at least one Transformation");
        }
        this.a = Arrays.asList(gVarArr);
    }

    public l a(l lVar, int i, int i2) {
        Iterator it = this.a.iterator();
        l lVar2 = lVar;
        while (it.hasNext()) {
            l a = ((g) it.next()).a(lVar2, i, i2);
            if (lVar2 != null && !lVar2.equals(lVar) && !lVar2.equals(a)) {
                lVar2.b();
            }
            lVar2 = a;
        }
        return lVar2;
    }

    public String getId() {
        if (this.b == null) {
            StringBuilder sb = new StringBuilder();
            Iterator it = this.a.iterator();
            while (it.hasNext()) {
                sb.append(((g) it.next()).getId());
            }
            this.b = sb.toString();
        }
        return this.b;
    }
}

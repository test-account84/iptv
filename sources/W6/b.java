package w6;

import I5.e;
import I5.j;
import com.google.firebase.components.ComponentRegistrar;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class b implements j {
    public static /* synthetic */ Object b(String str, I5.c cVar, e eVar) {
        return c(str, cVar, eVar);
    }

    public static /* synthetic */ Object c(String str, I5.c cVar, e eVar) {
        try {
            c.b(str);
            return cVar.h().a(eVar);
        } finally {
            c.a();
        }
    }

    public List a(ComponentRegistrar componentRegistrar) {
        ArrayList arrayList = new ArrayList();
        for (I5.c cVar : componentRegistrar.getComponents()) {
            String i = cVar.i();
            if (i != null) {
                cVar = cVar.t(new a(i, cVar));
            }
            arrayList.add(cVar);
        }
        return arrayList;
    }
}

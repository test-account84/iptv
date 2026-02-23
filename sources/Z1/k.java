package z1;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class k {
    public final Map a = new LinkedHashMap();

    public Collection a() {
        return this.a.values();
    }

    public Set b(i iVar) {
        i iVar2 = (i) this.a.get(iVar.g());
        if (iVar2 != null) {
            return iVar2.h(iVar);
        }
        this.a.put(iVar.g(), iVar);
        return Collections.emptySet();
    }
}

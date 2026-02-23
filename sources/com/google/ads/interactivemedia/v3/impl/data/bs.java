package com.google.ads.interactivemedia.v3.impl.data;

import com.google.ads.interactivemedia.v3.api.FriendlyObstruction;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class bs {
    public abstract bv build();

    public bs friendlyObstructions(Collection collection) {
        ArrayList arrayList = new ArrayList();
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            FriendlyObstruction friendlyObstruction = (FriendlyObstruction) it.next();
            arrayList.add(bu.builder().view(friendlyObstruction.getView()).purpose(friendlyObstruction.getPurpose()).detailedReason(friendlyObstruction.getDetailedReason()).build());
        }
        return obstructions(arrayList);
    }

    public abstract bs obstructions(List list);
}

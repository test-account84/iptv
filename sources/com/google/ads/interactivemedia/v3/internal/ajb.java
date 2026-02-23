package com.google.ads.interactivemedia.v3.internal;

import android.view.View;
import android.view.ViewGroup;
import com.google.ads.interactivemedia.v3.api.BaseDisplayContainer;
import com.google.ads.interactivemedia.v3.api.CompanionAdSlot;
import com.google.ads.interactivemedia.v3.api.FriendlyObstruction;
import com.google.ads.interactivemedia.v3.api.FriendlyObstructionPurpose;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class ajb implements BaseDisplayContainer {
    private static int a;
    private ViewGroup b;
    private Collection c = avo.o();
    private Map d = awb.n();
    private final Set e = new HashSet();
    private aja f = null;
    private boolean g = false;

    public ajb(ViewGroup viewGroup) {
        this.b = viewGroup;
    }

    public final Map a() {
        return this.d;
    }

    public final Set b() {
        return new HashSet(this.e);
    }

    public final void c(aja ajaVar) {
        this.f = ajaVar;
    }

    public final void claim() {
        atp.f(!this.g, "A given DisplayContainer may only be used once");
        this.g = true;
    }

    public final void destroy() {
        ViewGroup viewGroup = this.b;
        if (viewGroup != null) {
            viewGroup.removeAllViews();
        }
    }

    public final ViewGroup getAdContainer() {
        return this.b;
    }

    public final Collection getCompanionSlots() {
        return this.c;
    }

    public final void registerFriendlyObstruction(FriendlyObstruction friendlyObstruction) {
        if (friendlyObstruction == null || this.e.contains(friendlyObstruction)) {
            return;
        }
        this.e.add(friendlyObstruction);
        aja ajaVar = this.f;
        if (ajaVar != null) {
            ((akn) ajaVar).c(friendlyObstruction);
        }
    }

    public final void registerVideoControlsOverlay(View view) {
        if (view == null) {
            return;
        }
        com.google.ads.interactivemedia.v3.impl.data.bc builder = com.google.ads.interactivemedia.v3.impl.data.bd.builder();
        builder.view(view);
        builder.purpose(FriendlyObstructionPurpose.VIDEO_CONTROLS);
        com.google.ads.interactivemedia.v3.impl.data.bd build = builder.build();
        if (this.e.contains(build)) {
            return;
        }
        this.e.add(build);
        aja ajaVar = this.f;
        if (ajaVar != null) {
            ((akn) ajaVar).c(build);
        }
    }

    public final void setAdContainer(ViewGroup viewGroup) {
        atp.k(viewGroup);
        this.b = viewGroup;
    }

    public final void setCompanionSlots(Collection collection) {
        if (collection == null) {
            collection = avo.o();
        }
        avq avqVar = new avq();
        for (CompanionAdSlot companionAdSlot : collection) {
            if (companionAdSlot != null) {
                int i = a;
                a = i + 1;
                avqVar.a("compSlot_" + i, companionAdSlot);
            }
        }
        this.d = avqVar.b();
        this.c = collection;
    }

    public final void unregisterAllFriendlyObstructions() {
        this.e.clear();
        aja ajaVar = this.f;
        if (ajaVar != null) {
            ((akn) ajaVar).g();
        }
    }

    public final void unregisterAllVideoControlsOverlays() {
        this.e.clear();
        aja ajaVar = this.f;
        if (ajaVar != null) {
            ((akn) ajaVar).g();
        }
    }
}

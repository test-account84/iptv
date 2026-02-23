package com.google.ads.interactivemedia.v3.internal;

import android.content.Context;
import android.view.View;
import com.google.ads.interactivemedia.v3.api.AdErrorEvent;
import com.google.ads.interactivemedia.v3.api.AdEvent;
import com.google.ads.interactivemedia.v3.api.FriendlyObstruction;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class akn implements AdEvent.AdEventListener, AdErrorEvent.AdErrorListener, aja, ajw {
    private final ajx a;
    private final akm b;
    private final Context c;
    private View d;
    private String e;
    private final Set f;
    private boolean g;
    private boolean h;
    private String i;
    private agq j;

    public akn(ajx ajxVar, Context context) {
        akm akmVar = new akm();
        this.g = false;
        this.h = false;
        this.i = null;
        this.a = ajxVar;
        this.c = context;
        this.b = akmVar;
        this.f = new HashSet();
    }

    private final void j(List list) {
        com.google.ads.interactivemedia.v3.impl.data.bv bvVar;
        if (list == null) {
            bvVar = null;
        } else if (list.isEmpty()) {
            return;
        } else {
            bvVar = com.google.ads.interactivemedia.v3.impl.data.bv.builder().friendlyObstructions(list).build();
        }
        this.a.o(new ajr(ajp.omid, ajq.registerFriendlyObstructions, this.e, bvVar));
    }

    public final void a() {
        this.g = false;
    }

    public final void b() {
        ago.b(this.c);
        this.g = true;
    }

    public final void c(FriendlyObstruction friendlyObstruction) {
        if (this.f.contains(friendlyObstruction)) {
            return;
        }
        this.f.add(friendlyObstruction);
        agq agqVar = this.j;
        if (agqVar == null) {
            return;
        }
        agqVar.a(friendlyObstruction.getView(), friendlyObstruction.getPurpose().getOmidPurpose(), friendlyObstruction.getDetailedReason());
        j(Arrays.asList(new FriendlyObstruction[]{friendlyObstruction}));
    }

    public final void d(View view) {
        this.d = view;
    }

    public final void e(String str) {
        this.i = str;
    }

    public final void f(String str) {
        this.e = str;
    }

    public final void g() {
        this.f.clear();
        agq agqVar = this.j;
        if (agqVar == null) {
            return;
        }
        agqVar.d();
        j(null);
    }

    public final void h() {
        agq agqVar;
        if (!this.g || (agqVar = this.j) == null) {
            return;
        }
        agqVar.b();
        this.j = null;
    }

    public final void i() {
        this.h = true;
    }

    public final void onAdError(AdErrorEvent adErrorEvent) {
        agq agqVar;
        if (!this.g || (agqVar = this.j) == null) {
            return;
        }
        agqVar.b();
        this.j = null;
    }

    public final void onAdEvent(AdEvent adEvent) {
        if (this.g) {
            AdEvent.AdEventType adEventType = AdEvent.AdEventType.ALL_ADS_COMPLETED;
            int ordinal = adEvent.getType().ordinal();
            if (ordinal == 3 || ordinal == 14) {
                h();
                return;
            }
            if (ordinal == 15 && this.g && this.j == null && this.d != null) {
                agu aguVar = agu.DEFINED_BY_JAVASCRIPT;
                agw agwVar = agw.DEFINED_BY_JAVASCRIPT;
                agx agxVar = agx.JAVASCRIPT;
                agq f = agq.f(ly.k(aguVar, agwVar, agxVar, agxVar), agr.g(bdy.n(), this.a.a(), this.i, "{ssai:" + (true != this.h ? "false" : "true") + "}"));
                f.c(this.d);
                for (FriendlyObstruction friendlyObstruction : this.f) {
                    f.a(friendlyObstruction.getView(), friendlyObstruction.getPurpose().getOmidPurpose(), friendlyObstruction.getDetailedReason());
                }
                j(new ArrayList(this.f));
                f.e();
                this.j = f;
            }
        }
    }
}

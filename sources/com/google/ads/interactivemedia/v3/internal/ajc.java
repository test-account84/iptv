package com.google.ads.interactivemedia.v3.internal;

import android.app.Application;
import android.content.Context;
import com.google.ads.interactivemedia.v3.api.Ad;
import com.google.ads.interactivemedia.v3.api.AdError;
import com.google.ads.interactivemedia.v3.api.AdErrorEvent;
import com.google.ads.interactivemedia.v3.api.AdEvent;
import com.google.ads.interactivemedia.v3.api.AdProgressInfo;
import com.google.ads.interactivemedia.v3.api.AdsRenderingSettings;
import com.google.ads.interactivemedia.v3.api.BaseDisplayContainer;
import com.google.ads.interactivemedia.v3.api.BaseManager;
import com.google.ads.interactivemedia.v3.api.FriendlyObstruction;
import com.google.ads.interactivemedia.v3.api.player.VideoProgressUpdate;
import com.google.ads.interactivemedia.v3.impl.data.ResizeAndPositionVideoMsgData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
abstract class ajc implements BaseManager, ajv, alf {
    private final ajx a;
    private final String b;
    private final ajj d;
    private final Context e;
    private final aid f;
    private final akn g;
    private final akw h;
    private com.google.ads.interactivemedia.v3.impl.data.c i;
    private AdProgressInfo j;
    private final aly m;
    private alg n;
    private final List c = new ArrayList(1);
    private boolean l = false;
    private AdsRenderingSettings k = new com.google.ads.interactivemedia.v3.impl.data.g();

    public ajc(String str, ajx ajxVar, akw akwVar, BaseDisplayContainer baseDisplayContainer, aid aidVar, akn aknVar, ajj ajjVar, Context context, boolean z) {
        this.b = str;
        this.a = ajxVar;
        this.h = akwVar;
        this.e = context;
        this.d = ajjVar;
        this.f = aidVar;
        aidVar.j(z);
        if (aknVar == null) {
            aknVar = null;
        } else {
            aknVar.f(str);
            aknVar.d(baseDisplayContainer.getAdContainer());
            addAdEventListener(aknVar);
            addAdErrorListener(aknVar);
            ajb ajbVar = (ajb) baseDisplayContainer;
            Iterator it = ajbVar.b().iterator();
            while (it.hasNext()) {
                aknVar.c((FriendlyObstruction) it.next());
            }
            ajbVar.c(aknVar);
        }
        this.g = aknVar;
        this.m = new aly(context, this.k);
        ajxVar.g(this, str);
        ajxVar.i(this.h, str);
        aidVar.f();
        Application a = com.google.ads.interactivemedia.v3.impl.data.k.a(context);
        if (a != null) {
            alg algVar = new alg(a);
            this.n = algVar;
            algVar.a(this);
        }
    }

    private final void o(AdErrorEvent adErrorEvent) {
        this.j = null;
        this.d.c(adErrorEvent);
    }

    private final void p(String str) {
        if (com.google.ads.interactivemedia.v3.impl.data.k.b(this.e, this.a.b())) {
            this.a.a().requestFocus();
            this.a.o(new ajr(ajp.userInteraction, ajq.focusUiElement, str));
        }
    }

    private final boolean q() {
        return this.k.getFocusSkipButtonWhenAvailable();
    }

    public Map a(AdsRenderingSettings adsRenderingSettings) {
        HashMap hashMap = new HashMap();
        hashMap.put("adsRenderingSettings", com.google.ads.interactivemedia.v3.impl.data.f.builder(adsRenderingSettings).build());
        return hashMap;
    }

    public final void addAdErrorListener(AdErrorEvent.AdErrorListener adErrorListener) {
        this.d.a(adErrorListener);
    }

    public final void addAdEventListener(AdEvent.AdEventListener adEventListener) {
        this.c.add(adEventListener);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0051  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void b(com.google.ads.interactivemedia.v3.internal.aju r6) {
        /*
            r5 = this;
            com.google.ads.interactivemedia.v3.api.AdEvent$AdEventType r0 = r6.a
            com.google.ads.interactivemedia.v3.impl.data.c r1 = r6.b
            com.google.ads.interactivemedia.v3.impl.data.az r2 = com.google.ads.interactivemedia.v3.impl.data.az.Html
            com.google.ads.interactivemedia.v3.api.AdEvent$AdEventType r2 = com.google.ads.interactivemedia.v3.api.AdEvent.AdEventType.ALL_ADS_COMPLETED
            int r2 = r0.ordinal()
            r3 = 3
            r4 = 0
            if (r2 == r3) goto L51
            r3 = 24
            if (r2 == r3) goto L51
            r3 = 5
            if (r2 == r3) goto L4b
            r3 = 6
            if (r2 == r3) goto L45
            r3 = 20
            if (r2 == r3) goto L42
            r3 = 21
            if (r2 == r3) goto L3d
            switch(r2) {
                case 13: goto L36;
                case 14: goto L51;
                case 15: goto L26;
                default: goto L25;
            }
        L25:
            goto L53
        L26:
            if (r1 == 0) goto L2a
            r5.i = r1
        L2a:
            boolean r1 = r5.q()
            if (r1 == 0) goto L53
        L30:
            java.lang.String r1 = r5.b
            r5.p(r1)
            goto L53
        L36:
            boolean r1 = r5.q()
            if (r1 == 0) goto L53
            goto L30
        L3d:
            com.google.ads.interactivemedia.v3.api.AdProgressInfo r1 = r6.e
            r5.j = r1
            goto L53
        L42:
            r5.i = r1
            goto L53
        L45:
            com.google.ads.interactivemedia.v3.internal.aid r1 = r5.f
            r1.k()
            goto L53
        L4b:
            com.google.ads.interactivemedia.v3.internal.aid r1 = r5.f
            r1.i()
            goto L53
        L51:
            r5.j = r4
        L53:
            java.util.Map r6 = r6.c
            com.google.ads.interactivemedia.v3.internal.aig r1 = new com.google.ads.interactivemedia.v3.internal.aig
            com.google.ads.interactivemedia.v3.impl.data.c r2 = r5.i
            r1.<init>(r0, r2, r6)
            java.util.List r6 = r5.c
            java.util.Iterator r6 = r6.iterator()
        L62:
            boolean r2 = r6.hasNext()
            if (r2 == 0) goto L72
            java.lang.Object r2 = r6.next()
            com.google.ads.interactivemedia.v3.api.AdEvent$AdEventListener r2 = (com.google.ads.interactivemedia.v3.api.AdEvent.AdEventListener) r2
            r2.onAdEvent(r1)
            goto L62
        L72:
            com.google.ads.interactivemedia.v3.api.AdEvent$AdEventType r6 = com.google.ads.interactivemedia.v3.api.AdEvent.AdEventType.COMPLETED
            if (r0 == r6) goto L7c
            com.google.ads.interactivemedia.v3.api.AdEvent$AdEventType r6 = com.google.ads.interactivemedia.v3.api.AdEvent.AdEventType.SKIPPED
            if (r0 != r6) goto L7b
            goto L7c
        L7b:
            return
        L7c:
            r5.i = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.ajc.b(com.google.ads.interactivemedia.v3.internal.aju):void");
    }

    public final akw c() {
        return this.h;
    }

    public final void d() {
        this.a.o(new ajr(ajp.adsManager, ajq.appBackgrounding, this.b));
    }

    public void destroy() {
        this.l = true;
        this.g.h();
        this.f.g();
        this.f.k();
        alg algVar = this.n;
        if (algVar != null) {
            algVar.b();
        }
        this.h.c();
    }

    public final void e() {
        this.a.o(new ajr(ajp.adsManager, ajq.appForegrounding, this.b));
    }

    public final void f(AdError.AdErrorType adErrorType, int i, String str) {
        o(new aif(new AdError(adErrorType, i, str)));
    }

    public final void focus() {
        p(this.b);
    }

    public final void g(AdError.AdErrorType adErrorType, AdError.AdErrorCode adErrorCode, String str) {
        o(new aif(new AdError(adErrorType, adErrorCode, str)));
    }

    public final VideoProgressUpdate getAdProgress() {
        return this.l ? VideoProgressUpdate.VIDEO_TIME_NOT_READY : this.h.getAdProgress();
    }

    public final AdProgressInfo getAdProgressInfo() {
        return this.j;
    }

    public final Ad getCurrentAd() {
        return this.i;
    }

    public final void h(String str) {
        this.m.a(str);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0064  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void i(android.view.ViewGroup r10, com.google.ads.interactivemedia.v3.impl.data.CompanionData r11, java.lang.String r12, com.google.ads.interactivemedia.v3.api.CompanionAdSlot r13, com.google.ads.interactivemedia.v3.internal.ajx r14, com.google.ads.interactivemedia.v3.internal.all r15) {
        /*
            r9 = this;
            r10.removeAllViews()
            com.google.ads.interactivemedia.v3.internal.ajd r13 = (com.google.ads.interactivemedia.v3.internal.ajd) r13
            java.util.List r6 = r13.a()
            com.google.ads.interactivemedia.v3.impl.data.az r0 = com.google.ads.interactivemedia.v3.impl.data.az.Html
            com.google.ads.interactivemedia.v3.api.AdEvent$AdEventType r0 = com.google.ads.interactivemedia.v3.api.AdEvent.AdEventType.ALL_ADS_COMPLETED
            com.google.ads.interactivemedia.v3.impl.data.az r0 = r11.type()
            int r0 = r0.ordinal()
            if (r0 == 0) goto L64
            r1 = 0
            r2 = 2
            r3 = 1
            if (r0 == r3) goto L1f
            if (r0 == r2) goto L64
            goto L6f
        L1f:
            android.content.Context r4 = r10.getContext()
            java.lang.String r0 = r11.src()
            java.lang.String r5 = r11.size()
            if (r5 != 0) goto L2e
            goto L51
        L2e:
            java.lang.String r1 = "x"
            r7 = -1
            java.lang.String[] r1 = r5.split(r1, r7)
            int r5 = r1.length
            r7 = 0
            if (r5 == r2) goto L3f
            com.google.ads.interactivemedia.v3.impl.data.bh r1 = new com.google.ads.interactivemedia.v3.impl.data.bh
            r1.<init>(r7, r7)
            goto L51
        L3f:
            com.google.ads.interactivemedia.v3.impl.data.bh r2 = new com.google.ads.interactivemedia.v3.impl.data.bh
            r5 = r1[r7]
            int r5 = java.lang.Integer.parseInt(r5)
            r1 = r1[r3]
            int r1 = java.lang.Integer.parseInt(r1)
            r2.<init>(r5, r1)
            r1 = r2
        L51:
            com.google.android.gms.tasks.Task r15 = r15.b(r0, r1)
            com.google.ads.interactivemedia.v3.internal.ajn r8 = new com.google.ads.interactivemedia.v3.internal.ajn
            com.google.ads.interactivemedia.v3.internal.aly r7 = r9.m
            r0 = r8
            r1 = r4
            r2 = r14
            r3 = r11
            r4 = r15
            r5 = r12
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            r1 = r8
            goto L6f
        L64:
            com.google.ads.interactivemedia.v3.internal.ajg r1 = new com.google.ads.interactivemedia.v3.internal.ajg
            android.content.Context r14 = r10.getContext()
            com.google.ads.interactivemedia.v3.internal.aly r15 = r9.m
            r1.<init>(r14, r11, r6, r15)
        L6f:
            if (r1 == 0) goto L7a
            r1.setTag(r12)
            r13.b(r12)
            r10.addView(r1)
        L7a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.ajc.i(android.view.ViewGroup, com.google.ads.interactivemedia.v3.impl.data.CompanionData, java.lang.String, com.google.ads.interactivemedia.v3.api.CompanionAdSlot, com.google.ads.interactivemedia.v3.internal.ajx, com.google.ads.interactivemedia.v3.internal.all):void");
    }

    public final void init() {
        init(null);
    }

    public final void j(ResizeAndPositionVideoMsgData resizeAndPositionVideoMsgData) {
        this.h.g(resizeAndPositionVideoMsgData);
    }

    public final void k() {
        this.h.h();
    }

    public final void l() {
        this.a.n(this.b);
        this.c.clear();
        this.d.b();
    }

    public final void m(ajp ajpVar, ajq ajqVar, Object obj) {
        this.a.o(new ajr(ajpVar, ajqVar, this.b, obj));
    }

    public final void n(ajq ajqVar) {
        this.a.o(new ajr(ajp.adsManager, ajqVar, this.b));
    }

    public final void removeAdErrorListener(AdErrorEvent.AdErrorListener adErrorListener) {
        this.d.d(adErrorListener);
    }

    public final void removeAdEventListener(AdEvent.AdEventListener adEventListener) {
        this.c.remove(adEventListener);
    }

    public final void init(AdsRenderingSettings adsRenderingSettings) {
        if (adsRenderingSettings != null) {
            this.k = adsRenderingSettings;
            this.m.b(adsRenderingSettings);
        }
        this.a.o(new ajr(ajp.adsManager, ajq.init, this.b, a(this.k)));
        this.h.d();
    }
}

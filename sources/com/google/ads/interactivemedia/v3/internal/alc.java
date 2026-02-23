package com.google.ads.interactivemedia.v3.internal;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import android.view.SurfaceView;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.ads.interactivemedia.v3.api.AdPodInfo;
import com.google.ads.interactivemedia.v3.api.player.AdMediaInfo;
import com.google.ads.interactivemedia.v3.api.player.ResizablePlayer;
import com.google.ads.interactivemedia.v3.api.player.VideoAdPlayer;
import com.google.ads.interactivemedia.v3.api.player.VideoProgressUpdate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class alc implements VideoAdPlayer, ResizablePlayer, ald, aky {
    private final hn a;
    private final SurfaceView b;
    private final aew c;
    private final FrameLayout d;
    private final ViewGroup e;
    private final List f;
    private final HashSet g;
    private final akz h;
    private final ala i;
    private final alb j;
    private final ArrayList k;
    private final df l;
    private sp m;
    private AdPodInfo n;
    private int o;

    public alc(Context context, ViewGroup viewGroup) {
        hn a = hm.a(new fa(context, new ale(context)));
        this.k = new ArrayList();
        this.e = viewGroup;
        this.a = a;
        String as = cq.as(context);
        dg dgVar = new dg();
        dgVar.b(as);
        this.l = new df(context, dgVar);
        this.f = new ArrayList(1);
        ala alaVar = new ala(this);
        this.i = alaVar;
        this.g = axo.d(4);
        alb albVar = new alb(this);
        this.j = albVar;
        akz akzVar = new akz();
        this.h = akzVar;
        akzVar.b(this);
        a.x(alaVar);
        a.y(albVar);
        FrameLayout frameLayout = new FrameLayout(context);
        this.d = frameLayout;
        frameLayout.setBackgroundColor(-16777216);
        aew aewVar = new aew(context);
        this.c = aewVar;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        aewVar.setLayoutParams(layoutParams);
        this.o = 1;
        SurfaceView surfaceView = new SurfaceView(context);
        this.b = surfaceView;
        surfaceView.setZOrderMediaOverlay(true);
        a.F(surfaceView);
        aewVar.addView(surfaceView);
        frameLayout.addView(aewVar);
        viewGroup.addView(frameLayout, new ViewGroup.LayoutParams(-1, -1));
    }

    public static /* bridge */ /* synthetic */ hn b(alc alcVar) {
        return alcVar.a;
    }

    public static /* bridge */ /* synthetic */ sp c(alc alcVar) {
        return alcVar.m;
    }

    public static /* bridge */ /* synthetic */ aew d(alc alcVar) {
        return alcVar.c;
    }

    public static /* bridge */ /* synthetic */ AdMediaInfo e(alc alcVar, int i) {
        return alcVar.j(i);
    }

    public static /* bridge */ /* synthetic */ AdMediaInfo f(alc alcVar) {
        return alcVar.k();
    }

    public static /* bridge */ /* synthetic */ HashSet g(alc alcVar) {
        return alcVar.g;
    }

    public static /* bridge */ /* synthetic */ List h(alc alcVar) {
        return alcVar.f;
    }

    private final int i(AdMediaInfo adMediaInfo) {
        return this.k.indexOf(adMediaInfo);
    }

    private final AdMediaInfo j(int i) {
        if (i < 0 || i >= this.k.size()) {
            return null;
        }
        return (AdMediaInfo) this.k.get(i);
    }

    private final AdMediaInfo k() {
        int h = this.a.h();
        if (this.m == null) {
            return null;
        }
        return j(h);
    }

    private final void l(AdMediaInfo adMediaInfo) {
        tg a;
        Uri parse = Uri.parse(adMediaInfo.getUrl());
        ai a2 = ai.a(parse);
        int m = cq.m(parse);
        if (m == 0) {
            a = new lc(this.l).a(a2);
        } else if (m == 2) {
            a = new pb(this.l).a(a2);
        } else {
            if (m != 4) {
                throw new IllegalStateException("Unsupported type: " + m);
            }
            a = new tx(this.l, new xv(new zl(1, null)), null, null).a(a2);
        }
        sp spVar = this.m;
        atp.k(spVar);
        spVar.m(a);
        this.k.add(adMediaInfo);
    }

    private final void m() {
        this.d.setVisibility(8);
        this.b.setVisibility(4);
        this.m = null;
        this.h.d();
        this.o = 1;
        this.a.G();
        this.a.H();
        this.g.clear();
    }

    public final void a() {
        AdMediaInfo k = k();
        VideoProgressUpdate adProgress = getAdProgress();
        Iterator it = this.f.iterator();
        while (it.hasNext()) {
            ((VideoAdPlayer.VideoAdPlayerCallback) it.next()).onAdProgress(k, adProgress);
        }
    }

    public final void addCallback(VideoAdPlayer.VideoAdPlayerCallback videoAdPlayerCallback) {
        this.f.add(videoAdPlayerCallback);
    }

    public final VideoProgressUpdate getAdProgress() {
        return ((this.a.j() == 2 || this.a.j() == 3) && this.a.v() > 0) ? new VideoProgressUpdate(this.a.m(), this.a.v()) : VideoProgressUpdate.VIDEO_TIME_NOT_READY;
    }

    public final int getVolume() {
        return 100;
    }

    public final void loadAd(AdMediaInfo adMediaInfo, AdPodInfo adPodInfo) {
        if (this.m != null) {
            AdPodInfo adPodInfo2 = this.n;
            if (adPodInfo2 == null || adPodInfo == null || adPodInfo2.getPodIndex() != adPodInfo.getPodIndex()) {
                throw new IllegalStateException("Called loadAd on an ad from a different ad break.");
            }
            l(adMediaInfo);
            return;
        }
        this.a.G();
        hn hnVar = this.a;
        hnVar.u(hnVar.h());
        this.k.clear();
        this.m = new sp(new ui(), new tg[0]);
        this.n = adPodInfo;
        l(adMediaInfo);
        this.a.D(false);
        this.a.z(this.m);
        this.o = 2;
    }

    public final void pauseAd(AdMediaInfo adMediaInfo) {
        this.h.d();
        this.o = 4;
        this.a.D(false);
        Iterator it = this.f.iterator();
        while (it.hasNext()) {
            ((VideoAdPlayer.VideoAdPlayerCallback) it.next()).onPause(adMediaInfo);
        }
    }

    public final void playAd(AdMediaInfo adMediaInfo) {
        if (this.m == null || !this.k.contains(adMediaInfo)) {
            throw new IllegalStateException("Call to playAd without appropriate call to loadAd first.");
        }
        this.d.setVisibility(0);
        this.b.setVisibility(0);
        int i = this.o;
        int i2 = i - 1;
        if (i == 0) {
            throw null;
        }
        if (i2 == 0) {
            throw new IllegalStateException("Call to playAd when player state is not LOADED.");
        }
        if (i2 == 1) {
            Iterator it = this.f.iterator();
            while (it.hasNext()) {
                ((VideoAdPlayer.VideoAdPlayerCallback) it.next()).onPlay(adMediaInfo);
            }
            this.a.E(this.b.getHolder());
        } else {
            if (i2 == 2) {
                return;
            }
            if (i2 == 3) {
                Iterator it2 = this.f.iterator();
                while (it2.hasNext()) {
                    ((VideoAdPlayer.VideoAdPlayerCallback) it2.next()).onResume(adMediaInfo);
                }
            }
        }
        this.h.c();
        this.o = 3;
        this.a.D(true);
    }

    public final void release() {
        m();
        this.a.B(this.i);
        this.a.C(this.j);
        this.a.A();
        this.h.d();
        this.e.removeView(this.d);
    }

    public final void removeCallback(VideoAdPlayer.VideoAdPlayerCallback videoAdPlayerCallback) {
        this.f.remove(videoAdPlayerCallback);
    }

    public final void resize(int i, int i2, int i3, int i4) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((this.e.getWidth() - i) - i3, (this.e.getHeight() - i2) - i4);
        layoutParams.leftMargin = i;
        layoutParams.topMargin = i2;
        this.c.setLayoutParams(layoutParams);
    }

    public final void stopAd(AdMediaInfo adMediaInfo) {
        if (this.m == null) {
            Log.e("IMASDK", "Attempting to stop when no current ad source");
            return;
        }
        this.g.add(adMediaInfo);
        int i = i(adMediaInfo);
        int h = this.a.h();
        if (i == h) {
            if (i(adMediaInfo) == this.k.size() - 1) {
                m();
                return;
            } else {
                this.a.u(this.a.h() + 1);
                return;
            }
        }
        if (i > h) {
            int i2 = i(adMediaInfo);
            sp spVar = this.m;
            atp.k(spVar);
            spVar.O(i2);
            this.k.remove(adMediaInfo);
        }
    }
}

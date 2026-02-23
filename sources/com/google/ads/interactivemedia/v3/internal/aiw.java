package com.google.ads.interactivemedia.v3.internal;

import com.google.ads.interactivemedia.v3.api.AdsRequest;
import com.google.ads.interactivemedia.v3.api.player.ContentProgressProvider;
import com.google.ads.interactivemedia.v3.api.signals.SecureSignals;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class aiw implements AdsRequest {
    private String a;
    private Map b;
    private String c;
    private ContentProgressProvider d;
    private ait e = ait.UNKNOWN;
    private aiv f = aiv.UNKNOWN;
    private aiu g = aiu.UNKNOWN;
    private Float h;
    private List i;
    private String j;
    private String k;
    private Float l;
    private Float m;
    private SecureSignals n;
    private transient Object o;

    public final ait a() {
        return this.e;
    }

    public final aiu b() {
        return this.g;
    }

    public final aiv c() {
        return this.f;
    }

    public final Float d() {
        return this.h;
    }

    public final Float e() {
        return this.m;
    }

    public final Float f() {
        return this.l;
    }

    public final String g() {
        return this.j;
    }

    public final String getAdTagUrl() {
        return this.a;
    }

    public final String getAdsResponse() {
        return this.c;
    }

    public final ContentProgressProvider getContentProgressProvider() {
        return this.d;
    }

    public final String getExtraParameter(String str) {
        Map map = this.b;
        if (map == null) {
            return null;
        }
        return (String) map.get(str);
    }

    public final Map getExtraParameters() {
        return this.b;
    }

    public final SecureSignals getSecureSignals() {
        return this.n;
    }

    public final Object getUserRequestContext() {
        return this.o;
    }

    public final String h() {
        return this.k;
    }

    public final List i() {
        return this.i;
    }

    public final void setAdTagUrl(String str) {
        this.a = str;
    }

    public final void setAdWillAutoPlay(boolean z) {
        this.e = z ? ait.AUTO : ait.CLICK;
    }

    public final void setAdWillPlayMuted(boolean z) {
        this.f = z ? aiv.MUTED : aiv.UNMUTED;
    }

    public final void setAdsResponse(String str) {
        this.c = str;
    }

    public final void setContentDuration(float f) {
        this.h = Float.valueOf(f);
    }

    public final void setContentKeywords(List list) {
        this.i = list;
    }

    public final void setContentProgressProvider(ContentProgressProvider contentProgressProvider) {
        this.d = contentProgressProvider;
    }

    public final void setContentTitle(String str) {
        this.j = str;
    }

    public final void setContentUrl(String str) {
        this.k = str;
    }

    public final void setContinuousPlayback(boolean z) {
        this.g = z ? aiu.ON : aiu.OFF;
    }

    public final void setExtraParameter(String str, String str2) {
        if (this.b == null) {
            this.b = new HashMap();
        }
        this.b.put(str, str2);
    }

    public final void setLiveStreamPrefetchSeconds(float f) {
        this.m = Float.valueOf(f);
    }

    public final void setSecureSignals(SecureSignals secureSignals) {
        this.n = secureSignals;
    }

    public final void setUserRequestContext(Object obj) {
        this.o = obj;
    }

    public final void setVastLoadTimeout(float f) {
        this.l = Float.valueOf(f);
    }
}

package com.google.ads.interactivemedia.v3.internal;

import com.google.ads.interactivemedia.v3.api.StreamRequest;
import com.google.ads.interactivemedia.v3.api.signals.SecureSignals;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class akt implements StreamRequest {
    private String a;
    private String b;
    private String c;
    private boolean d;
    private String e;
    private String f;
    private String g;
    private String h;
    private String i;
    private String j;
    private String k;
    private Map l;
    private String m;
    private String n;
    private String o;
    private String p;
    private StreamRequest.StreamFormat q;
    private Boolean r;
    private SecureSignals s;
    private transient Object t;

    public final void a(String str) {
        this.b = str;
    }

    public final void b(String str) {
        this.a = str;
    }

    public final void c(String str) {
        this.c = str;
    }

    public final void d(String str) {
        this.g = str;
    }

    public final void e(String str) {
        this.h = str;
    }

    public final void f(String str) {
        this.f = str;
    }

    public final void g(String str) {
        this.k = str;
    }

    public final Map getAdTagParameters() {
        return this.l;
    }

    public final String getApiKey() {
        return this.b;
    }

    public final String getAssetKey() {
        return this.a;
    }

    public final String getAuthToken() {
        return this.o;
    }

    public final String getContentSourceId() {
        return this.c;
    }

    public final String getContentUrl() {
        return this.n;
    }

    public final String getCustomAssetKey() {
        return this.g;
    }

    public final boolean getEnableNonce() {
        return this.d;
    }

    public final StreamRequest.StreamFormat getFormat() {
        return this.q;
    }

    public final String getLiveStreamEventId() {
        return this.h;
    }

    public final String getManifestSuffix() {
        return this.m;
    }

    public final String getNetworkCode() {
        return this.f;
    }

    public final String getOAuthToken() {
        return this.k;
    }

    public final String getProjectNumber() {
        return this.j;
    }

    public final String getRegion() {
        return this.i;
    }

    public final SecureSignals getSecureSignals() {
        return this.s;
    }

    public final String getStreamActivityMonitorId() {
        return this.p;
    }

    public final Boolean getUseQAStreamBaseUrl() {
        return this.r;
    }

    public final Object getUserRequestContext() {
        return this.t;
    }

    public final String getVideoId() {
        return this.e;
    }

    public final void h(String str) {
        this.j = str;
    }

    public final void i(String str) {
        this.i = str;
    }

    public final void j(String str) {
        this.e = str;
    }

    public final void setAdTagParameters(Map map) {
        this.l = map;
    }

    public final void setAuthToken(String str) {
        this.o = str;
    }

    public final void setContentUrl(String str) {
        this.n = str;
    }

    public final void setEnableNonce(boolean z) {
        this.d = z;
    }

    public final void setFormat(StreamRequest.StreamFormat streamFormat) {
        this.q = streamFormat;
    }

    public final void setManifestSuffix(String str) {
        this.m = str;
    }

    public final void setSecureSignals(SecureSignals secureSignals) {
        this.s = secureSignals;
    }

    public final void setStreamActivityMonitorId(String str) {
        this.p = str;
    }

    public final void setUseQAStreamBaseUrl(Boolean bool) {
        this.r = bool;
    }

    public final void setUserRequestContext(Object obj) {
        this.t = obj;
    }
}

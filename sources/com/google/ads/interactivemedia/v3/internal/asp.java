package com.google.ads.interactivemedia.v3.internal;

import android.app.Activity;
import android.content.Context;
import android.util.Base64;
import android.view.MotionEvent;
import android.view.View;
import java.util.HashMap;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class asp implements arx {
    private final Object a;
    private final asq b;
    private final asy c;
    private final aru d;

    public asp(Object obj, asq asqVar, asy asyVar, aru aruVar) {
        this.a = obj;
        this.b = asqVar;
        this.c = asyVar;
        this.d = aruVar;
    }

    private static long i(long j) {
        return System.currentTimeMillis() - j;
    }

    private static String j(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        agl a = agm.a();
        a.c(agg.e);
        a.a(bpb.t(bArr));
        return Base64.encodeToString(((agm) a.aY()).av(), 11);
    }

    private final synchronized byte[] k(Map map) {
        long currentTimeMillis = System.currentTimeMillis();
        try {
        } catch (Exception e) {
            this.d.c(2007, i(currentTimeMillis), e);
            return null;
        }
        return (byte[]) this.a.getClass().getDeclaredMethod("xss", new Class[]{Map.class, Map.class}).invoke(this.a, new Object[]{null, map});
    }

    public final synchronized String a(Context context, String str, View view, Activity activity) {
        Map a;
        a = this.c.a();
        a.put("f", "c");
        a.put("ctx", context);
        a.put("cs", str);
        a.put("aid", (Object) null);
        a.put("view", view);
        a.put("act", activity);
        return j(k(a));
    }

    public final synchronized String b(Context context, View view, Activity activity) {
        Map c;
        c = this.c.c();
        c.put("f", "v");
        c.put("ctx", context);
        c.put("aid", (Object) null);
        c.put("view", view);
        c.put("act", activity);
        return j(k(c));
    }

    public final synchronized String c(Context context) {
        Map b;
        b = this.c.b();
        b.put("f", "q");
        b.put("ctx", context);
        b.put("aid", (Object) null);
        return j(k(b));
    }

    public final synchronized void d(MotionEvent motionEvent) throws asw {
        try {
            long currentTimeMillis = System.currentTimeMillis();
            HashMap hashMap = new HashMap();
            hashMap.put("t", new Throwable());
            hashMap.put("aid", (Object) null);
            hashMap.put("evt", motionEvent);
            this.a.getClass().getDeclaredMethod("he", new Class[]{Map.class}).invoke(this.a, new Object[]{hashMap});
            this.d.d(3003, i(currentTimeMillis));
        } catch (Exception e) {
            throw new asw(2005, (Throwable) e);
        }
    }

    public final synchronized int e() throws asw {
        try {
        } catch (Exception e) {
            throw new asw(2006, (Throwable) e);
        }
        return ((Integer) this.a.getClass().getDeclaredMethod("lcs", (Class[]) null).invoke(this.a, (Object[]) null)).intValue();
    }

    public final asq f() {
        return this.b;
    }

    public final synchronized void g() throws asw {
        try {
            long currentTimeMillis = System.currentTimeMillis();
            this.a.getClass().getDeclaredMethod("close", (Class[]) null).invoke(this.a, (Object[]) null);
            this.d.d(3001, i(currentTimeMillis));
        } catch (Exception e) {
            throw new asw(2003, (Throwable) e);
        }
    }

    public final synchronized boolean h() throws asw {
        try {
        } catch (Exception e) {
            throw new asw(2001, (Throwable) e);
        }
        return ((Boolean) this.a.getClass().getDeclaredMethod("init", (Class[]) null).invoke(this.a, (Object[]) null)).booleanValue();
    }
}

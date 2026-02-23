package com.google.ads.interactivemedia.v3.internal;

import android.app.Activity;
import android.content.Context;
import android.net.NetworkCapabilities;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class anb extends amw {
    private static anx A = null;
    protected static final Object r = new Object();
    static boolean s = false;
    private static final String w = "anb";
    private static long x;
    private static anh y;
    private static aof z;
    private final Map B;
    protected boolean t;
    protected final String u;
    aod v;

    public anb(Context context) {
        super(context);
        this.t = false;
        this.B = new HashMap();
        this.u = "";
        this.t = false;
    }

    private static final void j() {
        aof aofVar = z;
        if (aofVar != null) {
            aofVar.h();
        }
    }

    private final synchronized void m(anw anwVar, agl aglVar) {
        MotionEvent motionEvent;
        try {
            try {
                anz u = u(anwVar, this.b, this.q);
                Long l = u.a;
                if (l != null) {
                    aglVar.ax(l.longValue());
                }
                Long l2 = u.b;
                if (l2 != null) {
                    aglVar.ay(l2.longValue());
                }
                Long l3 = u.c;
                if (l3 != null) {
                    aglVar.av(l3.longValue());
                }
                if (this.p) {
                    Long l4 = u.d;
                    if (l4 != null) {
                        aglVar.au(l4.longValue());
                    }
                    Long l5 = u.e;
                    if (l5 != null) {
                        aglVar.ar(l5.longValue());
                    }
                }
            } catch (anp unused) {
            }
            agl w2 = aga.w();
            if (this.d > 0 && aoa.h(this.q)) {
                w2.s(aoa.a(this.k, this.q));
                w2.F(aoa.a(this.n - this.l, this.q));
                w2.G(aoa.a(this.o - this.m, this.q));
                w2.y(aoa.a(this.l, this.q));
                w2.A(aoa.a(this.m, this.q));
                if (this.p && (motionEvent = this.b) != null) {
                    long a = aoa.a(((this.l - this.n) + motionEvent.getRawX()) - this.b.getX(), this.q);
                    if (a != 0) {
                        w2.D(a);
                    }
                    long a2 = aoa.a(((this.m - this.o) + this.b.getRawY()) - this.b.getY(), this.q);
                    if (a2 != 0) {
                        w2.E(a2);
                    }
                }
            }
            try {
                anz b = b(this.b);
                Long l6 = b.a;
                if (l6 != null) {
                    w2.z(l6.longValue());
                }
                Long l7 = b.b;
                if (l7 != null) {
                    w2.B(l7.longValue());
                }
                w2.x(b.c.longValue());
                if (this.p) {
                    Long l8 = b.e;
                    if (l8 != null) {
                        w2.v(l8.longValue());
                    }
                    Long l9 = b.d;
                    if (l9 != null) {
                        w2.w(l9.longValue());
                    }
                    Long l10 = b.f;
                    if (l10 != null) {
                        w2.I(l10.longValue() != 0 ? agh.b : agh.a);
                    }
                    if (this.e > 0) {
                        Long valueOf = aoa.h(this.q) ? Long.valueOf(Math.round(this.j / this.e)) : null;
                        if (valueOf != null) {
                            w2.q(valueOf.longValue());
                        } else {
                            w2.p();
                        }
                        w2.r(Math.round(this.i / this.e));
                    }
                    Long l11 = b.i;
                    if (l11 != null) {
                        w2.t(l11.longValue());
                    }
                    Long l12 = b.j;
                    if (l12 != null) {
                        w2.C(l12.longValue());
                    }
                    Long l13 = b.k;
                    if (l13 != null) {
                        w2.H(l13.longValue() != 0 ? agh.b : agh.a);
                    }
                }
            } catch (anp unused2) {
            }
            long j = this.h;
            if (j > 0) {
                w2.u(j);
            }
            aglVar.aB((aga) w2.aY());
            long j2 = this.d;
            if (j2 > 0) {
                aglVar.as(j2);
            }
            long j3 = this.e;
            if (j3 > 0) {
                aglVar.at(j3);
            }
            long j4 = this.f;
            if (j4 > 0) {
                aglVar.aw(j4);
            }
            long j5 = this.g;
            if (j5 > 0) {
                aglVar.aq(j5);
            }
            try {
                int size = this.c.size() - 1;
                if (size > 0) {
                    aglVar.K();
                    for (int i = 0; i < size; i++) {
                        anz u2 = u(amw.a, (MotionEvent) this.c.get(i), this.q);
                        agl w3 = aga.w();
                        w3.z(u2.a.longValue());
                        w3.B(u2.b.longValue());
                        aglVar.J((aga) w3.aY());
                    }
                }
            } catch (anp unused3) {
                aglVar.K();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public static anw t(Context context, boolean z2) {
        if (amw.a == null) {
            synchronized (r) {
                try {
                    if (amw.a == null) {
                        anw t = anw.t(context, z2);
                        if (t.p()) {
                            try {
                                if (((Boolean) aqo.s.f()).booleanValue()) {
                                    t.u("JUzcgAa7QiZMDmYjeHwtF22qOBbojTFP/5L28xsdeCx9uYvsAo6FDNhapuA6bStH", "U55JZyt+fru+djXeCzNGPL143KELIHwp5RNEO07WiP4=", new Class[0]);
                                }
                            } catch (IllegalStateException unused) {
                            }
                            t.u("dJwO6Cl9MRqD0Gc5K3JTdZycyClQqkAPKU0XDLxQQPeGCWqiQha6f2rP1wtqtwx3", "rLNLoOjJQBnuvnCDgD+yaoADKoI2087E89SpHXw4yFg=", Context.class);
                            t.u("ATj3hbklxV/XiswqkLJ9VlaAJFBsAV/1VJ4eSTnw1AP/96KhgekAXYnIpmljK7wO", "rfBYaobM06JIPnbukgoyOwsb7bCc9rvkUNfR4KOQWHU=", Context.class);
                            t.u("S/SJ7YtODXxfB+6o9UyIgHiId71g3ksNaRMWqG3MsynbaW5fZJkURKKNBmxPvqKI", "TBTy2z6/sYWhl/djL8GAQh763EadMhWk9n5M3AmRbIg=", Context.class);
                            t.u("YC+pJVOZY25wDvtlWBPChLSjLU0iUh44DqTcbsbdAncZlcvrsOhFkSGXkkm3Hf4Z", "a17x9Lt/WQTGhUJAM6t8VqFWsXteADIsbbHvy7b7aMM=", Context.class);
                            t.u("qfI1DhKUvYvonhmDhl2HtQbINO0xIIYvKgMRQgz52nQi898Sh8QDGcMkGv/U7x7x", "dGQnAya6a12xEk9RZqxizYv1KQcB0awlyegaC3HNbmw=", Context.class);
                            Class cls = Boolean.TYPE;
                            t.u("Gdhi15k7cHPLVK8ak2AW2U8wWjJccRmTSeAAE7zSYYmR363nmijtloZo3WMMU3lH", "BmCZi3wg7cX26+HP9p5KWWgFeCy6CBwpe84PbqLu08A=", Context.class, cls);
                            t.u("n8eevinWOirOSPZe75LOlEw/rjd2yNw2EibrKlsvfLNOq/qV6IorYV+yJwJVSrU8", "z60w6+pWlGB4RCxkD/LDTBZ25WofjghjXXagNVA9cCM=", Context.class);
                            t.u("9iQ5YMaDdmXd2AE0qa10oJyqmGZHX7XNUzgm4wdKztIQI9jbAXaOTiv6toK0AOKU", "rCh66yJZbGwhYsjh3a4o4nMI5ui67q2Fs4U69kJBF3k=", Context.class);
                            t.u("Kjj/NWt5Xw530zWkhsqzO18XZPoLer8GCJYwlVW4Z2TDaLFXmLCWh2yD69kBis5q", "fBdzdgD1bofuaKTW6LUcH7mpQ3p8BVkg+3EYXR2IWu4=", MotionEvent.class, DisplayMetrics.class);
                            t.u("2VR7L/2srPLBbh3OPlGeS8Ru8uYXtYmourWjxCdZl0ZvDKChHNCuDLRy98nk4nFB", "ZDqFJ0I5g5uVDR0fSRJqwb59d8cP3p3/RbyvkYRlQc0=", MotionEvent.class, DisplayMetrics.class);
                            t.u("THnQW94FsCDUSM+XeJNpgUTCgMolxy7rl1LeD10r6fuFhGDZDxfkCa3f3R02TTfn", "RukHQ2QyoItYcCVOmbl/vMdZ4cajSx2BB5kPudfplwo=", new Class[0]);
                            t.u("EggzVxU0lX/1UlHAeEGUyUm45SOmio09y9T4hm0PM9xyGW0Fa8XV6zB35QkAF1yq", "13swnHoz78V4UQSpBM2KHvpNNnXpuWx8GAjTYu5TVQw=", new Class[0]);
                            t.u("azGRTaieBebLUCBtXxWiGC8ntdSjezuXnKrD7NOMrfVnrrLI+ziOvss+bqlk4xLN", "0tQXY1xo2ukrM9W+s0u6j2Mh+vSCsclEF17Hl/ROszM=", new Class[0]);
                            t.u("9MUQl4bkTrG/hbkOaiPEQeZR+Q1g5nerIUIYlLLAX+szyWBOaKlwxYudXHeApTjq", "w0yuMX287JAuExKzMpRTJqrOhPVTMBo6RInylnboEYs=", new Class[0]);
                            t.u("BL1uRQDu2iGGdqxtPT0UZ/lh1a1ebdj6ce5dHzXL9Xdh/V7EjoG/mOlN+ePhmCVj", "VbWvt5u3iV1e6mTKIEv50y8+Z2ekDgVJovyXyxeSHYc=", new Class[0]);
                            t.u("/nq0lRxQcGC1ASnfdnp1tRqKCtSvrxgzieToDPBUonPm4tHJx/5+TsZqcFW/70Mo", "myj1nOfIy7SmCD8TPLBSkg5Eqhpr16G4wLW5wXHtMTM=", new Class[0]);
                            t.u("JcyGK+UJP268FQFtTaGhQAzoKUodZulOKvzraNGT5p3xvR5cM9kMk5tDQLTCBUij", "f+92zzsRq9nsZjabs/oaBlCH7RtiJvk62T7dPsPTbRg=", Context.class, cls, String.class);
                            t.u("5Y5rtCIQhjVwnkrBvzpTMg0rZuVvyD2oudHeojlpiyRPt3QF1dIwn8qKzMnR3WrD", "L+eAMQBxQYtni61+5W3ps9X1nzCZQ5WzyUUXMjOuRZ4=", StackTraceElement[].class);
                            t.u("JgNevmfyr8lZxnvZfq3r729JgtxbLk039SjEVr1jMI7eztR3nd0tOgO6sMz+FJz+", "ylslQbtrjnaBQeIQLiG5TQpHgACRff6HBxNL0ysPa0Q=", View.class, DisplayMetrics.class, cls, cls);
                            t.u("UdRLZDfL4bVVU0VX3qg8hi1McU3FMuLhNf0tRNLophcguwloVZffIAQP6VRf+/uk", "yXOhM6UEm+Qz/JUey2l1+qI404D+W2SeSSnUBSRl6qI=", Context.class, cls);
                            t.u("rE+CHn9CLSmLsY/LfivBx+DmSmQMCqSMhAImHDd3dGWtfWUTJAZt/SbpXoR2i5+S", "XOTxexwsk5wzpmsanl+x8sPTZMmLepw+z7JZ/NtNU48=", View.class, Activity.class, cls);
                            t.u("yXY8/mGMSUXAD/doic4NhOcSiaIXIqWtQGozx2RibPkZkGDEn3zdgJKu8ncuIp2B", "lomf+VO0Ecj7WivSbw6aVWdgbo/lmDysFNgyXwY+gTY=", Long.TYPE);
                            t.u("wPLuRKbAvZPAiJqPYNBqgvUCesMc3+VTtpgM018gMz5F9Lz38uNUBeCfwu8TSv2X", "+DZ4rAqlxoGmt/vl5o0tqi0yaHBF48hUHJNY3yJnYpc=", new Class[0]);
                            try {
                                if (((Boolean) aqo.w.f()).booleanValue()) {
                                    t.u("q25n2/TPNEnWjiB7Eq/br1pf7I1+Pbd8JO4E5S/WFXDtJZ2FMIzDcDIeNK1YwkMp", "JTvnHx65Egq/4novhqSS3bMw+oihCNz02Yz4pG4S+kE=", Context.class);
                                }
                            } catch (IllegalStateException unused2) {
                            }
                            t.u("DZ4YQMGjiiG80De3h2RdExLJLCk1HXfUitSGB3xdLKjSzFe5jaVRnSWLaDfXmTZ6", "rN4de9ttzTEp3+iQIPyTFLSG8iLr2YuUXdQWnliGMSg=", Context.class);
                            try {
                                if (Build.VERSION.SDK_INT >= 26) {
                                    if (((Boolean) aqo.x.f()).booleanValue()) {
                                        Class cls2 = Long.TYPE;
                                        t.u("uXer3UA11jv0SZxM8rEYS7HzXCd8ucSITS/VghhemVPtPpwzWKxJYN2vUPP5dw9E", "hs3/rpu0ZtoaPE+A6aRGA1SNmSKC7zzkLMT9t285eJ8=", NetworkCapabilities.class, cls2, cls2);
                                    }
                                }
                            } catch (IllegalStateException unused3) {
                            }
                            if (((Boolean) aqo.p.f()).booleanValue()) {
                                Class cls3 = Long.TYPE;
                                t.u("DEi5JrQn0pxSuKS2Ij/fpEA7I+0FPLXDsBWBfvVwt/zwZUJJ4fnydbsyET2LCYMF", "Jj1vyuWfy0iUak+iXdGffQYzyyVnoa3nOmSynhrPgns=", cls3, cls3, cls3, cls3);
                            } else {
                                try {
                                    if (((Boolean) aqo.o.f()).booleanValue()) {
                                        t.u("FdWssDbNTznwvaSwEiy9othUceULqhXS0NiSaXeIdQIZaN4heVunXmsWFB1bgBsj", "TzSf4nrBofZD4sG4/0KqSG9VhwNKl95AgxoEIclkVIM=", long[].class, Context.class, View.class);
                                    }
                                } catch (IllegalStateException unused4) {
                                }
                            }
                        }
                        amw.a = t;
                    }
                } finally {
                }
            }
        }
        return amw.a;
    }

    public static anz u(anw anwVar, MotionEvent motionEvent, DisplayMetrics displayMetrics) throws anp {
        Method i = anwVar.i("Kjj/NWt5Xw530zWkhsqzO18XZPoLer8GCJYwlVW4Z2TDaLFXmLCWh2yD69kBis5q", "fBdzdgD1bofuaKTW6LUcH7mpQ3p8BVkg+3EYXR2IWu4=");
        if (i == null || motionEvent == null) {
            throw new anp();
        }
        try {
            return new anz((String) i.invoke((Object) null, new Object[]{motionEvent, displayMetrics}));
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new anp(e);
        }
    }

    public static synchronized void v(Context context, boolean z2) {
        synchronized (anb.class) {
            try {
                if (s) {
                    return;
                }
                x = System.currentTimeMillis() / 1000;
                amw.a = t(context, z2);
                if (((Boolean) aqo.x.f()).booleanValue()) {
                    y = anh.c(context);
                }
                ExecutorService j = amw.a.j();
                if (((Boolean) aqo.y.f()).booleanValue() && j != null) {
                    z = aof.d(context, j);
                }
                if (((Boolean) aqo.p.f()).booleanValue()) {
                    A = new anx();
                }
                s = true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static final void w(List list) {
        ExecutorService j;
        if (amw.a == null || (j = amw.a.j()) == null || list.isEmpty()) {
            return;
        }
        try {
            j.invokeAll(list, ((Long) aqo.k.f()).longValue(), TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            Log.d(w, String.format("class methods got exception: %s", new Object[]{aoa.e(e)}));
        }
    }

    public final long a(StackTraceElement[] stackTraceElementArr) throws anp {
        Method i = amw.a.i("5Y5rtCIQhjVwnkrBvzpTMg0rZuVvyD2oudHeojlpiyRPt3QF1dIwn8qKzMnR3WrD", "L+eAMQBxQYtni61+5W3ps9X1nzCZQ5WzyUUXMjOuRZ4=");
        if (i == null || stackTraceElementArr == null) {
            throw new anp();
        }
        try {
            return new anq((String) i.invoke((Object) null, new Object[]{stackTraceElementArr})).a.longValue();
        } catch (InvocationTargetException | IllegalAccessException e) {
            throw new anp(e);
        }
    }

    public final anz b(MotionEvent motionEvent) throws anp {
        Method i = amw.a.i("2VR7L/2srPLBbh3OPlGeS8Ru8uYXtYmourWjxCdZl0ZvDKChHNCuDLRy98nk4nFB", "ZDqFJ0I5g5uVDR0fSRJqwb59d8cP3p3/RbyvkYRlQc0=");
        if (i == null || motionEvent == null) {
            throw new anp();
        }
        try {
            return new anz((String) i.invoke((Object) null, new Object[]{motionEvent, this.q}));
        } catch (InvocationTargetException | IllegalAccessException e) {
            throw new anp(e);
        }
    }

    public agl c(Context context, View view, Activity activity) {
        j();
        if (((Boolean) aqo.p.f()).booleanValue()) {
            A.i();
        }
        agl as = agc.as();
        if (!TextUtils.isEmpty(this.u)) {
            as.Q(this.u);
        }
        x(t(context, this.t), as, view, activity, true, context);
        return as;
    }

    public final agl d(Context context, afm afmVar) {
        j();
        if (((Boolean) aqo.p.f()).booleanValue()) {
            A.j();
        }
        agl as = agc.as();
        if (!TextUtils.isEmpty(this.u)) {
            as.Q(this.u);
        }
        r(t(context, this.t), context, as, afmVar);
        if (afmVar != null && afmVar.f() && ((Boolean) aqo.q.f()).booleanValue() && !aoa.g(afmVar.d().d())) {
            agl c = agk.c();
            c.d(afmVar.d().d());
            as.an((agk) c.aY());
        }
        return as;
    }

    public agl i(Context context, View view, Activity activity) {
        j();
        if (((Boolean) aqo.p.f()).booleanValue()) {
            A.k(context, view);
        }
        agl as = agc.as();
        as.Q(this.u);
        x(t(context, this.t), as, view, activity, false, context);
        return as;
    }

    public final void n(View view) {
        if (((Boolean) aqo.n.f()).booleanValue()) {
            if (this.v == null) {
                anw anwVar = amw.a;
                this.v = new aod(anwVar.a, anwVar.f());
            }
            this.v.d(view);
        }
    }

    public List p(anw anwVar, Context context, agl aglVar, afm afmVar) {
        long j;
        long j2;
        int a = anwVar.a();
        ArrayList arrayList = new ArrayList();
        if (!anwVar.p()) {
            aglVar.am(afx.a(afx.w));
            return arrayList;
        }
        arrayList.add(new aok(anwVar, aglVar, a, context, afmVar, null, null, null));
        arrayList.add(new aon(anwVar, aglVar, x, a, null, null, null));
        arrayList.add(new aow(anwVar, aglVar, a, null, null, null));
        arrayList.add(new aoz(anwVar, aglVar, a, context, null, null, null));
        arrayList.add(new ape(anwVar, aglVar, a, null, null, null));
        arrayList.add(new aoj(anwVar, aglVar, a, context, null, null, null));
        arrayList.add(new aol(anwVar, aglVar, a, null, null, null));
        arrayList.add(new aov(anwVar, aglVar, a, null, null, null));
        arrayList.add(new aox(anwVar, aglVar, a, null, null, null));
        arrayList.add(new aom(anwVar, aglVar, a, null, null, null));
        arrayList.add(new aos(anwVar, aglVar, a, null, null, null));
        arrayList.add(new apf(anwVar, aglVar, a, null, null, null));
        arrayList.add(new aoi(anwVar, aglVar, a, null, null, null));
        arrayList.add(new apc(anwVar, aglVar, a, null, null, null));
        arrayList.add(new apa(anwVar, aglVar, a, null, null, null));
        if (Build.VERSION.SDK_INT >= 24 && ((Boolean) aqo.x.f()).booleanValue()) {
            aof aofVar = z;
            if (aofVar != null) {
                j = aofVar.c();
                j2 = z.b();
            } else {
                j = -1;
                j2 = -1;
            }
            arrayList.add(new aou(anwVar, aglVar, a, y, j, j2, null, null, null));
        }
        if (((Boolean) aqo.w.f()).booleanValue()) {
            arrayList.add(new aoy(anwVar, aglVar, a, null, null, null));
        }
        arrayList.add(new aot(anwVar, aglVar, a, null, null, null));
        if (((Boolean) aqo.A.f()).booleanValue()) {
            arrayList.add(new aoh(anwVar, aglVar, a, null, null, null));
        }
        return arrayList;
    }

    public void r(anw anwVar, Context context, agl aglVar, afm afmVar) {
        if (anwVar.j() == null) {
            return;
        }
        w(p(anwVar, context, aglVar, afmVar));
    }

    public final void x(anw anwVar, agl aglVar, View view, Activity activity, boolean z2, Context context) {
        List arrayList;
        Object aoqVar;
        if (anwVar.p()) {
            m(anwVar, aglVar);
            arrayList = new ArrayList();
            if (anwVar.j() != null) {
                int a = anwVar.a();
                arrayList.add(new aop(anwVar, aglVar, null, null, null));
                arrayList.add(new aow(anwVar, aglVar, a, null, null, null));
                arrayList.add(new aon(anwVar, aglVar, x, a, null, null, null));
                arrayList.add(new aom(anwVar, aglVar, a, null, null, null));
                arrayList.add(new aov(anwVar, aglVar, a, null, null, null));
                arrayList.add(new aox(anwVar, aglVar, a, null, null, null));
                arrayList.add(new aos(anwVar, aglVar, a, null, null, null));
                arrayList.add(new aol(anwVar, aglVar, a, null, null, null));
                arrayList.add(new apf(anwVar, aglVar, a, null, null, null));
                arrayList.add(new aoi(anwVar, aglVar, a, null, null, null));
                arrayList.add(new apc(anwVar, aglVar, a, null, null, null));
                arrayList.add(new apb(anwVar, aglVar, a, new Throwable().getStackTrace(), null, null, null));
                arrayList.add(new apg(anwVar, aglVar, a, view, null, null, null));
                arrayList.add(new apa(anwVar, aglVar, a, null, null, null));
                if (((Boolean) aqo.l.f()).booleanValue()) {
                    arrayList.add(new aog(anwVar, aglVar, a, view, activity, null, null, null));
                }
                if (((Boolean) aqo.A.f()).booleanValue()) {
                    arrayList.add(new aoh(anwVar, aglVar, a, null, null, null));
                }
                if (!z2) {
                    try {
                        if (((Boolean) aqo.o.f()).booleanValue()) {
                            arrayList.add(new aor(anwVar, aglVar, a, this.B, view, context, null, null, null));
                        }
                    } catch (IllegalStateException unused) {
                    }
                    try {
                        if (((Boolean) aqo.p.f()).booleanValue()) {
                            aoqVar = new aoq(anwVar, aglVar, a, A, null, null, null);
                            arrayList.add(aoqVar);
                        }
                    } catch (IllegalStateException unused2) {
                    }
                } else if (((Boolean) aqo.n.f()).booleanValue()) {
                    aoqVar = new apd(anwVar, aglVar, a, this.v, null, null, null);
                    arrayList.add(aoqVar);
                }
            }
        } else {
            aglVar.am(afx.a(afx.w));
            arrayList = Arrays.asList(new Callable[]{new aop(anwVar, aglVar, null, null, null)});
        }
        w(arrayList);
    }

    public anb(Context context, String str, boolean z2) {
        super(context);
        this.t = false;
        this.B = new HashMap();
        this.u = str;
        this.t = z2;
    }
}

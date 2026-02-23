package com.google.ads.interactivemedia.v3.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import java.io.ByteArrayInputStream;
import java.lang.reflect.InvocationTargetException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class aok extends apj {
    private static final ayt j = new ayt();
    private final Context h;
    private final afm i;

    public aok(anw anwVar, agl aglVar, int i, Context context, afm afmVar, byte[] bArr, byte[] bArr2, byte[] bArr3) {
        super(anwVar, "JcyGK+UJP268FQFtTaGhQAzoKUodZulOKvzraNGT5p3xvR5cM9kMk5tDQLTCBUij", "f+92zzsRq9nsZjabs/oaBlCH7RtiJvk62T7dPsPTbRg=", aglVar, i, 27, null, null, null);
        this.h = context;
        this.i = afmVar;
    }

    public static String c(afm afmVar) {
        if (afmVar == null || !afmVar.f() || aoa.g(afmVar.d().c())) {
            return null;
        }
        return afmVar.d().c();
    }

    private final String d() {
        try {
            if (this.a.k() != null) {
                this.a.k().get();
            }
            agc c = this.a.c();
            if (c == null || !c.aj()) {
                return null;
            }
            return c.f();
        } catch (InterruptedException | ExecutionException unused) {
            return null;
        }
    }

    private final boolean e() {
        return this.a.n();
    }

    public final void a() throws IllegalAccessException, InvocationTargetException {
        Boolean valueOf;
        int i;
        String d;
        ama amaVar;
        AtomicReference b = j.b(this.h.getPackageName());
        synchronized (b) {
            try {
                ama amaVar2 = (ama) b.get();
                if (amaVar2 == null || aoa.g(amaVar2.a) || amaVar2.a.equals("E") || amaVar2.a.equals("0000000000000000000000000000000000000000000000000000000000000000")) {
                    if (aoa.g(c(this.i))) {
                        afm afmVar = this.i;
                        if (aoa.g(c(afmVar))) {
                            valueOf = Boolean.valueOf(afmVar != null && afmVar.e() && afmVar.c().c() == afo.d);
                        } else {
                            valueOf = Boolean.FALSE;
                        }
                        i = (valueOf.booleanValue() && e()) ? afo.d : afo.c;
                    } else {
                        i = afo.e;
                    }
                    Boolean valueOf2 = Boolean.valueOf(i == afo.c);
                    Boolean bool = (Boolean) aqo.e.f();
                    String b2 = ((Boolean) aqo.d.f()).booleanValue() ? b() : null;
                    if (bool.booleanValue() && e() && aoa.g(b2)) {
                        b2 = d();
                    }
                    ama amaVar3 = new ama((String) this.d.invoke((Object) null, new Object[]{this.h, valueOf2, b2}));
                    if (aoa.g(amaVar3.a) || amaVar3.a.equals("E")) {
                        int i2 = i - 1;
                        if (i == 0) {
                            throw null;
                        }
                        if (i2 == 3) {
                            d = d();
                            if (!aoa.g(d)) {
                                amaVar3.a = d;
                            }
                        } else if (i2 == 4) {
                            d = this.i.d().c();
                            amaVar3.a = d;
                        }
                    }
                    b.set(amaVar3);
                }
                amaVar = (ama) b.get();
            } finally {
            }
        }
        synchronized (this.g) {
            if (amaVar != null) {
                try {
                    this.g.ag(amaVar.a);
                    this.g.aH(amaVar.b);
                    this.g.aJ(amaVar.c);
                    this.g.R(amaVar.d);
                    this.g.af(amaVar.e);
                } finally {
                }
            }
        }
    }

    public final String b() {
        try {
            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
            byte[] i = aoa.i((String) aqo.f.f());
            ArrayList arrayList = new ArrayList();
            arrayList.add(certificateFactory.generateCertificate(new ByteArrayInputStream(i)));
            if (!Build.TYPE.equals("user")) {
                arrayList.add(certificateFactory.generateCertificate(new ByteArrayInputStream(aoa.i((String) aqo.g.f()))));
            }
            Context context = this.h;
            String packageName = context.getPackageName();
            this.a.j();
            if (Build.VERSION.SDK_INT <= 30 && !Build.VERSION.CODENAME.equals("S")) {
                return null;
            }
            azi p = azi.p();
            B.a(context.getPackageManager(), packageName, false, 8, arrayList, new apk(p));
            return (String) p.get();
        } catch (CertificateEncodingException | PackageManager.NameNotFoundException | ExecutionException | InterruptedException | CertificateException | NoClassDefFoundError unused) {
            return null;
        }
    }
}

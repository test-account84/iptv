package com.google.ads.interactivemedia.v3.internal;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class bml implements bkm {
    private final bkw a;
    private final bjm b;
    private final bky c;
    private final bma d;
    private final List e;

    public bml(bkw bkwVar, bjm bjmVar, bky bkyVar, bma bmaVar, List list) {
        this.a = bkwVar;
        this.b = bjmVar;
        this.c = bkyVar;
        this.d = bmaVar;
        this.e = list;
    }

    public static /* bridge */ /* synthetic */ void b(Object obj, Field field) {
        if (true == Modifier.isStatic(field.getModifiers())) {
            obj = null;
        }
        if (blo.c(field, obj)) {
            return;
        }
        throw new bjz("Field '" + field.getDeclaringClass().getName() + "#" + field.getName() + "' is not accessible and ReflectionAccessFilter does not permit making it accessible. Register a TypeAdapter for the declaring type or adjust the access filter.");
    }

    private final boolean c(Field field, boolean z) {
        return (this.c.c(field.getType(), z) || this.c.d(field, z)) ? false : true;
    }

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException: Attempt to invoke virtual method 'java.util.List jadx.core.dex.instructions.args.SSAVar.getPhiList()' on a null object reference
        	at jadx.core.dex.visitors.InitCodeVariables.collectConnectedVars(Unknown Source:37)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(Unknown Source:18)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(SourceFile:12)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(Unknown Source:53)
        	at jadx.core.dex.visitors.InitCodeVariables.visit(Unknown Source:0)
        */
    public final com.google.ads.interactivemedia.v3.internal.bkl a(com.google.ads.interactivemedia.v3.internal.bjt r40, com.google.ads.interactivemedia.v3.internal.bof r41) {
        /*
            Method dump skipped, instructions count: 728
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.bml.a(com.google.ads.interactivemedia.v3.internal.bjt, com.google.ads.interactivemedia.v3.internal.bof):com.google.ads.interactivemedia.v3.internal.bkl");
    }
}

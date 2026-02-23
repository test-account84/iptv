package com.google.ads.interactivemedia.v3.internal;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
abstract class bqi {
    private static final Logger a = Logger.getLogger(bpk.class.getName());
    private static final String b = "com.google.ads.interactivemedia.v3.internal.bor";

    public static bqb b(Class cls) {
        String format;
        ClassLoader classLoader = bqi.class.getClassLoader();
        if (cls.equals(bqb.class)) {
            format = b;
        } else {
            if (!cls.getPackage().equals(bqi.class.getPackage())) {
                throw new IllegalArgumentException(cls.getName());
            }
            format = String.format("%s.BlazeGenerated%sLoader", new Object[]{cls.getPackage().getName(), cls.getSimpleName()});
        }
        try {
            try {
                try {
                    return (bqb) cls.cast(((bqi) Class.forName(format, true, classLoader).getConstructor((Class[]) null).newInstance((Object[]) null)).a());
                } catch (InvocationTargetException e) {
                    throw new IllegalStateException(e);
                } catch (IllegalAccessException e2) {
                    throw new IllegalStateException(e2);
                }
            } catch (NoSuchMethodException e3) {
                throw new IllegalStateException(e3);
            } catch (InstantiationException e4) {
                throw new IllegalStateException(e4);
            }
        } catch (ClassNotFoundException unused) {
            Iterator it = ServiceLoader.load(bqi.class, classLoader).iterator();
            ArrayList arrayList = new ArrayList();
            while (it.hasNext()) {
                try {
                    arrayList.add((bqb) cls.cast(((bqi) it.next()).a()));
                } catch (ServiceConfigurationError e5) {
                    a.logp(Level.SEVERE, "com.google.protobuf.GeneratedExtensionRegistryLoader", "load", "Unable to load ".concat(cls.getSimpleName()), e5);
                }
            }
            if (arrayList.size() == 1) {
                return (bqb) arrayList.get(0);
            }
            if (arrayList.size() == 0) {
                return null;
            }
            try {
                return (bqb) cls.getMethod("combine", new Class[]{Collection.class}).invoke((Object) null, new Object[]{arrayList});
            } catch (InvocationTargetException e6) {
                throw new IllegalStateException(e6);
            } catch (IllegalAccessException e7) {
                throw new IllegalStateException(e7);
            } catch (NoSuchMethodException e8) {
                throw new IllegalStateException(e8);
            }
        }
    }

    public abstract bqb a();
}

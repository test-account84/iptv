package com.google.ads.interactivemedia.v3.internal;

import java.io.EOFException;
import java.io.IOException;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.util.Iterator;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class blo {
    public static bjy a(boh bohVar) throws bkc {
        boolean z;
        try {
            try {
                bohVar.r();
                try {
                    return (bjy) bnw.T.read(bohVar);
                } catch (EOFException e) {
                    e = e;
                    z = false;
                    if (z) {
                        return bka.a;
                    }
                    throw new bkf((Throwable) e);
                }
            } catch (EOFException e2) {
                e = e2;
                z = true;
            }
        } catch (NumberFormatException e3) {
            throw new bkf((Throwable) e3);
        } catch (bok e4) {
            throw new bkf((Throwable) e4);
        } catch (IOException e5) {
            throw new bjz((Throwable) e5);
        }
    }

    public static void b(bjy bjyVar, boj bojVar) throws IOException {
        bnw.T.write(bojVar, bjyVar);
    }

    public static boolean c(AccessibleObject accessibleObject, Object obj) {
        return bln.b.a(accessibleObject, obj);
    }

    public static int d(List list, Class cls) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            int a = ((bkh) it.next()).a();
            if (a != 2) {
                return a;
            }
        }
        return 1;
    }

    public static RuntimeException e(IllegalAccessException illegalAccessException) {
        throw new RuntimeException("Unexpected IllegalAccessException occurred (Gson ${project.version}). Certain ReflectionAccessFilter features require Java >= 9 to work correctly. If you are not using ReflectionAccessFilter, report this to the Gson maintainers.", illegalAccessException);
    }

    public static String f(Constructor constructor) {
        try {
            constructor.setAccessible(true);
            return null;
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder(constructor.getDeclaringClass().getName());
            sb.append('#');
            sb.append(constructor.getDeclaringClass().getSimpleName());
            sb.append('(');
            Class[] parameterTypes = constructor.getParameterTypes();
            for (int i = 0; i < parameterTypes.length; i++) {
                if (i > 0) {
                    sb.append(", ");
                }
                sb.append(parameterTypes[i].getSimpleName());
            }
            sb.append(')');
            return "Failed making constructor '" + sb.toString() + "' accessible; either change its visibility or write a custom InstanceCreator or TypeAdapter for its declaring type: " + e.getMessage();
        }
    }
}

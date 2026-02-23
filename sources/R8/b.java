package r8;

import E8.o;
import kotlin.jvm.internal.l;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public abstract class b {
    public static final a a;

    static {
        a aVar;
        int a2 = a();
        if (a2 >= 65544 || a2 < 65536) {
            try {
                Object newInstance = t8.a.class.newInstance();
                l.d(newInstance, "forName(\"kotlin.internal…entations\").newInstance()");
                try {
                    try {
                        if (newInstance == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
                        }
                        aVar = (a) newInstance;
                    } catch (ClassCastException e) {
                        ClassLoader classLoader = newInstance.getClass().getClassLoader();
                        ClassLoader classLoader2 = a.class.getClassLoader();
                        if (l.a(classLoader, classLoader2)) {
                            throw e;
                        }
                        throw new ClassNotFoundException("Instance class was loaded from a different classloader: " + classLoader + ", base type classloader: " + classLoader2, e);
                    }
                } catch (ClassNotFoundException unused) {
                }
            } catch (ClassNotFoundException unused2) {
                Object newInstance2 = Class.forName("kotlin.internal.JRE8PlatformImplementations").newInstance();
                l.d(newInstance2, "forName(\"kotlin.internal…entations\").newInstance()");
                try {
                    if (newInstance2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
                    }
                    aVar = (a) newInstance2;
                } catch (ClassCastException e2) {
                    ClassLoader classLoader3 = newInstance2.getClass().getClassLoader();
                    ClassLoader classLoader4 = a.class.getClassLoader();
                    if (l.a(classLoader3, classLoader4)) {
                        throw e2;
                    }
                    throw new ClassNotFoundException("Instance class was loaded from a different classloader: " + classLoader3 + ", base type classloader: " + classLoader4, e2);
                }
            }
        } else if (a2 >= 65543 || a2 < 65536) {
            try {
                try {
                    Object newInstance3 = s8.a.class.newInstance();
                    l.d(newInstance3, "forName(\"kotlin.internal…entations\").newInstance()");
                    try {
                        if (newInstance3 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
                        }
                        aVar = (a) newInstance3;
                    } catch (ClassCastException e3) {
                        ClassLoader classLoader5 = newInstance3.getClass().getClassLoader();
                        ClassLoader classLoader6 = a.class.getClassLoader();
                        if (l.a(classLoader5, classLoader6)) {
                            throw e3;
                        }
                        throw new ClassNotFoundException("Instance class was loaded from a different classloader: " + classLoader5 + ", base type classloader: " + classLoader6, e3);
                    }
                } catch (ClassNotFoundException unused3) {
                    Object newInstance4 = Class.forName("kotlin.internal.JRE7PlatformImplementations").newInstance();
                    l.d(newInstance4, "forName(\"kotlin.internal…entations\").newInstance()");
                    try {
                        if (newInstance4 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
                        }
                        aVar = (a) newInstance4;
                    } catch (ClassCastException e4) {
                        ClassLoader classLoader7 = newInstance4.getClass().getClassLoader();
                        ClassLoader classLoader8 = a.class.getClassLoader();
                        if (l.a(classLoader7, classLoader8)) {
                            throw e4;
                        }
                        throw new ClassNotFoundException("Instance class was loaded from a different classloader: " + classLoader7 + ", base type classloader: " + classLoader8, e4);
                    }
                }
            } catch (ClassNotFoundException unused4) {
            }
        } else {
            aVar = new a();
        }
        a = aVar;
    }

    public static final int a() {
        String property = System.getProperty("java.specification.version");
        if (property == null) {
            return 65542;
        }
        int Q = o.Q(property, '.', 0, false, 6, null);
        if (Q < 0) {
            try {
                return Integer.parseInt(property) * 65536;
            } catch (NumberFormatException unused) {
                return 65542;
            }
        }
        int i = Q + 1;
        int Q2 = o.Q(property, '.', i, false, 4, null);
        if (Q2 < 0) {
            Q2 = property.length();
        }
        String substring = property.substring(0, Q);
        l.d(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        String substring2 = property.substring(i, Q2);
        l.d(substring2, "this as java.lang.String…ing(startIndex, endIndex)");
        try {
            return (Integer.parseInt(substring) * 65536) + Integer.parseInt(substring2);
        } catch (NumberFormatException unused2) {
            return 65542;
        }
    }
}

package org.apache.commons.logging;

import java.lang.reflect.Constructor;
import java.util.Hashtable;
import org.apache.commons.logging.impl.NoOpLog;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class LogSource {
    protected static boolean jdk14IsAvailable;
    protected static boolean log4jIsAvailable;
    protected static Hashtable logs = new Hashtable();
    protected static Constructor logImplctor = null;

    /*  JADX ERROR: IIiLliI1l1li1 in pass: RegionMakerVisitor
        LL1ili1iI1iI.IIiLliI1l1li1: Can't find top splitter block for handler:B:20:0x003e
        	at ILlL1lil1i1i.LLll11I1I1lL.llLliLLIll1lI(Unknown Source:36)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(Unknown Source:67)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(Unknown Source:9)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(Unknown Source:40)
        */
    static {
        /*
            java.util.Hashtable r0 = new java.util.Hashtable
            r0.<init>()
            org.apache.commons.logging.LogSource.logs = r0
            r0 = 0
            org.apache.commons.logging.LogSource.log4jIsAvailable = r0
            org.apache.commons.logging.LogSource.jdk14IsAvailable = r0
            r1 = 0
            org.apache.commons.logging.LogSource.logImplctor = r1
            r2 = 1
            java.lang.String r3 = "org.apache.log4j.Logger"
            java.lang.Class.forName(r3)     // Catch: java.lang.Throwable -> L18
            org.apache.commons.logging.LogSource.log4jIsAvailable = r2     // Catch: java.lang.Throwable -> L18
            goto L1a
        L18:
            org.apache.commons.logging.LogSource.log4jIsAvailable = r0
        L1a:
            java.lang.String r3 = "java.util.logging.Logger"
            java.lang.Class.forName(r3)     // Catch: java.lang.Throwable -> L24
            int r3 = org.apache.commons.logging.impl.Jdk14Logger.a     // Catch: java.lang.Throwable -> L24
            org.apache.commons.logging.LogSource.jdk14IsAvailable = r2     // Catch: java.lang.Throwable -> L24
            goto L26
        L24:
            org.apache.commons.logging.LogSource.jdk14IsAvailable = r0
        L26:
            java.lang.String r0 = "org.apache.commons.logging.log"
            java.lang.String r1 = java.lang.System.getProperty(r0)     // Catch: java.lang.Throwable -> L35
            if (r1 != 0) goto L36
            java.lang.String r0 = "org.apache.commons.logging.Log"
            java.lang.String r1 = java.lang.System.getProperty(r0)     // Catch: java.lang.Throwable -> L35
            goto L36
        L35:
        L36:
            java.lang.String r0 = "org.apache.commons.logging.impl.NoOpLog"
            if (r1 == 0) goto L42
        L3a:
            setLogImplementation(r1)     // Catch: java.lang.Throwable -> L3e
            goto L53
        L3e:
            setLogImplementation(r0)     // Catch: java.lang.Throwable -> L53
            goto L53
        L42:
            boolean r1 = org.apache.commons.logging.LogSource.log4jIsAvailable     // Catch: java.lang.Throwable -> L3e
            if (r1 == 0) goto L49
            java.lang.String r1 = "org.apache.commons.logging.impl.Log4JLogger"
            goto L3a
        L49:
            boolean r1 = org.apache.commons.logging.LogSource.jdk14IsAvailable     // Catch: java.lang.Throwable -> L3e
            if (r1 == 0) goto L50
            java.lang.String r1 = "org.apache.commons.logging.impl.Jdk14Logger"
            goto L3a
        L50:
            setLogImplementation(r0)     // Catch: java.lang.Throwable -> L3e
        L53:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.logging.LogSource.<clinit>():void");
    }

    private LogSource() {
    }

    public static Log getInstance(Class cls) {
        return getInstance(cls.getName());
    }

    public static String[] getLogNames() {
        return (String[]) logs.keySet().toArray(new String[logs.size()]);
    }

    public static Log makeNewLogInstance(String str) {
        Log log;
        try {
            log = (Log) logImplctor.newInstance(new Object[]{str});
        } catch (Throwable unused) {
            log = null;
        }
        return log == null ? new NoOpLog(str) : log;
    }

    public static void setLogImplementation(Class cls) throws LinkageError, ExceptionInInitializerError, NoSuchMethodException, SecurityException {
        logImplctor = cls.getConstructor(new Class[]{"".getClass()});
    }

    public static Log getInstance(String str) {
        Log log = (Log) logs.get(str);
        if (log != null) {
            return log;
        }
        Log makeNewLogInstance = makeNewLogInstance(str);
        logs.put(str, makeNewLogInstance);
        return makeNewLogInstance;
    }

    public static void setLogImplementation(String str) throws LinkageError, NoSuchMethodException, SecurityException, ClassNotFoundException {
        try {
            logImplctor = Class.forName(str).getConstructor(new Class[]{"".getClass()});
        } catch (Throwable unused) {
            logImplctor = null;
        }
    }
}

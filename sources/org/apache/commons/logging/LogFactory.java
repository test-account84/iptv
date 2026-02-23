package org.apache.commons.logging;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Properties;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public abstract class LogFactory {
    public static final String DIAGNOSTICS_DEST_PROPERTY = "org.apache.commons.logging.diagnostics.dest";
    public static final String FACTORY_DEFAULT = "org.apache.commons.logging.impl.LogFactoryImpl";
    public static final String FACTORY_PROPERTIES = "commons-logging.properties";
    public static final String FACTORY_PROPERTY = "org.apache.commons.logging.LogFactory";
    public static final String HASHTABLE_IMPLEMENTATION_PROPERTY = "org.apache.commons.logging.LogFactory.HashtableImpl";
    public static final String PRIORITY_KEY = "priority";
    protected static final String SERVICE_ID = "META-INF/services/org.apache.commons.logging.LogFactory";
    public static final String TCCL_KEY = "use_tccl";
    private static final String WEAK_HASHTABLE_CLASSNAME = "org.apache.commons.logging.impl.WeakHashtable";
    static /* synthetic */ Class class$org$apache$commons$logging$LogFactory;
    private static final String diagnosticPrefix;
    private static PrintStream diagnosticsStream;
    protected static Hashtable factories;
    protected static volatile LogFactory nullClassLoaderFactory;
    private static final ClassLoader thisClassLoader;

    final class 1 implements PrivilegedAction {
        public Object run() {
            return LogFactory.directGetContextClassLoader();
        }
    }

    final class 2 implements PrivilegedAction {
        private final /* synthetic */ ClassLoader val$classLoader;
        private final /* synthetic */ String val$factoryClass;

        public 2(String str, ClassLoader classLoader) {
            this.val$factoryClass = str;
            this.val$classLoader = classLoader;
        }

        public Object run() {
            return LogFactory.createFactory(this.val$factoryClass, this.val$classLoader);
        }
    }

    final class 3 implements PrivilegedAction {
        private final /* synthetic */ ClassLoader val$loader;
        private final /* synthetic */ String val$name;

        public 3(ClassLoader classLoader, String str) {
            this.val$loader = classLoader;
            this.val$name = str;
        }

        public Object run() {
            ClassLoader classLoader = this.val$loader;
            return classLoader != null ? classLoader.getResourceAsStream(this.val$name) : ClassLoader.getSystemResourceAsStream(this.val$name);
        }
    }

    final class 4 implements PrivilegedAction {
        private final /* synthetic */ ClassLoader val$loader;
        private final /* synthetic */ String val$name;

        public 4(ClassLoader classLoader, String str) {
            this.val$loader = classLoader;
            this.val$name = str;
        }

        public Object run() {
            try {
                ClassLoader classLoader = this.val$loader;
                return classLoader != null ? classLoader.getResources(this.val$name) : ClassLoader.getSystemResources(this.val$name);
            } catch (NoSuchMethodError unused) {
                return null;
            } catch (IOException e) {
                if (LogFactory.isDiagnosticsEnabled()) {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("Exception while trying to find configuration file ");
                    stringBuffer.append(this.val$name);
                    stringBuffer.append(":");
                    stringBuffer.append(e.getMessage());
                    LogFactory.access$000(stringBuffer.toString());
                }
                return null;
            }
        }
    }

    final class 5 implements PrivilegedAction {
        private final /* synthetic */ URL val$url;

        public 5(URL url) {
            this.val$url = url;
        }

        /* JADX WARN: Removed duplicated region for block: B:34:0x0079 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public java.lang.Object run() {
            /*
                r6 = this;
                java.lang.String r0 = "Unable to close stream for URL "
                r1 = 0
                java.net.URL r2 = r6.val$url     // Catch: java.lang.Throwable -> L42 java.io.IOException -> L47
                java.net.URLConnection r2 = r2.openConnection()     // Catch: java.lang.Throwable -> L42 java.io.IOException -> L47
                r3 = 0
                r2.setUseCaches(r3)     // Catch: java.lang.Throwable -> L42 java.io.IOException -> L47
                java.io.InputStream r2 = r2.getInputStream()     // Catch: java.lang.Throwable -> L42 java.io.IOException -> L47
                if (r2 == 0) goto L21
                java.util.Properties r3 = new java.util.Properties     // Catch: java.lang.Throwable -> L1f java.io.IOException -> L48
                r3.<init>()     // Catch: java.lang.Throwable -> L1f java.io.IOException -> L48
                r3.load(r2)     // Catch: java.lang.Throwable -> L1f java.io.IOException -> L48
                r2.close()     // Catch: java.lang.Throwable -> L1f java.io.IOException -> L48
                return r3
            L1f:
                r1 = move-exception
                goto L77
            L21:
                if (r2 == 0) goto L76
                r2.close()     // Catch: java.io.IOException -> L27
                goto L76
            L27:
                boolean r2 = org.apache.commons.logging.LogFactory.isDiagnosticsEnabled()
                if (r2 == 0) goto L76
                java.lang.StringBuffer r2 = new java.lang.StringBuffer
                r2.<init>()
            L32:
                r2.append(r0)
                java.net.URL r0 = r6.val$url
                r2.append(r0)
                java.lang.String r0 = r2.toString()
                org.apache.commons.logging.LogFactory.access$000(r0)
                goto L76
            L42:
                r2 = move-exception
                r5 = r2
                r2 = r1
                r1 = r5
                goto L77
            L47:
                r2 = r1
            L48:
                boolean r3 = org.apache.commons.logging.LogFactory.isDiagnosticsEnabled()     // Catch: java.lang.Throwable -> L1f
                if (r3 == 0) goto L64
                java.lang.StringBuffer r3 = new java.lang.StringBuffer     // Catch: java.lang.Throwable -> L1f
                r3.<init>()     // Catch: java.lang.Throwable -> L1f
                java.lang.String r4 = "Unable to read URL "
                r3.append(r4)     // Catch: java.lang.Throwable -> L1f
                java.net.URL r4 = r6.val$url     // Catch: java.lang.Throwable -> L1f
                r3.append(r4)     // Catch: java.lang.Throwable -> L1f
                java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> L1f
                org.apache.commons.logging.LogFactory.access$000(r3)     // Catch: java.lang.Throwable -> L1f
            L64:
                if (r2 == 0) goto L76
                r2.close()     // Catch: java.io.IOException -> L6a
                goto L76
            L6a:
                boolean r2 = org.apache.commons.logging.LogFactory.isDiagnosticsEnabled()
                if (r2 == 0) goto L76
                java.lang.StringBuffer r2 = new java.lang.StringBuffer
                r2.<init>()
                goto L32
            L76:
                return r1
            L77:
                if (r2 == 0) goto L97
                r2.close()     // Catch: java.io.IOException -> L7d
                goto L97
            L7d:
                boolean r2 = org.apache.commons.logging.LogFactory.isDiagnosticsEnabled()
                if (r2 == 0) goto L97
                java.lang.StringBuffer r2 = new java.lang.StringBuffer
                r2.<init>()
                r2.append(r0)
                java.net.URL r0 = r6.val$url
                r2.append(r0)
                java.lang.String r0 = r2.toString()
                org.apache.commons.logging.LogFactory.access$000(r0)
            L97:
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.logging.LogFactory.5.run():java.lang.Object");
        }
    }

    final class 6 implements PrivilegedAction {
        private final /* synthetic */ String val$def;
        private final /* synthetic */ String val$key;

        public 6(String str, String str2) {
            this.val$key = str;
            this.val$def = str2;
        }

        public Object run() {
            return System.getProperty(this.val$key, this.val$def);
        }
    }

    static {
        String str;
        Class cls = class$org$apache$commons$logging$LogFactory;
        if (cls == null) {
            cls = class$("org.apache.commons.logging.LogFactory");
            class$org$apache$commons$logging$LogFactory = cls;
        }
        ClassLoader classLoader = getClassLoader(cls);
        thisClassLoader = classLoader;
        if (classLoader == null) {
            str = "BOOTLOADER";
        } else {
            try {
                str = objectId(classLoader);
            } catch (SecurityException unused) {
                str = "UNKNOWN";
            }
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[LogFactory from ");
        stringBuffer.append(str);
        stringBuffer.append("] ");
        diagnosticPrefix = stringBuffer.toString();
        diagnosticsStream = initDiagnostics();
        Class cls2 = class$org$apache$commons$logging$LogFactory;
        if (cls2 == null) {
            cls2 = class$("org.apache.commons.logging.LogFactory");
            class$org$apache$commons$logging$LogFactory = cls2;
        }
        logClassLoaderEnvironment(cls2);
        factories = createFactoryStore();
        if (isDiagnosticsEnabled()) {
            logDiagnostic("BOOTSTRAP COMPLETED");
        }
    }

    public static /* synthetic */ void access$000(String str) {
        logDiagnostic(str);
    }

    private static void cacheFactory(ClassLoader classLoader, LogFactory logFactory) {
        if (logFactory != null) {
            if (classLoader == null) {
                nullClassLoaderFactory = logFactory;
            } else {
                factories.put(classLoader, logFactory);
            }
        }
    }

    public static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError(e.getMessage());
        }
    }

    public static Object createFactory(String str, ClassLoader classLoader) {
        String str2;
        Class cls = null;
        try {
            if (classLoader != null) {
                try {
                    try {
                        cls = classLoader.loadClass(str);
                        Class cls2 = class$org$apache$commons$logging$LogFactory;
                        if (cls2 == null) {
                            cls2 = class$("org.apache.commons.logging.LogFactory");
                            class$org$apache$commons$logging$LogFactory = cls2;
                        }
                        if (cls2.isAssignableFrom(cls)) {
                            if (isDiagnosticsEnabled()) {
                                StringBuffer stringBuffer = new StringBuffer();
                                stringBuffer.append("Loaded class ");
                                stringBuffer.append(cls.getName());
                                stringBuffer.append(" from classloader ");
                                stringBuffer.append(objectId(classLoader));
                                logDiagnostic(stringBuffer.toString());
                            }
                        } else if (isDiagnosticsEnabled()) {
                            StringBuffer stringBuffer2 = new StringBuffer();
                            stringBuffer2.append("Factory class ");
                            stringBuffer2.append(cls.getName());
                            stringBuffer2.append(" loaded from classloader ");
                            stringBuffer2.append(objectId(cls.getClassLoader()));
                            stringBuffer2.append(" does not extend '");
                            Class cls3 = class$org$apache$commons$logging$LogFactory;
                            if (cls3 == null) {
                                cls3 = class$("org.apache.commons.logging.LogFactory");
                                class$org$apache$commons$logging$LogFactory = cls3;
                            }
                            stringBuffer2.append(cls3.getName());
                            stringBuffer2.append("' as loaded by this classloader.");
                            logDiagnostic(stringBuffer2.toString());
                            logHierarchy("[BAD CL TREE] ", classLoader);
                        }
                        return (LogFactory) cls.newInstance();
                    } catch (NoClassDefFoundError e) {
                        if (classLoader == thisClassLoader) {
                            if (isDiagnosticsEnabled()) {
                                StringBuffer stringBuffer3 = new StringBuffer();
                                stringBuffer3.append("Class '");
                                stringBuffer3.append(str);
                                stringBuffer3.append("' cannot be loaded");
                                stringBuffer3.append(" via classloader ");
                                stringBuffer3.append(objectId(classLoader));
                                stringBuffer3.append(" - it depends on some other class that cannot be found.");
                                logDiagnostic(stringBuffer3.toString());
                            }
                            throw e;
                        }
                    }
                } catch (ClassCastException unused) {
                    if (classLoader == thisClassLoader) {
                        boolean implementsLogFactory = implementsLogFactory(cls);
                        StringBuffer stringBuffer4 = new StringBuffer();
                        stringBuffer4.append("The application has specified that a custom LogFactory implementation ");
                        stringBuffer4.append("should be used but Class '");
                        stringBuffer4.append(str);
                        stringBuffer4.append("' cannot be converted to '");
                        Class cls4 = class$org$apache$commons$logging$LogFactory;
                        if (cls4 == null) {
                            cls4 = class$("org.apache.commons.logging.LogFactory");
                            class$org$apache$commons$logging$LogFactory = cls4;
                        }
                        stringBuffer4.append(cls4.getName());
                        stringBuffer4.append("'. ");
                        if (implementsLogFactory) {
                            stringBuffer4.append("The conflict is caused by the presence of multiple LogFactory classes ");
                            stringBuffer4.append("in incompatible classloaders. ");
                            stringBuffer4.append("Background can be found in http://commons.apache.org/logging/tech.html. ");
                            stringBuffer4.append("If you have not explicitly specified a custom LogFactory then it is likely ");
                            stringBuffer4.append("that the container has set one without your knowledge. ");
                            stringBuffer4.append("In this case, consider using the commons-logging-adapters.jar file or ");
                            str2 = "specifying the standard LogFactory from the command line. ";
                        } else {
                            str2 = "Please check the custom implementation. ";
                        }
                        stringBuffer4.append(str2);
                        stringBuffer4.append("Help can be found @http://commons.apache.org/logging/troubleshooting.html.");
                        if (isDiagnosticsEnabled()) {
                            logDiagnostic(stringBuffer4.toString());
                        }
                        throw new ClassCastException(stringBuffer4.toString());
                    }
                } catch (ClassNotFoundException e2) {
                    if (classLoader == thisClassLoader) {
                        if (isDiagnosticsEnabled()) {
                            StringBuffer stringBuffer5 = new StringBuffer();
                            stringBuffer5.append("Unable to locate any class called '");
                            stringBuffer5.append(str);
                            stringBuffer5.append("' via classloader ");
                            stringBuffer5.append(objectId(classLoader));
                            logDiagnostic(stringBuffer5.toString());
                        }
                        throw e2;
                    }
                }
            }
            if (isDiagnosticsEnabled()) {
                StringBuffer stringBuffer6 = new StringBuffer();
                stringBuffer6.append("Unable to load factory class via classloader ");
                stringBuffer6.append(objectId(classLoader));
                stringBuffer6.append(" - trying the classloader associated with this LogFactory.");
                logDiagnostic(stringBuffer6.toString());
            }
            return (LogFactory) Class.forName(str).newInstance();
        } catch (Exception e3) {
            if (isDiagnosticsEnabled()) {
                logDiagnostic("Unable to create LogFactory instance.");
            }
            if (cls != null) {
                Class cls5 = class$org$apache$commons$logging$LogFactory;
                if (cls5 == null) {
                    cls5 = class$("org.apache.commons.logging.LogFactory");
                    class$org$apache$commons$logging$LogFactory = cls5;
                }
                if (!cls5.isAssignableFrom(cls)) {
                    return new LogConfigurationException("The chosen LogFactory implementation does not extend LogFactory. Please check your configuration.", e3);
                }
            }
            return new LogConfigurationException((Throwable) e3);
        }
    }

    private static final Hashtable createFactoryStore() {
        String str;
        Hashtable hashtable = null;
        try {
            str = getSystemProperty("org.apache.commons.logging.LogFactory.HashtableImpl", null);
        } catch (SecurityException unused) {
            str = null;
        }
        if (str == null) {
            str = "org.apache.commons.logging.impl.WeakHashtable";
        }
        try {
            hashtable = (Hashtable) Class.forName(str).newInstance();
        } catch (Throwable th) {
            handleThrowable(th);
            if (!"org.apache.commons.logging.impl.WeakHashtable".equals(str)) {
                if (isDiagnosticsEnabled()) {
                    logDiagnostic("[ERROR] LogFactory: Load of custom hashtable failed");
                } else {
                    System.err.println("[ERROR] LogFactory: Load of custom hashtable failed");
                }
            }
        }
        return hashtable == null ? new Hashtable() : hashtable;
    }

    public static ClassLoader directGetContextClassLoader() throws LogConfigurationException {
        try {
            return Thread.currentThread().getContextClassLoader();
        } catch (SecurityException unused) {
            return null;
        }
    }

    private static LogFactory getCachedFactory(ClassLoader classLoader) {
        return classLoader == null ? nullClassLoaderFactory : (LogFactory) factories.get(classLoader);
    }

    public static ClassLoader getClassLoader(Class cls) {
        try {
            return cls.getClassLoader();
        } catch (SecurityException e) {
            if (isDiagnosticsEnabled()) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("Unable to get classloader for class '");
                stringBuffer.append(cls);
                stringBuffer.append("' due to security restrictions - ");
                stringBuffer.append(e.getMessage());
                logDiagnostic(stringBuffer.toString());
            }
            throw e;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00f1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final java.util.Properties getConfigurationFile(java.lang.ClassLoader r14, java.lang.String r15) {
        /*
            Method dump skipped, instructions count: 295
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.logging.LogFactory.getConfigurationFile(java.lang.ClassLoader, java.lang.String):java.util.Properties");
    }

    public static ClassLoader getContextClassLoader() throws LogConfigurationException {
        return directGetContextClassLoader();
    }

    private static ClassLoader getContextClassLoaderInternal() throws LogConfigurationException {
        return (ClassLoader) AccessController.doPrivileged(new 1());
    }

    public static LogFactory getFactory() throws LogConfigurationException {
        String str;
        BufferedReader bufferedReader;
        String property;
        ClassLoader contextClassLoaderInternal = getContextClassLoaderInternal();
        if (contextClassLoaderInternal == null && isDiagnosticsEnabled()) {
            logDiagnostic("Context classloader is null.");
        }
        LogFactory cachedFactory = getCachedFactory(contextClassLoaderInternal);
        if (cachedFactory != null) {
            return cachedFactory;
        }
        if (isDiagnosticsEnabled()) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("[LOOKUP] LogFactory implementation requested for the first time for context classloader ");
            stringBuffer.append(objectId(contextClassLoaderInternal));
            logDiagnostic(stringBuffer.toString());
            logHierarchy("[LOOKUP] ", contextClassLoaderInternal);
        }
        Properties configurationFile = getConfigurationFile(contextClassLoaderInternal, "commons-logging.properties");
        ClassLoader classLoader = (configurationFile == null || (property = configurationFile.getProperty("use_tccl")) == null || Boolean.valueOf(property).booleanValue()) ? contextClassLoaderInternal : thisClassLoader;
        if (isDiagnosticsEnabled()) {
            logDiagnostic("[LOOKUP] Looking for system property [org.apache.commons.logging.LogFactory] to define the LogFactory subclass to use...");
        }
        try {
            String systemProperty = getSystemProperty("org.apache.commons.logging.LogFactory", null);
            if (systemProperty != null) {
                if (isDiagnosticsEnabled()) {
                    StringBuffer stringBuffer2 = new StringBuffer();
                    stringBuffer2.append("[LOOKUP] Creating an instance of LogFactory class '");
                    stringBuffer2.append(systemProperty);
                    stringBuffer2.append("' as specified by system property ");
                    stringBuffer2.append("org.apache.commons.logging.LogFactory");
                    logDiagnostic(stringBuffer2.toString());
                }
                cachedFactory = newFactory(systemProperty, classLoader, contextClassLoaderInternal);
            } else if (isDiagnosticsEnabled()) {
                logDiagnostic("[LOOKUP] No system property [org.apache.commons.logging.LogFactory] defined.");
            }
        } catch (RuntimeException e) {
            if (isDiagnosticsEnabled()) {
                StringBuffer stringBuffer3 = new StringBuffer();
                stringBuffer3.append("[LOOKUP] An exception occurred while trying to create an instance of the custom factory class: [");
                stringBuffer3.append(trim(e.getMessage()));
                stringBuffer3.append("] as specified by a system property.");
                logDiagnostic(stringBuffer3.toString());
            }
            throw e;
        } catch (SecurityException e2) {
            if (isDiagnosticsEnabled()) {
                StringBuffer stringBuffer4 = new StringBuffer();
                stringBuffer4.append("[LOOKUP] A security exception occurred while trying to create an instance of the custom factory class: [");
                stringBuffer4.append(trim(e2.getMessage()));
                stringBuffer4.append("]. Trying alternative implementations...");
                logDiagnostic(stringBuffer4.toString());
            }
        }
        if (cachedFactory == null) {
            if (isDiagnosticsEnabled()) {
                logDiagnostic("[LOOKUP] Looking for a resource file of name [META-INF/services/org.apache.commons.logging.LogFactory] to define the LogFactory subclass to use...");
            }
            try {
                InputStream resourceAsStream = getResourceAsStream(contextClassLoaderInternal, "META-INF/services/org.apache.commons.logging.LogFactory");
                if (resourceAsStream != null) {
                    try {
                        bufferedReader = new BufferedReader(new InputStreamReader(resourceAsStream, "UTF-8"));
                    } catch (UnsupportedEncodingException unused) {
                        bufferedReader = new BufferedReader(new InputStreamReader(resourceAsStream));
                    }
                    String readLine = bufferedReader.readLine();
                    bufferedReader.close();
                    if (readLine != null && !"".equals(readLine)) {
                        if (isDiagnosticsEnabled()) {
                            StringBuffer stringBuffer5 = new StringBuffer();
                            stringBuffer5.append("[LOOKUP]  Creating an instance of LogFactory class ");
                            stringBuffer5.append(readLine);
                            stringBuffer5.append(" as specified by file '");
                            stringBuffer5.append("META-INF/services/org.apache.commons.logging.LogFactory");
                            stringBuffer5.append("' which was present in the path of the context classloader.");
                            logDiagnostic(stringBuffer5.toString());
                        }
                        cachedFactory = newFactory(readLine, classLoader, contextClassLoaderInternal);
                    }
                } else if (isDiagnosticsEnabled()) {
                    logDiagnostic("[LOOKUP] No resource file with name 'META-INF/services/org.apache.commons.logging.LogFactory' found.");
                }
            } catch (Exception e3) {
                if (isDiagnosticsEnabled()) {
                    StringBuffer stringBuffer6 = new StringBuffer();
                    stringBuffer6.append("[LOOKUP] A security exception occurred while trying to create an instance of the custom factory class: [");
                    stringBuffer6.append(trim(e3.getMessage()));
                    stringBuffer6.append("]. Trying alternative implementations...");
                    logDiagnostic(stringBuffer6.toString());
                }
            }
        }
        if (cachedFactory == null) {
            boolean isDiagnosticsEnabled = isDiagnosticsEnabled();
            if (configurationFile != null) {
                if (isDiagnosticsEnabled) {
                    logDiagnostic("[LOOKUP] Looking in properties file for entry with key 'org.apache.commons.logging.LogFactory' to define the LogFactory subclass to use...");
                }
                String property2 = configurationFile.getProperty("org.apache.commons.logging.LogFactory");
                if (property2 != null) {
                    if (isDiagnosticsEnabled()) {
                        StringBuffer stringBuffer7 = new StringBuffer();
                        stringBuffer7.append("[LOOKUP] Properties file specifies LogFactory subclass '");
                        stringBuffer7.append(property2);
                        stringBuffer7.append("'");
                        logDiagnostic(stringBuffer7.toString());
                    }
                    cachedFactory = newFactory(property2, classLoader, contextClassLoaderInternal);
                } else if (isDiagnosticsEnabled()) {
                    str = "[LOOKUP] Properties file has no entry specifying LogFactory subclass.";
                    logDiagnostic(str);
                }
            } else if (isDiagnosticsEnabled) {
                str = "[LOOKUP] No properties file available to determine LogFactory subclass from..";
                logDiagnostic(str);
            }
        }
        if (cachedFactory == null) {
            if (isDiagnosticsEnabled()) {
                logDiagnostic("[LOOKUP] Loading the default LogFactory implementation 'org.apache.commons.logging.impl.LogFactoryImpl' via the same classloader that loaded this LogFactory class (ie not looking in the context classloader).");
            }
            cachedFactory = newFactory("org.apache.commons.logging.impl.LogFactoryImpl", thisClassLoader, contextClassLoaderInternal);
        }
        if (cachedFactory != null) {
            cacheFactory(contextClassLoaderInternal, cachedFactory);
            if (configurationFile != null) {
                Enumeration propertyNames = configurationFile.propertyNames();
                while (propertyNames.hasMoreElements()) {
                    String str2 = (String) propertyNames.nextElement();
                    cachedFactory.setAttribute(str2, configurationFile.getProperty(str2));
                }
            }
        }
        return cachedFactory;
    }

    public static Log getLog(Class cls) throws LogConfigurationException {
        return getFactory().getInstance(cls);
    }

    private static Properties getProperties(URL url) {
        return (Properties) AccessController.doPrivileged(new 5(url));
    }

    private static InputStream getResourceAsStream(ClassLoader classLoader, String str) {
        return (InputStream) AccessController.doPrivileged(new 3(classLoader, str));
    }

    private static Enumeration getResources(ClassLoader classLoader, String str) {
        return (Enumeration) AccessController.doPrivileged(new 4(classLoader, str));
    }

    private static String getSystemProperty(String str, String str2) throws SecurityException {
        return (String) AccessController.doPrivileged(new 6(str, str2));
    }

    public static void handleThrowable(Throwable th) {
        if (th instanceof ThreadDeath) {
            throw ((ThreadDeath) th);
        }
        if (th instanceof VirtualMachineError) {
            throw ((VirtualMachineError) th);
        }
    }

    private static boolean implementsLogFactory(Class cls) {
        StringBuffer stringBuffer;
        String str;
        String str2;
        String stringBuffer2;
        boolean z = false;
        if (cls != null) {
            try {
                ClassLoader classLoader = cls.getClassLoader();
                if (classLoader == null) {
                    stringBuffer2 = "[CUSTOM LOG FACTORY] was loaded by the boot classloader";
                } else {
                    logHierarchy("[CUSTOM LOG FACTORY] ", classLoader);
                    z = Class.forName("org.apache.commons.logging.LogFactory", false, classLoader).isAssignableFrom(cls);
                    if (z) {
                        StringBuffer stringBuffer3 = new StringBuffer();
                        stringBuffer3.append("[CUSTOM LOG FACTORY] ");
                        stringBuffer3.append(cls.getName());
                        stringBuffer3.append(" implements LogFactory but was loaded by an incompatible classloader.");
                        stringBuffer2 = stringBuffer3.toString();
                    } else {
                        StringBuffer stringBuffer4 = new StringBuffer();
                        stringBuffer4.append("[CUSTOM LOG FACTORY] ");
                        stringBuffer4.append(cls.getName());
                        stringBuffer4.append(" does not implement LogFactory.");
                        stringBuffer2 = stringBuffer4.toString();
                    }
                }
                logDiagnostic(stringBuffer2);
            } catch (LinkageError e) {
                e = e;
                stringBuffer = new StringBuffer();
                str = "[CUSTOM LOG FACTORY] LinkageError thrown whilst trying to determine whether the compatibility was caused by a classloader conflict: ";
                stringBuffer.append(str);
                stringBuffer.append(e.getMessage());
                str2 = stringBuffer.toString();
                logDiagnostic(str2);
                return z;
            } catch (ClassNotFoundException unused) {
                str2 = "[CUSTOM LOG FACTORY] LogFactory class cannot be loaded by classloader which loaded the custom LogFactory implementation. Is the custom factory in the right classloader?";
                logDiagnostic(str2);
                return z;
            } catch (SecurityException e2) {
                e = e2;
                stringBuffer = new StringBuffer();
                str = "[CUSTOM LOG FACTORY] SecurityException thrown whilst trying to determine whether the compatibility was caused by a classloader conflict: ";
                stringBuffer.append(str);
                stringBuffer.append(e.getMessage());
                str2 = stringBuffer.toString();
                logDiagnostic(str2);
                return z;
            }
        }
        return z;
    }

    private static PrintStream initDiagnostics() {
        try {
            String systemProperty = getSystemProperty("org.apache.commons.logging.diagnostics.dest", null);
            if (systemProperty == null) {
                return null;
            }
            return systemProperty.equals("STDOUT") ? System.out : systemProperty.equals("STDERR") ? System.err : new PrintStream(new FileOutputStream(systemProperty, true));
        } catch (SecurityException | IOException unused) {
            return null;
        }
    }

    public static boolean isDiagnosticsEnabled() {
        return diagnosticsStream != null;
    }

    private static void logClassLoaderEnvironment(Class cls) {
        if (isDiagnosticsEnabled()) {
            try {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("[ENV] Extension directories (java.ext.dir): ");
                stringBuffer.append(System.getProperty("java.ext.dir"));
                logDiagnostic(stringBuffer.toString());
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append("[ENV] Application classpath (java.class.path): ");
                stringBuffer2.append(System.getProperty("java.class.path"));
                logDiagnostic(stringBuffer2.toString());
            } catch (SecurityException unused) {
                logDiagnostic("[ENV] Security setting prevent interrogation of system classpaths.");
            }
            String name = cls.getName();
            try {
                ClassLoader classLoader = getClassLoader(cls);
                StringBuffer stringBuffer3 = new StringBuffer();
                stringBuffer3.append("[ENV] Class ");
                stringBuffer3.append(name);
                stringBuffer3.append(" was loaded via classloader ");
                stringBuffer3.append(objectId(classLoader));
                logDiagnostic(stringBuffer3.toString());
                StringBuffer stringBuffer4 = new StringBuffer();
                stringBuffer4.append("[ENV] Ancestry of classloader which loaded ");
                stringBuffer4.append(name);
                stringBuffer4.append(" is ");
                logHierarchy(stringBuffer4.toString(), classLoader);
            } catch (SecurityException unused2) {
                StringBuffer stringBuffer5 = new StringBuffer();
                stringBuffer5.append("[ENV] Security forbids determining the classloader for ");
                stringBuffer5.append(name);
                logDiagnostic(stringBuffer5.toString());
            }
        }
    }

    private static final void logDiagnostic(String str) {
        PrintStream printStream = diagnosticsStream;
        if (printStream != null) {
            printStream.print(diagnosticPrefix);
            diagnosticsStream.println(str);
            diagnosticsStream.flush();
        }
    }

    private static void logHierarchy(String str, ClassLoader classLoader) {
        String str2;
        if (isDiagnosticsEnabled()) {
            if (classLoader != null) {
                String obj = classLoader.toString();
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(str);
                stringBuffer.append(objectId(classLoader));
                stringBuffer.append(" == '");
                stringBuffer.append(obj);
                stringBuffer.append("'");
                logDiagnostic(stringBuffer.toString());
            }
            try {
                ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
                if (classLoader != null) {
                    StringBuffer stringBuffer2 = new StringBuffer();
                    stringBuffer2.append(str);
                    stringBuffer2.append("ClassLoader tree:");
                    StringBuffer stringBuffer3 = new StringBuffer(stringBuffer2.toString());
                    do {
                        stringBuffer3.append(objectId(classLoader));
                        if (classLoader == systemClassLoader) {
                            stringBuffer3.append(" (SYSTEM) ");
                        }
                        try {
                            classLoader = classLoader.getParent();
                            stringBuffer3.append(" --> ");
                        } catch (SecurityException unused) {
                            str2 = " --> SECRET";
                        }
                    } while (classLoader != null);
                    str2 = "BOOT";
                    stringBuffer3.append(str2);
                    logDiagnostic(stringBuffer3.toString());
                }
            } catch (SecurityException unused2) {
                StringBuffer stringBuffer4 = new StringBuffer();
                stringBuffer4.append(str);
                stringBuffer4.append("Security forbids determining the system classloader.");
                logDiagnostic(stringBuffer4.toString());
            }
        }
    }

    public static final void logRawDiagnostic(String str) {
        PrintStream printStream = diagnosticsStream;
        if (printStream != null) {
            printStream.println(str);
            diagnosticsStream.flush();
        }
    }

    public static LogFactory newFactory(String str, ClassLoader classLoader) {
        return newFactory(str, classLoader, null);
    }

    public static String objectId(Object obj) {
        if (obj == null) {
            return "null";
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(obj.getClass().getName());
        stringBuffer.append("@");
        stringBuffer.append(System.identityHashCode(obj));
        return stringBuffer.toString();
    }

    public static void release(ClassLoader classLoader) {
        if (isDiagnosticsEnabled()) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Releasing factory for classloader ");
            stringBuffer.append(objectId(classLoader));
            logDiagnostic(stringBuffer.toString());
        }
        Hashtable hashtable = factories;
        synchronized (hashtable) {
            try {
                if (classLoader != null) {
                    LogFactory logFactory = (LogFactory) hashtable.get(classLoader);
                    if (logFactory != null) {
                        logFactory.release();
                        hashtable.remove(classLoader);
                    }
                } else if (nullClassLoaderFactory != null) {
                    nullClassLoaderFactory.release();
                    nullClassLoaderFactory = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void releaseAll() {
        if (isDiagnosticsEnabled()) {
            logDiagnostic("Releasing factory for all classloaders.");
        }
        Hashtable hashtable = factories;
        synchronized (hashtable) {
            try {
                Enumeration elements = hashtable.elements();
                while (elements.hasMoreElements()) {
                    ((LogFactory) elements.nextElement()).release();
                }
                hashtable.clear();
                if (nullClassLoaderFactory != null) {
                    nullClassLoaderFactory.release();
                    nullClassLoaderFactory = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static String trim(String str) {
        if (str == null) {
            return null;
        }
        return str.trim();
    }

    public abstract Object getAttribute(String str);

    public abstract String[] getAttributeNames();

    public abstract Log getInstance(Class cls) throws LogConfigurationException;

    public abstract Log getInstance(String str) throws LogConfigurationException;

    public abstract void release();

    public abstract void removeAttribute(String str);

    public abstract void setAttribute(String str, Object obj);

    public static Log getLog(String str) throws LogConfigurationException {
        return getFactory().getInstance(str);
    }

    public static LogFactory newFactory(String str, ClassLoader classLoader, ClassLoader classLoader2) throws LogConfigurationException {
        Object doPrivileged = AccessController.doPrivileged(new 2(str, classLoader));
        if (doPrivileged instanceof LogConfigurationException) {
            LogConfigurationException logConfigurationException = (LogConfigurationException) doPrivileged;
            if (!isDiagnosticsEnabled()) {
                throw logConfigurationException;
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("An error occurred while loading the factory class:");
            stringBuffer.append(logConfigurationException.getMessage());
            logDiagnostic(stringBuffer.toString());
            throw logConfigurationException;
        }
        if (isDiagnosticsEnabled()) {
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append("Created object ");
            stringBuffer2.append(objectId(doPrivileged));
            stringBuffer2.append(" to manage classloader ");
            stringBuffer2.append(objectId(classLoader2));
            logDiagnostic(stringBuffer2.toString());
        }
        return (LogFactory) doPrivileged;
    }
}

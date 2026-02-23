package org.apache.commons.logging.impl;

import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import org.apache.commons.logging.LogFactory;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class ServletContextCleaner implements ServletContextListener {
    private static final Class[] RELEASE_SIGNATURE;
    static /* synthetic */ Class class$java$lang$ClassLoader;

    static {
        Class cls = class$java$lang$ClassLoader;
        if (cls == null) {
            cls = class$("java.lang.ClassLoader");
            class$java$lang$ClassLoader = cls;
        }
        RELEASE_SIGNATURE = new Class[]{cls};
    }

    public static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError(e.getMessage());
        }
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        PrintStream printStream;
        String str;
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        Object[] objArr = {contextClassLoader};
        ClassLoader classLoader = contextClassLoader;
        while (classLoader != null) {
            try {
                Class loadClass = classLoader.loadClass("org.apache.commons.logging.LogFactory");
                loadClass.getMethod("release", RELEASE_SIGNATURE).invoke((Object) null, objArr);
                classLoader = loadClass.getClassLoader().getParent();
            } catch (NoSuchMethodException unused) {
                printStream = System.err;
                str = "LogFactory instance found which does not support release method!";
                printStream.println(str);
                classLoader = null;
            } catch (InvocationTargetException unused2) {
                printStream = System.err;
                str = "LogFactory instance release method failed!";
                printStream.println(str);
                classLoader = null;
            } catch (IllegalAccessException unused3) {
                printStream = System.err;
                str = "LogFactory instance found which is not accessable!";
                printStream.println(str);
                classLoader = null;
            } catch (ClassNotFoundException unused4) {
                classLoader = null;
            }
        }
        LogFactory.release(contextClassLoader);
    }

    public void contextInitialized(ServletContextEvent servletContextEvent) {
    }
}

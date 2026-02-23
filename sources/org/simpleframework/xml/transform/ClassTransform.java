package org.simpleframework.xml.transform;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
class ClassTransform implements Transform {
    private static final String BOOLEAN = "boolean";
    private static final String BYTE = "byte";
    private static final String CHARACTER = "char";
    private static final String DOUBLE = "double";
    private static final String FLOAT = "float";
    private static final String INTEGER = "int";
    private static final String LONG = "long";
    private static final String SHORT = "short";
    private static final String VOID = "void";

    private ClassLoader getCallerClassLoader() {
        return getClass().getClassLoader();
    }

    private static ClassLoader getClassLoader() {
        return Thread.currentThread().getContextClassLoader();
    }

    private Class readPrimitive(String str) throws Exception {
        if (str.equals("byte")) {
            return Byte.TYPE;
        }
        if (str.equals("short")) {
            return Short.TYPE;
        }
        if (str.equals("int")) {
            return Integer.TYPE;
        }
        if (str.equals("long")) {
            return Long.TYPE;
        }
        if (str.equals("char")) {
            return Character.TYPE;
        }
        if (str.equals("float")) {
            return Float.TYPE;
        }
        if (str.equals("double")) {
            return Double.TYPE;
        }
        if (str.equals("boolean")) {
            return Boolean.TYPE;
        }
        if (str.equals("void")) {
            return Void.TYPE;
        }
        return null;
    }

    public Class read(String str) throws Exception {
        Class readPrimitive = readPrimitive(str);
        if (readPrimitive != null) {
            return readPrimitive;
        }
        ClassLoader classLoader = getClassLoader();
        if (classLoader == null) {
            classLoader = getCallerClassLoader();
        }
        return classLoader.loadClass(str);
    }

    public String write(Class cls) throws Exception {
        return cls.getName();
    }
}

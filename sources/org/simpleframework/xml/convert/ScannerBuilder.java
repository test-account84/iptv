package org.simpleframework.xml.convert;

import java.lang.annotation.Annotation;
import org.simpleframework.xml.util.ConcurrentCache;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
class ScannerBuilder extends ConcurrentCache {

    public static class Entry extends ConcurrentCache implements Scanner {
        private final Class root;

        public Entry(Class cls) {
            this.root = cls;
        }

        private Annotation find(Class cls) {
            for (Class cls2 = this.root; cls2 != null; cls2 = cls2.getSuperclass()) {
                Annotation annotation = cls2.getAnnotation(cls);
                if (annotation != null) {
                    return annotation;
                }
            }
            return null;
        }

        public Annotation scan(Class cls) {
            if (!contains(cls)) {
                Annotation find = find(cls);
                if (cls != null && find != null) {
                    put(cls, find);
                }
            }
            return (Annotation) get(cls);
        }
    }

    public Scanner build(Class cls) {
        Scanner scanner = (Scanner) get(cls);
        if (scanner != null) {
            return scanner;
        }
        Entry entry = new Entry(cls);
        put(cls, entry);
        return entry;
    }
}

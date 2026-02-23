package org.simpleframework.xml.core;

import org.simpleframework.xml.util.Cache;
import org.simpleframework.xml.util.ConcurrentCache;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
class ScannerFactory {
    private final Cache cache = new ConcurrentCache();
    private final Support support;

    public ScannerFactory(Support support) {
        this.support = support;
    }

    public Scanner getInstance(Class cls) throws Exception {
        Scanner objectScanner;
        Scanner scanner = (Scanner) this.cache.fetch(cls);
        if (scanner == null) {
            Detail detail = this.support.getDetail(cls);
            if (this.support.isPrimitive(cls)) {
                objectScanner = new PrimitiveScanner(detail);
            } else {
                objectScanner = new ObjectScanner(detail, this.support);
                if (objectScanner.isPrimitive() && !this.support.isContainer(cls)) {
                    objectScanner = new DefaultScanner(detail, this.support);
                }
            }
            scanner = objectScanner;
            this.cache.cache(cls, scanner);
        }
        return scanner;
    }
}

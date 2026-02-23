package org.simpleframework.xml.transform;

import org.simpleframework.xml.util.Cache;
import org.simpleframework.xml.util.ConcurrentCache;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class RegistryMatcher implements Matcher {
    private final Cache transforms = new ConcurrentCache();
    private final Cache types = new ConcurrentCache();

    private Transform create(Class cls) throws Exception {
        Class cls2 = (Class) this.types.fetch(cls);
        if (cls2 != null) {
            return create(cls, cls2);
        }
        return null;
    }

    public void bind(Class cls, Class cls2) {
        this.types.cache(cls, cls2);
    }

    public Transform match(Class cls) throws Exception {
        Transform transform = (Transform) this.transforms.fetch(cls);
        return transform == null ? create(cls) : transform;
    }

    private Transform create(Class cls, Class cls2) throws Exception {
        Transform transform = (Transform) cls2.newInstance();
        if (transform != null) {
            this.transforms.cache(cls, transform);
        }
        return transform;
    }

    public void bind(Class cls, Transform transform) {
        this.transforms.cache(cls, transform);
    }
}

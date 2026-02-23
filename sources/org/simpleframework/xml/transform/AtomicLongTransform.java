package org.simpleframework.xml.transform;

import java.util.concurrent.atomic.AtomicLong;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
class AtomicLongTransform implements Transform {
    public AtomicLong read(String str) {
        return new AtomicLong(Long.valueOf(str).longValue());
    }

    public String write(AtomicLong atomicLong) {
        return atomicLong.toString();
    }
}

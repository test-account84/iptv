package org.simpleframework.xml.transform;

import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
class AtomicIntegerTransform implements Transform {
    public AtomicInteger read(String str) {
        return new AtomicInteger(Integer.valueOf(str).intValue());
    }

    public String write(AtomicInteger atomicInteger) {
        return atomicInteger.toString();
    }
}

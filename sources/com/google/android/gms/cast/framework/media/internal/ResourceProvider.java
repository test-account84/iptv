package com.google.android.gms.cast.framework.media.internal;

import androidx.annotation.Keep;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import o4.o;
import o4.p;
import o4.t;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class ResourceProvider {
    public static final Map a;

    static {
        HashMap hashMap = new HashMap();
        hashMap.put("smallIconDrawableResId", Integer.valueOf(p.m));
        hashMap.put("stopLiveStreamDrawableResId", Integer.valueOf(p.n));
        hashMap.put("pauseDrawableResId", Integer.valueOf(p.f));
        hashMap.put("playDrawableResId", Integer.valueOf(p.g));
        hashMap.put("skipNextDrawableResId", Integer.valueOf(p.k));
        hashMap.put("skipPrevDrawableResId", Integer.valueOf(p.l));
        hashMap.put("forwardDrawableResId", Integer.valueOf(p.c));
        hashMap.put("forward10DrawableResId", Integer.valueOf(p.d));
        hashMap.put("forward30DrawableResId", Integer.valueOf(p.e));
        hashMap.put("rewindDrawableResId", Integer.valueOf(p.h));
        hashMap.put("rewind10DrawableResId", Integer.valueOf(p.i));
        hashMap.put("rewind30DrawableResId", Integer.valueOf(p.j));
        hashMap.put("disconnectDrawableResId", Integer.valueOf(p.b));
        hashMap.put("notificationImageSizeDimenResId", Integer.valueOf(o.j));
        hashMap.put("castingToDeviceStringResId", Integer.valueOf(t.b));
        hashMap.put("stopLiveStreamStringResId", Integer.valueOf(t.v));
        hashMap.put("pauseStringResId", Integer.valueOf(t.n));
        hashMap.put("playStringResId", Integer.valueOf(t.o));
        hashMap.put("skipNextStringResId", Integer.valueOf(t.s));
        hashMap.put("skipPrevStringResId", Integer.valueOf(t.t));
        hashMap.put("forwardStringResId", Integer.valueOf(t.i));
        hashMap.put("forward10StringResId", Integer.valueOf(t.j));
        hashMap.put("forward30StringResId", Integer.valueOf(t.k));
        hashMap.put("rewindStringResId", Integer.valueOf(t.p));
        hashMap.put("rewind10StringResId", Integer.valueOf(t.q));
        hashMap.put("rewind30StringResId", Integer.valueOf(t.r));
        hashMap.put("disconnectStringResId", Integer.valueOf(t.f));
        a = Collections.unmodifiableMap(hashMap);
    }

    @Keep
    public static Integer findResourceByName(String str) {
        if (str == null) {
            return null;
        }
        return (Integer) a.get(str);
    }
}

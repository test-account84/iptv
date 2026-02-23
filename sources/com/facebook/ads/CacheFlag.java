package com.facebook.ads;

import androidx.annotation.Keep;
import java.util.EnumSet;

@Keep
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public enum CacheFlag {
    NONE,
    ICON,
    IMAGE,
    VIDEO;

    public static final EnumSet ALL = EnumSet.allOf(CacheFlag.class);
}

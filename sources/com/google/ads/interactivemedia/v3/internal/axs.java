package com.google.ads.interactivemedia.v3.internal;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class axs implements FilenameFilter {
    private final Pattern a;

    public axs(Pattern pattern) {
        atp.k(pattern);
        this.a = pattern;
    }

    public final boolean accept(File file, String str) {
        return this.a.matcher(str).matches();
    }
}

package com.amplifyframework.core.model;

import java.util.Map;
import java.util.Set;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public interface ModelProvider {
    Set customTypeNames();

    Map customTypeSchemas();

    Set modelNames();

    Map modelSchemas();

    Set models();

    String version();
}

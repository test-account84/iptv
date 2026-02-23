package com.amazonaws.util.json;

import java.io.Reader;
import java.io.Writer;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public interface AwsJsonFactory {
    AwsJsonReader getJsonReader(Reader reader);

    AwsJsonWriter getJsonWriter(Writer writer);
}

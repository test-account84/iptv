package org.simpleframework.xml.stream;

import java.io.InputStream;
import java.io.Reader;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
interface Provider {
    EventReader provide(InputStream inputStream) throws Exception;

    EventReader provide(Reader reader) throws Exception;
}

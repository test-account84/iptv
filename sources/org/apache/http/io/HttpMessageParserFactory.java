package org.apache.http.io;

import org.apache.http.config.MessageConstraints;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public interface HttpMessageParserFactory {
    HttpMessageParser create(SessionInputBuffer sessionInputBuffer, MessageConstraints messageConstraints);
}

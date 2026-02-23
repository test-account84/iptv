package org.simpleframework.xml.convert;

import org.simpleframework.xml.stream.InputNode;
import org.simpleframework.xml.stream.OutputNode;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public interface Converter {
    Object read(InputNode inputNode) throws Exception;

    void write(OutputNode outputNode, Object obj) throws Exception;
}

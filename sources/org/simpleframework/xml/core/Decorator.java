package org.simpleframework.xml.core;

import org.simpleframework.xml.stream.OutputNode;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
interface Decorator {
    void decorate(OutputNode outputNode);

    void decorate(OutputNode outputNode, Decorator decorator);
}

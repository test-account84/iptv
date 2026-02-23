package org.simpleframework.xml.core;

import org.simpleframework.xml.Version;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
interface Schema {
    Caller getCaller();

    Decorator getDecorator();

    Instantiator getInstantiator();

    Version getRevision();

    Section getSection();

    Label getText();

    Label getVersion();

    boolean isPrimitive();
}

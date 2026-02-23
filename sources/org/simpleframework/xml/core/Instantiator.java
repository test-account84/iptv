package org.simpleframework.xml.core;

import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
interface Instantiator {
    List getCreators();

    Object getInstance() throws Exception;

    Object getInstance(Criteria criteria) throws Exception;

    Parameter getParameter(String str);

    List getParameters();

    boolean isDefault();
}

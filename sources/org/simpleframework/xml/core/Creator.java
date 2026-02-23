package org.simpleframework.xml.core;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
interface Creator {
    Object getInstance() throws Exception;

    Object getInstance(Criteria criteria) throws Exception;

    double getScore(Criteria criteria) throws Exception;

    Signature getSignature() throws Exception;

    Class getType() throws Exception;
}

package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
interface Extractor {
    Annotation[] getAnnotations() throws Exception;

    Label getLabel(Annotation annotation) throws Exception;

    Class getType(Annotation annotation) throws Exception;
}

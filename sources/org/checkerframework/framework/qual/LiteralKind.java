package org.checkerframework.framework.qual;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public enum LiteralKind {
    NULL,
    INT,
    LONG,
    FLOAT,
    DOUBLE,
    BOOLEAN,
    CHAR,
    STRING,
    ALL,
    PRIMITIVE;

    public static List allLiteralKinds() {
        ArrayList arrayList = new ArrayList(Arrays.asList(values()));
        arrayList.remove(ALL);
        arrayList.remove(PRIMITIVE);
        return arrayList;
    }

    public static List primitiveLiteralKinds() {
        return Arrays.asList(new LiteralKind[]{INT, LONG, FLOAT, DOUBLE, BOOLEAN, CHAR});
    }
}

package org.simpleframework.xml.transform;

import java.math.BigDecimal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
class BigDecimalTransform implements Transform {
    public BigDecimal read(String str) {
        return new BigDecimal(str);
    }

    public String write(BigDecimal bigDecimal) {
        return bigDecimal.toString();
    }
}

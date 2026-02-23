package org.simpleframework.xml.transform;

import java.math.BigInteger;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
class BigIntegerTransform implements Transform {
    public BigInteger read(String str) {
        return new BigInteger(str);
    }

    public String write(BigInteger bigInteger) {
        return bigInteger.toString();
    }
}

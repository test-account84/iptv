package org.simpleframework.xml.transform;

import java.util.Currency;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
class CurrencyTransform implements Transform {
    public Currency read(String str) {
        return Currency.getInstance(str);
    }

    public String write(Currency currency) {
        return currency.toString();
    }
}

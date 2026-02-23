package com.amplifyframework.util;

import j$.util.function.Function;
import java.lang.reflect.Field;
import java.util.function.Function;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final /* synthetic */ class b implements Function {
    public /* synthetic */ Function andThen(Function function) {
        return Function.-CC.$default$andThen(this, function);
    }

    public final Object apply(Object obj) {
        return ((Field) obj).getName();
    }

    public /* synthetic */ java.util.function.Function compose(java.util.function.Function function) {
        return Function.-CC.$default$compose(this, function);
    }
}

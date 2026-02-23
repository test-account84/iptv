package l8;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public abstract class j {
    public static final Object[] a(Object[] objArr, boolean z) {
        kotlin.jvm.internal.l.e(objArr, "<this>");
        if (z && kotlin.jvm.internal.l.a(objArr.getClass(), Object[].class)) {
            return objArr;
        }
        Object[] copyOf = Arrays.copyOf(objArr, objArr.length, Object[].class);
        kotlin.jvm.internal.l.d(copyOf, "copyOf(this, this.size, Array<Any?>::class.java)");
        return copyOf;
    }

    public static List b(Object obj) {
        List singletonList = Collections.singletonList(obj);
        kotlin.jvm.internal.l.d(singletonList, "singletonList(element)");
        return singletonList;
    }
}

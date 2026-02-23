package j$.util.concurrent;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
final class g extends l {
    final l[] e;

    g(l[] lVarArr) {
        super(-1, null, null);
        this.e = lVarArr;
    }

    final l a(Object obj, int i) {
        int length;
        l k;
        Object obj2;
        l[] lVarArr = this.e;
        loop0: while (obj != null && lVarArr != null && (length = lVarArr.length) != 0 && (k = ConcurrentHashMap.k(lVarArr, (length - 1) & i)) != null) {
            do {
                int i2 = k.a;
                if (i2 == i && ((obj2 = k.b) == obj || (obj2 != null && obj.equals(obj2)))) {
                    return k;
                }
                if (i2 >= 0) {
                    k = k.d;
                } else {
                    if (!(k instanceof g)) {
                        return k.a(obj, i);
                    }
                    lVarArr = ((g) k).e;
                }
            } while (k != null);
        }
        return null;
    }
}

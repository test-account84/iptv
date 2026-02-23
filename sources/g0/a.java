package G0;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class a implements e {
    public final String a;
    public final Object[] c;

    public a(String str) {
        this(str, null);
    }

    public static void b(d dVar, int i, Object obj) {
        long j;
        int byteValue;
        double doubleValue;
        if (obj == null) {
            dVar.X(i);
            return;
        }
        if (obj instanceof byte[]) {
            dVar.S(i, (byte[]) obj);
            return;
        }
        if (obj instanceof Float) {
            doubleValue = ((Float) obj).floatValue();
        } else {
            if (!(obj instanceof Double)) {
                if (obj instanceof Long) {
                    j = ((Long) obj).longValue();
                } else {
                    if (obj instanceof Integer) {
                        byteValue = ((Integer) obj).intValue();
                    } else if (obj instanceof Short) {
                        byteValue = ((Short) obj).shortValue();
                    } else if (obj instanceof Byte) {
                        byteValue = ((Byte) obj).byteValue();
                    } else {
                        if (obj instanceof String) {
                            dVar.x(i, (String) obj);
                            return;
                        }
                        if (!(obj instanceof Boolean)) {
                            throw new IllegalArgumentException("Cannot bind " + obj + " at index " + i + " Supported types: null, byte[], float, double, long, int, short, byte, string");
                        }
                        j = ((Boolean) obj).booleanValue() ? 1L : 0L;
                    }
                    j = byteValue;
                }
                dVar.A(i, j);
                return;
            }
            doubleValue = ((Double) obj).doubleValue();
        }
        dVar.f(i, doubleValue);
    }

    public static void d(d dVar, Object[] objArr) {
        if (objArr == null) {
            return;
        }
        int length = objArr.length;
        int i = 0;
        while (i < length) {
            Object obj = objArr[i];
            i++;
            b(dVar, i, obj);
        }
    }

    public String a() {
        return this.a;
    }

    public void c(d dVar) {
        d(dVar, this.c);
    }

    public a(String str, Object[] objArr) {
        this.a = str;
        this.c = objArr;
    }
}

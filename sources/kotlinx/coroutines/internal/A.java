package kotlinx.coroutines.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class a {
    public Object[] a = new Object[16];
    public int b;
    public int c;

    public final void a(Object obj) {
        Object[] objArr = this.a;
        int i = this.c;
        objArr[i] = obj;
        int length = (objArr.length - 1) & (i + 1);
        this.c = length;
        if (length == this.b) {
            b();
        }
    }

    public final void b() {
        Object[] objArr = this.a;
        int length = objArr.length;
        Object[] objArr2 = new Object[length << 1];
        l8.g.f(objArr, objArr2, 0, this.b, 0, 10, null);
        Object[] objArr3 = this.a;
        int length2 = objArr3.length;
        int i = this.b;
        l8.g.f(objArr3, objArr2, length2 - i, 0, i, 4, null);
        this.a = objArr2;
        this.b = 0;
        this.c = length;
    }

    public final boolean c() {
        return this.b == this.c;
    }

    public final Object d() {
        int i = this.b;
        if (i == this.c) {
            return null;
        }
        Object[] objArr = this.a;
        Object obj = objArr[i];
        objArr[i] = null;
        this.b = (i + 1) & (objArr.length - 1);
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException("null cannot be cast to non-null type T of kotlinx.coroutines.internal.ArrayQueue");
    }
}

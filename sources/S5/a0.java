package s5;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class a0 extends C {
    public final transient Object d;

    public a0(Object obj) {
        this.d = r5.m.k(obj);
    }

    public boolean contains(Object obj) {
        return this.d.equals(obj);
    }

    public y d() {
        return y.A(this.d);
    }

    public int e(Object[] objArr, int i) {
        objArr[i] = this.d;
        return i + 1;
    }

    public final int hashCode() {
        return this.d.hashCode();
    }

    public boolean j() {
        return false;
    }

    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public c0 iterator() {
        return E.r(this.d);
    }

    public int size() {
        return 1;
    }

    public String toString() {
        String obj = this.d.toString();
        StringBuilder sb = new StringBuilder(String.valueOf(obj).length() + 2);
        sb.append('[');
        sb.append(obj);
        sb.append(']');
        return sb.toString();
    }
}

package androidx.datastore.preferences.protobuf;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class c0 implements M {
    public final O a;
    public final String b;
    public final Object[] c;
    public final int d;

    public c0(O o, String str, Object[] objArr) {
        char charAt;
        this.a = o;
        this.b = str;
        this.c = objArr;
        int charAt2 = str.charAt(0);
        if (charAt2 >= 55296) {
            int i = charAt2 & 8191;
            int i2 = 13;
            int i3 = 1;
            while (true) {
                int i4 = i3 + 1;
                charAt = str.charAt(i3);
                if (charAt < 55296) {
                    break;
                }
                i |= (charAt & 8191) << i2;
                i2 += 13;
                i3 = i4;
            }
            charAt2 = i | (charAt << i2);
        }
        this.d = charAt2;
    }

    public boolean a() {
        return (this.d & 2) == 2;
    }

    public O b() {
        return this.a;
    }

    public Z c() {
        return (this.d & 1) == 1 ? Z.PROTO2 : Z.PROTO3;
    }

    public Object[] d() {
        return this.c;
    }

    public String e() {
        return this.b;
    }
}

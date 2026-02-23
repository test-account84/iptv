package g1;

import java.util.ArrayList;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class k {
    public String a;
    public List b;

    public static class a {
        public String a;
        public List b;

        public /* synthetic */ a(S s) {
        }

        public k a() {
            String str = this.a;
            if (str == null) {
                throw new IllegalArgumentException("SKU type must be set");
            }
            if (this.b == null) {
                throw new IllegalArgumentException("SKU list must be set");
            }
            k kVar = new k();
            k.d(kVar, str);
            k.e(kVar, this.b);
            return kVar;
        }

        public a b(List list) {
            this.b = new ArrayList(list);
            return this;
        }

        public a c(String str) {
            this.a = str;
            return this;
        }
    }

    public static a c() {
        return new a(null);
    }

    public static /* bridge */ /* synthetic */ void d(k kVar, String str) {
        kVar.a = str;
    }

    public static /* bridge */ /* synthetic */ void e(k kVar, List list) {
        kVar.b = list;
    }

    public String a() {
        return this.a;
    }

    public List b() {
        return this.b;
    }
}

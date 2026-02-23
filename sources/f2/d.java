package F2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class d {
    public static final d c = new a().a();
    public final String a;
    public final List b;

    public static final class a {
        public String a = "";
        public List b = new ArrayList();

        public d a() {
            return new d(this.a, Collections.unmodifiableList(this.b));
        }

        public a b(List list) {
            this.b = list;
            return this;
        }

        public a c(String str) {
            this.a = str;
            return this;
        }
    }

    public d(String str, List list) {
        this.a = str;
        this.b = list;
    }

    public static a c() {
        return new a();
    }

    public List a() {
        return this.b;
    }

    public String b() {
        return this.a;
    }
}

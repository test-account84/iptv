package h1;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public interface b {

    public static class a {
        public byte[] a;
        public String b;
        public long c;
        public long d;
        public long e;
        public long f;
        public Map g = Collections.emptyMap();
        public List h;

        public boolean a() {
            return b(System.currentTimeMillis());
        }

        public boolean b(long j) {
            return this.e < j;
        }

        public boolean c(long j) {
            return this.f < j;
        }
    }

    void a(String str, boolean z);

    void b(String str, a aVar);

    a get(String str);

    void initialize();
}

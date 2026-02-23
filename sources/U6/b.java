package u6;

import kotlin.jvm.internal.l;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public interface b {

    public enum a {
        CRASHLYTICS,
        PERFORMANCE,
        MATT_SAYS_HI
    }

    public static final class b {
        public final String a;

        public b(String str) {
            l.e(str, "sessionId");
            this.a = str;
        }

        public final String a() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof b) && l.a(this.a, ((b) obj).a);
        }

        public int hashCode() {
            return this.a.hashCode();
        }

        public String toString() {
            return "SessionDetails(sessionId=" + this.a + ')';
        }
    }

    void a(b bVar);

    boolean b();

    a c();
}

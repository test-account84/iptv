package Q0;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public interface n {
    public static final b.c a = new b.c(null);
    public static final b.b b = new b.b(null);

    public static abstract class b {

        public static final class a extends b {
            public final Throwable a;

            public a(Throwable th) {
                this.a = th;
            }

            public Throwable a() {
                return this.a;
            }

            public String toString() {
                return String.format("FAILURE (%s)", new Object[]{this.a.getMessage()});
            }
        }

        public static final class b extends b {
            public b() {
            }

            public String toString() {
                return "IN_PROGRESS";
            }

            public /* synthetic */ b(a aVar) {
                this();
            }
        }

        public static final class c extends b {
            public c() {
            }

            public String toString() {
                return "SUCCESS";
            }

            public /* synthetic */ c(a aVar) {
                this();
            }
        }
    }
}

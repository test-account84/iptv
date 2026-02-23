package androidx.work;

import Q0.w;
import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.Keep;
import b1.c;
import java.util.UUID;
import java.util.concurrent.Executor;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class ListenableWorker {
    public Context a;
    public WorkerParameters c;
    public volatile boolean d;
    public boolean e;
    public boolean f;

    public static abstract class a {

        public static final class a extends a {
            public final androidx.work.b a;

            public a() {
                this(androidx.work.b.c);
            }

            public androidx.work.b e() {
                return this.a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || a.class != obj.getClass()) {
                    return false;
                }
                return this.a.equals(((a) obj).a);
            }

            public int hashCode() {
                return (a.class.getName().hashCode() * 31) + this.a.hashCode();
            }

            public String toString() {
                return "Failure {mOutputData=" + this.a + '}';
            }

            public a(androidx.work.b bVar) {
                this.a = bVar;
            }
        }

        public static final class b extends a {
            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && b.class == obj.getClass();
            }

            public int hashCode() {
                return b.class.getName().hashCode();
            }

            public String toString() {
                return "Retry";
            }
        }

        public static final class c extends a {
            public final androidx.work.b a;

            public c() {
                this(androidx.work.b.c);
            }

            public androidx.work.b e() {
                return this.a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || c.class != obj.getClass()) {
                    return false;
                }
                return this.a.equals(((c) obj).a);
            }

            public int hashCode() {
                return (c.class.getName().hashCode() * 31) + this.a.hashCode();
            }

            public String toString() {
                return "Success {mOutputData=" + this.a + '}';
            }

            public c(androidx.work.b bVar) {
                this.a = bVar;
            }
        }

        public static a a() {
            return new a();
        }

        public static a b() {
            return new b();
        }

        public static a c() {
            return new c();
        }

        public static a d(androidx.work.b bVar) {
            return new c(bVar);
        }
    }

    @Keep
    @SuppressLint({"BanKeepAnnotation"})
    public ListenableWorker(Context context, WorkerParameters workerParameters) {
        if (context == null) {
            throw new IllegalArgumentException("Application Context is null");
        }
        if (workerParameters == null) {
            throw new IllegalArgumentException("WorkerParameters is null");
        }
        this.a = context;
        this.c = workerParameters;
    }

    public final Context a() {
        return this.a;
    }

    public Executor c() {
        return this.c.a();
    }

    public y5.b d() {
        c t = c.t();
        t.q(new IllegalStateException("Expedited WorkRequests require a ListenableWorker to provide an implementation for `getForegroundInfoAsync()`"));
        return t;
    }

    public final UUID e() {
        return this.c.c();
    }

    public final b g() {
        return this.c.d();
    }

    public c1.a h() {
        return this.c.e();
    }

    public w i() {
        return this.c.f();
    }

    public boolean j() {
        return this.f;
    }

    public final boolean k() {
        return this.d;
    }

    public final boolean l() {
        return this.e;
    }

    public void m() {
    }

    public void n(boolean z) {
        this.f = z;
    }

    public final void o() {
        this.e = true;
    }

    public abstract y5.b p();

    public final void q() {
        this.d = true;
        m();
    }
}

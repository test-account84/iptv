package Q0;

import android.os.Build;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class v {
    public UUID a;
    public Z0.p b;
    public Set c;

    public static abstract class a {
        public Z0.p c;
        public Class e;
        public boolean a = false;
        public Set d = new HashSet();
        public UUID b = UUID.randomUUID();

        public a(Class cls) {
            this.e = cls;
            this.c = new Z0.p(this.b.toString(), cls.getName());
            a(cls.getName());
        }

        public final a a(String str) {
            this.d.add(str);
            return d();
        }

        public final v b() {
            v c = c();
            b bVar = this.c.j;
            int i = Build.VERSION.SDK_INT;
            boolean z = (i >= 24 && bVar.e()) || bVar.f() || bVar.g() || (i >= 23 && bVar.h());
            if (this.c.q && z) {
                throw new IllegalArgumentException("Expedited jobs only support network and storage constraints");
            }
            this.b = UUID.randomUUID();
            Z0.p pVar = new Z0.p(this.c);
            this.c = pVar;
            pVar.a = this.b.toString();
            return c;
        }

        public abstract v c();

        public abstract a d();

        public final a e(b bVar) {
            this.c.j = bVar;
            return d();
        }

        public a f(long j, TimeUnit timeUnit) {
            this.c.g = timeUnit.toMillis(j);
            if (Long.MAX_VALUE - System.currentTimeMillis() > this.c.g) {
                return d();
            }
            throw new IllegalArgumentException("The given initial delay is too large and will cause an overflow!");
        }

        public final a g(androidx.work.b bVar) {
            this.c.e = bVar;
            return d();
        }
    }

    public v(UUID uuid, Z0.p pVar, Set set) {
        this.a = uuid;
        this.b = pVar;
        this.c = set;
    }

    public String a() {
        return this.a.toString();
    }

    public Set b() {
        return this.c;
    }

    public Z0.p c() {
        return this.b;
    }
}

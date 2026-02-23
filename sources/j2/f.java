package J2;

import J2.c;
import android.app.job.JobInfo;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class f {

    public static class a {
        public M2.a a;
        public Map b = new HashMap();

        public a a(z2.d dVar, b bVar) {
            this.b.put(dVar, bVar);
            return this;
        }

        public f b() {
            if (this.a == null) {
                throw new NullPointerException("missing required property: clock");
            }
            if (this.b.keySet().size() < z2.d.values().length) {
                throw new IllegalStateException("Not all priorities have been configured");
            }
            Map map = this.b;
            this.b = new HashMap();
            return f.d(this.a, map);
        }

        public a c(M2.a aVar) {
            this.a = aVar;
            return this;
        }
    }

    public static abstract class b {

        public static abstract class a {
            public abstract b a();

            public abstract a b(long j);

            public abstract a c(Set set);

            public abstract a d(long j);
        }

        public static a a() {
            return new c.b().c(Collections.emptySet());
        }

        public abstract long b();

        public abstract Set c();

        public abstract long d();
    }

    public enum c {
        NETWORK_UNMETERED,
        DEVICE_IDLE,
        DEVICE_CHARGING
    }

    public static a b() {
        return new a();
    }

    public static f d(M2.a aVar, Map map) {
        return new J2.b(aVar, map);
    }

    public static f f(M2.a aVar) {
        return b().a(z2.d.DEFAULT, b.a().b(30000L).d(86400000L).a()).a(z2.d.HIGHEST, b.a().b(1000L).d(86400000L).a()).a(z2.d.VERY_LOW, b.a().b(86400000L).d(86400000L).c(i(c.DEVICE_IDLE)).a()).c(aVar).b();
    }

    public static Set i(Object... objArr) {
        return Collections.unmodifiableSet(new HashSet(Arrays.asList(objArr)));
    }

    public final long a(int i, long j) {
        return (long) (Math.pow(3.0d, i - 1) * j * Math.max(1.0d, Math.log(10000.0d) / Math.log((j > 1 ? j : 2L) * r7)));
    }

    public JobInfo.Builder c(JobInfo.Builder builder, z2.d dVar, long j, int i) {
        builder.setMinimumLatency(g(dVar, j, i));
        j(builder, ((b) h().get(dVar)).c());
        return builder;
    }

    public abstract M2.a e();

    public long g(z2.d dVar, long j, int i) {
        long a2 = j - e().a();
        b bVar = (b) h().get(dVar);
        return Math.min(Math.max(a(i, bVar.b()), a2), bVar.d());
    }

    public abstract Map h();

    public final void j(JobInfo.Builder builder, Set set) {
        if (set.contains(c.NETWORK_UNMETERED)) {
            builder.setRequiredNetworkType(2);
        } else {
            builder.setRequiredNetworkType(1);
        }
        if (set.contains(c.DEVICE_CHARGING)) {
            builder.setRequiresCharging(true);
        }
        if (set.contains(c.DEVICE_IDLE)) {
            builder.setRequiresDeviceIdle(true);
        }
    }
}

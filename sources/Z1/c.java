package z1;

import java.util.Map;
import v1.f;
import v1.t;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class c {
    public static final c DEFAULT = new a();
    public static final b QUERY_ROOT_KEY = b.a("QUERY_ROOT");
    public static final b MUTATION_ROOT_KEY = b.a("MUTATION_ROOT");
    public static final b SUBSCRIPTION_ROOT_KEY = b.a("SUBSCRIPTION_ROOT");

    public static class a extends c {
        public b fromFieldArguments(v1.k kVar, f.b bVar) {
            return b.b;
        }

        public b fromFieldRecordSet(v1.k kVar, Map map) {
            return b.b;
        }
    }

    public static b rootKeyForOperation(v1.f fVar) {
        if (fVar instanceof v1.h) {
            return QUERY_ROOT_KEY;
        }
        if (fVar instanceof v1.e) {
            return MUTATION_ROOT_KEY;
        }
        if (fVar instanceof t) {
            return SUBSCRIPTION_ROOT_KEY;
        }
        throw new IllegalArgumentException("Unknown operation type.");
    }

    public abstract b fromFieldArguments(v1.k kVar, f.b bVar);

    public abstract b fromFieldRecordSet(v1.k kVar, Map map);
}

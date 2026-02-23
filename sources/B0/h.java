package b0;

import Y.k;
import a0.f;
import a0.h;
import androidx.datastore.preferences.protobuf.w;
import b0.d;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;
import java.util.Set;
import k8.q;
import kotlin.jvm.internal.l;
import l8.s;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class h implements k {
    public static final h a = new h();
    public static final String b = "preferences_pb";

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[h.b.values().length];
            iArr[h.b.BOOLEAN.ordinal()] = 1;
            iArr[h.b.FLOAT.ordinal()] = 2;
            iArr[h.b.DOUBLE.ordinal()] = 3;
            iArr[h.b.INTEGER.ordinal()] = 4;
            iArr[h.b.LONG.ordinal()] = 5;
            iArr[h.b.STRING.ordinal()] = 6;
            iArr[h.b.STRING_SET.ordinal()] = 7;
            iArr[h.b.VALUE_NOT_SET.ordinal()] = 8;
            a = iArr;
        }
    }

    public Object c(InputStream inputStream, o8.d dVar) {
        a0.f a2 = a0.d.a.a(inputStream);
        b0.a b2 = e.b(new d.b[0]);
        Map K = a2.K();
        l.d(K, "preferencesProto.preferencesMap");
        for (Map.Entry entry : K.entrySet()) {
            String str = (String) entry.getKey();
            a0.h hVar = (a0.h) entry.getValue();
            h hVar2 = a;
            l.d(str, "name");
            l.d(hVar, "value");
            hVar2.d(str, hVar, b2);
        }
        return b2.d();
    }

    public final void d(String str, a0.h hVar, b0.a aVar) {
        d.a a2;
        Set valueOf;
        h.b X = hVar.X();
        switch (X == null ? -1 : a.a[X.ordinal()]) {
            case -1:
                throw new Y.a("Value case is null.", null, 2, null);
            case 0:
            default:
                throw new k8.h();
            case 1:
                a2 = f.a(str);
                valueOf = Boolean.valueOf(hVar.P());
                break;
            case 2:
                a2 = f.c(str);
                valueOf = Float.valueOf(hVar.S());
                break;
            case 3:
                a2 = f.b(str);
                valueOf = Double.valueOf(hVar.R());
                break;
            case 4:
                a2 = f.d(str);
                valueOf = Integer.valueOf(hVar.T());
                break;
            case 5:
                a2 = f.e(str);
                valueOf = Long.valueOf(hVar.U());
                break;
            case 6:
                a2 = f.f(str);
                valueOf = hVar.V();
                l.d(valueOf, "value.string");
                break;
            case 7:
                a2 = f.g(str);
                Iterable M = hVar.W().M();
                l.d(M, "value.stringSet.stringsList");
                valueOf = s.O(M);
                break;
            case 8:
                throw new Y.a("Value not set.", null, 2, null);
        }
        aVar.i(a2, valueOf);
    }

    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public d a() {
        return e.a();
    }

    public final String f() {
        return b;
    }

    public final a0.h g(Object obj) {
        w l;
        String str;
        if (obj instanceof Boolean) {
            l = a0.h.Y().u(((Boolean) obj).booleanValue()).l();
            str = "newBuilder().setBoolean(value).build()";
        } else if (obj instanceof Float) {
            l = a0.h.Y().w(((Number) obj).floatValue()).l();
            str = "newBuilder().setFloat(value).build()";
        } else if (obj instanceof Double) {
            l = a0.h.Y().v(((Number) obj).doubleValue()).l();
            str = "newBuilder().setDouble(value).build()";
        } else if (obj instanceof Integer) {
            l = a0.h.Y().x(((Number) obj).intValue()).l();
            str = "newBuilder().setInteger(value).build()";
        } else if (obj instanceof Long) {
            l = a0.h.Y().y(((Number) obj).longValue()).l();
            str = "newBuilder().setLong(value).build()";
        } else if (obj instanceof String) {
            l = a0.h.Y().z((String) obj).l();
            str = "newBuilder().setString(value).build()";
        } else {
            if (!(obj instanceof Set)) {
                throw new IllegalStateException(l.l("PreferencesSerializer does not support type: ", obj.getClass().getName()));
            }
            l = a0.h.Y().A(a0.g.N().u((Iterable) ((Set) obj))).l();
            str = "newBuilder().setStringSet(\n                    StringSet.newBuilder().addAllStrings(value as Set<String>)\n                ).build()";
        }
        l.d(l, str);
        return (a0.h) l;
    }

    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public Object b(d dVar, OutputStream outputStream, o8.d dVar2) {
        Map a2 = dVar.a();
        f.a N = a0.f.N();
        for (Map.Entry entry : a2.entrySet()) {
            N.u(((d.a) entry.getKey()).a(), g(entry.getValue()));
        }
        ((a0.f) N.l()).l(outputStream);
        return q.a;
    }
}

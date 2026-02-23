package androidx.navigation;

import android.os.Bundle;
import android.os.Parcelable;
import java.io.Serializable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class q {
    public static final q b = new c(false);
    public static final q c = new d(false);
    public static final q d = new e(true);
    public static final q e = new f(false);
    public static final q f = new g(true);
    public static final q g = new h(false);
    public static final q h = new i(true);
    public static final q i = new j(false);
    public static final q j = new k(true);
    public static final q k = new a(true);
    public static final q l = new b(true);
    public final boolean a;

    public class a extends q {
        public a(boolean z) {
            super(z);
        }

        public String c() {
            return "string";
        }

        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public String b(Bundle bundle, String str) {
            return (String) bundle.get(str);
        }

        /* renamed from: k, reason: merged with bridge method [inline-methods] */
        public String h(String str) {
            return str;
        }

        /* renamed from: l, reason: merged with bridge method [inline-methods] */
        public void i(Bundle bundle, String str, String str2) {
            bundle.putString(str, str2);
        }
    }

    public class b extends q {
        public b(boolean z) {
            super(z);
        }

        public String c() {
            return "string[]";
        }

        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public String[] b(Bundle bundle, String str) {
            return (String[]) bundle.get(str);
        }

        /* renamed from: k, reason: merged with bridge method [inline-methods] */
        public String[] h(String str) {
            throw new UnsupportedOperationException("Arrays don't support default values.");
        }

        /* renamed from: l, reason: merged with bridge method [inline-methods] */
        public void i(Bundle bundle, String str, String[] strArr) {
            bundle.putStringArray(str, strArr);
        }
    }

    public class c extends q {
        public c(boolean z) {
            super(z);
        }

        public String c() {
            return "integer";
        }

        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public Integer b(Bundle bundle, String str) {
            return (Integer) bundle.get(str);
        }

        /* renamed from: k, reason: merged with bridge method [inline-methods] */
        public Integer h(String str) {
            return Integer.valueOf(str.startsWith("0x") ? Integer.parseInt(str.substring(2), 16) : Integer.parseInt(str));
        }

        /* renamed from: l, reason: merged with bridge method [inline-methods] */
        public void i(Bundle bundle, String str, Integer num) {
            bundle.putInt(str, num.intValue());
        }
    }

    public class d extends q {
        public d(boolean z) {
            super(z);
        }

        public String c() {
            return "reference";
        }

        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public Integer b(Bundle bundle, String str) {
            return (Integer) bundle.get(str);
        }

        /* renamed from: k, reason: merged with bridge method [inline-methods] */
        public Integer h(String str) {
            return Integer.valueOf(str.startsWith("0x") ? Integer.parseInt(str.substring(2), 16) : Integer.parseInt(str));
        }

        /* renamed from: l, reason: merged with bridge method [inline-methods] */
        public void i(Bundle bundle, String str, Integer num) {
            bundle.putInt(str, num.intValue());
        }
    }

    public class e extends q {
        public e(boolean z) {
            super(z);
        }

        public String c() {
            return "integer[]";
        }

        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public int[] b(Bundle bundle, String str) {
            return (int[]) bundle.get(str);
        }

        /* renamed from: k, reason: merged with bridge method [inline-methods] */
        public int[] h(String str) {
            throw new UnsupportedOperationException("Arrays don't support default values.");
        }

        /* renamed from: l, reason: merged with bridge method [inline-methods] */
        public void i(Bundle bundle, String str, int[] iArr) {
            bundle.putIntArray(str, iArr);
        }
    }

    public class f extends q {
        public f(boolean z) {
            super(z);
        }

        public String c() {
            return "long";
        }

        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public Long b(Bundle bundle, String str) {
            return (Long) bundle.get(str);
        }

        /* renamed from: k, reason: merged with bridge method [inline-methods] */
        public Long h(String str) {
            if (str.endsWith("L")) {
                str = str.substring(0, str.length() - 1);
            }
            return Long.valueOf(str.startsWith("0x") ? Long.parseLong(str.substring(2), 16) : Long.parseLong(str));
        }

        /* renamed from: l, reason: merged with bridge method [inline-methods] */
        public void i(Bundle bundle, String str, Long l) {
            bundle.putLong(str, l.longValue());
        }
    }

    public class g extends q {
        public g(boolean z) {
            super(z);
        }

        public String c() {
            return "long[]";
        }

        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public long[] b(Bundle bundle, String str) {
            return (long[]) bundle.get(str);
        }

        /* renamed from: k, reason: merged with bridge method [inline-methods] */
        public long[] h(String str) {
            throw new UnsupportedOperationException("Arrays don't support default values.");
        }

        /* renamed from: l, reason: merged with bridge method [inline-methods] */
        public void i(Bundle bundle, String str, long[] jArr) {
            bundle.putLongArray(str, jArr);
        }
    }

    public class h extends q {
        public h(boolean z) {
            super(z);
        }

        public String c() {
            return "float";
        }

        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public Float b(Bundle bundle, String str) {
            return (Float) bundle.get(str);
        }

        /* renamed from: k, reason: merged with bridge method [inline-methods] */
        public Float h(String str) {
            return Float.valueOf(Float.parseFloat(str));
        }

        /* renamed from: l, reason: merged with bridge method [inline-methods] */
        public void i(Bundle bundle, String str, Float f) {
            bundle.putFloat(str, f.floatValue());
        }
    }

    public class i extends q {
        public i(boolean z) {
            super(z);
        }

        public String c() {
            return "float[]";
        }

        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public float[] b(Bundle bundle, String str) {
            return (float[]) bundle.get(str);
        }

        /* renamed from: k, reason: merged with bridge method [inline-methods] */
        public float[] h(String str) {
            throw new UnsupportedOperationException("Arrays don't support default values.");
        }

        /* renamed from: l, reason: merged with bridge method [inline-methods] */
        public void i(Bundle bundle, String str, float[] fArr) {
            bundle.putFloatArray(str, fArr);
        }
    }

    public class j extends q {
        public j(boolean z) {
            super(z);
        }

        public String c() {
            return "boolean";
        }

        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public Boolean b(Bundle bundle, String str) {
            return (Boolean) bundle.get(str);
        }

        /* renamed from: k, reason: merged with bridge method [inline-methods] */
        public Boolean h(String str) {
            if ("true".equals(str)) {
                return Boolean.TRUE;
            }
            if ("false".equals(str)) {
                return Boolean.FALSE;
            }
            throw new IllegalArgumentException("A boolean NavType only accepts \"true\" or \"false\" values.");
        }

        /* renamed from: l, reason: merged with bridge method [inline-methods] */
        public void i(Bundle bundle, String str, Boolean bool) {
            bundle.putBoolean(str, bool.booleanValue());
        }
    }

    public class k extends q {
        public k(boolean z) {
            super(z);
        }

        public String c() {
            return "boolean[]";
        }

        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public boolean[] b(Bundle bundle, String str) {
            return (boolean[]) bundle.get(str);
        }

        /* renamed from: k, reason: merged with bridge method [inline-methods] */
        public boolean[] h(String str) {
            throw new UnsupportedOperationException("Arrays don't support default values.");
        }

        /* renamed from: l, reason: merged with bridge method [inline-methods] */
        public void i(Bundle bundle, String str, boolean[] zArr) {
            bundle.putBooleanArray(str, zArr);
        }
    }

    public static final class l extends p {
        public final Class n;

        public l(Class cls) {
            super(false, cls);
            if (cls.isEnum()) {
                this.n = cls;
                return;
            }
            throw new IllegalArgumentException(cls + " is not an Enum type.");
        }

        public String c() {
            return this.n.getName();
        }

        /* renamed from: m, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public Enum k(String str) {
            for (Enum r3 : (Enum[]) this.n.getEnumConstants()) {
                if (r3.name().equals(str)) {
                    return r3;
                }
            }
            throw new IllegalArgumentException("Enum value " + str + " not found for type " + this.n.getName() + ".");
        }
    }

    public static final class m extends q {
        public final Class m;

        public m(Class cls) {
            super(true);
            if (!Parcelable.class.isAssignableFrom(cls)) {
                throw new IllegalArgumentException(cls + " does not implement Parcelable.");
            }
            try {
                this.m = Class.forName("[L" + cls.getName() + ";");
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }

        public String c() {
            return this.m.getName();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || m.class != obj.getClass()) {
                return false;
            }
            return this.m.equals(((m) obj).m);
        }

        public int hashCode() {
            return this.m.hashCode();
        }

        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public Parcelable[] b(Bundle bundle, String str) {
            return (Parcelable[]) bundle.get(str);
        }

        /* renamed from: k, reason: merged with bridge method [inline-methods] */
        public Parcelable[] h(String str) {
            throw new UnsupportedOperationException("Arrays don't support default values.");
        }

        /* renamed from: l, reason: merged with bridge method [inline-methods] */
        public void i(Bundle bundle, String str, Parcelable[] parcelableArr) {
            this.m.cast(parcelableArr);
            bundle.putParcelableArray(str, parcelableArr);
        }
    }

    public static final class n extends q {
        public final Class m;

        public n(Class cls) {
            super(true);
            if (Parcelable.class.isAssignableFrom(cls) || Serializable.class.isAssignableFrom(cls)) {
                this.m = cls;
                return;
            }
            throw new IllegalArgumentException(cls + " does not implement Parcelable or Serializable.");
        }

        public Object b(Bundle bundle, String str) {
            return bundle.get(str);
        }

        public String c() {
            return this.m.getName();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || n.class != obj.getClass()) {
                return false;
            }
            return this.m.equals(((n) obj).m);
        }

        public Object h(String str) {
            throw new UnsupportedOperationException("Parcelables don't support default values.");
        }

        public int hashCode() {
            return this.m.hashCode();
        }

        public void i(Bundle bundle, String str, Object obj) {
            this.m.cast(obj);
            if (obj == null || (obj instanceof Parcelable)) {
                bundle.putParcelable(str, (Parcelable) obj);
            } else if (obj instanceof Serializable) {
                bundle.putSerializable(str, (Serializable) obj);
            }
        }
    }

    public static final class o extends q {
        public final Class m;

        public o(Class cls) {
            super(true);
            if (!Serializable.class.isAssignableFrom(cls)) {
                throw new IllegalArgumentException(cls + " does not implement Serializable.");
            }
            try {
                this.m = Class.forName("[L" + cls.getName() + ";");
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }

        public String c() {
            return this.m.getName();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || o.class != obj.getClass()) {
                return false;
            }
            return this.m.equals(((o) obj).m);
        }

        public int hashCode() {
            return this.m.hashCode();
        }

        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public Serializable[] b(Bundle bundle, String str) {
            return (Serializable[]) bundle.get(str);
        }

        /* renamed from: k, reason: merged with bridge method [inline-methods] */
        public Serializable[] h(String str) {
            throw new UnsupportedOperationException("Arrays don't support default values.");
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* renamed from: l, reason: merged with bridge method [inline-methods] */
        public void i(Bundle bundle, String str, Serializable[] serializableArr) {
            this.m.cast(serializableArr);
            bundle.putSerializable(str, serializableArr);
        }
    }

    public static class p extends q {
        public final Class m;

        public p(Class cls) {
            super(true);
            if (!Serializable.class.isAssignableFrom(cls)) {
                throw new IllegalArgumentException(cls + " does not implement Serializable.");
            }
            if (!cls.isEnum()) {
                this.m = cls;
                return;
            }
            throw new IllegalArgumentException(cls + " is an Enum. You should use EnumType instead.");
        }

        public String c() {
            return this.m.getName();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof p) {
                return this.m.equals(((p) obj).m);
            }
            return false;
        }

        public int hashCode() {
            return this.m.hashCode();
        }

        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public Serializable b(Bundle bundle, String str) {
            return (Serializable) bundle.get(str);
        }

        /* renamed from: k, reason: merged with bridge method [inline-methods] */
        public Serializable h(String str) {
            throw new UnsupportedOperationException("Serializables don't support default values.");
        }

        /* renamed from: l, reason: merged with bridge method [inline-methods] */
        public void i(Bundle bundle, String str, Serializable serializable) {
            this.m.cast(serializable);
            bundle.putSerializable(str, serializable);
        }

        public p(boolean z, Class cls) {
            super(z);
            if (Serializable.class.isAssignableFrom(cls)) {
                this.m = cls;
                return;
            }
            throw new IllegalArgumentException(cls + " does not implement Serializable.");
        }
    }

    public q(boolean z) {
        this.a = z;
    }

    public static q a(String str, String str2) {
        String str3;
        q qVar = b;
        if (qVar.c().equals(str)) {
            return qVar;
        }
        q qVar2 = d;
        if (qVar2.c().equals(str)) {
            return qVar2;
        }
        q qVar3 = e;
        if (qVar3.c().equals(str)) {
            return qVar3;
        }
        q qVar4 = f;
        if (qVar4.c().equals(str)) {
            return qVar4;
        }
        q qVar5 = i;
        if (qVar5.c().equals(str)) {
            return qVar5;
        }
        q qVar6 = j;
        if (qVar6.c().equals(str)) {
            return qVar6;
        }
        q qVar7 = k;
        if (qVar7.c().equals(str)) {
            return qVar7;
        }
        q qVar8 = l;
        if (qVar8.c().equals(str)) {
            return qVar8;
        }
        q qVar9 = g;
        if (qVar9.c().equals(str)) {
            return qVar9;
        }
        q qVar10 = h;
        if (qVar10.c().equals(str)) {
            return qVar10;
        }
        q qVar11 = c;
        if (qVar11.c().equals(str)) {
            return qVar11;
        }
        if (str == null || str.isEmpty()) {
            return qVar7;
        }
        try {
            if (!str.startsWith(".") || str2 == null) {
                str3 = str;
            } else {
                str3 = str2 + str;
            }
            if (str.endsWith("[]")) {
                str3 = str3.substring(0, str3.length() - 2);
                Class cls = Class.forName(str3);
                if (Parcelable.class.isAssignableFrom(cls)) {
                    return new m(cls);
                }
                if (Serializable.class.isAssignableFrom(cls)) {
                    return new o(cls);
                }
            } else {
                Class cls2 = Class.forName(str3);
                if (Parcelable.class.isAssignableFrom(cls2)) {
                    return new n(cls2);
                }
                if (Enum.class.isAssignableFrom(cls2)) {
                    return new l(cls2);
                }
                if (Serializable.class.isAssignableFrom(cls2)) {
                    return new p(cls2);
                }
            }
            throw new IllegalArgumentException(str3 + " is not Serializable or Parcelable.");
        } catch (ClassNotFoundException e2) {
            throw new RuntimeException(e2);
        }
    }

    public static q d(String str) {
        try {
            try {
                try {
                    try {
                        q qVar = b;
                        qVar.h(str);
                        return qVar;
                    } catch (IllegalArgumentException unused) {
                        q qVar2 = i;
                        qVar2.h(str);
                        return qVar2;
                    }
                } catch (IllegalArgumentException unused2) {
                    q qVar3 = g;
                    qVar3.h(str);
                    return qVar3;
                }
            } catch (IllegalArgumentException unused3) {
                q qVar4 = e;
                qVar4.h(str);
                return qVar4;
            }
        } catch (IllegalArgumentException unused4) {
            return k;
        }
    }

    public static q e(Object obj) {
        if (obj instanceof Integer) {
            return b;
        }
        if (obj instanceof int[]) {
            return d;
        }
        if (obj instanceof Long) {
            return e;
        }
        if (obj instanceof long[]) {
            return f;
        }
        if (obj instanceof Float) {
            return g;
        }
        if (obj instanceof float[]) {
            return h;
        }
        if (obj instanceof Boolean) {
            return i;
        }
        if (obj instanceof boolean[]) {
            return j;
        }
        if ((obj instanceof String) || obj == null) {
            return k;
        }
        if (obj instanceof String[]) {
            return l;
        }
        if (obj.getClass().isArray() && Parcelable.class.isAssignableFrom(obj.getClass().getComponentType())) {
            return new m(obj.getClass().getComponentType());
        }
        if (obj.getClass().isArray() && Serializable.class.isAssignableFrom(obj.getClass().getComponentType())) {
            return new o(obj.getClass().getComponentType());
        }
        if (obj instanceof Parcelable) {
            return new n(obj.getClass());
        }
        if (obj instanceof Enum) {
            return new l(obj.getClass());
        }
        if (obj instanceof Serializable) {
            return new p(obj.getClass());
        }
        throw new IllegalArgumentException("Object of type " + obj.getClass().getName() + " is not supported for navigation arguments.");
    }

    public abstract Object b(Bundle bundle, String str);

    public abstract String c();

    public boolean f() {
        return this.a;
    }

    public Object g(Bundle bundle, String str, String str2) {
        Object h2 = h(str2);
        i(bundle, str, h2);
        return h2;
    }

    public abstract Object h(String str);

    public abstract void i(Bundle bundle, String str, Object obj);

    public String toString() {
        return c();
    }
}

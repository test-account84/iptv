package com.nytimes.android.external.cache;

import java.util.Arrays;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public abstract class l {

    public static final class b {
        public final String a;
        public a b;
        public a c;
        public boolean d;

        public static final class a {
            public String a;
            public Object b;
            public a c;

            public a() {
            }

            public /* synthetic */ a(a aVar) {
                this();
            }
        }

        public b(String str) {
            a aVar = new a(null);
            this.b = aVar;
            this.c = aVar;
            this.d = false;
            this.a = (String) o.a(str);
        }

        public b a(String str, int i) {
            return f(str, String.valueOf(i));
        }

        public b b(String str, long j) {
            return f(str, String.valueOf(j));
        }

        public b c(String str, Object obj) {
            return f(str, obj);
        }

        public final a d() {
            a aVar = new a(null);
            this.c.c = aVar;
            this.c = aVar;
            return aVar;
        }

        public final b e(Object obj) {
            d().b = obj;
            return this;
        }

        public final b f(String str, Object obj) {
            a d = d();
            d.b = obj;
            d.a = (String) o.a(str);
            return this;
        }

        public b g(Object obj) {
            return e(obj);
        }

        public String toString() {
            boolean z = this.d;
            StringBuilder sb = new StringBuilder(32);
            sb.append(this.a);
            sb.append('{');
            String str = "";
            for (a aVar = this.b.c; aVar != null; aVar = aVar.c) {
                Object obj = aVar.b;
                if (!z || obj != null) {
                    sb.append(str);
                    String str2 = aVar.a;
                    if (str2 != null) {
                        sb.append(str2);
                        sb.append('=');
                    }
                    if (obj == null || !obj.getClass().isArray()) {
                        sb.append(obj);
                    } else {
                        String deepToString = Arrays.deepToString(new Object[]{obj});
                        sb.append(deepToString.substring(1, deepToString.length() - 1));
                    }
                    str = ", ";
                }
            }
            sb.append('}');
            return sb.toString();
        }

        public /* synthetic */ b(String str, a aVar) {
            this(str);
        }
    }

    public static Object a(Object obj, Object obj2) {
        return obj != null ? obj : o.a(obj2);
    }

    public static b b(Object obj) {
        return new b(obj.getClass().getSimpleName(), null);
    }
}

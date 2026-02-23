package com.google.android.exoplayer2.extractor;

import d3.u;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public interface g {

    public static final class a {
        public final u a;
        public final u b;

        public a(u uVar) {
            this(uVar, uVar);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || a.class != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            return this.a.equals(aVar.a) && this.b.equals(aVar.b);
        }

        public int hashCode() {
            return (this.a.hashCode() * 31) + this.b.hashCode();
        }

        public String toString() {
            String str;
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            sb.append(this.a);
            if (this.a.equals(this.b)) {
                str = "";
            } else {
                str = ", " + this.b;
            }
            sb.append(str);
            sb.append("]");
            return sb.toString();
        }

        public a(u uVar, u uVar2) {
            this.a = (u) d4.a.e(uVar);
            this.b = (u) d4.a.e(uVar2);
        }
    }

    public static class b implements g {
        public final long a;
        public final a b;

        public b(long j) {
            this(j, 0L);
        }

        public a e(long j) {
            return this.b;
        }

        public boolean g() {
            return false;
        }

        public long i() {
            return this.a;
        }

        public b(long j, long j2) {
            this.a = j;
            this.b = new a(j2 == 0 ? u.c : new u(0L, j2));
        }
    }

    a e(long j);

    boolean g();

    long i();
}

package z2;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class a extends c {
    public final Integer a;
    public final Object b;
    public final d c;

    public a(Integer num, Object obj, d dVar) {
        this.a = num;
        if (obj == null) {
            throw new NullPointerException("Null payload");
        }
        this.b = obj;
        if (dVar == null) {
            throw new NullPointerException("Null priority");
        }
        this.c = dVar;
    }

    public Integer a() {
        return this.a;
    }

    public Object b() {
        return this.b;
    }

    public d c() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        Integer num = this.a;
        if (num != null ? num.equals(cVar.a()) : cVar.a() == null) {
            if (this.b.equals(cVar.b()) && this.c.equals(cVar.c())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        Integer num = this.a;
        return (((((num == null ? 0 : num.hashCode()) ^ 1000003) * 1000003) ^ this.b.hashCode()) * 1000003) ^ this.c.hashCode();
    }

    public String toString() {
        return "Event{code=" + this.a + ", payload=" + this.b + ", priority=" + this.c + "}";
    }
}

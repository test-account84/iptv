package j$.util;

import java.util.NoSuchElementException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
public final class Optional {
    private static final Optional b = new Optional();
    private final Object a;

    private Optional() {
        this.a = null;
    }

    private Optional(Object obj) {
        this.a = Objects.requireNonNull(obj);
    }

    public static Optional a() {
        return b;
    }

    public static Optional d(Object obj) {
        return new Optional(obj);
    }

    public static Optional ofNullable(Object obj) {
        return obj == null ? b : new Optional(obj);
    }

    public final Object b() {
        Object obj = this.a;
        if (obj != null) {
            return obj;
        }
        throw new NoSuchElementException("No value present");
    }

    public final boolean c() {
        return this.a != null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Optional) {
            return Objects.equals(this.a, ((Optional) obj).a);
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.a);
    }

    public final String toString() {
        Object obj = this.a;
        return obj != null ? String.format("Optional[%s]", new Object[]{obj}) : "Optional.empty";
    }
}

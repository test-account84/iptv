package com.google.ads.interactivemedia.v3.internal;

import java.math.BigInteger;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class bkd extends bjy {
    private final Object a;

    public bkd(Boolean bool) {
        this.a = bool;
    }

    private static boolean g(bkd bkdVar) {
        Object obj = bkdVar.a;
        if (!(obj instanceof Number)) {
            return false;
        }
        Number number = (Number) obj;
        return (number instanceof BigInteger) || (number instanceof Long) || (number instanceof Integer) || (number instanceof Short) || (number instanceof Byte);
    }

    public final Number a() {
        Object obj = this.a;
        if (obj instanceof Number) {
            return (Number) obj;
        }
        if (obj instanceof String) {
            return new blb((String) obj);
        }
        throw new UnsupportedOperationException("Primitive is neither a number nor a string");
    }

    public final String b() {
        Object obj = this.a;
        if (obj instanceof String) {
            return (String) obj;
        }
        if (e()) {
            return a().toString();
        }
        if (d()) {
            return ((Boolean) this.a).toString();
        }
        throw new AssertionError("Unexpected value type: ".concat(String.valueOf(this.a.getClass())));
    }

    public final boolean c() {
        return d() ? ((Boolean) this.a).booleanValue() : Boolean.parseBoolean(b());
    }

    public final boolean d() {
        return this.a instanceof Boolean;
    }

    public final boolean e() {
        return this.a instanceof Number;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || bkd.class != obj.getClass()) {
            return false;
        }
        bkd bkdVar = (bkd) obj;
        if (this.a == null) {
            return bkdVar.a == null;
        }
        if (g(this) && g(bkdVar)) {
            return a().longValue() == bkdVar.a().longValue();
        }
        Object obj2 = this.a;
        if (!(obj2 instanceof Number) || !(bkdVar.a instanceof Number)) {
            return obj2.equals(bkdVar.a);
        }
        double doubleValue = a().doubleValue();
        double doubleValue2 = bkdVar.a().doubleValue();
        if (doubleValue != doubleValue2) {
            return Double.isNaN(doubleValue) && Double.isNaN(doubleValue2);
        }
        return true;
    }

    public final boolean f() {
        return this.a instanceof String;
    }

    public final int hashCode() {
        long doubleToLongBits;
        if (this.a == null) {
            return 31;
        }
        if (g(this)) {
            doubleToLongBits = a().longValue();
        } else {
            Object obj = this.a;
            if (!(obj instanceof Number)) {
                return obj.hashCode();
            }
            doubleToLongBits = Double.doubleToLongBits(a().doubleValue());
        }
        return (int) ((doubleToLongBits >>> 32) ^ doubleToLongBits);
    }

    public bkd(Number number) {
        this.a = number;
    }

    public bkd(String str) {
        str.getClass();
        this.a = str;
    }
}

package org.simpleframework.xml.core;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
class Revision {
    private boolean equal = true;

    public boolean compare(Object obj, Object obj2) {
        boolean equals;
        if (obj2 == null) {
            if (obj != null) {
                equals = obj.equals(Double.valueOf(1.0d));
            }
            return this.equal;
        }
        equals = obj2.equals(obj);
        this.equal = equals;
        return this.equal;
    }

    public double getDefault() {
        return 1.0d;
    }

    public boolean isEqual() {
        return this.equal;
    }
}

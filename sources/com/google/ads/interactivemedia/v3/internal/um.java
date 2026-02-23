package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class um {
    public static final um a = new um(new bf[0]);
    public final int b;
    private final avo c;
    private int d;

    public um(bf... bfVarArr) {
        this.c = avo.n(bfVarArr);
        this.b = bfVarArr.length;
        int i = 0;
        while (i < this.c.size()) {
            int i2 = i + 1;
            for (int i3 = i2; i3 < this.c.size(); i3++) {
                if (((bf) this.c.get(i)).equals(this.c.get(i3))) {
                    cd.c("TrackGroupArray", "", new IllegalArgumentException("Multiple identical TrackGroups added to one TrackGroupArray."));
                }
            }
            i = i2;
        }
    }

    public final int a(bf bfVar) {
        int indexOf = this.c.indexOf(bfVar);
        if (indexOf >= 0) {
            return indexOf;
        }
        return -1;
    }

    public final bf b(int i) {
        return (bf) this.c.get(i);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && um.class == obj.getClass()) {
            um umVar = (um) obj;
            if (this.b == umVar.b && this.c.equals(umVar.c)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = this.d;
        if (i != 0) {
            return i;
        }
        int hashCode = this.c.hashCode();
        this.d = hashCode;
        return hashCode;
    }
}

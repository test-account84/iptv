package O5;

import O5.z;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class c extends z.a {
    public final String a;
    public final String b;

    public c(String str, String str2) {
        if (str == null) {
            throw new NullPointerException("Null crashlyticsInstallId");
        }
        this.a = str;
        this.b = str2;
    }

    public String c() {
        return this.a;
    }

    public String d() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof z.a)) {
            return false;
        }
        z.a aVar = (z.a) obj;
        if (this.a.equals(aVar.c())) {
            String str = this.b;
            String d = aVar.d();
            if (str == null) {
                if (d == null) {
                    return true;
                }
            } else if (str.equals(d)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int hashCode = (this.a.hashCode() ^ 1000003) * 1000003;
        String str = this.b;
        return hashCode ^ (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "InstallIds{crashlyticsInstallId=" + this.a + ", firebaseInstallationId=" + this.b + "}";
    }
}

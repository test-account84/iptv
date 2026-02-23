package G8;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class g0 implements s0 {
    public final boolean a;

    public g0(boolean z) {
        this.a = z;
    }

    public J0 c() {
        return null;
    }

    public boolean isActive() {
        return this.a;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Empty{");
        sb.append(isActive() ? "Active" : "New");
        sb.append('}');
        return sb.toString();
    }
}

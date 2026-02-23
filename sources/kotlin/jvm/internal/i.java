package kotlin.jvm.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public abstract class i extends c implements h, C8.e {
    public final int a;
    public final int c;

    public i(int i, Object obj, Class cls, String str, String str2, int i2) {
        super(obj, cls, str, str2, (i2 & 1) == 1);
        this.a = i;
        this.c = i2 >> 1;
    }

    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C8.e getReflected() {
        return (C8.e) super.getReflected();
    }

    public C8.b computeReflected() {
        return C.a(this);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof i) {
            i iVar = (i) obj;
            return getName().equals(iVar.getName()) && getSignature().equals(iVar.getSignature()) && this.c == iVar.c && this.a == iVar.a && l.a(getBoundReceiver(), iVar.getBoundReceiver()) && l.a(getOwner(), iVar.getOwner());
        }
        if (obj instanceof C8.e) {
            return obj.equals(compute());
        }
        return false;
    }

    public int getArity() {
        return this.a;
    }

    public int hashCode() {
        return (((getOwner() == null ? 0 : getOwner().hashCode() * 31) + getName().hashCode()) * 31) + getSignature().hashCode();
    }

    public boolean isSuspend() {
        return getReflected().isSuspend();
    }

    public String toString() {
        C8.b compute = compute();
        if (compute != this) {
            return compute.toString();
        }
        if ("<init>".equals(getName())) {
            return "constructor (Kotlin reflection is not available)";
        }
        return "function " + getName() + " (Kotlin reflection is not available)";
    }
}

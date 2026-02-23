package G8;

import java.util.concurrent.CancellationException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class y0 extends CancellationException {
    public final transient x0 a;

    public y0(String str, Throwable th, x0 x0Var) {
        super(str);
        this.a = x0Var;
        if (th != null) {
            initCause(th);
        }
    }

    public boolean equals(Object obj) {
        if (obj != this) {
            if (obj instanceof y0) {
                y0 y0Var = (y0) obj;
                if (!kotlin.jvm.internal.l.a(y0Var.getMessage(), getMessage()) || !kotlin.jvm.internal.l.a(y0Var.a, this.a) || !kotlin.jvm.internal.l.a(y0Var.getCause(), getCause())) {
                }
            }
            return false;
        }
        return true;
    }

    public Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }

    public int hashCode() {
        String message = getMessage();
        kotlin.jvm.internal.l.b(message);
        int hashCode = ((message.hashCode() * 31) + this.a.hashCode()) * 31;
        Throwable cause = getCause();
        return hashCode + (cause != null ? cause.hashCode() : 0);
    }

    public String toString() {
        return super.toString() + "; job=" + this.a;
    }
}

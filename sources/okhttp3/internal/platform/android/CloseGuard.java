package okhttp3.internal.platform.android;

import java.lang.reflect.Method;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.l;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class CloseGuard {
    public static final Companion Companion = new Companion(null);
    private final Method getMethod;
    private final Method openMethod;
    private final Method warnIfOpenMethod;

    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final CloseGuard get() {
            Method method;
            Method method2;
            Method method3 = null;
            try {
                Class cls = Class.forName("dalvik.system.CloseGuard");
                Method method4 = cls.getMethod("get", (Class[]) null);
                method2 = cls.getMethod("open", new Class[]{String.class});
                method = cls.getMethod("warnIfOpen", (Class[]) null);
                method3 = method4;
            } catch (Exception unused) {
                method = null;
                method2 = null;
            }
            return new CloseGuard(method3, method2, method);
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }
    }

    public CloseGuard(@Nullable Method method, @Nullable Method method2, @Nullable Method method3) {
        this.getMethod = method;
        this.openMethod = method2;
        this.warnIfOpenMethod = method3;
    }

    @Nullable
    public final Object createAndOpen(@NotNull String closer) {
        l.e(closer, "closer");
        Method method = this.getMethod;
        if (method != null) {
            try {
                Object invoke = method.invoke((Object) null, (Object[]) null);
                Method method2 = this.openMethod;
                l.b(method2);
                method2.invoke(invoke, new Object[]{closer});
                return invoke;
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public final boolean warnIfOpen(@Nullable Object obj) {
        if (obj != null) {
            try {
                Method method = this.warnIfOpenMethod;
                l.b(method);
                method.invoke(obj, (Object[]) null);
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }
}

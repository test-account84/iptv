package okio;

import E8.c;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.l;
import org.jetbrains.annotations.NotNull;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class -Platform {
    @NotNull
    public static final byte[] asUtf8ToByteArray(@NotNull String asUtf8ToByteArray) {
        l.e(asUtf8ToByteArray, "$this$asUtf8ToByteArray");
        byte[] bytes = asUtf8ToByteArray.getBytes(c.b);
        l.d(bytes, "(this as java.lang.String).getBytes(charset)");
        return bytes;
    }

    public static final Object synchronized(@NotNull Object lock, @NotNull w8.a block) {
        Object invoke;
        l.e(lock, "lock");
        l.e(block, "block");
        synchronized (lock) {
            try {
                invoke = block.invoke();
                k.b(1);
            } catch (Throwable th) {
                k.b(1);
                k.a(1);
                throw th;
            }
        }
        k.a(1);
        return invoke;
    }

    @NotNull
    public static final String toUtf8String(@NotNull byte[] toUtf8String) {
        l.e(toUtf8String, "$this$toUtf8String");
        return new String(toUtf8String, c.b);
    }
}

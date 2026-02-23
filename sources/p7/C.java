package P7;

import E8.n;
import kotlin.jvm.internal.g;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public enum c {
    DIRECT,
    INDIRECT,
    UNATTRIBUTED,
    DISABLED;


    @NotNull
    public static final a Companion = new a(null);

    public static final class a {
        public a() {
        }

        public final c a(String str) {
            c cVar = null;
            if (str != null) {
                c[] values = c.values();
                int length = values.length;
                while (true) {
                    length--;
                    if (length < 0) {
                        break;
                    }
                    c cVar2 = values[length];
                    if (n.o(cVar2.name(), str, true)) {
                        cVar = cVar2;
                        break;
                    }
                }
            }
            return cVar == null ? c.UNATTRIBUTED : cVar;
        }

        public /* synthetic */ a(g gVar) {
            this();
        }
    }

    @NotNull
    public static final c fromString(@Nullable String str) {
        return Companion.a(str);
    }

    public final boolean isAttributed() {
        return isDirect() || isIndirect();
    }

    public final boolean isDirect() {
        return this == DIRECT;
    }

    public final boolean isDisabled() {
        return this == DISABLED;
    }

    public final boolean isIndirect() {
        return this == INDIRECT;
    }

    public final boolean isUnattributed() {
        return this == UNATTRIBUTED;
    }
}

package P7;

import kotlin.jvm.internal.g;
import kotlin.jvm.internal.l;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public enum b {
    IAM("iam"),
    NOTIFICATION("notification");


    @NotNull
    public static final a Companion = new a(null);

    @NotNull
    private final String nameValue;

    public static final class a {
        public a() {
        }

        public final b a(String str) {
            b bVar = null;
            if (str != null) {
                b[] values = b.values();
                int length = values.length;
                while (true) {
                    length--;
                    if (length < 0) {
                        break;
                    }
                    b bVar2 = values[length];
                    if (bVar2.equalsName(str)) {
                        bVar = bVar2;
                        break;
                    }
                }
            }
            return bVar == null ? b.NOTIFICATION : bVar;
        }

        public /* synthetic */ a(g gVar) {
            this();
        }
    }

    b(String str) {
        this.nameValue = str;
    }

    @NotNull
    public static final b fromString(@Nullable String str) {
        return Companion.a(str);
    }

    public final boolean equalsName(@NotNull String otherName) {
        l.e(otherName, "otherName");
        return l.a(this.nameValue, otherName);
    }

    @NotNull
    public String toString() {
        return this.nameValue;
    }
}

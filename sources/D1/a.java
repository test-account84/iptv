package d1;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public enum a {
    START,
    CENTER,
    END;

    private static final boolean HAS_RTL = true;

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[a.values().length];
            a = iArr;
            try {
                iArr[a.START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[a.CENTER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[a.END.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    @SuppressLint({"RtlHardcoded"})
    public int getGravityInt() {
        int i = a.a[ordinal()];
        if (i == 1) {
            return HAS_RTL ? 8388611 : 3;
        }
        if (i == 2) {
            return 1;
        }
        if (i == 3) {
            return HAS_RTL ? 8388613 : 5;
        }
        throw new IllegalStateException("Invalid gravity constant");
    }

    @TargetApi(17)
    public int getTextAlignment() {
        int i = a.a[ordinal()];
        if (i != 2) {
            return i != 3 ? 5 : 6;
        }
        return 4;
    }
}

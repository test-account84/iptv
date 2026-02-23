package j$.util;

import java.util.Arrays;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
public final class StringJoiner {
    private final String a;
    private final String b;
    private final String c;
    private String[] d;
    private int e;
    private int f;

    public StringJoiner(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3) {
        Objects.a(charSequence2, "The prefix must not be null");
        Objects.a(charSequence, "The delimiter must not be null");
        Objects.a(charSequence3, "The suffix must not be null");
        this.a = charSequence2.toString();
        this.b = charSequence.toString();
        this.c = charSequence3.toString();
    }

    private static int a(String str, char[] cArr, int i) {
        int length = str.length();
        str.getChars(0, length, cArr, i);
        return length;
    }

    public StringJoiner add(CharSequence charSequence) {
        String valueOf = String.valueOf(charSequence);
        String[] strArr = this.d;
        if (strArr == null) {
            this.d = new String[8];
        } else {
            int i = this.e;
            if (i == strArr.length) {
                this.d = (String[]) Arrays.copyOf(strArr, i * 2);
            }
            this.f = this.b.length() + this.f;
        }
        this.f = valueOf.length() + this.f;
        String[] strArr2 = this.d;
        int i2 = this.e;
        this.e = i2 + 1;
        strArr2[i2] = valueOf;
        return this;
    }

    public final String toString() {
        String[] strArr;
        String[] strArr2 = this.d;
        int i = this.e;
        String str = this.a;
        int length = str.length();
        String str2 = this.c;
        int length2 = str2.length() + length;
        String str3 = this.b;
        if (length2 != 0) {
            char[] cArr = new char[this.f + length2];
            int a = a(str, cArr, 0);
            if (i > 0) {
                a += a(strArr2[0], cArr, a);
                for (int i2 = 1; i2 < i; i2++) {
                    int a2 = a + a(str3, cArr, a);
                    a = a2 + a(strArr2[i2], cArr, a2);
                }
            }
            a(str2, cArr, a);
            return new String(cArr);
        }
        if (this.e > 1) {
            char[] cArr2 = new char[this.f];
            int a3 = a(this.d[0], cArr2, 0);
            int i3 = 1;
            do {
                int a4 = a3 + a(str3, cArr2, a3);
                a3 = a4 + a(this.d[i3], cArr2, a4);
                strArr = this.d;
                strArr[i3] = null;
                i3++;
            } while (i3 < this.e);
            this.e = 1;
            strArr[0] = new String(cArr2);
        }
        return i == 0 ? "" : strArr2[0];
    }
}

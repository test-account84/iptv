package Y6;

import android.content.Intent;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class t {
    public final String a;
    public final String b;
    public final byte[] c;
    public final Integer d;
    public final String e;
    public final String f;
    public final Intent g;

    public t(Intent intent) {
        this(null, null, null, null, null, null, intent);
    }

    public static t c(int i, Intent intent) {
        if (i != -1) {
            return new t(intent);
        }
        String stringExtra = intent.getStringExtra("SCAN_RESULT");
        String stringExtra2 = intent.getStringExtra("SCAN_RESULT_FORMAT");
        byte[] byteArrayExtra = intent.getByteArrayExtra("SCAN_RESULT_BYTES");
        int intExtra = intent.getIntExtra("SCAN_RESULT_ORIENTATION", Integer.MIN_VALUE);
        return new t(stringExtra, stringExtra2, byteArrayExtra, intExtra == Integer.MIN_VALUE ? null : Integer.valueOf(intExtra), intent.getStringExtra("SCAN_RESULT_ERROR_CORRECTION_LEVEL"), intent.getStringExtra("SCAN_RESULT_IMAGE_PATH"), intent);
    }

    public String a() {
        return this.a;
    }

    public Intent b() {
        return this.g;
    }

    public String toString() {
        byte[] bArr = this.c;
        return "Format: " + this.b + "\nContents: " + this.a + "\nRaw bytes: (" + (bArr == null ? 0 : bArr.length) + " bytes)\nOrientation: " + this.d + "\nEC level: " + this.e + "\nBarcode image: " + this.f + "\nOriginal intent: " + this.g + '\n';
    }

    public t(String str, String str2, byte[] bArr, Integer num, String str3, String str4, Intent intent) {
        this.a = str;
        this.b = str2;
        this.c = bArr;
        this.d = num;
        this.e = str3;
        this.f = str4;
        this.g = intent;
    }
}

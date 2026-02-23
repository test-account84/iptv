package Y6;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.journeyapps.barcodescanner.CaptureActivity;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class u {
    public static final Collection d = e("UPC_A", "UPC_E", "EAN_8", "EAN_13", "RSS_14");
    public static final Collection e = e("UPC_A", "UPC_E", "EAN_8", "EAN_13", "RSS_14", "CODE_39", "CODE_93", "CODE_128", "ITF", "RSS_14", "RSS_EXPANDED");
    public static final Collection f = null;
    public final Map a = new HashMap(3);
    public Collection b;
    public Class c;

    public static List e(String... strArr) {
        return Collections.unmodifiableList(Arrays.asList(strArr));
    }

    public final void a(Intent intent) {
        Float f2;
        for (Map.Entry entry : this.a.entrySet()) {
            String str = (String) entry.getKey();
            Object value = entry.getValue();
            if (value instanceof Integer) {
                f2 = (Integer) value;
            } else if (value instanceof Long) {
                f2 = (Long) value;
            } else if (value instanceof Boolean) {
                f2 = (Boolean) value;
            } else if (value instanceof Double) {
                f2 = (Double) value;
            } else if (value instanceof Float) {
                f2 = (Float) value;
            } else if (value instanceof Bundle) {
                intent.putExtra(str, (Bundle) value);
            } else if (value instanceof int[]) {
                intent.putExtra(str, (int[]) value);
            } else if (value instanceof long[]) {
                intent.putExtra(str, (long[]) value);
            } else if (value instanceof boolean[]) {
                intent.putExtra(str, (boolean[]) value);
            } else if (value instanceof double[]) {
                intent.putExtra(str, (double[]) value);
            } else if (value instanceof float[]) {
                intent.putExtra(str, (float[]) value);
            } else if (value instanceof String[]) {
                intent.putExtra(str, (String[]) value);
            } else {
                intent.putExtra(str, value.toString());
            }
            intent.putExtra(str, f2);
        }
    }

    public Intent b(Context context) {
        Intent intent = new Intent(context, c());
        intent.setAction("com.google.zxing.client.android.SCAN");
        if (this.b != null) {
            StringBuilder sb = new StringBuilder();
            for (String str : this.b) {
                if (sb.length() > 0) {
                    sb.append(',');
                }
                sb.append(str);
            }
            intent.putExtra("SCAN_FORMATS", sb.toString());
        }
        intent.addFlags(67108864);
        intent.addFlags(524288);
        a(intent);
        return intent;
    }

    public Class c() {
        if (this.c == null) {
            this.c = d();
        }
        return this.c;
    }

    public Class d() {
        return CaptureActivity.class;
    }

    public u f(Class cls) {
        this.c = cls;
        return this;
    }
}

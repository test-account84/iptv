package B6;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import java.util.EnumMap;
import java.util.Map;
import java.util.regex.Pattern;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class g {
    public static final String a = "g";
    public static final Pattern b = Pattern.compile(",");

    public static Map a(Intent intent) {
        Object obj;
        Bundle extras = intent.getExtras();
        if (extras == null || extras.isEmpty()) {
            return null;
        }
        EnumMap enumMap = new EnumMap(x6.e.class);
        for (x6.e eVar : x6.e.values()) {
            if (eVar != x6.e.CHARACTER_SET && eVar != x6.e.NEED_RESULT_POINT_CALLBACK && eVar != x6.e.POSSIBLE_FORMATS) {
                String name = eVar.name();
                if (extras.containsKey(name)) {
                    if (eVar.getValueType().equals(Void.class)) {
                        obj = Boolean.TRUE;
                    } else {
                        obj = extras.get(name);
                        if (!eVar.getValueType().isInstance(obj)) {
                            Log.w(a, "Ignoring hint " + eVar + " because it is not assignable from " + obj);
                        }
                    }
                    enumMap.put(eVar, obj);
                }
            }
        }
        Log.i(a, "Hints from the Intent: " + enumMap);
        return enumMap;
    }
}

package com.amplifyframework.devmenu;

import android.content.Context;
import com.amplifyframework.logging.Logger;
import com.amplifyframework.logging.LoggingPlugin;
import com.amplifyframework.util.Immutable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class PersistentLogStoragePlugin extends LoggingPlugin {
    private static final String AMPLIFY_NAMESPACE = "amplify";
    private final Map loggers = new HashMap();

    public void configure(JSONObject jSONObject, Context context) {
    }

    public Logger forNamespace(String str) {
        if (str == null) {
            str = "amplify";
        }
        PersistentLogger persistentLogger = (PersistentLogger) this.loggers.get(str);
        if (persistentLogger != null) {
            return persistentLogger;
        }
        PersistentLogger persistentLogger2 = new PersistentLogger(str);
        this.loggers.put(str, persistentLogger2);
        return persistentLogger2;
    }

    public List getLogs() {
        ArrayList arrayList = new ArrayList();
        Iterator it = this.loggers.values().iterator();
        while (it.hasNext()) {
            arrayList.addAll(((PersistentLogger) it.next()).getLogs());
        }
        Collections.sort(arrayList);
        return Immutable.of((List) arrayList);
    }

    public String getPluginKey() {
        return PersistentLogStoragePlugin.class.getSimpleName();
    }

    public String getVersion() {
        return "1.37.10";
    }

    public Void getEscapeHatch() {
        return null;
    }
}

package com.amplifyframework.core.category;

import j$.util.concurrent.ConcurrentHashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class CategoryConfiguration implements CategoryTypeable {
    private static final String PLUGINS_KEY = "plugins";
    private final Map pluginConfigs = new ConcurrentHashMap();

    public final JSONObject getPluginConfig(String str) {
        return (JSONObject) this.pluginConfigs.get(str);
    }

    public void populateFromJSON(JSONObject jSONObject) throws JSONException {
        if (jSONObject.has("plugins")) {
            JSONObject jSONObject2 = jSONObject.getJSONObject("plugins");
            Iterator keys = jSONObject2.keys();
            while (keys.hasNext()) {
                String str = (String) keys.next();
                this.pluginConfigs.put(str, jSONObject2.getJSONObject(str));
            }
        }
    }
}

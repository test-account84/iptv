package com.amplifyframework.core.plugin;

import android.content.Context;
import com.amplifyframework.AmplifyException;
import com.amplifyframework.core.category.CategoryTypeable;
import org.json.JSONObject;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public interface Plugin extends CategoryTypeable {
    void configure(JSONObject jSONObject, Context context) throws AmplifyException;

    Object getEscapeHatch();

    String getPluginKey();

    String getVersion();

    void initialize(Context context) throws AmplifyException;
}

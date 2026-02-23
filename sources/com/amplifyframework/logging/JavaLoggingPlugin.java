package com.amplifyframework.logging;

import android.content.Context;
import org.json.JSONObject;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class JavaLoggingPlugin extends LoggingPlugin {
    private static final String AMPLIFY_NAMESPACE = "amplify";
    private final LogLevel defaultLoggerThreshold;

    public JavaLoggingPlugin() {
        this(LogLevel.INFO);
    }

    public void configure(JSONObject jSONObject, Context context) {
    }

    public Logger forNamespace(String str) {
        if (str == null) {
            str = "amplify";
        }
        return new JavaLogger(str, this.defaultLoggerThreshold);
    }

    public String getPluginKey() {
        return "JavaLoggingPlugin";
    }

    public String getVersion() {
        return "1.37.10";
    }

    public JavaLoggingPlugin(LogLevel logLevel) {
        this.defaultLoggerThreshold = logLevel;
    }

    public Void getEscapeHatch() {
        return null;
    }
}

package com.amplifyframework.devmenu;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.amplifyframework.AmplifyException;
import com.amplifyframework.core.Amplify;
import com.amplifyframework.devmenu.ShakeDetector;
import com.amplifyframework.logging.LogLevel;
import com.amplifyframework.logging.Logger;
import com.amplifyframework.util.Empty;
import java.util.List;
import java.util.Locale;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class DeveloperMenu implements ShakeDetector.Listener {
    private static final Logger LOG = Amplify.Logging.forNamespace("amplify:devmenu");
    private static DeveloperMenu sInstance;
    private Context context;
    private HideAction hideAction;
    private PersistentLogStoragePlugin loggingPlugin;
    private boolean visible;

    public interface HideAction {
        void hideDeveloperMenu();
    }

    private DeveloperMenu(Context context) {
        this.context = context.getApplicationContext();
    }

    public static DeveloperMenu singletonInstance(Context context) {
        if (sInstance == null) {
            sInstance = new DeveloperMenu(context);
        }
        return sInstance;
    }

    public void copyToClipboard(String str) {
        ((ClipboardManager) this.context.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("Copied Text", str));
    }

    public String createIssueBody(String str, boolean z) {
        String str2;
        EnvironmentInfo environmentInfo = new EnvironmentInfo();
        String str3 = "*Amplify Plugins Information:*\n" + environmentInfo.getPluginVersions();
        String str4 = "";
        try {
            str2 = environmentInfo.getDeveloperEnvironmentInfo(this.context);
        } catch (AmplifyException unused) {
            LOG.warn("Error reading developer environment information.");
            str2 = "";
        }
        if (!str2.isEmpty()) {
            str3 = str3 + "\n\n*Developer Environment Information:*\n" + str2;
        }
        String deviceInfo = new DeviceInfo().toString();
        if (z && !this.loggingPlugin.getLogs().isEmpty()) {
            str4 = "**Logs**\n```\n" + getLogs() + "```";
        }
        return String.format(Locale.US, "**Issue Description**\n%s\n\n**Environment Information**\n%s\n\n**Device Information**\n%s\n\n%s", new Object[]{str, str3, deviceInfo, str4});
    }

    public void enableDeveloperMenu() throws AmplifyException {
        if ((this.context.getApplicationInfo().flags & 2) != 0) {
            PersistentLogStoragePlugin persistentLogStoragePlugin = new PersistentLogStoragePlugin();
            this.loggingPlugin = persistentLogStoragePlugin;
            Amplify.addPlugin(persistentLogStoragePlugin);
            startListening();
        }
    }

    public String getFilteredLogs(String str, LogLevel logLevel) {
        if (Empty.check(str) && logLevel == null) {
            return getLogs();
        }
        List<LogEntry> logs = this.loggingPlugin.getLogs();
        if (logs.isEmpty()) {
            return "No logs to display.";
        }
        StringBuilder sb = new StringBuilder();
        String lowerCase = str == null ? "" : str.toLowerCase(Locale.US);
        for (LogEntry logEntry : logs) {
            String logEntry2 = logEntry.toString();
            if (logEntry2.toLowerCase(Locale.US).contains(lowerCase) && (logLevel == null || logEntry.getLogLevel() == logLevel)) {
                sb.append(logEntry2);
            }
        }
        String sb2 = sb.toString();
        return sb2.isEmpty() ? "No logs match the search criteria." : sb2;
    }

    public String getLogs() {
        List logs = this.loggingPlugin.getLogs();
        return logs.isEmpty() ? "No logs to display." : TextUtils.join("", logs);
    }

    public void onShakeDetected() {
        boolean z;
        if (this.visible) {
            HideAction hideAction = this.hideAction;
            if (hideAction != null) {
                hideAction.hideDeveloperMenu();
            }
            z = false;
        } else {
            Intent intent = new Intent(this.context, DeveloperMenuActivity.class);
            intent.setAction("android.intent.action.MAIN");
            intent.setFlags(268435456);
            this.context.startActivity(intent);
            z = true;
        }
        this.visible = z;
    }

    public void setOnHideAction(HideAction hideAction) {
        this.hideAction = hideAction;
    }

    public void setVisible(boolean z) {
        this.visible = z;
    }

    public void startListening() {
        new ShakeDetector(this.context, this).startDetecting();
    }
}

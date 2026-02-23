package com.amplifyframework.util;

import android.annotation.SuppressLint;
import android.os.Build;
import com.amplifyframework.AmplifyException;
import com.amplifyframework.core.Amplify;
import com.amplifyframework.logging.Logger;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class UserAgent {
    private static final int SIZE_LIMIT = 254;
    private static final Logger LOG = Amplify.Logging.forNamespace("amplify:core");
    private static String instance = null;

    public static final class Builder {
        private String deviceManufacturer;
        private String deviceName;
        private String libraryName;
        private String libraryVersion;
        private String systemName;
        private String systemVersion;
        private String userLanguage;
        private String userRegion;

        private Builder() {
        }

        private static String sanitize(String str) {
            return str != null ? str : "UNKNOWN";
        }

        public Builder deviceManufacturer(String str) {
            this.deviceManufacturer = sanitize(str);
            return this;
        }

        public Builder deviceName(String str) {
            this.deviceName = sanitize(str);
            return this;
        }

        public Builder libraryName(String str) {
            this.libraryName = sanitize(str);
            return this;
        }

        public Builder libraryVersion(String str) {
            this.libraryVersion = sanitize(str);
            return this;
        }

        public Builder systemName(String str) {
            this.systemName = sanitize(str);
            return this;
        }

        public Builder systemVersion(String str) {
            this.systemVersion = sanitize(str);
            return this;
        }

        public String toString() {
            return String.format("%s/%s (%s %s; %s %s; %s_%s)", new Object[]{this.libraryName, this.libraryVersion, this.systemName, this.systemVersion, this.deviceManufacturer, this.deviceName, this.userLanguage, this.userRegion});
        }

        public Builder userLanguage(String str) {
            this.userLanguage = sanitize(str);
            return this;
        }

        public Builder userRegion(String str) {
            this.userRegion = sanitize(str);
            return this;
        }

        public /* synthetic */ Builder(1 r1) {
            this();
        }
    }

    public enum Platform {
        ANDROID("amplify-android"),
        FLUTTER("amplify-flutter");

        private final String libraryName;

        Platform(String str) {
            this.libraryName = str;
        }

        public static /* synthetic */ String access$100(Platform platform) {
            return platform.libraryName;
        }

        public String getLibraryName() {
            return this.libraryName;
        }
    }

    private UserAgent() {
    }

    public static synchronized void configure(Map map) throws AmplifyException {
        synchronized (UserAgent.class) {
            try {
                if (instance != null) {
                    throw new AmplifyException("User-Agent was already configured successfully.", "User-Agent is configured internally during Amplify configuration. This method should not be called externally.");
                }
                StringBuilder sb = new StringBuilder();
                for (Map.Entry entry : map.entrySet()) {
                    sb.append(String.format("%s/%s ", new Object[]{((Platform) entry.getKey()).getLibraryName(), entry.getValue()}));
                }
                sb.append(forAndroid());
                if (sb.length() > 254) {
                    throw new AmplifyException("User-Agent exceeds the size limit of VARCHAR(254).", "There is a possibility that there is a bug if this error persists. Please take a look at \nhttps://github.com/aws-amplify/amplify-android/issues to see if there are any existing issues that \nmatch your scenario, and file an issue with the details of the bug if there isn't.");
                }
                instance = sb.toString();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static String forAndroid() {
        return new Builder(null).libraryName(Platform.ANDROID.getLibraryName()).libraryVersion("1.37.10").systemName("Android").systemVersion(Build.VERSION.RELEASE).deviceManufacturer(Build.MANUFACTURER).deviceName(Build.MODEL).userLanguage(System.getProperty("user.language")).userRegion(System.getProperty("user.region")).toString();
    }

    public static boolean isFlutter() {
        return string().contains(Platform.access$100(Platform.FLUTTER));
    }

    public static synchronized void reset() {
        synchronized (UserAgent.class) {
            instance = null;
        }
    }

    @SuppressLint({"SyntheticAccessor"})
    public static String string() {
        String str = instance;
        if (str != null) {
            return str;
        }
        LOG.debug("User-Agent is not yet configured. Returning default Android user-agent.");
        return forAndroid();
    }
}

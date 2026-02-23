package com.amazonaws.auth;

import com.amazonaws.ClientConfiguration;
import java.util.HashMap;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class SessionCredentialsProviderFactory {
    private static final Map cache = new HashMap();

    public static final class Key {
        private final String awsAccessKeyId;
        private final String serviceEndpoint;

        public Key(String str, String str2) {
            this.awsAccessKeyId = str;
            this.serviceEndpoint = str2;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || Key.class != obj.getClass()) {
                return false;
            }
            Key key = (Key) obj;
            String str = this.awsAccessKeyId;
            if (str == null) {
                if (key.awsAccessKeyId != null) {
                    return false;
                }
            } else if (!str.equals(key.awsAccessKeyId)) {
                return false;
            }
            String str2 = this.serviceEndpoint;
            String str3 = key.serviceEndpoint;
            if (str2 == null) {
                if (str3 != null) {
                    return false;
                }
            } else if (!str2.equals(str3)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            String str = this.awsAccessKeyId;
            int hashCode = ((str == null ? 0 : str.hashCode()) + 31) * 31;
            String str2 = this.serviceEndpoint;
            return hashCode + (str2 != null ? str2.hashCode() : 0);
        }
    }

    public static synchronized STSSessionCredentialsProvider getSessionCredentialsProvider(AWSCredentials aWSCredentials, String str, ClientConfiguration clientConfiguration) {
        STSSessionCredentialsProvider sTSSessionCredentialsProvider;
        synchronized (SessionCredentialsProviderFactory.class) {
            try {
                Key key = new Key(aWSCredentials.getAWSAccessKeyId(), str);
                Map map = cache;
                if (!map.containsKey(key)) {
                    map.put(key, new STSSessionCredentialsProvider(aWSCredentials, clientConfiguration));
                }
                sTSSessionCredentialsProvider = (STSSessionCredentialsProvider) map.get(key);
            } catch (Throwable th) {
                throw th;
            }
        }
        return sTSSessionCredentialsProvider;
    }
}

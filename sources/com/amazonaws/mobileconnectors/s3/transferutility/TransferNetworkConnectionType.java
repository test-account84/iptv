package com.amazonaws.mobileconnectors.s3.transferutility;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.Map;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class TransferNetworkConnectionType {
    private static final /* synthetic */ TransferNetworkConnectionType[] $VALUES;

    @SerializedName("ANY")
    public static final TransferNetworkConnectionType ANY;
    private static final Log LOGGER;
    private static final Map MAP;

    @SerializedName("MOBILE")
    public static final TransferNetworkConnectionType MOBILE;

    @SerializedName("WIFI")
    public static final TransferNetworkConnectionType WIFI;

    public enum 1 extends TransferNetworkConnectionType {
        public 1(String str, int i) {
            super(str, i, null);
        }

        public boolean verify(NetworkInfo networkInfo) {
            return networkInfo != null && networkInfo.isConnected();
        }
    }

    public enum 2 extends TransferNetworkConnectionType {
        public 2(String str, int i) {
            super(str, i, null);
        }

        public boolean verify(NetworkInfo networkInfo) {
            return networkInfo != null && networkInfo.isConnected() && networkInfo.getType() == 1;
        }
    }

    public enum 3 extends TransferNetworkConnectionType {
        public 3(String str, int i) {
            super(str, i, null);
        }

        public boolean verify(NetworkInfo networkInfo) {
            return networkInfo != null && networkInfo.isConnected() && networkInfo.getType() == 0;
        }
    }

    static {
        1 r0 = new 1("ANY", 0);
        ANY = r0;
        2 r1 = new 2("WIFI", 1);
        WIFI = r1;
        3 r3 = new 3("MOBILE", 2);
        MOBILE = r3;
        $VALUES = new TransferNetworkConnectionType[]{r0, r1, r3};
        MAP = new HashMap();
        for (TransferNetworkConnectionType transferNetworkConnectionType : values()) {
            MAP.put(transferNetworkConnectionType.toString(), transferNetworkConnectionType);
        }
        LOGGER = LogFactory.getLog(TransferNetworkConnectionType.class);
    }

    private TransferNetworkConnectionType(String str, int i) {
    }

    public static TransferNetworkConnectionType getConnectionType(String str) {
        Map map = MAP;
        if (map.containsKey(str)) {
            return (TransferNetworkConnectionType) map.get(str);
        }
        LOGGER.error("Unknown connection type " + str + " transfer will have connection type set to ANY.");
        return ANY;
    }

    public static TransferNetworkConnectionType valueOf(String str) {
        return (TransferNetworkConnectionType) Enum.valueOf(TransferNetworkConnectionType.class, str);
    }

    public static TransferNetworkConnectionType[] values() {
        return (TransferNetworkConnectionType[]) $VALUES.clone();
    }

    public boolean isConnected(ConnectivityManager connectivityManager) {
        return verify(connectivityManager.getActiveNetworkInfo());
    }

    public abstract boolean verify(NetworkInfo networkInfo);

    public /* synthetic */ TransferNetworkConnectionType(String str, int i, 1 r3) {
        this(str, i);
    }
}

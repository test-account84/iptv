package com.amazonaws.auth;

import com.amazonaws.internal.config.InternalConfig;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class SignerFactory {
    private static final String NO_OP_SIGNER = "NoOpSignerType";
    private static final String QUERY_STRING_SIGNER = "QueryStringSignerType";
    private static final Map SIGNERS;
    private static final String VERSION_FOUR_SIGNER = "AWS4SignerType";

    static {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        SIGNERS = concurrentHashMap;
        concurrentHashMap.put("QueryStringSignerType", QueryStringSigner.class);
        concurrentHashMap.put("AWS4SignerType", AWS4Signer.class);
        concurrentHashMap.put("NoOpSignerType", NoOpSigner.class);
    }

    private SignerFactory() {
    }

    private static Signer createSigner(String str, String str2) {
        Class cls = (Class) SIGNERS.get(str);
        if (cls == null) {
            throw new IllegalArgumentException();
        }
        try {
            Signer signer = (Signer) cls.newInstance();
            if (signer instanceof ServiceAwareSigner) {
                ((ServiceAwareSigner) signer).setServiceName(str2);
            }
            return signer;
        } catch (InstantiationException e) {
            throw new IllegalStateException("Cannot create an instance of " + cls.getName(), e);
        } catch (IllegalAccessException e2) {
            throw new IllegalStateException("Cannot create an instance of " + cls.getName(), e2);
        }
    }

    public static Signer getSigner(String str, String str2) {
        return lookupAndCreateSigner(str, str2);
    }

    public static Signer getSignerByTypeAndService(String str, String str2) {
        return createSigner(str, str2);
    }

    private static Signer lookupAndCreateSigner(String str, String str2) {
        return createSigner(InternalConfig.Factory.getInternalConfig().getSignerConfig(str, str2).getSignerType(), str);
    }

    public static void registerSigner(String str, Class cls) {
        if (str == null) {
            throw new IllegalArgumentException("signerType cannot be null");
        }
        if (cls == null) {
            throw new IllegalArgumentException("signerClass cannot be null");
        }
        SIGNERS.put(str, cls);
    }
}

package com.amazonaws.mobileconnectors.appsync.sigv4;

import com.amazonaws.Request;
import com.amazonaws.auth.AWS4Signer;
import com.amazonaws.util.BinaryUtils;
import java.io.InputStream;
import java.net.URI;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class AppSyncV4Signer extends AWS4Signer {
    private static final String RESOURCE_PATH = "/graphql";
    private static final String SERVICE_NAME_SCOPE = "appsync";
    private static final String TAG = "AppSyncV4Signer";
    private ResourcePath resourcePath;

    public enum ResourcePath {
        IAM_CONNECTION_RESOURCE_PATH,
        DEFAULT_RESOURCE_PATH
    }

    public AppSyncV4Signer(String str) {
        this(str, ResourcePath.DEFAULT_RESOURCE_PATH);
    }

    public String calculateContentHash(Request request) {
        InputStream content = request.getContent();
        content.mark(-1);
        return BinaryUtils.toHex(hash(content));
    }

    public String extractServiceName(URI uri) {
        return "appsync";
    }

    public String getCanonicalizedResourcePath(String str) {
        ResourcePath resourcePath = this.resourcePath;
        return (resourcePath == null || !resourcePath.equals(ResourcePath.IAM_CONNECTION_RESOURCE_PATH)) ? "/graphql" : "/graphql/connect";
    }

    public AppSyncV4Signer(String str, ResourcePath resourcePath) {
        super(true);
        this.resourcePath = resourcePath;
        setRegionName(str);
    }

    public String getCanonicalizedResourcePath(String str, boolean z) {
        ResourcePath resourcePath = this.resourcePath;
        return (resourcePath == null || !resourcePath.equals(ResourcePath.IAM_CONNECTION_RESOURCE_PATH)) ? "/graphql" : "/graphql/connect";
    }
}

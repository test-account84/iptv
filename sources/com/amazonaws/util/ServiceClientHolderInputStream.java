package com.amazonaws.util;

import com.amazonaws.AmazonWebServiceClient;
import com.amazonaws.internal.SdkFilterInputStream;
import java.io.InputStream;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class ServiceClientHolderInputStream extends SdkFilterInputStream {
    private AmazonWebServiceClient client;

    public ServiceClientHolderInputStream(InputStream inputStream, AmazonWebServiceClient amazonWebServiceClient) {
        super(inputStream);
        this.client = amazonWebServiceClient;
    }
}

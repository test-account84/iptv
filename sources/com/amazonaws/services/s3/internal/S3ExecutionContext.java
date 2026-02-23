package com.amazonaws.services.s3.internal;

import com.amazonaws.AmazonWebServiceClient;
import com.amazonaws.auth.Signer;
import com.amazonaws.http.ExecutionContext;
import java.net.URI;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class S3ExecutionContext extends ExecutionContext {
    private Signer signer;

    public S3ExecutionContext(List list, boolean z, AmazonWebServiceClient amazonWebServiceClient) {
        super(list, z, amazonWebServiceClient);
    }

    public Signer getSignerByURI(URI uri) {
        return this.signer;
    }

    public void setSigner(Signer signer) {
        this.signer = signer;
    }
}

package com.amazonaws.services.s3;

import com.amazonaws.ResponseMetadata;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class S3ResponseMetadata extends ResponseMetadata {
    public static final String CLOUD_FRONT_ID = "CLOUD_FRONT_ID";
    public static final String HOST_ID = "HOST_ID";

    public S3ResponseMetadata(ResponseMetadata responseMetadata) {
        super(responseMetadata);
    }

    public String getCloudFrontId() {
        return (String) this.metadata.get("CLOUD_FRONT_ID");
    }

    public String getHostId() {
        return (String) this.metadata.get("HOST_ID");
    }

    public S3ResponseMetadata(Map map) {
        super(map);
    }
}

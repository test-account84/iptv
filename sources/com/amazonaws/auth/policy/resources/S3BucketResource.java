package com.amazonaws.auth.policy.resources;

import com.amazonaws.auth.policy.Resource;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class S3BucketResource extends Resource {
    public S3BucketResource(String str) {
        super("arn:aws:s3:::" + str);
    }
}

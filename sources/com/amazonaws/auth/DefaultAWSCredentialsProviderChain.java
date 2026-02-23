package com.amazonaws.auth;

@Deprecated
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class DefaultAWSCredentialsProviderChain extends AWSCredentialsProviderChain {
    public DefaultAWSCredentialsProviderChain() {
        super(new SystemPropertiesCredentialsProvider(), new ClasspathPropertiesFileCredentialsProvider());
    }
}

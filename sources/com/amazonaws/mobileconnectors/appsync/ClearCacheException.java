package com.amazonaws.mobileconnectors.appsync;

import java.util.ArrayList;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class ClearCacheException extends AWSAppSyncClientException {
    private List exceptions;

    public ClearCacheException() {
    }

    public void addException(Exception exc) {
        if (this.exceptions == null) {
            this.exceptions = new ArrayList();
        }
        this.exceptions.add(exc);
    }

    public List getExceptions() {
        return this.exceptions;
    }

    public ClearCacheException(String str) {
        super(str);
    }

    public ClearCacheException(String str, Throwable th) {
        super(str, th);
    }

    public ClearCacheException(Throwable th) {
        super(th);
    }
}

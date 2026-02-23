package com.amazonaws.transform;

import com.amazonaws.AmazonServiceException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class AbstractErrorUnmarshaller implements Unmarshaller {
    protected final Class exceptionClass;

    public AbstractErrorUnmarshaller() {
        this(AmazonServiceException.class);
    }

    public AmazonServiceException newException(String str) throws Exception {
        return (AmazonServiceException) this.exceptionClass.getConstructor(new Class[]{String.class}).newInstance(new Object[]{str});
    }

    public AbstractErrorUnmarshaller(Class cls) {
        this.exceptionClass = cls;
    }
}

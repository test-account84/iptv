package org.simpleframework.xml.strategy;

import org.simpleframework.xml.core.PersistenceException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class CycleException extends PersistenceException {
    public CycleException(String str, Object... objArr) {
        super(str, objArr);
    }

    public CycleException(Throwable th, String str, Object... objArr) {
        super(th, str, objArr);
    }
}

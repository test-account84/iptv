package com.amazonaws.services.s3.internal;

import java.util.Date;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public interface ObjectRestoreResult {
    Boolean getOngoingRestore();

    Date getRestoreExpirationTime();

    void setOngoingRestore(boolean z);

    void setRestoreExpirationTime(Date date);
}

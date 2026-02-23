package com.amazonaws.mobileconnectors.s3.transferutility;

import android.content.Context;
import kotlin.jvm.internal.l;
import org.jetbrains.annotations.NotNull;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class TransferStatusUpdaterAccessor {

    @NotNull
    public static final TransferStatusUpdaterAccessor INSTANCE = new TransferStatusUpdaterAccessor();

    private TransferStatusUpdaterAccessor() {
    }

    public final boolean hasActiveTransfer(@NotNull Context context) {
        l.e(context, "context");
        TransferStatusUpdater transferStatusUpdater = TransferStatusUpdater.getInstance(context);
        l.d(transferStatusUpdater, "TransferStatusUpdater.getInstance(context)");
        for (TransferRecord transferRecord : transferStatusUpdater.getTransfers().values()) {
            if (!TransferState.isFinalState(transferRecord.state) && transferRecord.state != TransferState.PAUSED) {
                return true;
            }
        }
        return false;
    }
}

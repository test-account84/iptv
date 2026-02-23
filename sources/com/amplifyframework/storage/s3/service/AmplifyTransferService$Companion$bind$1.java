package com.amplifyframework.storage.s3.service;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.amplifyframework.storage.s3.service.AmplifyTransferService;
import kotlin.jvm.internal.l;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class AmplifyTransferService$Companion$bind$1 implements ServiceConnection {
    final /* synthetic */ Context $context;

    public AmplifyTransferService$Companion$bind$1(Context context) {
        this.$context = context;
    }

    public void onServiceConnected(@NotNull ComponentName componentName, @Nullable IBinder iBinder) {
        l.e(componentName, "name");
        if (iBinder == null) {
            throw new NullPointerException("null cannot be cast to non-null type com.amplifyframework.storage.s3.service.AmplifyTransferService.LocalBinder");
        }
        AmplifyTransferService.access$setBoundService$cp(((AmplifyTransferService.LocalBinder) iBinder).getService());
        AmplifyTransferService.Companion.startForeground(this.$context);
        AmplifyTransferService access$getBoundService$cp = AmplifyTransferService.access$getBoundService$cp();
        if (access$getBoundService$cp != null) {
            AmplifyTransferService.access$startUnbindCheck(access$getBoundService$cp);
        }
    }

    public void onServiceDisconnected(@Nullable ComponentName componentName) {
        AmplifyTransferService.Companion.stopForegroundAndUnbind(this.$context);
        AmplifyTransferService.access$setBoundService$cp(null);
    }
}

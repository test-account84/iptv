package p7;

import com.amplifyframework.core.Consumer;
import com.amplifyframework.storage.result.StorageDownloadFileResult;
import com.nst.iptvsmarterstvbox.view.activity.BackupAndRestoreActivity;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final /* synthetic */ class i implements Consumer {
    public final /* synthetic */ BackupAndRestoreActivity.e a;

    public /* synthetic */ i(BackupAndRestoreActivity.e eVar) {
        this.a = eVar;
    }

    public final void accept(Object obj) {
        BackupAndRestoreActivity.e.c(this.a, (StorageDownloadFileResult) obj);
    }
}

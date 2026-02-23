package p7;

import com.amplifyframework.core.Consumer;
import com.amplifyframework.storage.result.StorageRemoveResult;
import com.nst.iptvsmarterstvbox.view.activity.BackupAndRestoreActivity;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final /* synthetic */ class d implements Consumer {
    public final /* synthetic */ BackupAndRestoreActivity a;
    public final /* synthetic */ String b;

    public /* synthetic */ d(BackupAndRestoreActivity backupAndRestoreActivity, String str) {
        this.a = backupAndRestoreActivity;
        this.b = str;
    }

    public final void accept(Object obj) {
        BackupAndRestoreActivity.z1(this.a, this.b, (StorageRemoveResult) obj);
    }
}

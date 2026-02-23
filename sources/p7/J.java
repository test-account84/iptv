package p7;

import com.amplifyframework.core.Consumer;
import com.amplifyframework.storage.StorageException;
import com.nst.iptvsmarterstvbox.view.activity.BackupAndRestoreActivity;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final /* synthetic */ class j implements Consumer {
    public final /* synthetic */ BackupAndRestoreActivity.e a;

    public /* synthetic */ j(BackupAndRestoreActivity.e eVar) {
        this.a = eVar;
    }

    public final void accept(Object obj) {
        BackupAndRestoreActivity.e.b(this.a, (StorageException) obj);
    }
}

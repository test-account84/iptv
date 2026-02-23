package okhttp3;

import java.util.List;
import kotlin.jvm.internal.m;
import org.jetbrains.annotations.NotNull;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class Handshake$Companion$get$1 extends m implements w8.a {
    final /* synthetic */ List $peerCertificatesCopy;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Handshake$Companion$get$1(List list) {
        super(0);
        this.$peerCertificatesCopy = list;
    }

    @NotNull
    public final List invoke() {
        return this.$peerCertificatesCopy;
    }
}

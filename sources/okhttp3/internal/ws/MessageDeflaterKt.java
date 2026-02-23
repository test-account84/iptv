package okhttp3.internal.ws;

import okio.ByteString;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class MessageDeflaterKt {
    private static final ByteString EMPTY_DEFLATE_BLOCK = ByteString.Companion.decodeHex("000000ffff");
    private static final int LAST_OCTETS_COUNT_TO_REMOVE_AFTER_DEFLATION = 4;

    public static final /* synthetic */ ByteString access$getEMPTY_DEFLATE_BLOCK$p() {
        return EMPTY_DEFLATE_BLOCK;
    }
}

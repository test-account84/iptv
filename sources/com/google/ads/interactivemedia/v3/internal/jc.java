package com.google.ads.interactivemedia.v3.internal;

import android.content.Context;
import android.media.AudioTrack;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final /* synthetic */ class jc implements Runnable {
    public final /* synthetic */ Object a;
    public final /* synthetic */ Object b;
    private final /* synthetic */ int c;

    public /* synthetic */ jc(Context context, TaskCompletionSource taskCompletionSource, int i) {
        this.c = i;
        this.a = context;
        this.b = taskCompletionSource;
    }

    /* JADX WARN: Type inference failed for: r1v14, types: [com.google.ads.interactivemedia.v3.internal.no, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v15, types: [com.google.ads.interactivemedia.v3.internal.no, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v16, types: [com.google.ads.interactivemedia.v3.internal.no, java.lang.Object] */
    public final void run() {
        switch (this.c) {
            case 0:
                ((ji) this.a).h((Exception) this.b);
                break;
            case 1:
                Object obj = this.a;
                ((xv) this.b).b(((ch) obj).a());
                break;
            case 2:
                ((ji) this.b).l((ep) this.a);
                break;
            case 3:
                ((ji) this.b).m((ep) this.a);
                break;
            case 4:
                ((ji) this.a).i((Exception) this.b);
                break;
            case 5:
                ((ji) this.a).k((String) this.b);
                break;
            case 6:
                kh.G((AudioTrack) this.a, (agp) this.b);
                break;
            case 7:
                nn nnVar = (nn) this.a;
                this.b.al(nnVar.a, nnVar.b);
                break;
            case 8:
                nn nnVar2 = (nn) this.a;
                this.b.ao(nnVar2.a, nnVar2.b);
                break;
            case 9:
                nn nnVar3 = (nn) this.a;
                this.b.ak(nnVar3.a, nnVar3.b);
                break;
            default:
                Object obj2 = this.a;
                ((TaskCompletionSource) this.b).setResult(ata.c((Context) obj2, "GLAS"));
                break;
        }
    }

    public /* synthetic */ jc(AudioTrack audioTrack, agp agpVar, int i, byte[] bArr) {
        this.c = i;
        this.a = audioTrack;
        this.b = agpVar;
    }

    public /* synthetic */ jc(ch chVar, xv xvVar, int i, byte[] bArr) {
        this.c = i;
        this.a = chVar;
        this.b = xvVar;
    }

    public /* synthetic */ jc(ji jiVar, ep epVar, int i) {
        this.c = i;
        this.b = jiVar;
        this.a = epVar;
    }

    public /* synthetic */ jc(ji jiVar, Exception exc, int i) {
        this.c = i;
        this.a = jiVar;
        this.b = exc;
    }

    public /* synthetic */ jc(ji jiVar, String str, int i) {
        this.c = i;
        this.a = jiVar;
        this.b = str;
    }

    public /* synthetic */ jc(nn nnVar, no noVar, int i) {
        this.c = i;
        this.a = nnVar;
        this.b = noVar;
    }
}

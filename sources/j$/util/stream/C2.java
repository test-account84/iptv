package j$.util.stream;

import java.util.function.Consumer;
import java.util.function.IntFunction;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
public final /* synthetic */ class c2 implements IntFunction, Consumer {
    public final /* synthetic */ int a;

    public /* synthetic */ c2(int i) {
        this.a = i;
    }

    private final void accept$j$$util$stream$StreamSpliterators$SliceSpliterator$OfRef$$ExternalSyntheticLambda0(Object obj) {
    }

    private final void accept$j$$util$stream$StreamSpliterators$SliceSpliterator$OfRef$$ExternalSyntheticLambda1(Object obj) {
    }

    public void accept(Object obj) {
        int i = this.a;
    }

    public /* synthetic */ Consumer andThen(Consumer consumer) {
        switch (this.a) {
        }
        return j$.com.android.tools.r8.a.d(this, consumer);
    }

    public Object apply(int i) {
        switch (this.a) {
            case 0:
                return new Object[i];
            case 1:
                return new Integer[i];
            case 2:
                return new Long[i];
            case 3:
                return new Double[i];
            case 4:
            case 5:
            default:
                return new Double[i];
            case 6:
                return new Integer[i];
            case 7:
                return new Integer[i];
            case 8:
                return new Long[i];
            case 9:
                return new Long[i];
            case 10:
                return new Double[i];
        }
    }
}

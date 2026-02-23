package a4;

import com.google.android.exoplayer2.ui.TrackSelectionView;
import java.util.Comparator;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final /* synthetic */ class d0 implements Comparator {
    public final /* synthetic */ Comparator a;

    public /* synthetic */ d0(Comparator comparator) {
        this.a = comparator;
    }

    public final int compare(Object obj, Object obj2) {
        return TrackSelectionView.a(this.a, (TrackSelectionView.c) obj, (TrackSelectionView.c) obj2);
    }
}

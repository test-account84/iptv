package o4;

import java.util.HashSet;
import java.util.Iterator;
import n4.e;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class m0 extends e.d {
    public final /* synthetic */ e a;

    public /* synthetic */ m0(e eVar, l0 l0Var) {
        this.a = eVar;
    }

    public final void onActiveInputStateChanged(int i) {
        Iterator it = new HashSet(e.z(this.a)).iterator();
        while (it.hasNext()) {
            ((e.d) it.next()).onActiveInputStateChanged(i);
        }
    }

    public final void onApplicationDisconnected(int i) {
        e.A(this.a, i);
        this.a.h(i);
        Iterator it = new HashSet(e.z(this.a)).iterator();
        while (it.hasNext()) {
            ((e.d) it.next()).onApplicationDisconnected(i);
        }
    }

    public final void onApplicationMetadataChanged(n4.d dVar) {
        Iterator it = new HashSet(e.z(this.a)).iterator();
        while (it.hasNext()) {
            ((e.d) it.next()).onApplicationMetadataChanged(dVar);
        }
    }

    public final void onApplicationStatusChanged() {
        Iterator it = new HashSet(e.z(this.a)).iterator();
        while (it.hasNext()) {
            ((e.d) it.next()).onApplicationStatusChanged();
        }
    }

    public final void onStandbyStateChanged(int i) {
        Iterator it = new HashSet(e.z(this.a)).iterator();
        while (it.hasNext()) {
            ((e.d) it.next()).onStandbyStateChanged(i);
        }
    }

    public final void onVolumeChanged() {
        Iterator it = new HashSet(e.z(this.a)).iterator();
        while (it.hasNext()) {
            ((e.d) it.next()).onVolumeChanged();
        }
    }
}

package j$.util.stream;

import j$.util.Spliterator;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
abstract class b0 extends c0 {
    public final /* synthetic */ int l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ b0(b bVar, int i, int i2) {
        super(bVar, i);
        this.l = i2;
    }

    final boolean Q() {
        switch (this.l) {
            case 0:
                return true;
            default:
                return false;
        }
    }

    public final /* bridge */ /* synthetic */ IntStream parallel() {
        switch (this.l) {
            case 0:
                parallel();
                break;
            default:
                parallel();
                break;
        }
        return this;
    }

    public final /* bridge */ /* synthetic */ IntStream sequential() {
        switch (this.l) {
            case 0:
                sequential();
                break;
            default:
                sequential();
                break;
        }
        return this;
    }

    public final /* bridge */ /* synthetic */ Spliterator spliterator() {
        switch (this.l) {
        }
        return spliterator();
    }

    public final h unordered() {
        switch (this.l) {
            case 0:
                if (!L()) {
                    break;
                } else {
                    break;
                }
            default:
                if (!L()) {
                    break;
                } else {
                    break;
                }
        }
        return new w(this, e3.r, 2);
    }
}

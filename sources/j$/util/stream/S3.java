package j$.util.stream;

import java.util.function.Consumer;
import java.util.function.LongConsumer;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
public final /* synthetic */ class s3 implements p2 {
    public final /* synthetic */ int a;
    public final /* synthetic */ LongConsumer b;

    public /* synthetic */ s3(LongConsumer longConsumer, int i) {
        this.a = i;
        this.b = longConsumer;
    }

    private final /* synthetic */ void b(long j) {
    }

    private final /* synthetic */ void c(long j) {
    }

    private final /* synthetic */ void d() {
    }

    private final /* synthetic */ void e() {
    }

    public final /* synthetic */ void accept(double d) {
        switch (this.a) {
            case 0:
                y0.a();
                throw null;
            default:
                y0.a();
                throw null;
        }
    }

    public final /* synthetic */ void accept(int i) {
        switch (this.a) {
            case 0:
                y0.k();
                throw null;
            default:
                y0.k();
                throw null;
        }
    }

    public final void accept(long j) {
        switch (this.a) {
            case 0:
                ((X2) this.b).accept(j);
                break;
            default:
                this.b.accept(j);
                break;
        }
    }

    public final /* bridge */ /* synthetic */ void accept(Object obj) {
        switch (this.a) {
            case 0:
                y0.j(this, obj);
                break;
            default:
                y0.j(this, obj);
                break;
        }
    }

    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        switch (this.a) {
        }
        return j$.com.android.tools.r8.a.d(this, consumer);
    }

    public final /* synthetic */ LongConsumer andThen(LongConsumer longConsumer) {
        switch (this.a) {
        }
        return j$.com.android.tools.r8.a.g(this, longConsumer);
    }

    public final /* synthetic */ void k(Long l) {
        switch (this.a) {
            case 0:
                y0.i(this, l);
                break;
            default:
                y0.i(this, l);
                break;
        }
    }

    public final /* synthetic */ void l() {
        int i = this.a;
    }

    public final /* synthetic */ void m(long j) {
        int i = this.a;
    }

    public final /* synthetic */ boolean o() {
        switch (this.a) {
        }
        return false;
    }
}

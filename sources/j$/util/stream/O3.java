package j$.util.stream;

import java.util.function.Consumer;
import java.util.function.DoubleConsumer;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
public final /* synthetic */ class o3 implements n2 {
    public final /* synthetic */ int a;
    public final /* synthetic */ DoubleConsumer b;

    public /* synthetic */ o3(DoubleConsumer doubleConsumer, int i) {
        this.a = i;
        this.b = doubleConsumer;
    }

    private final /* synthetic */ void b(long j) {
    }

    private final /* synthetic */ void c(long j) {
    }

    private final /* synthetic */ void d() {
    }

    private final /* synthetic */ void e() {
    }

    public final void accept(double d) {
        switch (this.a) {
            case 0:
                ((T2) this.b).accept(d);
                break;
            default:
                this.b.accept(d);
                break;
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

    public final /* synthetic */ void accept(long j) {
        switch (this.a) {
            case 0:
                y0.l();
                throw null;
            default:
                y0.l();
                throw null;
        }
    }

    public final /* bridge */ /* synthetic */ void accept(Object obj) {
        switch (this.a) {
            case 0:
                y0.f(this, obj);
                break;
            default:
                y0.f(this, obj);
                break;
        }
    }

    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        switch (this.a) {
        }
        return j$.com.android.tools.r8.a.d(this, consumer);
    }

    public final /* synthetic */ DoubleConsumer andThen(DoubleConsumer doubleConsumer) {
        switch (this.a) {
        }
        return j$.com.android.tools.r8.a.e(this, doubleConsumer);
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

    public final /* synthetic */ void q(Double d) {
        switch (this.a) {
            case 0:
                y0.e(this, d);
                break;
            default:
                y0.e(this, d);
                break;
        }
    }
}

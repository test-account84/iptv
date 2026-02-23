package j$.util.stream;

import java.util.function.Consumer;
import java.util.function.IntConsumer;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
public final /* synthetic */ class q3 implements o2 {
    public final /* synthetic */ int a;
    public final /* synthetic */ IntConsumer b;

    public /* synthetic */ q3(IntConsumer intConsumer, int i) {
        this.a = i;
        this.b = intConsumer;
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

    public final void accept(int i) {
        switch (this.a) {
            case 0:
                ((V2) this.b).accept(i);
                break;
            default:
                this.b.accept(i);
                break;
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
                y0.h(this, obj);
                break;
            default:
                y0.h(this, obj);
                break;
        }
    }

    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        switch (this.a) {
        }
        return j$.com.android.tools.r8.a.d(this, consumer);
    }

    public final /* synthetic */ IntConsumer andThen(IntConsumer intConsumer) {
        switch (this.a) {
        }
        return j$.com.android.tools.r8.a.f(this, intConsumer);
    }

    public final /* synthetic */ void l() {
        int i = this.a;
    }

    public final /* synthetic */ void m(long j) {
        int i = this.a;
    }

    public final /* synthetic */ void n(Integer num) {
        switch (this.a) {
            case 0:
                y0.g(this, num);
                break;
            default:
                y0.g(this, num);
                break;
        }
    }

    public final /* synthetic */ boolean o() {
        switch (this.a) {
        }
        return false;
    }
}

package j$.util.stream;

import java.util.function.Consumer;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
public final /* synthetic */ class H3 implements q2 {
    public final /* synthetic */ int a;
    public final /* synthetic */ Consumer b;

    public /* synthetic */ H3(Consumer consumer, int i) {
        this.a = i;
        this.b = consumer;
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

    public final void accept(Object obj) {
        switch (this.a) {
            case 0:
                ((a3) this.b).accept(obj);
                break;
            default:
                this.b.accept(obj);
                break;
        }
    }

    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        switch (this.a) {
        }
        return j$.com.android.tools.r8.a.d(this, consumer);
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

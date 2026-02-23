package j$.util.stream;

import j$.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
public final /* synthetic */ class p0 implements Supplier, Consumer {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;

    public /* synthetic */ p0(int i, Object obj, Object obj2) {
        this.a = i;
        this.b = obj;
        this.c = obj2;
    }

    public void accept(Object obj) {
        switch (this.a) {
            case 1:
                ((n3) this.b).b((Consumer) this.c, obj);
                break;
            case 2:
                if (obj != null) {
                    ((ConcurrentHashMap) this.c).putIfAbsent(obj, Boolean.TRUE);
                    break;
                } else {
                    ((AtomicBoolean) this.b).set(true);
                    break;
                }
            default:
                ((BiConsumer) this.b).accept(this.c, obj);
                break;
        }
    }

    public /* synthetic */ Consumer andThen(Consumer consumer) {
        switch (this.a) {
        }
        return j$.com.android.tools.r8.a.d(this, consumer);
    }

    public Object get() {
        return new q0((v0) this.b, (Predicate) this.c);
    }
}

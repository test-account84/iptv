package q8;

import java.io.Serializable;
import k8.j;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public abstract class a implements o8.d, e, Serializable {

    @Nullable
    private final o8.d completion;

    public a(o8.d dVar) {
        this.completion = dVar;
    }

    @NotNull
    public o8.d create(@Nullable Object obj, @NotNull o8.d completion) {
        kotlin.jvm.internal.l.e(completion, "completion");
        throw new UnsupportedOperationException("create(Any?;Continuation) has not been overridden");
    }

    @Nullable
    public e getCallerFrame() {
        o8.d dVar = this.completion;
        if (dVar instanceof e) {
            return (e) dVar;
        }
        return null;
    }

    @Nullable
    public final o8.d getCompletion() {
        return this.completion;
    }

    @Nullable
    public StackTraceElement getStackTraceElement() {
        return g.d(this);
    }

    public abstract Object invokeSuspend(Object obj);

    public final void resumeWith(@NotNull Object obj) {
        Object invokeSuspend;
        o8.d dVar = this;
        while (true) {
            h.b(dVar);
            a aVar = (a) dVar;
            o8.d dVar2 = aVar.completion;
            kotlin.jvm.internal.l.b(dVar2);
            try {
                invokeSuspend = aVar.invokeSuspend(obj);
            } catch (Throwable th) {
                j.a aVar2 = k8.j.c;
                obj = k8.j.b(k8.k.a(th));
            }
            if (invokeSuspend == p8.c.d()) {
                return;
            }
            obj = k8.j.b(invokeSuspend);
            aVar.releaseIntercepted();
            if (!(dVar2 instanceof a)) {
                dVar2.resumeWith(obj);
                return;
            }
            dVar = dVar2;
        }
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Continuation at ");
        String stackTraceElement = getStackTraceElement();
        if (stackTraceElement == null) {
            stackTraceElement = getClass().getName();
        }
        sb.append(stackTraceElement);
        return sb.toString();
    }

    @NotNull
    public o8.d create(@NotNull o8.d completion) {
        kotlin.jvm.internal.l.e(completion, "completion");
        throw new UnsupportedOperationException("create(Continuation) has not been overridden");
    }

    public void releaseIntercepted() {
    }
}

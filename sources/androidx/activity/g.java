package androidx.activity;

import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import androidx.lifecycle.j;
import androidx.lifecycle.p;
import androidx.lifecycle.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class g extends Dialog implements p, l {

    @Nullable
    private q _lifecycleRegistry;

    @NotNull
    private final OnBackPressedDispatcher onBackPressedDispatcher;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(Context context, int i) {
        super(context, i);
        kotlin.jvm.internal.l.e(context, "context");
        this.onBackPressedDispatcher = new OnBackPressedDispatcher(new f(this));
    }

    public static /* synthetic */ void a(g gVar) {
        c(gVar);
    }

    public static final void c(g gVar) {
        kotlin.jvm.internal.l.e(gVar, "this$0");
        super.onBackPressed();
    }

    public final q b() {
        q qVar = this._lifecycleRegistry;
        if (qVar != null) {
            return qVar;
        }
        q qVar2 = new q(this);
        this._lifecycleRegistry = qVar2;
        return qVar2;
    }

    @NotNull
    public final androidx.lifecycle.j getLifecycle() {
        return b();
    }

    @NotNull
    public final OnBackPressedDispatcher getOnBackPressedDispatcher() {
        return this.onBackPressedDispatcher;
    }

    public void onBackPressed() {
        this.onBackPressedDispatcher.f();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (Build.VERSION.SDK_INT >= 33) {
            this.onBackPressedDispatcher.g(e.a(this));
        }
        b().h(j.b.ON_CREATE);
    }

    public void onStart() {
        super.onStart();
        b().h(j.b.ON_RESUME);
    }

    public void onStop() {
        b().h(j.b.ON_DESTROY);
        this._lifecycleRegistry = null;
        super.onStop();
    }
}

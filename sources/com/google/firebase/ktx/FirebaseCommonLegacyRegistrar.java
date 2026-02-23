package com.google.firebase.ktx;

import androidx.annotation.Keep;
import com.google.firebase.components.ComponentRegistrar;
import java.util.List;
import l8.j;
import org.jetbrains.annotations.NotNull;
import s6.h;

@Keep
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class FirebaseCommonLegacyRegistrar implements ComponentRegistrar {
    @NotNull
    public List getComponents() {
        return j.b(h.b("fire-core-ktx", "20.4.2"));
    }
}

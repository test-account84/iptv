package com.google.android.recaptcha.internal;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import k8.q;
import kotlin.jvm.internal.l;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class zzbd implements InvocationHandler {

    @Nullable
    private final Object zza;

    public zzbd(@Nullable Object obj) {
        this.zza = obj;
    }

    @NotNull
    public final Object invoke(@NotNull Object obj, @NotNull Method method, @Nullable Object[] objArr) {
        Object obj2;
        if (l.a(method.getName(), "toString") && method.getParameterTypes().length == 0) {
            return "Proxy@".concat(String.valueOf(Integer.toHexString(obj.hashCode())));
        }
        if (l.a(method.getName(), "hashCode") && method.getParameterTypes().length == 0) {
            return Integer.valueOf(System.identityHashCode(obj));
        }
        if (l.a(method.getName(), "equals") && method.getParameterTypes().length != 0) {
            boolean z = false;
            if (objArr != null && objArr.length != 0 && objArr[0].hashCode() == obj.hashCode()) {
                z = true;
            }
            return Boolean.valueOf(z);
        }
        if (!zza(obj, method, objArr)) {
            return q.a;
        }
        if ((this.zza == null && l.a(method.getReturnType(), Void.TYPE)) || ((obj2 = this.zza) != null && l.a(zzeg.zza(obj2.getClass()), zzeg.zza(method.getReturnType())))) {
            Object obj3 = this.zza;
            return obj3 == null ? q.a : obj3;
        }
        throw new IllegalArgumentException(this.zza + " cannot be returned from method with return type " + method.getReturnType());
    }

    public abstract boolean zza(@NotNull Object obj, @NotNull Method method, @Nullable Object[] objArr);
}

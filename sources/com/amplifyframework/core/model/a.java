package com.amplifyframework.core.model;

import j$.util.Objects;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract /* synthetic */ class a {
    public static String a(Model model) {
        return model.getClass().getSimpleName();
    }

    public static String b(Model model) {
        try {
            return model.resolveIdentifier() instanceof ModelIdentifier ? ((ModelIdentifier) model.resolveIdentifier()).getIdentifier() : model.resolveIdentifier();
        } catch (Exception e) {
            throw new IllegalStateException("Invalid Primary Key, It should either be of type String or composite Primary Key." + e);
        }
    }

    public static Serializable c(Model model) {
        try {
            Object invoke = model.getClass().getMethod("getId", (Class[]) null).invoke(model, (Object[]) null);
            Objects.requireNonNull(invoke);
            return (Serializable) invoke;
        } catch (InvocationTargetException e) {
            throw new IllegalStateException("Primary key field Id not found.", e);
        } catch (NoSuchMethodException e2) {
            throw new IllegalStateException("Primary key field Id not found.", e2);
        } catch (IllegalAccessException e3) {
            throw new IllegalStateException("Primary key field Id not found.", e3);
        }
    }
}

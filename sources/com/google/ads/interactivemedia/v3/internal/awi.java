package com.google.ads.interactivemedia.v3.internal;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class awi implements Iterator {
    public static final awi a;
    private static final /* synthetic */ awi[] b;

    static {
        awi awiVar = new awi();
        a = awiVar;
        b = new awi[]{awiVar};
    }

    private awi() {
    }

    public static awi[] values() {
        return (awi[]) b.clone();
    }

    public final boolean hasNext() {
        return false;
    }

    public final Object next() {
        throw new NoSuchElementException();
    }

    public final void remove() {
        axo.J(false);
    }
}

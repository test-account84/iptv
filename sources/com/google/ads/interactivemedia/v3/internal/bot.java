package com.google.ads.interactivemedia.v3.internal;

import java.util.NoSuchElementException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class bot extends bou {
    final /* synthetic */ bpb a;
    private int b = 0;
    private final int c;

    public bot(bpb bpbVar) {
        this.a = bpbVar;
        this.c = bpbVar.d();
    }

    public final byte a() {
        int i = this.b;
        if (i >= this.c) {
            throw new NoSuchElementException();
        }
        this.b = i + 1;
        return this.a.b(i);
    }

    public final boolean hasNext() {
        return this.b < this.c;
    }
}

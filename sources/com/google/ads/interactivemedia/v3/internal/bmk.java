package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;
import java.lang.reflect.Field;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class bmk {
    final String a;
    final boolean b;
    final boolean c;
    final /* synthetic */ boolean d;
    final /* synthetic */ Field e;
    final /* synthetic */ boolean f;
    final /* synthetic */ bkl g;
    final /* synthetic */ bjt h;
    final /* synthetic */ bof i;
    final /* synthetic */ boolean j;

    public bmk(String str, boolean z, boolean z2) {
        this.a = str;
        this.b = z;
        this.c = z2;
    }

    public final void a(boh bohVar, Object obj) throws IOException, IllegalAccessException {
        Object read = this.g.read(bohVar);
        if (read == null && this.j) {
            return;
        }
        if (this.d) {
            bml.b(obj, this.e);
        }
        this.e.set(obj, read);
    }

    public final void b(boj bojVar, Object obj) throws IOException, IllegalAccessException {
        if (this.b) {
            if (this.d) {
                bml.b(obj, this.e);
            }
            Object obj2 = this.e.get(obj);
            if (obj2 == obj) {
                return;
            }
            bojVar.f(this.a);
            (this.f ? this.g : new bmp(this.h, this.g, this.i.d())).write(bojVar, obj2);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public bmk(String str, boolean z, boolean z2, boolean z3, Field field, boolean z4, bkl bklVar, bjt bjtVar, bof bofVar, boolean z5) {
        this(str, z, z2);
        this.d = z3;
        this.e = field;
        this.f = z4;
        this.g = bklVar;
        this.h = bjtVar;
        this.i = bofVar;
        this.j = z5;
    }
}

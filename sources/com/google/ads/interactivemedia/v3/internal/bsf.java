package com.google.ads.interactivemedia.v3.internal;

import java.util.ArrayDeque;
import java.util.Arrays;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class bsf {
    private final ArrayDeque a = new ArrayDeque();

    private bsf() {
    }

    public static /* bridge */ /* synthetic */ bpb a(bsf bsfVar, bpb bpbVar, bpb bpbVar2) {
        bsfVar.b(bpbVar);
        bsfVar.b(bpbVar2);
        bpb bpbVar3 = (bpb) bsfVar.a.pop();
        while (!bsfVar.a.isEmpty()) {
            bpbVar3 = new bsh((bpb) bsfVar.a.pop(), bpbVar3, null);
        }
        return bpbVar3;
    }

    private final void b(bpb bpbVar) {
        if (!bpbVar.h()) {
            if (!(bpbVar instanceof bsh)) {
                throw new IllegalArgumentException("Has a new type of ByteString been created? Found ".concat(String.valueOf(bpbVar.getClass())));
            }
            bsh bshVar = (bsh) bpbVar;
            b(bsh.g(bshVar));
            b(bsh.D(bshVar));
            return;
        }
        int c = c(bpbVar.d());
        int c2 = bsh.c(c + 1);
        if (this.a.isEmpty() || ((bpb) this.a.peek()).d() >= c2) {
            this.a.push(bpbVar);
            return;
        }
        int c3 = bsh.c(c);
        bpb bpbVar2 = (bpb) this.a.pop();
        while (!this.a.isEmpty() && ((bpb) this.a.peek()).d() < c3) {
            bpbVar2 = new bsh((bpb) this.a.pop(), bpbVar2, null);
        }
        bsh bshVar2 = new bsh(bpbVar2, bpbVar, null);
        while (!this.a.isEmpty()) {
            if (((bpb) this.a.peek()).d() >= bsh.c(c(bshVar2.d()) + 1)) {
                break;
            } else {
                bshVar2 = new bsh((bpb) this.a.pop(), bshVar2, null);
            }
        }
        this.a.push(bshVar2);
    }

    private static final int c(int i) {
        int binarySearch = Arrays.binarySearch(bsh.a, i);
        return binarySearch < 0 ? (-(binarySearch + 1)) - 1 : binarySearch;
    }

    public /* synthetic */ bsf(byte[] bArr) {
    }
}

package com.google.ads.interactivemedia.v3.internal;

import java.net.InetAddress;
import java.net.URI;
import java.net.URL;
import java.util.BitSet;
import java.util.Calendar;
import java.util.Currency;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class bnw {
    public static final bkm A;
    public static final bkl B;
    public static final bkm C;
    public static final bkl D;
    public static final bkm E;
    public static final bkl F;
    public static final bkm G;
    public static final bkl H;
    public static final bkm I;
    public static final bkl J;
    public static final bkm K;
    public static final bkl L;
    public static final bkm M;
    public static final bkl N;
    public static final bkm O;
    public static final bkl P;
    public static final bkm Q;
    public static final bkl R;
    public static final bkm S;
    public static final bkl T;
    public static final bkm U;
    public static final bkm V;
    public static final bkl a;
    public static final bkm b;
    public static final bkl c;
    public static final bkm d;
    public static final bkl e;
    public static final bkl f;
    public static final bkm g;
    public static final bkl h;
    public static final bkm i;
    public static final bkl j;
    public static final bkm k;
    public static final bkl l;
    public static final bkm m;
    public static final bkl n;
    public static final bkm o;
    public static final bkl p;
    public static final bkm q;
    public static final bkl r;
    public static final bkm s;
    public static final bkl t;
    public static final bkl u;
    public static final bkm v;
    public static final bkl w;
    public static final bkl x;
    public static final bkl y;
    public static final bkl z;

    static {
        bkl nullSafe = new bmy().nullSafe();
        a = nullSafe;
        b = b(Class.class, nullSafe);
        bkl nullSafe2 = new bni().nullSafe();
        c = nullSafe2;
        d = b(BitSet.class, nullSafe2);
        bnn bnnVar = new bnn();
        e = bnnVar;
        f = new bno();
        g = c(Boolean.TYPE, Boolean.class, bnnVar);
        bnp bnpVar = new bnp();
        h = bnpVar;
        i = c(Byte.TYPE, Byte.class, bnpVar);
        bnq bnqVar = new bnq();
        j = bnqVar;
        k = c(Short.TYPE, Short.class, bnqVar);
        bnr bnrVar = new bnr();
        l = bnrVar;
        m = c(Integer.TYPE, Integer.class, bnrVar);
        bkl nullSafe3 = new bns().nullSafe();
        n = nullSafe3;
        o = b(AtomicInteger.class, nullSafe3);
        bkl nullSafe4 = new bnt().nullSafe();
        p = nullSafe4;
        q = b(AtomicBoolean.class, nullSafe4);
        bkl nullSafe5 = new bmq().nullSafe();
        r = nullSafe5;
        s = b(AtomicIntegerArray.class, nullSafe5);
        t = new bmr();
        bms bmsVar = new bms();
        u = bmsVar;
        v = c(Character.TYPE, Character.class, bmsVar);
        bmt bmtVar = new bmt();
        w = bmtVar;
        x = new bmu();
        y = new bmv();
        z = new bmw();
        A = b(String.class, bmtVar);
        bmx bmxVar = new bmx();
        B = bmxVar;
        C = b(StringBuilder.class, bmxVar);
        bmz bmzVar = new bmz();
        D = bmzVar;
        E = b(StringBuffer.class, bmzVar);
        bna bnaVar = new bna();
        F = bnaVar;
        G = b(URL.class, bnaVar);
        bnb bnbVar = new bnb();
        H = bnbVar;
        I = b(URI.class, bnbVar);
        bnc bncVar = new bnc();
        J = bncVar;
        K = d(InetAddress.class, bncVar);
        bnd bndVar = new bnd();
        L = bndVar;
        M = b(UUID.class, bndVar);
        bkl nullSafe6 = new bne().nullSafe();
        N = nullSafe6;
        O = b(Currency.class, nullSafe6);
        bnf bnfVar = new bnf();
        P = bnfVar;
        Q = new bnk(Calendar.class, GregorianCalendar.class, bnfVar, 0);
        bng bngVar = new bng();
        R = bngVar;
        S = b(Locale.class, bngVar);
        bnh bnhVar = new bnh();
        T = bnhVar;
        U = d(bjy.class, bnhVar);
        V = new blw(2);
    }

    public static bkm a(bof bofVar, bkl bklVar) {
        return new bnj(bofVar, bklVar);
    }

    public static bkm b(Class cls, bkl bklVar) {
        return new bnm(cls, bklVar, 1);
    }

    public static bkm c(Class cls, Class cls2, bkl bklVar) {
        return new bnk(cls, cls2, bklVar, 1, null);
    }

    public static bkm d(Class cls, bkl bklVar) {
        return new bnm(cls, bklVar, 0);
    }
}

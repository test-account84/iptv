package com.nst.iptvsmarterstvbox.sbpfunction.singletonpushnotification;

import java.util.ArrayList;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class Listsingleton {
    public static final Listsingleton e = new Listsingleton();
    public List a = new ArrayList();
    public List b = new ArrayList();
    public List c = new ArrayList();
    public List d = new ArrayList();

    public static Listsingleton b() {
        return e;
    }

    public List a() {
        return this.a;
    }

    public List c() {
        return this.b;
    }

    public void d(List list) {
        this.a = list;
    }

    public void e(List list) {
        this.d = list;
    }

    public void f(List list) {
        this.b = list;
    }
}

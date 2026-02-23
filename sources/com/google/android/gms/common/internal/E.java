package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.view.View;
import com.google.android.gms.common.api.GoogleApiClient;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class e {
    public final Account a;
    public final Set b;
    public final Set c;
    public final Map d;
    public final int e;
    public final View f;
    public final String g;
    public final String h;
    public final O4.a i;
    public Integer j;

    public static final class a {
        public Account a;
        public s.b b;
        public String c;
        public String d;
        public final O4.a e = O4.a.k;

        public e a() {
            return new e(this.a, this.b, null, 0, null, this.c, this.d, this.e, false);
        }

        public a b(String str) {
            this.c = str;
            return this;
        }

        public final a c(Collection collection) {
            if (this.b == null) {
                this.b = new s.b();
            }
            this.b.addAll(collection);
            return this;
        }

        public final a d(Account account) {
            this.a = account;
            return this;
        }

        public final a e(String str) {
            this.d = str;
            return this;
        }
    }

    public e(Account account, Set set, Map map, int i, View view, String str, String str2, O4.a aVar, boolean z) {
        this.a = account;
        Set emptySet = set == null ? Collections.emptySet() : Collections.unmodifiableSet(set);
        this.b = emptySet;
        map = map == null ? Collections.emptyMap() : map;
        this.d = map;
        this.f = view;
        this.e = i;
        this.g = str;
        this.h = str2;
        this.i = aVar == null ? O4.a.k : aVar;
        HashSet hashSet = new HashSet(emptySet);
        Iterator it = map.values().iterator();
        if (it.hasNext()) {
            d.D.a(it.next());
            throw null;
        }
        this.c = Collections.unmodifiableSet(hashSet);
    }

    public static e a(Context context) {
        return new GoogleApiClient.a(context).f();
    }

    public Account b() {
        return this.a;
    }

    public Account c() {
        Account account = this.a;
        return account != null ? account : new Account("<<default account>>", "com.google");
    }

    public Set d() {
        return this.c;
    }

    public String e() {
        return this.g;
    }

    public Set f() {
        return this.b;
    }

    public final O4.a g() {
        return this.i;
    }

    public final Integer h() {
        return this.j;
    }

    public final String i() {
        return this.h;
    }

    public final Map j() {
        return this.d;
    }

    public final void k(Integer num) {
        this.j = num;
    }
}

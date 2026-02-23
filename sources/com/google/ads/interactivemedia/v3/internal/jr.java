package com.google.ads.interactivemedia.v3.internal;

import android.annotation.TargetApi;
import android.media.AudioTrack;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class jr {
    private final jq a;
    private int b;
    private long c;
    private long d;
    private long e;
    private long f;

    public jr(AudioTrack audioTrack) {
        if (cq.a >= 19) {
            this.a = new jq(audioTrack);
            e();
        } else {
            this.a = null;
            h(3);
        }
    }

    private final void h(int i) {
        this.b = i;
        long j = 10000;
        if (i == 0) {
            this.e = 0L;
            this.f = -1L;
            this.c = System.nanoTime() / 1000;
        } else {
            if (i == 1) {
                this.d = 10000L;
                return;
            }
            j = (i == 2 || i == 3) ? 10000000L : 500000L;
        }
        this.d = j;
    }

    @TargetApi(19)
    public final long a() {
        jq jqVar = this.a;
        if (jqVar != null) {
            return jqVar.a();
        }
        return -1L;
    }

    @TargetApi(19)
    public final long b() {
        jq jqVar = this.a;
        if (jqVar != null) {
            return jqVar.b();
        }
        return -9223372036854775807L;
    }

    public final void c() {
        if (this.b == 4) {
            e();
        }
    }

    public final void d() {
        h(4);
    }

    public final void e() {
        if (this.a != null) {
            h(0);
        }
    }

    public final boolean f() {
        return this.b == 2;
    }

    @TargetApi(19)
    public final boolean g(long j) {
        jq jqVar = this.a;
        if (jqVar != null && j - this.e >= this.d) {
            this.e = j;
            boolean c = jqVar.c();
            int i = this.b;
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        if (i == 3 && c) {
                            e();
                            return true;
                        }
                    } else if (!c) {
                        e();
                        return false;
                    }
                } else if (!c) {
                    e();
                } else if (this.a.a() > this.f) {
                    h(2);
                    return true;
                }
            } else {
                if (c) {
                    if (this.a.b() < this.c) {
                        return false;
                    }
                    this.f = this.a.a();
                    h(1);
                    return true;
                }
                if (j - this.c > 500000) {
                    h(3);
                }
            }
            return c;
        }
        return false;
    }
}

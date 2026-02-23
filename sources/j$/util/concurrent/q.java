package j$.util.concurrent;

import java.util.concurrent.locks.LockSupport;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
final class q extends l {
    private static final j$.sun.misc.a h;
    private static final long i;
    r e;
    volatile r f;
    volatile Thread g;
    volatile int lockState;

    static {
        j$.sun.misc.a h2 = j$.sun.misc.a.h();
        h = h2;
        i = h2.j(q.class, "lockState");
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x004b A[PHI: r7
      0x004b: PHI (r7v3 java.lang.Class) = (r7v2 java.lang.Class), (r7v4 java.lang.Class) binds: [B:34:0x0049, B:27:0x0033] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    q(j$.util.concurrent.r r11) {
        /*
            r10 = this;
            r0 = -2
            r1 = 0
            r10.<init>(r0, r1, r1)
            r10.f = r11
            r0 = r1
        L8:
            if (r11 == 0) goto L6c
            j$.util.concurrent.l r2 = r11.d
            j$.util.concurrent.r r2 = (j$.util.concurrent.r) r2
            r11.g = r1
            r11.f = r1
            r3 = 0
            if (r0 != 0) goto L1b
            r11.e = r1
            r11.i = r3
        L19:
            r0 = r11
            goto L68
        L1b:
            java.lang.Object r4 = r11.b
            int r5 = r11.a
            r6 = r0
            r7 = r1
        L21:
            java.lang.Object r8 = r6.b
            int r9 = r6.a
            if (r9 <= r5) goto L29
            r8 = -1
            goto L51
        L29:
            if (r9 >= r5) goto L2d
            r8 = 1
            goto L51
        L2d:
            if (r7 != 0) goto L35
            java.lang.Class r7 = j$.util.concurrent.ConcurrentHashMap.c(r4)
            if (r7 == 0) goto L4b
        L35:
            int r9 = j$.util.concurrent.ConcurrentHashMap.g
            if (r8 == 0) goto L48
            java.lang.Class r9 = r8.getClass()
            if (r9 == r7) goto L40
            goto L48
        L40:
            r9 = r4
            java.lang.Comparable r9 = (java.lang.Comparable) r9
            int r9 = r9.compareTo(r8)
            goto L49
        L48:
            r9 = 0
        L49:
            if (r9 != 0) goto L50
        L4b:
            int r8 = i(r4, r8)
            goto L51
        L50:
            r8 = r9
        L51:
            if (r8 > 0) goto L56
            j$.util.concurrent.r r9 = r6.f
            goto L58
        L56:
            j$.util.concurrent.r r9 = r6.g
        L58:
            if (r9 != 0) goto L6a
            r11.e = r6
            if (r8 > 0) goto L61
            r6.f = r11
            goto L63
        L61:
            r6.g = r11
        L63:
            j$.util.concurrent.r r11 = c(r0, r11)
            goto L19
        L68:
            r11 = r2
            goto L8
        L6a:
            r6 = r9
            goto L21
        L6c:
            r10.e = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.util.concurrent.q.<init>(j$.util.concurrent.r):void");
    }

    static r b(r rVar, r rVar2) {
        while (rVar2 != null && rVar2 != rVar) {
            r rVar3 = rVar2.e;
            if (rVar3 == null) {
                rVar2.i = false;
                return rVar2;
            }
            if (rVar2.i) {
                rVar2.i = false;
                return rVar;
            }
            r rVar4 = rVar3.f;
            if (rVar4 == rVar2) {
                rVar4 = rVar3.g;
                if (rVar4 != null && rVar4.i) {
                    rVar4.i = false;
                    rVar3.i = true;
                    rVar = g(rVar, rVar3);
                    rVar3 = rVar2.e;
                    rVar4 = rVar3 == null ? null : rVar3.g;
                }
                if (rVar4 == null) {
                    rVar2 = rVar3;
                } else {
                    r rVar5 = rVar4.f;
                    r rVar6 = rVar4.g;
                    if ((rVar6 != null && rVar6.i) || (rVar5 != null && rVar5.i)) {
                        if (rVar6 == null || !rVar6.i) {
                            if (rVar5 != null) {
                                rVar5.i = false;
                            }
                            rVar4.i = true;
                            rVar = h(rVar, rVar4);
                            rVar3 = rVar2.e;
                            rVar4 = rVar3 != null ? rVar3.g : null;
                        }
                        if (rVar4 != null) {
                            rVar4.i = rVar3 == null ? false : rVar3.i;
                            r rVar7 = rVar4.g;
                            if (rVar7 != null) {
                                rVar7.i = false;
                            }
                        }
                        if (rVar3 != null) {
                            rVar3.i = false;
                            rVar = g(rVar, rVar3);
                        }
                        rVar2 = rVar;
                    }
                    rVar4.i = true;
                    rVar2 = rVar3;
                }
            } else {
                if (rVar4 != null && rVar4.i) {
                    rVar4.i = false;
                    rVar3.i = true;
                    rVar = h(rVar, rVar3);
                    rVar3 = rVar2.e;
                    rVar4 = rVar3 == null ? null : rVar3.f;
                }
                if (rVar4 == null) {
                    rVar2 = rVar3;
                } else {
                    r rVar8 = rVar4.f;
                    r rVar9 = rVar4.g;
                    if ((rVar8 != null && rVar8.i) || (rVar9 != null && rVar9.i)) {
                        if (rVar8 == null || !rVar8.i) {
                            if (rVar9 != null) {
                                rVar9.i = false;
                            }
                            rVar4.i = true;
                            rVar = g(rVar, rVar4);
                            rVar3 = rVar2.e;
                            rVar4 = rVar3 != null ? rVar3.f : null;
                        }
                        if (rVar4 != null) {
                            rVar4.i = rVar3 == null ? false : rVar3.i;
                            r rVar10 = rVar4.f;
                            if (rVar10 != null) {
                                rVar10.i = false;
                            }
                        }
                        if (rVar3 != null) {
                            rVar3.i = false;
                            rVar = h(rVar, rVar3);
                        }
                        rVar2 = rVar;
                    }
                    rVar4.i = true;
                    rVar2 = rVar3;
                }
            }
        }
        return rVar;
    }

    static r c(r rVar, r rVar2) {
        r rVar3;
        rVar2.i = true;
        while (true) {
            r rVar4 = rVar2.e;
            if (rVar4 == null) {
                rVar2.i = false;
                return rVar2;
            }
            if (!rVar4.i || (rVar3 = rVar4.e) == null) {
                break;
            }
            r rVar5 = rVar3.f;
            if (rVar4 == rVar5) {
                rVar5 = rVar3.g;
                if (rVar5 == null || !rVar5.i) {
                    if (rVar2 == rVar4.g) {
                        rVar = g(rVar, rVar4);
                        r rVar6 = rVar4.e;
                        rVar3 = rVar6 == null ? null : rVar6.e;
                        rVar4 = rVar6;
                        rVar2 = rVar4;
                    }
                    if (rVar4 != null) {
                        rVar4.i = false;
                        if (rVar3 != null) {
                            rVar3.i = true;
                            rVar = h(rVar, rVar3);
                        }
                    }
                } else {
                    rVar5.i = false;
                    rVar4.i = false;
                    rVar3.i = true;
                    rVar2 = rVar3;
                }
            } else if (rVar5 == null || !rVar5.i) {
                if (rVar2 == rVar4.f) {
                    rVar = h(rVar, rVar4);
                    r rVar7 = rVar4.e;
                    rVar3 = rVar7 == null ? null : rVar7.e;
                    rVar4 = rVar7;
                    rVar2 = rVar4;
                }
                if (rVar4 != null) {
                    rVar4.i = false;
                    if (rVar3 != null) {
                        rVar3.i = true;
                        rVar = g(rVar, rVar3);
                    }
                }
            } else {
                rVar5.i = false;
                rVar4.i = false;
                rVar3.i = true;
                rVar2 = rVar3;
            }
        }
        return rVar;
    }

    private final void d() {
        if (h.c(this, i, 0, 1)) {
            return;
        }
        boolean z = false;
        while (true) {
            int i2 = this.lockState;
            if ((i2 & (-3)) == 0) {
                if (h.c(this, i, i2, 1)) {
                    break;
                }
            } else if ((i2 & 2) == 0) {
                if (h.c(this, i, i2, i2 | 2)) {
                    this.g = Thread.currentThread();
                    z = true;
                }
            } else if (z) {
                LockSupport.park(this);
            }
        }
        if (z) {
            this.g = null;
        }
    }

    static r g(r rVar, r rVar2) {
        r rVar3;
        if (rVar2 != null && (rVar3 = rVar2.g) != null) {
            r rVar4 = rVar3.f;
            rVar2.g = rVar4;
            if (rVar4 != null) {
                rVar4.e = rVar2;
            }
            r rVar5 = rVar2.e;
            rVar3.e = rVar5;
            if (rVar5 == null) {
                rVar3.i = false;
                rVar = rVar3;
            } else if (rVar5.f == rVar2) {
                rVar5.f = rVar3;
            } else {
                rVar5.g = rVar3;
            }
            rVar3.f = rVar2;
            rVar2.e = rVar3;
        }
        return rVar;
    }

    static r h(r rVar, r rVar2) {
        r rVar3;
        if (rVar2 != null && (rVar3 = rVar2.f) != null) {
            r rVar4 = rVar3.g;
            rVar2.f = rVar4;
            if (rVar4 != null) {
                rVar4.e = rVar2;
            }
            r rVar5 = rVar2.e;
            rVar3.e = rVar5;
            if (rVar5 == null) {
                rVar3.i = false;
                rVar = rVar3;
            } else if (rVar5.g == rVar2) {
                rVar5.g = rVar3;
            } else {
                rVar5.f = rVar3;
            }
            rVar3.g = rVar2;
            rVar2.e = rVar3;
        }
        return rVar;
    }

    static int i(Object obj, Object obj2) {
        int compareTo;
        return (obj == null || obj2 == null || (compareTo = obj.getClass().getName().compareTo(obj2.getClass().getName())) == 0) ? System.identityHashCode(obj) <= System.identityHashCode(obj2) ? -1 : 1 : compareTo;
    }

    final l a(Object obj, int i2) {
        Object obj2;
        Thread thread;
        Thread thread2;
        r rVar = null;
        if (obj != null) {
            l lVar = this.f;
            while (lVar != null) {
                int i3 = this.lockState;
                if ((i3 & 3) == 0) {
                    j$.sun.misc.a aVar = h;
                    long j = i;
                    if (aVar.c(this, j, i3, i3 + 4)) {
                        try {
                            r rVar2 = this.e;
                            if (rVar2 != null) {
                                rVar = rVar2.b(i2, obj, null);
                            }
                            if (aVar.f(this, j) == 6 && (thread2 = this.g) != null) {
                                LockSupport.unpark(thread2);
                            }
                            return rVar;
                        } catch (Throwable th) {
                            if (h.f(this, i) == 6 && (thread = this.g) != null) {
                                LockSupport.unpark(thread);
                            }
                            throw th;
                        }
                    }
                } else {
                    if (lVar.a == i2 && ((obj2 = lVar.b) == obj || (obj2 != null && obj.equals(obj2)))) {
                        return lVar;
                    }
                    lVar = lVar.d;
                }
            }
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x00b3, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0070, code lost:
    
        return r3;
     */
    /* JADX WARN: Removed duplicated region for block: B:43:0x005a A[PHI: r2
      0x005a: PHI (r2v5 java.lang.Class) = (r2v4 java.lang.Class), (r2v6 java.lang.Class) binds: [B:62:0x0058, B:42:0x0042] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    final j$.util.concurrent.r e(int r16, java.lang.Object r17, java.lang.Object r18) {
        /*
            Method dump skipped, instructions count: 188
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.util.concurrent.q.e(int, java.lang.Object, java.lang.Object):j$.util.concurrent.r");
    }

    /* JADX WARN: Removed duplicated region for block: B:67:0x008e A[PHI: r0
      0x008e: PHI (r0v4 j$.util.concurrent.r) = (r0v3 j$.util.concurrent.r), (r0v12 j$.util.concurrent.r) binds: [B:81:0x008a, B:38:0x0083] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    final boolean f(j$.util.concurrent.r r11) {
        /*
            Method dump skipped, instructions count: 207
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.util.concurrent.q.f(j$.util.concurrent.r):boolean");
    }
}

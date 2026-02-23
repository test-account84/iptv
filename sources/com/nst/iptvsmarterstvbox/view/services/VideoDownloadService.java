package com.nst.iptvsmarterstvbox.view.services;

import A3.g;
import a4.i;
import a7.j;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import com.nst.iptvsmarterstvbox.model.DownloadedDataModel;
import com.nst.iptvsmarterstvbox.model.database.DownloadedDBHandler;
import d4.B;
import d4.k0;
import java.util.ArrayList;
import java.util.List;
import z3.c;
import z3.s;
import z3.u;
import z3.x;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class VideoDownloadService extends x {
    public static Runnable m;
    public static Handler n = new Handler();

    public static final class a implements s.d {
        public final Context a;
        public final i b;
        public int c;

        public class a implements Runnable {
            public final /* synthetic */ c a;
            public final /* synthetic */ s c;

            public a(c cVar, s sVar) {
                this.a = cVar;
                this.c = sVar;
            }

            public void run() {
                VideoDownloadService.F().postDelayed(this, 3000L);
                if (this.a.b == 2) {
                    B.g("sizeISHere", "size:" + this.c.e().size());
                    for (int i = 0; i < this.c.e().size(); i++) {
                        B.g("stateSS:", "state:" + ((c) this.c.e().get(i)).b);
                        if (((c) this.c.e().get(i)).b == 2) {
                            String uri = ((c) this.c.e().get(i)).a.c.toString();
                            int b = (int) ((c) this.c.e().get(i)).b();
                            B.g("uriIShere", "uri" + uri + "\npercent" + b);
                            if (b != -1) {
                                try {
                                    DownloadedDBHandler downloadedDBHandler = new DownloadedDBHandler(a.h(a.this));
                                    ArrayList downloadedData = downloadedDBHandler.getDownloadedData();
                                    if (downloadedData.size() > 0) {
                                        int i2 = 0;
                                        while (true) {
                                            if (i2 >= downloadedData.size()) {
                                                break;
                                            }
                                            if (((DownloadedDataModel) downloadedData.get(i2)).getMovieURL().equals(uri)) {
                                                int idAuto = ((DownloadedDataModel) downloadedData.get(i2)).getIdAuto();
                                                ArrayList arrayList = new ArrayList();
                                                DownloadedDataModel downloadedDataModel = new DownloadedDataModel();
                                                downloadedDataModel.setMovieState("Downloading");
                                                downloadedDataModel.setMoviePercentage(b);
                                                arrayList.add(downloadedDataModel);
                                                downloadedDBHandler.updateDownloadedData(arrayList, idAuto);
                                                Intent intent = new Intent("DownloadChecker");
                                                intent.putExtra("status", "downloading");
                                                intent.putExtra("percent", b);
                                                intent.putExtra("url", uri);
                                                p0.a.b(a.h(a.this)).d(intent);
                                                break;
                                            }
                                            i2++;
                                        }
                                    }
                                } catch (Exception unused) {
                                }
                            }
                        }
                    }
                }
            }
        }

        public a(Context context, i iVar, int i) {
            this.a = context.getApplicationContext();
            this.b = iVar;
            this.c = i;
        }

        public static /* synthetic */ Context h(a aVar) {
            return aVar.a;
        }

        /* JADX WARN: Code restructure failed: missing block: B:15:0x0072, code lost:
        
            r7 = new java.util.ArrayList();
            r8 = new com.nst.iptvsmarterstvbox.model.DownloadedDataModel();
            r8.setMovieState("Completed");
            r8.setMoviePercentage(100);
            r7.add(r8);
            r14.updateDownloadedData(r7, ((com.nst.iptvsmarterstvbox.model.DownloadedDataModel) r6.get(r5)).getIdAuto());
            r14 = new android.content.Intent("DownloadChecker");
            r14.putExtra("status", "completed");
            r14.putExtra("percent", 100);
            r14.putExtra("url", r12);
            p0.a.b(r11.a).d(r14);
         */
        /* JADX WARN: Code restructure failed: missing block: B:35:0x00f9, code lost:
        
            r7 = ((com.nst.iptvsmarterstvbox.model.DownloadedDataModel) r6.get(r5)).getMoviePercentage();
            r8 = new java.util.ArrayList();
            r9 = new com.nst.iptvsmarterstvbox.model.DownloadedDataModel();
            r9.setMovieState("Failed");
            r9.setMoviePercentage(r7);
            r8.add(r9);
            r14.updateDownloadedData(r8, ((com.nst.iptvsmarterstvbox.model.DownloadedDataModel) r6.get(r5)).getIdAuto());
            r14 = new android.content.Intent("DownloadChecker");
            r14.putExtra("status", "failed");
            r14.putExtra("percent", r7);
            r14.putExtra("url", r12);
            p0.a.b(r11.a).d(r14);
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void a(z3.s r12, z3.c r13, java.lang.Exception r14) {
            /*
                Method dump skipped, instructions count: 352
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.services.VideoDownloadService.a.a(z3.s, z3.c, java.lang.Exception):void");
        }

        public /* synthetic */ void b(s sVar, A3.c cVar, int i) {
            u.e(this, sVar, cVar, i);
        }

        public /* synthetic */ void c(s sVar) {
            u.c(this, sVar);
        }

        public /* synthetic */ void d(s sVar, c cVar) {
            u.a(this, sVar, cVar);
        }

        public /* synthetic */ void e(s sVar, boolean z) {
            u.b(this, sVar, z);
        }

        public /* synthetic */ void f(s sVar, boolean z) {
            u.f(this, sVar, z);
        }

        public /* synthetic */ void g(s sVar) {
            u.d(this, sVar);
        }
    }

    public VideoDownloadService() {
        super(1, 1000L, "downChannel", j.G, 0);
    }

    public static /* synthetic */ Runnable D() {
        return m;
    }

    public static /* synthetic */ Runnable E(Runnable runnable) {
        m = runnable;
        return runnable;
    }

    public static /* synthetic */ Handler F() {
        return n;
    }

    public s m() {
        s f = B7.a.f(this);
        f.d(new a(this, B7.a.g(this), 2));
        return f;
    }

    public Notification n(List list, int i) {
        return B7.a.g(this).e(this, a7.i.a, (PendingIntent) null, (String) null, list);
    }

    public g q() {
        if (k0.a >= 21) {
            return new A3.a(this, 1);
        }
        return null;
    }
}

package com.nst.iptvsmarterstvbox.miscelleneious;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import com.nst.iptvsmarterstvbox.model.database.SharepreferenceDBHandler;
import com.nst.iptvsmarterstvbox.sbpfunction.adsdatacallback.AdsDataResponse;
import com.nst.iptvsmarterstvbox.sbpfunction.adsdatacallback.DashboardData;
import com.nst.iptvsmarterstvbox.sbpfunction.adsdatacallback.RewardedData;
import com.nst.iptvsmarterstvbox.sbpfunction.maintanencemodel.AdvertismentModel;
import com.nst.iptvsmarterstvbox.sbpfunction.pushnotificationinterface.AdsInterface;
import com.nst.iptvsmarterstvbox.sbpfunction.pushnotificationpresenter.AddSpeedPresenter;
import com.nst.iptvsmarterstvbox.sbpfunction.singletonpushnotification.DashBoardListssingleton;
import com.nst.iptvsmarterstvbox.sbpfunction.singletonpushnotification.Listsingleton;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import m7.w;
import y5.b;
import y5.e;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class ApiCallWorker extends ListenableWorker {
    public Context g;
    public AddSpeedPresenter h;
    public List i;

    public class a implements AdsInterface {
        public final /* synthetic */ e a;

        public a(e eVar) {
            this.a = eVar;
        }

        public void a(AdsDataResponse adsDataResponse) {
            Log.e("jaskirat", "success");
            if (adsDataResponse == null || !adsDataResponse.b().equalsIgnoreCase("success")) {
                Listsingleton.b().d(null);
                SharepreferenceDBHandler.setRewardedImageList(null, ApiCallWorker.s(ApiCallWorker.this));
                SharepreferenceDBHandler.setRewardedTextList(null, ApiCallWorker.s(ApiCallWorker.this));
                Listsingleton.b().f(null);
            } else {
                if (adsDataResponse.c() == null || !adsDataResponse.c().a().equalsIgnoreCase("1")) {
                    Listsingleton.b().d(null);
                    SharepreferenceDBHandler.setRewardedImageList(null, ApiCallWorker.s(ApiCallWorker.this));
                    SharepreferenceDBHandler.setRewardedTextList(null, ApiCallWorker.s(ApiCallWorker.this));
                    Listsingleton.b().f(null);
                } else {
                    SharepreferenceDBHandler.setPrefAdsStatus(adsDataResponse.c().a(), ApiCallWorker.s(ApiCallWorker.this));
                    SharepreferenceDBHandler.setViewableRate(Integer.parseInt(adsDataResponse.c().b()), ApiCallWorker.s(ApiCallWorker.this));
                    m7.a.e1 = SharepreferenceDBHandler.getPrefAdsStatus(ApiCallWorker.s(ApiCallWorker.this));
                    m7.a.f1 = SharepreferenceDBHandler.getViewableRate(ApiCallWorker.s(ApiCallWorker.this));
                    ApiCallWorker.t(ApiCallWorker.this, adsDataResponse);
                }
                if (!m7.a.o.booleanValue()) {
                    if (adsDataResponse.a() == null || !adsDataResponse.a().a().equalsIgnoreCase("1")) {
                        DashBoardListssingleton.b().d(null);
                        DashBoardListssingleton.b().g(null);
                        SharepreferenceDBHandler.setDashboardImageList(null, ApiCallWorker.s(ApiCallWorker.this));
                        SharepreferenceDBHandler.setDashboardTextList(null, ApiCallWorker.s(ApiCallWorker.this));
                    } else {
                        ApiCallWorker.u(ApiCallWorker.this, adsDataResponse);
                    }
                }
            }
            p0.a.b(ApiCallWorker.s(ApiCallWorker.this)).d(new Intent("notification"));
            this.a.v(ListenableWorker.a.c());
        }

        public void b(String str) {
            Log.e("jaskirat", "failure");
            this.a.v(ListenableWorker.a.a());
        }
    }

    public ApiCallWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        this.i = new ArrayList();
        this.g = context;
    }

    public static /* synthetic */ Context s(ApiCallWorker apiCallWorker) {
        return apiCallWorker.g;
    }

    public static /* synthetic */ void t(ApiCallWorker apiCallWorker, AdsDataResponse adsDataResponse) {
        apiCallWorker.w(adsDataResponse);
    }

    public static /* synthetic */ void u(ApiCallWorker apiCallWorker, AdsDataResponse adsDataResponse) {
        apiCallWorker.v(adsDataResponse);
    }

    public b p() {
        e x = e.x();
        this.h = new AddSpeedPresenter(this.g, new a(x));
        String format = new SimpleDateFormat("yyyy-MM").format(new Date());
        r();
        this.h.b(m7.a.S0, m7.a.T0, b7.b.b, format, w.o0(m7.a.S0 + "*Njh0&$@HAH828283636JSJSHS*" + b7.b.b + "*" + format), "get-allcombinedashrequest");
        Log.e("jaskirat", "final exit");
        return x;
    }

    public void r() {
        b7.b.b = String.valueOf(new Random().nextInt(8378600) + 10000);
    }

    public final void v(AdsDataResponse adsDataResponse) {
        List list;
        ArrayList arrayList = null;
        if (adsDataResponse.a().b() == null || adsDataResponse.a().c() == null || adsDataResponse.a().c().intValue() <= 0 || adsDataResponse.a().b().size() <= 0) {
            DashBoardListssingleton.b().d(null);
            SharepreferenceDBHandler.setDashboardTextList(null, this.g);
            SharepreferenceDBHandler.setDashboardImageList(null, this.g);
        } else {
            DashBoardListssingleton.b().d(null);
            DashBoardListssingleton.b().g(null);
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            ArrayList arrayList4 = new ArrayList();
            ArrayList arrayList5 = new ArrayList();
            List b = adsDataResponse.a().b();
            int i = 0;
            while (i < b.size()) {
                if (((DashboardData) b.get(i)).b() == null || !((DashboardData) b.get(i)).b().equalsIgnoreCase("dashboard")) {
                    list = b;
                } else {
                    DashboardData dashboardData = (DashboardData) b.get(i);
                    String e = dashboardData.e();
                    if (e != null && e.equalsIgnoreCase("image")) {
                        String b2 = dashboardData.b();
                        dashboardData.e();
                        String c = dashboardData.c();
                        List a2 = dashboardData.a();
                        int i2 = 0;
                        while (i2 < a2.size()) {
                            String str = (String) a2.get(i2);
                            AdvertismentModel advertismentModel = new AdvertismentModel();
                            advertismentModel.e(e);
                            advertismentModel.c(b2);
                            advertismentModel.a(str);
                            advertismentModel.b("");
                            advertismentModel.d(c);
                            this.i.add(advertismentModel);
                            arrayList4.add(c);
                            arrayList2.add(str);
                            i2++;
                            b = b;
                        }
                    }
                    list = b;
                    String b3 = dashboardData.b();
                    String e2 = dashboardData.e();
                    String d = dashboardData.d();
                    String c2 = dashboardData.c();
                    AdvertismentModel advertismentModel2 = new AdvertismentModel();
                    advertismentModel2.e(e2);
                    advertismentModel2.c(b3);
                    advertismentModel2.a("");
                    advertismentModel2.b(d);
                    advertismentModel2.d(c2);
                    this.i.add(advertismentModel2);
                    arrayList5.add(c2);
                    arrayList3.add(d);
                }
                i++;
                b = list;
            }
            if (arrayList2.size() > 0) {
                SharepreferenceDBHandler.setDashboardImageList(arrayList2, this.g);
                arrayList = null;
            } else {
                arrayList = null;
                DashBoardListssingleton.b().d(null);
                SharepreferenceDBHandler.setDashboardImageList(null, this.g);
            }
            if (arrayList3.size() > 0) {
                SharepreferenceDBHandler.setDashboardTextList(arrayList3, this.g);
                return;
            }
            SharepreferenceDBHandler.setDashboardTextList(arrayList, this.g);
        }
        DashBoardListssingleton.b().g(arrayList);
    }

    public final void w(AdsDataResponse adsDataResponse) {
        ArrayList arrayList;
        if (adsDataResponse.c().d() == null || adsDataResponse.c().d().intValue() <= 0 || adsDataResponse.c().c() == null || adsDataResponse.c().c().size() <= 0) {
            arrayList = null;
            Listsingleton.b().d(null);
            SharepreferenceDBHandler.setRewardedImageList(null, this.g);
        } else {
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            ArrayList arrayList4 = new ArrayList();
            ArrayList arrayList5 = new ArrayList();
            List c = adsDataResponse.c().c();
            for (int i = 0; i < c.size(); i++) {
                if (((RewardedData) c.get(i)).b() != null && ((RewardedData) c.get(i)).b().equalsIgnoreCase("dashboard")) {
                    RewardedData rewardedData = (RewardedData) c.get(i);
                    String e = rewardedData.e();
                    if (e != null && e.equalsIgnoreCase("image")) {
                        String b = rewardedData.b();
                        rewardedData.e();
                        String c2 = rewardedData.c();
                        List a2 = rewardedData.a();
                        for (int i2 = 0; i2 < a2.size(); i2++) {
                            String str = (String) a2.get(i2);
                            AdvertismentModel advertismentModel = new AdvertismentModel();
                            advertismentModel.e(e);
                            advertismentModel.c(b);
                            advertismentModel.a(str);
                            advertismentModel.b("");
                            advertismentModel.d(c2);
                            this.i.add(advertismentModel);
                            arrayList4.add(c2);
                            arrayList2.add(str);
                        }
                    } else if (e != null && e.equalsIgnoreCase("message")) {
                        String b2 = rewardedData.b();
                        String e2 = rewardedData.e();
                        String d = rewardedData.d();
                        String c3 = rewardedData.c();
                        AdvertismentModel advertismentModel2 = new AdvertismentModel();
                        advertismentModel2.e(e2);
                        advertismentModel2.c(b2);
                        advertismentModel2.a("");
                        advertismentModel2.b(d);
                        advertismentModel2.d(c3);
                        this.i.add(advertismentModel2);
                        arrayList5.add(c3);
                        arrayList3.add(d);
                    }
                }
            }
            if (arrayList2.size() > 0) {
                arrayList = null;
                Listsingleton.b().d(null);
                SharepreferenceDBHandler.setRewardedImageList(null, this.g);
                SharepreferenceDBHandler.setRewardedImageList(arrayList2, this.g);
            } else {
                arrayList = null;
                Listsingleton.b().d(null);
                SharepreferenceDBHandler.setRewardedImageList(null, this.g);
            }
            if (arrayList3.size() > 0) {
                SharepreferenceDBHandler.setRewardedTextList(arrayList, this.g);
                Listsingleton.b().f(arrayList);
                SharepreferenceDBHandler.setRewardedTextList(arrayList3, this.g);
                return;
            }
        }
        SharepreferenceDBHandler.setRewardedTextList(arrayList, this.g);
        Listsingleton.b().f(arrayList);
    }
}

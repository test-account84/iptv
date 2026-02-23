package com.nst.iptvsmarterstvbox.miscelleneious;

import android.content.Context;
import android.content.Intent;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import com.nst.iptvsmarterstvbox.model.SbpCombinedResponse.CheckMaintainencemode;
import com.nst.iptvsmarterstvbox.model.SbpCombinedResponse.DashboardData;
import com.nst.iptvsmarterstvbox.model.SbpCombinedResponse.GetAllcombinedashrequest;
import com.nst.iptvsmarterstvbox.model.SbpCombinedResponse.GetAnnouncements;
import com.nst.iptvsmarterstvbox.model.SbpCombinedResponse.GetApkversion;
import com.nst.iptvsmarterstvbox.model.SbpCombinedResponse.GetAppStoragePrefences;
import com.nst.iptvsmarterstvbox.model.SbpCombinedResponse.GetLastupdated;
import com.nst.iptvsmarterstvbox.model.SbpCombinedResponse.RewardedData;
import com.nst.iptvsmarterstvbox.model.SbpCombinedResponse.SbpCombinedResponse;
import com.nst.iptvsmarterstvbox.model.database.SharepreferenceDBHandler;
import com.nst.iptvsmarterstvbox.sbpfunction.maintanencemodel.AdvertismentModel;
import com.nst.iptvsmarterstvbox.sbpfunction.pushnotificationpresenter.FirebasePresenter;
import com.nst.iptvsmarterstvbox.sbpfunction.singletonpushnotification.AnnouncementsSBPSingleton;
import com.nst.iptvsmarterstvbox.sbpfunction.singletonpushnotification.DashBoardListssingleton;
import com.nst.iptvsmarterstvbox.sbpfunction.singletonpushnotification.Listsingleton;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import m7.w;
import retrofit2.Response;
import y5.b;
import y5.e;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class ApiWorkerCombinedRequest extends ListenableWorker {
    public Context g;
    public FirebasePresenter h;
    public List i;

    public class a implements FirebasePresenter.OnCombinedListener {
        public final /* synthetic */ e a;

        public a(e eVar) {
            this.a = eVar;
        }

        public void a() {
            this.a.v(ListenableWorker.a.a());
        }

        public void b(Response response) {
            if (response.body() == null || !response.isSuccessful() || ((SbpCombinedResponse) response.body()).getResult() == null || !((SbpCombinedResponse) response.body()).getResult().equalsIgnoreCase("success") || ((SbpCombinedResponse) response.body()).getSc() == null || ((SbpCombinedResponse) response.body()).getSc().length() <= 0) {
                return;
            }
            ApiWorkerCombinedRequest.s(ApiWorkerCombinedRequest.this, "Api success");
            if (((SbpCombinedResponse) response.body()).getGetAllcombinedashrequest() != null) {
                ApiWorkerCombinedRequest.this.z(((SbpCombinedResponse) response.body()).getGetAllcombinedashrequest());
            }
            if (((SbpCombinedResponse) response.body()).getCheckMaintainencemode() != null) {
                ApiWorkerCombinedRequest.t(ApiWorkerCombinedRequest.this, ((SbpCombinedResponse) response.body()).getCheckMaintainencemode());
            }
            if (((SbpCombinedResponse) response.body()).getGetAnnouncements() != null) {
                ApiWorkerCombinedRequest.u(ApiWorkerCombinedRequest.this, ((SbpCombinedResponse) response.body()).getGetAnnouncements());
            }
            if (((SbpCombinedResponse) response.body()).getGetAppStoragePrefences() != null) {
                ApiWorkerCombinedRequest.v(ApiWorkerCombinedRequest.this, ((SbpCombinedResponse) response.body()).getGetAppStoragePrefences());
            }
            if (((SbpCombinedResponse) response.body()).getGetLastupdated() == null || ((SbpCombinedResponse) response.body()).getGetLastupdated().getNextrequest() == null || ((SbpCombinedResponse) response.body()).getGetLastupdated().getNextrequest().length() <= 0) {
                SharepreferenceDBHandler.setLastUpdate(24, ApiWorkerCombinedRequest.x(ApiWorkerCombinedRequest.this));
                SharepreferenceDBHandler.setLastUpdateTime(w.p(), ApiWorkerCombinedRequest.x(ApiWorkerCombinedRequest.this));
            } else {
                ApiWorkerCombinedRequest.w(ApiWorkerCombinedRequest.this, ((SbpCombinedResponse) response.body()).getGetLastupdated());
            }
            if (((SbpCombinedResponse) response.body()).getGetApkversion() != null) {
                ApiWorkerCombinedRequest.y(ApiWorkerCombinedRequest.this, ((SbpCombinedResponse) response.body()).getGetApkversion());
            }
            ApiWorkerCombinedRequest.s(ApiWorkerCombinedRequest.this, "Result.success()");
            this.a.v(ListenableWorker.a.c());
        }
    }

    public ApiWorkerCombinedRequest(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        this.i = new ArrayList();
        this.g = context;
    }

    public static /* synthetic */ void s(ApiWorkerCombinedRequest apiWorkerCombinedRequest, String str) {
        apiWorkerCombinedRequest.H(str);
    }

    public static /* synthetic */ void t(ApiWorkerCombinedRequest apiWorkerCombinedRequest, CheckMaintainencemode checkMaintainencemode) {
        apiWorkerCombinedRequest.F(checkMaintainencemode);
    }

    public static /* synthetic */ void u(ApiWorkerCombinedRequest apiWorkerCombinedRequest, GetAnnouncements getAnnouncements) {
        apiWorkerCombinedRequest.A(getAnnouncements);
    }

    public static /* synthetic */ void v(ApiWorkerCombinedRequest apiWorkerCombinedRequest, GetAppStoragePrefences getAppStoragePrefences) {
        apiWorkerCombinedRequest.C(getAppStoragePrefences);
    }

    public static /* synthetic */ void w(ApiWorkerCombinedRequest apiWorkerCombinedRequest, GetLastupdated getLastupdated) {
        apiWorkerCombinedRequest.E(getLastupdated);
    }

    public static /* synthetic */ Context x(ApiWorkerCombinedRequest apiWorkerCombinedRequest) {
        return apiWorkerCombinedRequest.g;
    }

    public static /* synthetic */ void y(ApiWorkerCombinedRequest apiWorkerCombinedRequest, GetApkversion getApkversion) {
        apiWorkerCombinedRequest.B(getApkversion);
    }

    public final void A(GetAnnouncements getAnnouncements) {
        try {
            if (getAnnouncements.getTotalrecords() == null || getAnnouncements.getData() == null || getAnnouncements.getData().size() <= 0) {
                SharepreferenceDBHandler.setAnnouncementsList(null, this.g);
                AnnouncementsSBPSingleton.b().c(null);
            } else {
                AnnouncementsSBPSingleton.b().c(getAnnouncements.getData());
                SharepreferenceDBHandler.setAnnouncementsList(getAnnouncements.getData(), this.g);
            }
            p0.a.b(this.g).d(new Intent("notification").putExtra("noti_announcements", "announcement"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        H("setAnnouncementsData");
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x006c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void B(com.nst.iptvsmarterstvbox.model.SbpCombinedResponse.GetApkversion r6) {
        /*
            r5 = this;
            java.lang.String r0 = ""
            com.nst.iptvsmarterstvbox.model.SbpCombinedResponse.GetApkData r1 = r6.getData()     // Catch: java.lang.Exception -> L20
            java.lang.String r1 = r1.getAppversion()     // Catch: java.lang.Exception -> L20
            com.nst.iptvsmarterstvbox.model.SbpCombinedResponse.GetApkData r2 = r6.getData()     // Catch: java.lang.Exception -> L1d
            java.lang.String r2 = r2.getApkversionname()     // Catch: java.lang.Exception -> L1d
            com.nst.iptvsmarterstvbox.model.SbpCombinedResponse.GetApkData r6 = r6.getData()     // Catch: java.lang.Exception -> L1b
            java.lang.String r6 = r6.getAppdownloadlink()     // Catch: java.lang.Exception -> L1b
            goto L27
        L1b:
            r6 = move-exception
            goto L23
        L1d:
            r6 = move-exception
            r2 = r0
            goto L23
        L20:
            r6 = move-exception
            r1 = r0
            r2 = r1
        L23:
            r6.printStackTrace()
            r6 = r0
        L27:
            if (r1 == 0) goto L6c
            int r3 = r1.length()
            if (r3 <= 0) goto L6c
            java.lang.String r3 = "."
            boolean r3 = r1.contains(r3)
            if (r3 != 0) goto L73
            int r3 = java.lang.Integer.parseInt(r1)
            r4 = 108(0x6c, float:1.51E-43)
            if (r3 <= r4) goto L5e
            android.content.Context r0 = r5.a()
            com.nst.iptvsmarterstvbox.model.database.SharepreferenceDBHandler.setUpdateVersionCode(r0, r1, r6, r2)
            android.content.Intent r6 = new android.content.Intent
            java.lang.String r0 = "notification"
            r6.<init>(r0)
            java.lang.String r0 = "app_version"
            java.lang.String r1 = "appversion"
            r6.putExtra(r0, r1)
            android.content.Context r0 = r5.g
            p0.a r0 = p0.a.b(r0)
            r0.d(r6)
            goto L73
        L5e:
            android.content.Context r6 = r5.a()
            java.lang.String r1 = java.lang.String.valueOf(r4)
            java.lang.String r2 = "5.0"
            com.nst.iptvsmarterstvbox.model.database.SharepreferenceDBHandler.setUpdateVersionCode(r6, r1, r0, r2)
            goto L73
        L6c:
            android.content.Context r6 = r5.a()
            com.nst.iptvsmarterstvbox.model.database.SharepreferenceDBHandler.setUpdateVersionCode(r6, r0, r0, r0)
        L73:
            java.lang.String r6 = "setApkVersionData"
            r5.H(r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.miscelleneious.ApiWorkerCombinedRequest.B(com.nst.iptvsmarterstvbox.model.SbpCombinedResponse.GetApkversion):void");
    }

    public final void C(GetAppStoragePrefences getAppStoragePrefences) {
        Intent intent;
        String str;
        if (getAppStoragePrefences.getData().getMode().equalsIgnoreCase("1")) {
            if (SharepreferenceDBHandler.isLocalDb(this.g)) {
                SharepreferenceDBHandler.setLocalDb(this.g, false);
                intent = new Intent("notification");
                str = "firebase";
                intent.putExtra("notification_popup", str);
                p0.a.b(this.g).d(intent);
            }
        } else if (!SharepreferenceDBHandler.isLocalDb(this.g)) {
            SharepreferenceDBHandler.setLocalDb(this.g, true);
            intent = new Intent("notification");
            str = "local";
            intent.putExtra("notification_popup", str);
            p0.a.b(this.g).d(intent);
        }
        H("setAppStoragePref");
    }

    public final void D(GetAllcombinedashrequest getAllcombinedashrequest) {
        List list;
        ArrayList arrayList = null;
        if (getAllcombinedashrequest.getDashboard().getData() == null || getAllcombinedashrequest.getDashboard().getTotalrecords() == null || getAllcombinedashrequest.getDashboard().getTotalrecords().intValue() <= 0 || getAllcombinedashrequest.getDashboard().getData().size() <= 0) {
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
            List data = getAllcombinedashrequest.getDashboard().getData();
            int i = 0;
            while (i < data.size()) {
                if (((DashboardData) data.get(i)).getPages() == null || !((DashboardData) data.get(i)).getPages().equalsIgnoreCase("dashboard")) {
                    list = data;
                } else {
                    DashboardData dashboardData = (DashboardData) data.get(i);
                    String type = dashboardData.getType();
                    if (type != null && type.equalsIgnoreCase("image")) {
                        String pages = dashboardData.getPages();
                        dashboardData.getType();
                        String redirectLink = dashboardData.getRedirectLink();
                        List images = dashboardData.getImages();
                        int i2 = 0;
                        while (i2 < images.size()) {
                            String str = (String) images.get(i2);
                            AdvertismentModel advertismentModel = new AdvertismentModel();
                            advertismentModel.e(type);
                            advertismentModel.c(pages);
                            advertismentModel.a(str);
                            advertismentModel.b("");
                            advertismentModel.d(redirectLink);
                            this.i.add(advertismentModel);
                            arrayList4.add(redirectLink);
                            arrayList2.add(str);
                            i2++;
                            data = data;
                        }
                    }
                    list = data;
                    String pages2 = dashboardData.getPages();
                    String type2 = dashboardData.getType();
                    String text = dashboardData.getText();
                    String redirectLink2 = dashboardData.getRedirectLink();
                    AdvertismentModel advertismentModel2 = new AdvertismentModel();
                    advertismentModel2.e(type2);
                    advertismentModel2.c(pages2);
                    advertismentModel2.a("");
                    advertismentModel2.b(text);
                    advertismentModel2.d(redirectLink2);
                    this.i.add(advertismentModel2);
                    arrayList5.add(redirectLink2);
                    arrayList3.add(text);
                }
                i++;
                data = list;
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
                H("setDashboardResults");
            }
            SharepreferenceDBHandler.setDashboardTextList(arrayList, this.g);
        }
        DashBoardListssingleton.b().g(arrayList);
        H("setDashboardResults");
    }

    public final void E(GetLastupdated getLastupdated) {
        int i;
        SharepreferenceDBHandler.setVPNLastUpdate(true, this.g);
        String nextrequest = getLastupdated.getNextrequest();
        if (nextrequest.contains(".")) {
            nextrequest = nextrequest.substring(0, nextrequest.indexOf(46));
        }
        try {
            i = Integer.parseInt(nextrequest);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            i = 24;
        }
        SharepreferenceDBHandler.setLastUpdate(i, this.g);
        SharepreferenceDBHandler.setLastUpdateTime(w.p(), this.g);
        H("setLastUpdate");
    }

    public final void F(CheckMaintainencemode checkMaintainencemode) {
        if (checkMaintainencemode.getMaintenancemode() == null || !checkMaintainencemode.getMaintenancemode().equalsIgnoreCase("on")) {
            H("maintenance mode off");
            SharepreferenceDBHandler.setMaintanceModeState(false, a());
        } else {
            H("maintenance mode on");
            SharepreferenceDBHandler.setMaintanceModeState(true, this.g);
            String footercontent = checkMaintainencemode.getFootercontent() != null ? checkMaintainencemode.getFootercontent() : "";
            String message = checkMaintainencemode.getMessage() != null ? checkMaintainencemode.getMessage() : "";
            if (footercontent != null) {
                SharepreferenceDBHandler.setMaintanceModeFooterMessage(footercontent, a());
            }
            if (message != null) {
                SharepreferenceDBHandler.setMaintanceModeMessage(message, a());
            }
        }
        p0.a.b(this.g).d(new Intent("notification").putExtra("sbp_maintenance_mode", "maintenance_mode"));
        H("setMaintenanceModeResult");
    }

    public final void G(GetAllcombinedashrequest getAllcombinedashrequest) {
        ArrayList arrayList;
        if (getAllcombinedashrequest.getRewarded().getTotalrecords() != null && getAllcombinedashrequest.getRewarded().getTotalrecords().intValue() > 0 && getAllcombinedashrequest.getRewarded().getData() != null && getAllcombinedashrequest.getRewarded().getData().size() > 0) {
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            ArrayList arrayList4 = new ArrayList();
            ArrayList arrayList5 = new ArrayList();
            List data = getAllcombinedashrequest.getRewarded().getData();
            for (int i = 0; i < data.size(); i++) {
                if (((RewardedData) data.get(i)).getPages() != null && ((RewardedData) data.get(i)).getPages().equalsIgnoreCase("dashboard")) {
                    RewardedData rewardedData = (RewardedData) data.get(i);
                    String type = rewardedData.getType();
                    if (type != null && type.equalsIgnoreCase("image")) {
                        String pages = rewardedData.getPages();
                        rewardedData.getType();
                        String redirectLink = rewardedData.getRedirectLink();
                        List images = rewardedData.getImages();
                        for (int i2 = 0; i2 < images.size(); i2++) {
                            String str = (String) images.get(i2);
                            AdvertismentModel advertismentModel = new AdvertismentModel();
                            advertismentModel.e(type);
                            advertismentModel.c(pages);
                            advertismentModel.a(str);
                            advertismentModel.b("");
                            advertismentModel.d(redirectLink);
                            this.i.add(advertismentModel);
                            arrayList4.add(redirectLink);
                            arrayList2.add(str);
                        }
                    } else if (type != null && type.equalsIgnoreCase("message")) {
                        String pages2 = rewardedData.getPages();
                        String type2 = rewardedData.getType();
                        String text = rewardedData.getText();
                        String redirectLink2 = rewardedData.getRedirectLink();
                        AdvertismentModel advertismentModel2 = new AdvertismentModel();
                        advertismentModel2.e(type2);
                        advertismentModel2.c(pages2);
                        advertismentModel2.a("");
                        advertismentModel2.b(text);
                        advertismentModel2.d(redirectLink2);
                        this.i.add(advertismentModel2);
                        arrayList5.add(redirectLink2);
                        arrayList3.add(text);
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
            }
            H("setRewardedResults");
        }
        arrayList = null;
        Listsingleton.b().d(null);
        SharepreferenceDBHandler.setRewardedImageList(null, this.g);
        SharepreferenceDBHandler.setRewardedTextList(arrayList, this.g);
        Listsingleton.b().f(arrayList);
        H("setRewardedResults");
    }

    public final void H(String str) {
    }

    public b p() {
        e x = e.x();
        this.h = new FirebasePresenter(this.g, new a(x));
        String format = new SimpleDateFormat("yyyy-MM").format(new Date());
        r();
        this.h.l(m7.a.S0, m7.a.T0, b7.b.b, format, w.o0(m7.a.S0 + "*Njh0&$@HAH828283636JSJSHS*" + b7.b.b + "*" + format), "get-allcombinedashrequest", (SharepreferenceDBHandler.getDeviceUUID(this.g) == null || SharepreferenceDBHandler.getDeviceUUID(this.g).length() <= 0) ? "" : SharepreferenceDBHandler.getDeviceUUID(this.g));
        return x;
    }

    public void r() {
        b7.b.b = String.valueOf(new Random().nextInt(8378600) + 10000);
    }

    public void z(GetAllcombinedashrequest getAllcombinedashrequest) {
        if (getAllcombinedashrequest == null || !getAllcombinedashrequest.getResult().equalsIgnoreCase("success")) {
            Listsingleton.b().d(null);
            SharepreferenceDBHandler.setRewardedImageList(null, this.g);
            SharepreferenceDBHandler.setRewardedTextList(null, this.g);
            Listsingleton.b().f(null);
        } else {
            if (getAllcombinedashrequest.getRewarded() == null || !getAllcombinedashrequest.getRewarded().getAddStatus().equalsIgnoreCase("1")) {
                Listsingleton.b().d(null);
                SharepreferenceDBHandler.setRewardedImageList(null, this.g);
                SharepreferenceDBHandler.setRewardedTextList(null, this.g);
                Listsingleton.b().f(null);
            } else {
                SharepreferenceDBHandler.setPrefAdsStatus(getAllcombinedashrequest.getRewarded().getAddStatus(), this.g);
                SharepreferenceDBHandler.setViewableRate(Integer.parseInt(getAllcombinedashrequest.getRewarded().getAddViewableRate()), this.g);
                m7.a.e1 = SharepreferenceDBHandler.getPrefAdsStatus(this.g);
                m7.a.f1 = SharepreferenceDBHandler.getViewableRate(this.g);
                G(getAllcombinedashrequest);
            }
            if (!m7.a.o.booleanValue()) {
                if (getAllcombinedashrequest.getDashboard() == null || !getAllcombinedashrequest.getDashboard().getAddStatus().equalsIgnoreCase("1")) {
                    DashBoardListssingleton.b().d(null);
                    DashBoardListssingleton.b().g(null);
                    SharepreferenceDBHandler.setDashboardImageList(null, this.g);
                    SharepreferenceDBHandler.setDashboardTextList(null, this.g);
                } else {
                    D(getAllcombinedashrequest);
                }
            }
        }
        p0.a.b(this.g).d(new Intent("notification").putExtra("sbp_panel_ads", "ads_data"));
        H("adsDataResponseSuccess");
    }
}

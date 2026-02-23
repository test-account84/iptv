package com.facebook.ads;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import androidx.annotation.Keep;
import com.facebook.ads.internal.api.AudienceNetworkActivityApi;
import com.facebook.ads.internal.dynamicloading.DynamicLoaderFactory;

@Keep
@SuppressLint({"MissingSuperCall"})
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class AudienceNetworkActivity extends Activity {
    private AudienceNetworkActivityApi mAudienceNetworkActivityApi;
    private final AudienceNetworkActivityApi mAudienceNetworkActivityParentApi = new a();

    public class a implements AudienceNetworkActivityApi {
        public a() {
        }

        public void finish(int i) {
            AudienceNetworkActivity.access$601(AudienceNetworkActivity.this);
        }

        public void onBackPressed() {
            AudienceNetworkActivity.access$801(AudienceNetworkActivity.this);
        }

        public void onConfigurationChanged(Configuration configuration) {
            AudienceNetworkActivity.access$901(AudienceNetworkActivity.this, configuration);
        }

        public void onCreate(Bundle bundle) {
            AudienceNetworkActivity.access$001(AudienceNetworkActivity.this, bundle);
        }

        public void onDestroy() {
            AudienceNetworkActivity.access$701(AudienceNetworkActivity.this);
        }

        public void onPause() {
            AudienceNetworkActivity.access$201(AudienceNetworkActivity.this);
        }

        public void onResume() {
            AudienceNetworkActivity.access$301(AudienceNetworkActivity.this);
        }

        public void onSaveInstanceState(Bundle bundle) {
            AudienceNetworkActivity.access$501(AudienceNetworkActivity.this, bundle);
        }

        public void onStart() {
            AudienceNetworkActivity.access$101(AudienceNetworkActivity.this);
        }

        public void onStop() {
            AudienceNetworkActivity.access$401(AudienceNetworkActivity.this);
        }

        public boolean onTouchEvent(MotionEvent motionEvent) {
            return AudienceNetworkActivity.access$1001(AudienceNetworkActivity.this, motionEvent);
        }
    }

    public static /* synthetic */ void access$001(AudienceNetworkActivity audienceNetworkActivity, Bundle bundle) {
        super.onCreate(bundle);
    }

    public static /* synthetic */ boolean access$1001(AudienceNetworkActivity audienceNetworkActivity, MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public static /* synthetic */ void access$101(AudienceNetworkActivity audienceNetworkActivity) {
        super.onStart();
    }

    public static /* synthetic */ void access$201(AudienceNetworkActivity audienceNetworkActivity) {
        super.onPause();
    }

    public static /* synthetic */ void access$301(AudienceNetworkActivity audienceNetworkActivity) {
        super.onResume();
    }

    public static /* synthetic */ void access$401(AudienceNetworkActivity audienceNetworkActivity) {
        super.onStop();
    }

    public static /* synthetic */ void access$501(AudienceNetworkActivity audienceNetworkActivity, Bundle bundle) {
        super.onSaveInstanceState(bundle);
    }

    public static /* synthetic */ void access$601(AudienceNetworkActivity audienceNetworkActivity) {
        super.finish();
    }

    public static /* synthetic */ void access$701(AudienceNetworkActivity audienceNetworkActivity) {
        super.onDestroy();
    }

    public static /* synthetic */ void access$801(AudienceNetworkActivity audienceNetworkActivity) {
        super.onBackPressed();
    }

    public static /* synthetic */ void access$901(AudienceNetworkActivity audienceNetworkActivity, Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    public void finish() {
        this.mAudienceNetworkActivityApi.finish(0);
    }

    public void onBackPressed() {
        this.mAudienceNetworkActivityApi.onBackPressed();
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.mAudienceNetworkActivityApi.onConfigurationChanged(configuration);
    }

    public void onCreate(Bundle bundle) {
        AudienceNetworkActivityApi createAudienceNetworkActivity = DynamicLoaderFactory.makeLoader(this).createAudienceNetworkActivity(this, this.mAudienceNetworkActivityParentApi);
        this.mAudienceNetworkActivityApi = createAudienceNetworkActivity;
        createAudienceNetworkActivity.onCreate(bundle);
    }

    public void onDestroy() {
        this.mAudienceNetworkActivityApi.onDestroy();
    }

    public void onPause() {
        this.mAudienceNetworkActivityApi.onPause();
    }

    public void onResume() {
        this.mAudienceNetworkActivityApi.onResume();
    }

    public void onSaveInstanceState(Bundle bundle) {
        this.mAudienceNetworkActivityApi.onSaveInstanceState(bundle);
    }

    public void onStart() {
        this.mAudienceNetworkActivityApi.onStart();
    }

    public void onStop() {
        this.mAudienceNetworkActivityApi.onStop();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.mAudienceNetworkActivityApi.onTouchEvent(motionEvent);
    }
}

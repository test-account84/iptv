package com.google.ads.interactivemedia.v3.impl.data;

import com.google.ads.interactivemedia.v3.internal.atf;
import com.google.ads.interactivemedia.v3.internal.avo;
import com.google.ads.interactivemedia.v3.internal.avs;

@atf(a = ar.class, b = {"extraParams", "isTv", "ignoreStrictModeFalsePositives"})
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class TestingConfiguration {
    public static final String PARAMETER_KEY = "tcnfp";

    public interface Builder {
        TestingConfiguration build();

        Builder disableExperiments(boolean z);

        Builder disableOnScreenDetection(boolean z);

        Builder disableSkipFadeTransition(boolean z);

        Builder enableMonitorAppLifecycle(boolean z);

        Builder extraParams(avs avsVar);

        Builder forceExperimentIds(avo avoVar);

        Builder forceTvMode(boolean z);

        Builder ignoreStrictModeFalsePositives(boolean z);

        Builder useTestStreamManager(boolean z);

        Builder useVideoElementMock(boolean z);

        Builder videoElementMockDuration(float f);
    }

    public static Builder builder() {
        ap apVar = new ap();
        apVar.disableExperiments(true);
        apVar.disableOnScreenDetection(false);
        apVar.disableSkipFadeTransition(true);
        apVar.useVideoElementMock(false);
        apVar.videoElementMockDuration(30.0f);
        apVar.useTestStreamManager(false);
        apVar.ignoreStrictModeFalsePositives(false);
        apVar.forceTvMode(false);
        apVar.forceExperimentIds(null);
        apVar.enableMonitorAppLifecycle(true);
        return apVar;
    }

    public Builder copy() {
        ap apVar = new ap();
        apVar.disableExperiments(disableExperiments());
        apVar.disableOnScreenDetection(disableOnScreenDetection());
        apVar.disableSkipFadeTransition(disableSkipFadeTransition());
        apVar.useVideoElementMock(useVideoElementMock());
        apVar.videoElementMockDuration(videoElementMockDuration());
        apVar.useTestStreamManager(useTestStreamManager());
        apVar.forceExperimentIds(forceExperimentIds());
        apVar.enableMonitorAppLifecycle(enableMonitorAppLifecycle());
        apVar.forceTvMode(forceTvMode());
        apVar.ignoreStrictModeFalsePositives(ignoreStrictModeFalsePositives());
        apVar.extraParams(extraParams());
        return apVar;
    }

    public abstract boolean disableExperiments();

    public abstract boolean disableOnScreenDetection();

    public abstract boolean disableSkipFadeTransition();

    public abstract boolean enableMonitorAppLifecycle();

    public abstract avs extraParams();

    public abstract avo forceExperimentIds();

    public abstract boolean forceTvMode();

    public abstract boolean ignoreStrictModeFalsePositives();

    public abstract boolean useTestStreamManager();

    public abstract boolean useVideoElementMock();

    public abstract float videoElementMockDuration();
}

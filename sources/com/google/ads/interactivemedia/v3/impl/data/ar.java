package com.google.ads.interactivemedia.v3.impl.data;

import com.google.ads.interactivemedia.v3.internal.avo;
import com.google.ads.interactivemedia.v3.internal.avs;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class ar extends TestingConfiguration {
    private final boolean disableExperiments;
    private final boolean disableOnScreenDetection;
    private final boolean disableSkipFadeTransition;
    private final boolean enableMonitorAppLifecycle;
    private final avs extraParams;
    private final avo forceExperimentIds;
    private final boolean forceTvMode;
    private final boolean ignoreStrictModeFalsePositives;
    private final boolean useTestStreamManager;
    private final boolean useVideoElementMock;
    private final float videoElementMockDuration;

    private ar(boolean z, boolean z2, boolean z3, avo avoVar, boolean z4, float f, boolean z5, boolean z6, boolean z7, boolean z8, avs avsVar) {
        this.disableExperiments = z;
        this.disableOnScreenDetection = z2;
        this.disableSkipFadeTransition = z3;
        this.forceExperimentIds = avoVar;
        this.useVideoElementMock = z4;
        this.videoElementMockDuration = f;
        this.useTestStreamManager = z5;
        this.enableMonitorAppLifecycle = z6;
        this.forceTvMode = z7;
        this.ignoreStrictModeFalsePositives = z8;
        this.extraParams = avsVar;
    }

    public boolean disableExperiments() {
        return this.disableExperiments;
    }

    public boolean disableOnScreenDetection() {
        return this.disableOnScreenDetection;
    }

    public boolean disableSkipFadeTransition() {
        return this.disableSkipFadeTransition;
    }

    public boolean enableMonitorAppLifecycle() {
        return this.enableMonitorAppLifecycle;
    }

    public boolean equals(Object obj) {
        avo avoVar;
        if (obj == this) {
            return true;
        }
        if (obj instanceof TestingConfiguration) {
            TestingConfiguration testingConfiguration = (TestingConfiguration) obj;
            if (this.disableExperiments == testingConfiguration.disableExperiments() && this.disableOnScreenDetection == testingConfiguration.disableOnScreenDetection() && this.disableSkipFadeTransition == testingConfiguration.disableSkipFadeTransition() && ((avoVar = this.forceExperimentIds) != null ? avoVar.equals(testingConfiguration.forceExperimentIds()) : testingConfiguration.forceExperimentIds() == null) && this.useVideoElementMock == testingConfiguration.useVideoElementMock() && Float.floatToIntBits(this.videoElementMockDuration) == Float.floatToIntBits(testingConfiguration.videoElementMockDuration()) && this.useTestStreamManager == testingConfiguration.useTestStreamManager() && this.enableMonitorAppLifecycle == testingConfiguration.enableMonitorAppLifecycle() && this.forceTvMode == testingConfiguration.forceTvMode() && this.ignoreStrictModeFalsePositives == testingConfiguration.ignoreStrictModeFalsePositives()) {
                avs avsVar = this.extraParams;
                avs extraParams = testingConfiguration.extraParams();
                if (avsVar != null ? avsVar.equals(extraParams) : extraParams == null) {
                    return true;
                }
            }
        }
        return false;
    }

    public avs extraParams() {
        return this.extraParams;
    }

    public avo forceExperimentIds() {
        return this.forceExperimentIds;
    }

    public boolean forceTvMode() {
        return this.forceTvMode;
    }

    public int hashCode() {
        int i = ((((((true != this.disableExperiments ? 1237 : 1231) ^ 1000003) * 1000003) ^ (true != this.disableOnScreenDetection ? 1237 : 1231)) * 1000003) ^ (true != this.disableSkipFadeTransition ? 1237 : 1231)) * 1000003;
        avo avoVar = this.forceExperimentIds;
        int hashCode = (((((((((((((i ^ (avoVar == null ? 0 : avoVar.hashCode())) * 1000003) ^ (true != this.useVideoElementMock ? 1237 : 1231)) * 1000003) ^ Float.floatToIntBits(this.videoElementMockDuration)) * 1000003) ^ (true != this.useTestStreamManager ? 1237 : 1231)) * 1000003) ^ (true != this.enableMonitorAppLifecycle ? 1237 : 1231)) * 1000003) ^ (true != this.forceTvMode ? 1237 : 1231)) * 1000003) ^ (true != this.ignoreStrictModeFalsePositives ? 1237 : 1231)) * 1000003;
        avs avsVar = this.extraParams;
        return hashCode ^ (avsVar != null ? avsVar.hashCode() : 0);
    }

    public boolean ignoreStrictModeFalsePositives() {
        return this.ignoreStrictModeFalsePositives;
    }

    public String toString() {
        return "TestingConfiguration{disableExperiments=" + this.disableExperiments + ", disableOnScreenDetection=" + this.disableOnScreenDetection + ", disableSkipFadeTransition=" + this.disableSkipFadeTransition + ", forceExperimentIds=" + String.valueOf(this.forceExperimentIds) + ", useVideoElementMock=" + this.useVideoElementMock + ", videoElementMockDuration=" + this.videoElementMockDuration + ", useTestStreamManager=" + this.useTestStreamManager + ", enableMonitorAppLifecycle=" + this.enableMonitorAppLifecycle + ", forceTvMode=" + this.forceTvMode + ", ignoreStrictModeFalsePositives=" + this.ignoreStrictModeFalsePositives + ", extraParams=" + String.valueOf(this.extraParams) + "}";
    }

    public boolean useTestStreamManager() {
        return this.useTestStreamManager;
    }

    public boolean useVideoElementMock() {
        return this.useVideoElementMock;
    }

    public float videoElementMockDuration() {
        return this.videoElementMockDuration;
    }

    public /* synthetic */ ar(boolean z, boolean z2, boolean z3, avo avoVar, boolean z4, float f, boolean z5, boolean z6, boolean z7, boolean z8, avs avsVar, aq aqVar) {
        this(z, z2, z3, avoVar, z4, f, z5, z6, z7, z8, avsVar);
    }
}

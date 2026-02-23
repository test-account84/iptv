package com.google.ads.interactivemedia.v3.impl.data;

import com.google.ads.interactivemedia.v3.impl.data.TestingConfiguration;
import com.google.ads.interactivemedia.v3.internal.avo;
import com.google.ads.interactivemedia.v3.internal.avs;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class ap implements TestingConfiguration.Builder {
    private boolean disableExperiments;
    private boolean disableOnScreenDetection;
    private boolean disableSkipFadeTransition;
    private boolean enableMonitorAppLifecycle;
    private avs extraParams;
    private avo forceExperimentIds;
    private boolean forceTvMode;
    private boolean ignoreStrictModeFalsePositives;
    private short set$0;
    private boolean useTestStreamManager;
    private boolean useVideoElementMock;
    private float videoElementMockDuration;

    public TestingConfiguration build() {
        if (this.set$0 == 511) {
            return new ar(this.disableExperiments, this.disableOnScreenDetection, this.disableSkipFadeTransition, this.forceExperimentIds, this.useVideoElementMock, this.videoElementMockDuration, this.useTestStreamManager, this.enableMonitorAppLifecycle, this.forceTvMode, this.ignoreStrictModeFalsePositives, this.extraParams, null);
        }
        StringBuilder sb = new StringBuilder();
        if ((this.set$0 & 1) == 0) {
            sb.append(" disableExperiments");
        }
        if ((this.set$0 & 2) == 0) {
            sb.append(" disableOnScreenDetection");
        }
        if ((this.set$0 & 4) == 0) {
            sb.append(" disableSkipFadeTransition");
        }
        if ((this.set$0 & 8) == 0) {
            sb.append(" useVideoElementMock");
        }
        if ((this.set$0 & 16) == 0) {
            sb.append(" videoElementMockDuration");
        }
        if ((this.set$0 & 32) == 0) {
            sb.append(" useTestStreamManager");
        }
        if ((this.set$0 & 64) == 0) {
            sb.append(" enableMonitorAppLifecycle");
        }
        if ((this.set$0 & 128) == 0) {
            sb.append(" forceTvMode");
        }
        if ((this.set$0 & 256) == 0) {
            sb.append(" ignoreStrictModeFalsePositives");
        }
        throw new IllegalStateException("Missing required properties:".concat(sb.toString()));
    }

    public TestingConfiguration.Builder disableExperiments(boolean z) {
        this.disableExperiments = z;
        this.set$0 = (short) (this.set$0 | 1);
        return this;
    }

    public TestingConfiguration.Builder disableOnScreenDetection(boolean z) {
        this.disableOnScreenDetection = z;
        this.set$0 = (short) (this.set$0 | 2);
        return this;
    }

    public TestingConfiguration.Builder disableSkipFadeTransition(boolean z) {
        this.disableSkipFadeTransition = z;
        this.set$0 = (short) (this.set$0 | 4);
        return this;
    }

    public TestingConfiguration.Builder enableMonitorAppLifecycle(boolean z) {
        this.enableMonitorAppLifecycle = z;
        this.set$0 = (short) (this.set$0 | 64);
        return this;
    }

    public TestingConfiguration.Builder extraParams(avs avsVar) {
        this.extraParams = avsVar;
        return this;
    }

    public TestingConfiguration.Builder forceExperimentIds(avo avoVar) {
        this.forceExperimentIds = avoVar;
        return this;
    }

    public TestingConfiguration.Builder forceTvMode(boolean z) {
        this.forceTvMode = z;
        this.set$0 = (short) (this.set$0 | 128);
        return this;
    }

    public TestingConfiguration.Builder ignoreStrictModeFalsePositives(boolean z) {
        this.ignoreStrictModeFalsePositives = z;
        this.set$0 = (short) (this.set$0 | 256);
        return this;
    }

    public TestingConfiguration.Builder useTestStreamManager(boolean z) {
        this.useTestStreamManager = z;
        this.set$0 = (short) (this.set$0 | 32);
        return this;
    }

    public TestingConfiguration.Builder useVideoElementMock(boolean z) {
        this.useVideoElementMock = z;
        this.set$0 = (short) (this.set$0 | 8);
        return this;
    }

    public TestingConfiguration.Builder videoElementMockDuration(float f) {
        this.videoElementMockDuration = f;
        this.set$0 = (short) (this.set$0 | 16);
        return this;
    }
}

package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class DescribeRiskConfigurationResult implements Serializable {
    private RiskConfigurationType riskConfiguration;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DescribeRiskConfigurationResult)) {
            return false;
        }
        DescribeRiskConfigurationResult describeRiskConfigurationResult = (DescribeRiskConfigurationResult) obj;
        if ((describeRiskConfigurationResult.getRiskConfiguration() == null) ^ (getRiskConfiguration() == null)) {
            return false;
        }
        return describeRiskConfigurationResult.getRiskConfiguration() == null || describeRiskConfigurationResult.getRiskConfiguration().equals(getRiskConfiguration());
    }

    public RiskConfigurationType getRiskConfiguration() {
        return this.riskConfiguration;
    }

    public int hashCode() {
        return 31 + (getRiskConfiguration() == null ? 0 : getRiskConfiguration().hashCode());
    }

    public void setRiskConfiguration(RiskConfigurationType riskConfigurationType) {
        this.riskConfiguration = riskConfigurationType;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getRiskConfiguration() != null) {
            sb.append("RiskConfiguration: " + getRiskConfiguration());
        }
        sb.append("}");
        return sb.toString();
    }

    public DescribeRiskConfigurationResult withRiskConfiguration(RiskConfigurationType riskConfigurationType) {
        this.riskConfiguration = riskConfigurationType;
        return this;
    }
}

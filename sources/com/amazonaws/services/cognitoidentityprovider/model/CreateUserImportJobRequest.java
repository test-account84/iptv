package com.amazonaws.services.cognitoidentityprovider.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class CreateUserImportJobRequest extends AmazonWebServiceRequest implements Serializable {
    private String cloudWatchLogsRoleArn;
    private String jobName;
    private String userPoolId;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof CreateUserImportJobRequest)) {
            return false;
        }
        CreateUserImportJobRequest createUserImportJobRequest = (CreateUserImportJobRequest) obj;
        if ((createUserImportJobRequest.getJobName() == null) ^ (getJobName() == null)) {
            return false;
        }
        if (createUserImportJobRequest.getJobName() != null && !createUserImportJobRequest.getJobName().equals(getJobName())) {
            return false;
        }
        if ((createUserImportJobRequest.getUserPoolId() == null) ^ (getUserPoolId() == null)) {
            return false;
        }
        if (createUserImportJobRequest.getUserPoolId() != null && !createUserImportJobRequest.getUserPoolId().equals(getUserPoolId())) {
            return false;
        }
        if ((createUserImportJobRequest.getCloudWatchLogsRoleArn() == null) ^ (getCloudWatchLogsRoleArn() == null)) {
            return false;
        }
        return createUserImportJobRequest.getCloudWatchLogsRoleArn() == null || createUserImportJobRequest.getCloudWatchLogsRoleArn().equals(getCloudWatchLogsRoleArn());
    }

    public String getCloudWatchLogsRoleArn() {
        return this.cloudWatchLogsRoleArn;
    }

    public String getJobName() {
        return this.jobName;
    }

    public String getUserPoolId() {
        return this.userPoolId;
    }

    public int hashCode() {
        return (((((getJobName() == null ? 0 : getJobName().hashCode()) + 31) * 31) + (getUserPoolId() == null ? 0 : getUserPoolId().hashCode())) * 31) + (getCloudWatchLogsRoleArn() != null ? getCloudWatchLogsRoleArn().hashCode() : 0);
    }

    public void setCloudWatchLogsRoleArn(String str) {
        this.cloudWatchLogsRoleArn = str;
    }

    public void setJobName(String str) {
        this.jobName = str;
    }

    public void setUserPoolId(String str) {
        this.userPoolId = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getJobName() != null) {
            sb.append("JobName: " + getJobName() + ",");
        }
        if (getUserPoolId() != null) {
            sb.append("UserPoolId: " + getUserPoolId() + ",");
        }
        if (getCloudWatchLogsRoleArn() != null) {
            sb.append("CloudWatchLogsRoleArn: " + getCloudWatchLogsRoleArn());
        }
        sb.append("}");
        return sb.toString();
    }

    public CreateUserImportJobRequest withCloudWatchLogsRoleArn(String str) {
        this.cloudWatchLogsRoleArn = str;
        return this;
    }

    public CreateUserImportJobRequest withJobName(String str) {
        this.jobName = str;
        return this;
    }

    public CreateUserImportJobRequest withUserPoolId(String str) {
        this.userPoolId = str;
        return this;
    }
}

package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;
import java.util.Date;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class UserImportJobType implements Serializable {
    private String cloudWatchLogsRoleArn;
    private Date completionDate;
    private String completionMessage;
    private Date creationDate;
    private Long failedUsers;
    private Long importedUsers;
    private String jobId;
    private String jobName;
    private String preSignedUrl;
    private Long skippedUsers;
    private Date startDate;
    private String status;
    private String userPoolId;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof UserImportJobType)) {
            return false;
        }
        UserImportJobType userImportJobType = (UserImportJobType) obj;
        if ((userImportJobType.getJobName() == null) ^ (getJobName() == null)) {
            return false;
        }
        if (userImportJobType.getJobName() != null && !userImportJobType.getJobName().equals(getJobName())) {
            return false;
        }
        if ((userImportJobType.getJobId() == null) ^ (getJobId() == null)) {
            return false;
        }
        if (userImportJobType.getJobId() != null && !userImportJobType.getJobId().equals(getJobId())) {
            return false;
        }
        if ((userImportJobType.getUserPoolId() == null) ^ (getUserPoolId() == null)) {
            return false;
        }
        if (userImportJobType.getUserPoolId() != null && !userImportJobType.getUserPoolId().equals(getUserPoolId())) {
            return false;
        }
        if ((userImportJobType.getPreSignedUrl() == null) ^ (getPreSignedUrl() == null)) {
            return false;
        }
        if (userImportJobType.getPreSignedUrl() != null && !userImportJobType.getPreSignedUrl().equals(getPreSignedUrl())) {
            return false;
        }
        if ((userImportJobType.getCreationDate() == null) ^ (getCreationDate() == null)) {
            return false;
        }
        if (userImportJobType.getCreationDate() != null && !userImportJobType.getCreationDate().equals(getCreationDate())) {
            return false;
        }
        if ((userImportJobType.getStartDate() == null) ^ (getStartDate() == null)) {
            return false;
        }
        if (userImportJobType.getStartDate() != null && !userImportJobType.getStartDate().equals(getStartDate())) {
            return false;
        }
        if ((userImportJobType.getCompletionDate() == null) ^ (getCompletionDate() == null)) {
            return false;
        }
        if (userImportJobType.getCompletionDate() != null && !userImportJobType.getCompletionDate().equals(getCompletionDate())) {
            return false;
        }
        if ((userImportJobType.getStatus() == null) ^ (getStatus() == null)) {
            return false;
        }
        if (userImportJobType.getStatus() != null && !userImportJobType.getStatus().equals(getStatus())) {
            return false;
        }
        if ((userImportJobType.getCloudWatchLogsRoleArn() == null) ^ (getCloudWatchLogsRoleArn() == null)) {
            return false;
        }
        if (userImportJobType.getCloudWatchLogsRoleArn() != null && !userImportJobType.getCloudWatchLogsRoleArn().equals(getCloudWatchLogsRoleArn())) {
            return false;
        }
        if ((userImportJobType.getImportedUsers() == null) ^ (getImportedUsers() == null)) {
            return false;
        }
        if (userImportJobType.getImportedUsers() != null && !userImportJobType.getImportedUsers().equals(getImportedUsers())) {
            return false;
        }
        if ((userImportJobType.getSkippedUsers() == null) ^ (getSkippedUsers() == null)) {
            return false;
        }
        if (userImportJobType.getSkippedUsers() != null && !userImportJobType.getSkippedUsers().equals(getSkippedUsers())) {
            return false;
        }
        if ((userImportJobType.getFailedUsers() == null) ^ (getFailedUsers() == null)) {
            return false;
        }
        if (userImportJobType.getFailedUsers() != null && !userImportJobType.getFailedUsers().equals(getFailedUsers())) {
            return false;
        }
        if ((userImportJobType.getCompletionMessage() == null) ^ (getCompletionMessage() == null)) {
            return false;
        }
        return userImportJobType.getCompletionMessage() == null || userImportJobType.getCompletionMessage().equals(getCompletionMessage());
    }

    public String getCloudWatchLogsRoleArn() {
        return this.cloudWatchLogsRoleArn;
    }

    public Date getCompletionDate() {
        return this.completionDate;
    }

    public String getCompletionMessage() {
        return this.completionMessage;
    }

    public Date getCreationDate() {
        return this.creationDate;
    }

    public Long getFailedUsers() {
        return this.failedUsers;
    }

    public Long getImportedUsers() {
        return this.importedUsers;
    }

    public String getJobId() {
        return this.jobId;
    }

    public String getJobName() {
        return this.jobName;
    }

    public String getPreSignedUrl() {
        return this.preSignedUrl;
    }

    public Long getSkippedUsers() {
        return this.skippedUsers;
    }

    public Date getStartDate() {
        return this.startDate;
    }

    public String getStatus() {
        return this.status;
    }

    public String getUserPoolId() {
        return this.userPoolId;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((getJobName() == null ? 0 : getJobName().hashCode()) + 31) * 31) + (getJobId() == null ? 0 : getJobId().hashCode())) * 31) + (getUserPoolId() == null ? 0 : getUserPoolId().hashCode())) * 31) + (getPreSignedUrl() == null ? 0 : getPreSignedUrl().hashCode())) * 31) + (getCreationDate() == null ? 0 : getCreationDate().hashCode())) * 31) + (getStartDate() == null ? 0 : getStartDate().hashCode())) * 31) + (getCompletionDate() == null ? 0 : getCompletionDate().hashCode())) * 31) + (getStatus() == null ? 0 : getStatus().hashCode())) * 31) + (getCloudWatchLogsRoleArn() == null ? 0 : getCloudWatchLogsRoleArn().hashCode())) * 31) + (getImportedUsers() == null ? 0 : getImportedUsers().hashCode())) * 31) + (getSkippedUsers() == null ? 0 : getSkippedUsers().hashCode())) * 31) + (getFailedUsers() == null ? 0 : getFailedUsers().hashCode())) * 31) + (getCompletionMessage() != null ? getCompletionMessage().hashCode() : 0);
    }

    public void setCloudWatchLogsRoleArn(String str) {
        this.cloudWatchLogsRoleArn = str;
    }

    public void setCompletionDate(Date date) {
        this.completionDate = date;
    }

    public void setCompletionMessage(String str) {
        this.completionMessage = str;
    }

    public void setCreationDate(Date date) {
        this.creationDate = date;
    }

    public void setFailedUsers(Long l) {
        this.failedUsers = l;
    }

    public void setImportedUsers(Long l) {
        this.importedUsers = l;
    }

    public void setJobId(String str) {
        this.jobId = str;
    }

    public void setJobName(String str) {
        this.jobName = str;
    }

    public void setPreSignedUrl(String str) {
        this.preSignedUrl = str;
    }

    public void setSkippedUsers(Long l) {
        this.skippedUsers = l;
    }

    public void setStartDate(Date date) {
        this.startDate = date;
    }

    public void setStatus(UserImportJobStatusType userImportJobStatusType) {
        this.status = userImportJobStatusType.toString();
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
        if (getJobId() != null) {
            sb.append("JobId: " + getJobId() + ",");
        }
        if (getUserPoolId() != null) {
            sb.append("UserPoolId: " + getUserPoolId() + ",");
        }
        if (getPreSignedUrl() != null) {
            sb.append("PreSignedUrl: " + getPreSignedUrl() + ",");
        }
        if (getCreationDate() != null) {
            sb.append("CreationDate: " + getCreationDate() + ",");
        }
        if (getStartDate() != null) {
            sb.append("StartDate: " + getStartDate() + ",");
        }
        if (getCompletionDate() != null) {
            sb.append("CompletionDate: " + getCompletionDate() + ",");
        }
        if (getStatus() != null) {
            sb.append("Status: " + getStatus() + ",");
        }
        if (getCloudWatchLogsRoleArn() != null) {
            sb.append("CloudWatchLogsRoleArn: " + getCloudWatchLogsRoleArn() + ",");
        }
        if (getImportedUsers() != null) {
            sb.append("ImportedUsers: " + getImportedUsers() + ",");
        }
        if (getSkippedUsers() != null) {
            sb.append("SkippedUsers: " + getSkippedUsers() + ",");
        }
        if (getFailedUsers() != null) {
            sb.append("FailedUsers: " + getFailedUsers() + ",");
        }
        if (getCompletionMessage() != null) {
            sb.append("CompletionMessage: " + getCompletionMessage());
        }
        sb.append("}");
        return sb.toString();
    }

    public UserImportJobType withCloudWatchLogsRoleArn(String str) {
        this.cloudWatchLogsRoleArn = str;
        return this;
    }

    public UserImportJobType withCompletionDate(Date date) {
        this.completionDate = date;
        return this;
    }

    public UserImportJobType withCompletionMessage(String str) {
        this.completionMessage = str;
        return this;
    }

    public UserImportJobType withCreationDate(Date date) {
        this.creationDate = date;
        return this;
    }

    public UserImportJobType withFailedUsers(Long l) {
        this.failedUsers = l;
        return this;
    }

    public UserImportJobType withImportedUsers(Long l) {
        this.importedUsers = l;
        return this;
    }

    public UserImportJobType withJobId(String str) {
        this.jobId = str;
        return this;
    }

    public UserImportJobType withJobName(String str) {
        this.jobName = str;
        return this;
    }

    public UserImportJobType withPreSignedUrl(String str) {
        this.preSignedUrl = str;
        return this;
    }

    public UserImportJobType withSkippedUsers(Long l) {
        this.skippedUsers = l;
        return this;
    }

    public UserImportJobType withStartDate(Date date) {
        this.startDate = date;
        return this;
    }

    public UserImportJobType withStatus(UserImportJobStatusType userImportJobStatusType) {
        this.status = userImportJobStatusType.toString();
        return this;
    }

    public UserImportJobType withUserPoolId(String str) {
        this.userPoolId = str;
        return this;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public UserImportJobType withStatus(String str) {
        this.status = str;
        return this;
    }
}

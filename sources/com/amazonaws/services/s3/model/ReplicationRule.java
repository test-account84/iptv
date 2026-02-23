package com.amazonaws.services.s3.model;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class ReplicationRule {
    private ReplicationDestinationConfig destinationConfig;
    private String prefix;
    private String status;

    public ReplicationDestinationConfig getDestinationConfig() {
        return this.destinationConfig;
    }

    public String getPrefix() {
        return this.prefix;
    }

    public String getStatus() {
        return this.status;
    }

    public void setDestinationConfig(ReplicationDestinationConfig replicationDestinationConfig) {
        if (replicationDestinationConfig == null) {
            throw new IllegalArgumentException("Destination cannot be null in the replication rule");
        }
        this.destinationConfig = replicationDestinationConfig;
    }

    public void setPrefix(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Prefix cannot be null for a replication rule");
        }
        this.prefix = str;
    }

    public void setStatus(ReplicationRuleStatus replicationRuleStatus) {
        setStatus(replicationRuleStatus.getStatus());
    }

    public ReplicationRule withDestinationConfig(ReplicationDestinationConfig replicationDestinationConfig) {
        setDestinationConfig(replicationDestinationConfig);
        return this;
    }

    public ReplicationRule withPrefix(String str) {
        setPrefix(str);
        return this;
    }

    public ReplicationRule withStatus(ReplicationRuleStatus replicationRuleStatus) {
        setStatus(replicationRuleStatus.getStatus());
        return this;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public ReplicationRule withStatus(String str) {
        setStatus(str);
        return this;
    }
}

package com.amazonaws.mobile.client;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class FederatedSignInOptions {
    private final Builder builder;

    public static class Builder {
        private String cognitoIdentityId;
        private String customRoleARN;

        public static /* synthetic */ String access$000(Builder builder) {
            return builder.customRoleARN;
        }

        public static /* synthetic */ String access$100(Builder builder) {
            return builder.cognitoIdentityId;
        }

        public FederatedSignInOptions build() {
            return new FederatedSignInOptions(this);
        }

        public Builder cognitoIdentityId(String str) {
            this.cognitoIdentityId = str;
            return this;
        }

        public Builder customRoleARN(String str) {
            this.customRoleARN = str;
            return this;
        }
    }

    public FederatedSignInOptions(Builder builder) {
        this.builder = builder;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getCognitoIdentityId() {
        return Builder.access$100(this.builder);
    }

    public String getCustomRoleARN() {
        return Builder.access$000(this.builder);
    }
}

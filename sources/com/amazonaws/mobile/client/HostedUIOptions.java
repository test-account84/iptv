package com.amazonaws.mobile.client;

import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class HostedUIOptions {
    private final Builder builder;

    public static class Builder {
        private Boolean disableFederation;
        private String federationProviderName;
        private String identityProvider;
        private String idpIdentifier;
        private String[] scopes;
        private Map signInQueryParameters;
        private Map signOutQueryParameters;
        private Map tokenQueryParameters;

        public static /* synthetic */ String[] access$000(Builder builder) {
            return builder.scopes;
        }

        public static /* synthetic */ String access$100(Builder builder) {
            return builder.identityProvider;
        }

        public static /* synthetic */ String access$200(Builder builder) {
            return builder.idpIdentifier;
        }

        public static /* synthetic */ Boolean access$300(Builder builder) {
            return builder.disableFederation;
        }

        public static /* synthetic */ String access$400(Builder builder) {
            return builder.federationProviderName;
        }

        public static /* synthetic */ Map access$500(Builder builder) {
            return builder.signInQueryParameters;
        }

        public static /* synthetic */ Map access$600(Builder builder) {
            return builder.signOutQueryParameters;
        }

        public static /* synthetic */ Map access$700(Builder builder) {
            return builder.tokenQueryParameters;
        }

        public HostedUIOptions build() {
            return new HostedUIOptions(this);
        }

        public Builder disableFederation(boolean z) {
            this.disableFederation = Boolean.valueOf(z);
            return this;
        }

        public Builder federationProviderName(String str) {
            this.federationProviderName = str;
            return this;
        }

        public Builder identityProvider(String str) {
            this.identityProvider = str;
            return this;
        }

        public Builder idpIdentifier(String str) {
            this.idpIdentifier = str;
            return this;
        }

        public Builder scopes(String... strArr) {
            this.scopes = strArr;
            return this;
        }

        public Builder signInQueryParameters(Map map) {
            this.signInQueryParameters = map;
            return this;
        }

        public Builder signOutQueryParameters(Map map) {
            this.signOutQueryParameters = map;
            return this;
        }

        public Builder tokenQueryParameters(Map map) {
            this.tokenQueryParameters = map;
            return this;
        }
    }

    public HostedUIOptions(Builder builder) {
        this.builder = builder;
    }

    public static Builder builder() {
        return new Builder();
    }

    public Boolean getFederationEnabled() {
        return Builder.access$300(this.builder);
    }

    public String getFederationProviderName() {
        return Builder.access$400(this.builder);
    }

    public String getIdentityProvider() {
        return Builder.access$100(this.builder);
    }

    public String getIdpIdentifier() {
        return Builder.access$200(this.builder);
    }

    public String[] getScopes() {
        return Builder.access$000(this.builder);
    }

    public Map getSignInQueryParameters() {
        return Builder.access$500(this.builder);
    }

    public Map getSignOutQueryParameters() {
        return Builder.access$600(this.builder);
    }

    public Map getTokenQueryParameters() {
        return Builder.access$700(this.builder);
    }
}

package com.amazonaws.mobile.client;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class SignOutOptions {
    private final Builder builder;

    public static class Builder {
        private String browserPackage;
        private boolean invalidateTokens;
        private boolean signOutGlobally;

        public static /* synthetic */ boolean access$000(Builder builder) {
            return builder.signOutGlobally;
        }

        public static /* synthetic */ boolean access$100(Builder builder) {
            return builder.invalidateTokens;
        }

        public static /* synthetic */ String access$200(Builder builder) {
            return builder.browserPackage;
        }

        public Builder browserPackage(String str) {
            this.browserPackage = str;
            return this;
        }

        public SignOutOptions build() {
            return new SignOutOptions(this);
        }

        public Builder invalidateTokens(boolean z) {
            this.invalidateTokens = z;
            return this;
        }

        public Builder signOutGlobally(boolean z) {
            this.signOutGlobally = z;
            return this;
        }
    }

    public SignOutOptions(Builder builder) {
        this.builder = builder;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getBrowserPackage() {
        return Builder.access$200(this.builder);
    }

    public boolean isInvalidateTokens() {
        return Builder.access$100(this.builder);
    }

    public boolean isSignOutGlobally() {
        return Builder.access$000(this.builder);
    }
}

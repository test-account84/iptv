package com.amplifyframework.auth.options;

import O.c;
import com.amplifyframework.util.Immutable;
import j$.util.Objects;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class AuthWebUISignInOptions {
    private final List scopes;
    private final Map signInQueryParameters;
    private final Map signOutQueryParameters;
    private final Map tokenQueryParameters;

    public static abstract class Builder {
        private List scopes = new ArrayList();
        private Map signInQueryParameters = new HashMap();
        private Map signOutQueryParameters = new HashMap();
        private Map tokenQueryParameters = new HashMap();

        public AuthWebUISignInOptions build() {
            return new AuthWebUISignInOptions(Immutable.of(this.scopes), Immutable.of(this.signInQueryParameters), Immutable.of(this.signOutQueryParameters), Immutable.of(this.tokenQueryParameters));
        }

        public List getScopes() {
            return this.scopes;
        }

        public Map getSignInQueryParameters() {
            return this.signInQueryParameters;
        }

        public Map getSignOutQueryParameters() {
            return this.signOutQueryParameters;
        }

        public abstract Builder getThis();

        public Map getTokenQueryParameters() {
            return this.tokenQueryParameters;
        }

        public Builder scopes(List list) {
            Objects.requireNonNull(list);
            this.scopes.clear();
            this.scopes.addAll(list);
            return getThis();
        }

        public Builder signInQueryParameters(Map map) {
            Objects.requireNonNull(map);
            this.signInQueryParameters.clear();
            this.signInQueryParameters.putAll(map);
            return getThis();
        }

        public Builder signOutQueryParameters(Map map) {
            Objects.requireNonNull(map);
            this.signOutQueryParameters.clear();
            this.signOutQueryParameters.putAll(map);
            return getThis();
        }

        public Builder tokenQueryParameters(Map map) {
            Objects.requireNonNull(map);
            this.tokenQueryParameters.clear();
            this.tokenQueryParameters.putAll(map);
            return getThis();
        }
    }

    public static final class CoreBuilder extends Builder {
        public CoreBuilder getThis() {
            return this;
        }
    }

    public AuthWebUISignInOptions(List list, Map map, Map map2, Map map3) {
        this.scopes = list;
        this.signInQueryParameters = map;
        this.signOutQueryParameters = map2;
        this.tokenQueryParameters = map3;
    }

    public static Builder builder() {
        return new CoreBuilder();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        AuthWebUISignInOptions authWebUISignInOptions = (AuthWebUISignInOptions) obj;
        return c.a(getScopes(), authWebUISignInOptions.getScopes()) && c.a(getSignInQueryParameters(), authWebUISignInOptions.getSignInQueryParameters()) && c.a(getSignOutQueryParameters(), authWebUISignInOptions.getSignOutQueryParameters()) && c.a(getTokenQueryParameters(), authWebUISignInOptions.getTokenQueryParameters());
    }

    public List getScopes() {
        return this.scopes;
    }

    public Map getSignInQueryParameters() {
        return this.signInQueryParameters;
    }

    public Map getSignOutQueryParameters() {
        return this.signOutQueryParameters;
    }

    public Map getTokenQueryParameters() {
        return this.tokenQueryParameters;
    }

    public int hashCode() {
        return c.b(getScopes(), getSignInQueryParameters(), getSignOutQueryParameters(), getTokenQueryParameters());
    }

    public String toString() {
        return "AuthWebUISignInOptions{scopes=" + getScopes() + ", signInQueryParameters=" + getSignInQueryParameters() + ", signOutQueryParameters=" + getSignOutQueryParameters() + ", tokenQueryParameters=" + getTokenQueryParameters() + '}';
    }
}

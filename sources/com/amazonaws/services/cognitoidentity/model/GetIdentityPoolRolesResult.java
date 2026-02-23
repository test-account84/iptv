package com.amazonaws.services.cognitoidentity.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class GetIdentityPoolRolesResult implements Serializable {
    private String identityPoolId;
    private Map roleMappings;
    private Map roles;

    public GetIdentityPoolRolesResult addRoleMappingsEntry(String str, RoleMapping roleMapping) {
        if (this.roleMappings == null) {
            this.roleMappings = new HashMap();
        }
        if (!this.roleMappings.containsKey(str)) {
            this.roleMappings.put(str, roleMapping);
            return this;
        }
        throw new IllegalArgumentException("Duplicated keys (" + str.toString() + ") are provided.");
    }

    public GetIdentityPoolRolesResult addRolesEntry(String str, String str2) {
        if (this.roles == null) {
            this.roles = new HashMap();
        }
        if (!this.roles.containsKey(str)) {
            this.roles.put(str, str2);
            return this;
        }
        throw new IllegalArgumentException("Duplicated keys (" + str.toString() + ") are provided.");
    }

    public GetIdentityPoolRolesResult clearRoleMappingsEntries() {
        this.roleMappings = null;
        return this;
    }

    public GetIdentityPoolRolesResult clearRolesEntries() {
        this.roles = null;
        return this;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof GetIdentityPoolRolesResult)) {
            return false;
        }
        GetIdentityPoolRolesResult getIdentityPoolRolesResult = (GetIdentityPoolRolesResult) obj;
        if ((getIdentityPoolRolesResult.getIdentityPoolId() == null) ^ (getIdentityPoolId() == null)) {
            return false;
        }
        if (getIdentityPoolRolesResult.getIdentityPoolId() != null && !getIdentityPoolRolesResult.getIdentityPoolId().equals(getIdentityPoolId())) {
            return false;
        }
        if ((getIdentityPoolRolesResult.getRoles() == null) ^ (getRoles() == null)) {
            return false;
        }
        if (getIdentityPoolRolesResult.getRoles() != null && !getIdentityPoolRolesResult.getRoles().equals(getRoles())) {
            return false;
        }
        if ((getIdentityPoolRolesResult.getRoleMappings() == null) ^ (getRoleMappings() == null)) {
            return false;
        }
        return getIdentityPoolRolesResult.getRoleMappings() == null || getIdentityPoolRolesResult.getRoleMappings().equals(getRoleMappings());
    }

    public String getIdentityPoolId() {
        return this.identityPoolId;
    }

    public Map getRoleMappings() {
        return this.roleMappings;
    }

    public Map getRoles() {
        return this.roles;
    }

    public int hashCode() {
        return (((((getIdentityPoolId() == null ? 0 : getIdentityPoolId().hashCode()) + 31) * 31) + (getRoles() == null ? 0 : getRoles().hashCode())) * 31) + (getRoleMappings() != null ? getRoleMappings().hashCode() : 0);
    }

    public void setIdentityPoolId(String str) {
        this.identityPoolId = str;
    }

    public void setRoleMappings(Map map) {
        this.roleMappings = map;
    }

    public void setRoles(Map map) {
        this.roles = map;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getIdentityPoolId() != null) {
            sb.append("IdentityPoolId: " + getIdentityPoolId() + ",");
        }
        if (getRoles() != null) {
            sb.append("Roles: " + getRoles() + ",");
        }
        if (getRoleMappings() != null) {
            sb.append("RoleMappings: " + getRoleMappings());
        }
        sb.append("}");
        return sb.toString();
    }

    public GetIdentityPoolRolesResult withIdentityPoolId(String str) {
        this.identityPoolId = str;
        return this;
    }

    public GetIdentityPoolRolesResult withRoleMappings(Map map) {
        this.roleMappings = map;
        return this;
    }

    public GetIdentityPoolRolesResult withRoles(Map map) {
        this.roles = map;
        return this;
    }
}

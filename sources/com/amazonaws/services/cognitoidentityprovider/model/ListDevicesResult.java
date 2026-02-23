package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class ListDevicesResult implements Serializable {
    private List devices;
    private String paginationToken;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ListDevicesResult)) {
            return false;
        }
        ListDevicesResult listDevicesResult = (ListDevicesResult) obj;
        if ((listDevicesResult.getDevices() == null) ^ (getDevices() == null)) {
            return false;
        }
        if (listDevicesResult.getDevices() != null && !listDevicesResult.getDevices().equals(getDevices())) {
            return false;
        }
        if ((listDevicesResult.getPaginationToken() == null) ^ (getPaginationToken() == null)) {
            return false;
        }
        return listDevicesResult.getPaginationToken() == null || listDevicesResult.getPaginationToken().equals(getPaginationToken());
    }

    public List getDevices() {
        return this.devices;
    }

    public String getPaginationToken() {
        return this.paginationToken;
    }

    public int hashCode() {
        return (((getDevices() == null ? 0 : getDevices().hashCode()) + 31) * 31) + (getPaginationToken() != null ? getPaginationToken().hashCode() : 0);
    }

    public void setDevices(Collection collection) {
        if (collection == null) {
            this.devices = null;
        } else {
            this.devices = new ArrayList(collection);
        }
    }

    public void setPaginationToken(String str) {
        this.paginationToken = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getDevices() != null) {
            sb.append("Devices: " + getDevices() + ",");
        }
        if (getPaginationToken() != null) {
            sb.append("PaginationToken: " + getPaginationToken());
        }
        sb.append("}");
        return sb.toString();
    }

    public ListDevicesResult withDevices(Collection collection) {
        setDevices(collection);
        return this;
    }

    public ListDevicesResult withPaginationToken(String str) {
        this.paginationToken = str;
        return this;
    }

    public ListDevicesResult withDevices(DeviceType... deviceTypeArr) {
        if (getDevices() == null) {
            this.devices = new ArrayList(deviceTypeArr.length);
        }
        for (DeviceType deviceType : deviceTypeArr) {
            this.devices.add(deviceType);
        }
        return this;
    }
}

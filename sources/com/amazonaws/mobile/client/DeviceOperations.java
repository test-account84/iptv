package com.amazonaws.mobile.client;

import com.amazonaws.mobile.client.internal.ReturningRunnable;
import com.amazonaws.mobile.client.results.Device;
import com.amazonaws.mobile.client.results.ListDevicesResult;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoDevice;
import com.amazonaws.services.cognitoidentityprovider.AmazonCognitoIdentityProvider;
import com.amazonaws.services.cognitoidentityprovider.model.AttributeType;
import com.amazonaws.services.cognitoidentityprovider.model.DeviceRememberedStatusType;
import com.amazonaws.services.cognitoidentityprovider.model.DeviceType;
import com.amazonaws.services.cognitoidentityprovider.model.ForgetDeviceRequest;
import com.amazonaws.services.cognitoidentityprovider.model.GetDeviceRequest;
import com.amazonaws.services.cognitoidentityprovider.model.ListDevicesRequest;
import com.amazonaws.services.cognitoidentityprovider.model.UpdateDeviceStatusRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class DeviceOperations {
    private final AWSMobileClient mobileClient;
    private final AmazonCognitoIdentityProvider userpoolLL;

    public class 1 extends ReturningRunnable {
        final /* synthetic */ String val$deviceKey;

        public 1(String str) {
            this.val$deviceKey = str;
        }

        public Device run() throws Exception {
            CognitoDevice access$000 = DeviceOperations.access$000(DeviceOperations.this, this.val$deviceKey);
            GetDeviceRequest getDeviceRequest = new GetDeviceRequest();
            getDeviceRequest.setAccessToken(DeviceOperations.access$100(DeviceOperations.this).getTokens().getAccessToken().getTokenString());
            getDeviceRequest.setDeviceKey(access$000.getDeviceKey());
            return DeviceOperations.access$300(DeviceOperations.this, DeviceOperations.access$200(DeviceOperations.this).getDevice(getDeviceRequest).getDevice());
        }
    }

    public class 2 extends ReturningRunnable {
        final /* synthetic */ Integer val$limit;
        final /* synthetic */ String val$paginationToken;

        public 2(Integer num, String str) {
            this.val$limit = num;
            this.val$paginationToken = str;
        }

        public ListDevicesResult run() throws Exception {
            ListDevicesRequest listDevicesRequest = new ListDevicesRequest();
            listDevicesRequest.setAccessToken(DeviceOperations.access$100(DeviceOperations.this).getTokens().getAccessToken().getTokenString());
            listDevicesRequest.setLimit(this.val$limit);
            listDevicesRequest.setPaginationToken(this.val$paginationToken);
            com.amazonaws.services.cognitoidentityprovider.model.ListDevicesResult listDevices = DeviceOperations.access$200(DeviceOperations.this).listDevices(listDevicesRequest);
            ArrayList arrayList = new ArrayList(this.val$limit.intValue());
            Iterator it = listDevices.getDevices().iterator();
            while (it.hasNext()) {
                arrayList.add(DeviceOperations.access$300(DeviceOperations.this, (DeviceType) it.next()));
            }
            return new ListDevicesResult(arrayList, listDevices.getPaginationToken());
        }
    }

    public class 3 extends ReturningRunnable {
        final /* synthetic */ String val$deviceKey;
        final /* synthetic */ boolean val$rememberDevice;

        public 3(String str, boolean z) {
            this.val$deviceKey = str;
            this.val$rememberDevice = z;
        }

        public Void run() throws Exception {
            DeviceOperations.access$200(DeviceOperations.this).updateDeviceStatus(new UpdateDeviceStatusRequest().withAccessToken(DeviceOperations.access$100(DeviceOperations.this).getTokens().getAccessToken().getTokenString()).withDeviceKey(DeviceOperations.access$000(DeviceOperations.this, this.val$deviceKey).getDeviceKey()).withDeviceRememberedStatus(this.val$rememberDevice ? DeviceRememberedStatusType.Remembered : DeviceRememberedStatusType.Not_remembered));
            return null;
        }
    }

    public class 4 extends ReturningRunnable {
        final /* synthetic */ String val$deviceKey;

        public 4(String str) {
            this.val$deviceKey = str;
        }

        public Void run() throws Exception {
            DeviceOperations.access$200(DeviceOperations.this).forgetDevice(new ForgetDeviceRequest().withAccessToken(DeviceOperations.access$100(DeviceOperations.this).getTokens().getAccessToken().getTokenString()).withDeviceKey(DeviceOperations.access$000(DeviceOperations.this, this.val$deviceKey).getDeviceKey()));
            return null;
        }
    }

    public DeviceOperations(AWSMobileClient aWSMobileClient, AmazonCognitoIdentityProvider amazonCognitoIdentityProvider) {
        this.mobileClient = aWSMobileClient;
        this.userpoolLL = amazonCognitoIdentityProvider;
    }

    private ReturningRunnable _forgetDevice(String str) {
        return new 4(str);
    }

    private ReturningRunnable _getDevice(String str) {
        return new 1(str);
    }

    private ReturningRunnable _listDevices(Integer num, String str) {
        return new 2(num, str);
    }

    private ReturningRunnable _rememberDevice(String str, boolean z) {
        return new 3(str, z);
    }

    public static /* synthetic */ CognitoDevice access$000(DeviceOperations deviceOperations, String str) {
        return deviceOperations.getCognitoDevice(str);
    }

    public static /* synthetic */ AWSMobileClient access$100(DeviceOperations deviceOperations) {
        return deviceOperations.mobileClient;
    }

    public static /* synthetic */ AmazonCognitoIdentityProvider access$200(DeviceOperations deviceOperations) {
        return deviceOperations.userpoolLL;
    }

    public static /* synthetic */ Device access$300(DeviceOperations deviceOperations, DeviceType deviceType) {
        return deviceOperations.marshallDeviceTypeToDevice(deviceType);
    }

    private CognitoDevice getCognitoDevice(String str) {
        if (str == null) {
            str = this.mobileClient.userpool.getCurrentUser().thisDevice().getDeviceKey();
        }
        return new CognitoDevice(str, null, null, null, null, this.mobileClient.userpool.getCurrentUser(), this.mobileClient.mContext);
    }

    private Device marshallDeviceTypeToDevice(DeviceType deviceType) {
        HashMap hashMap = new HashMap();
        for (AttributeType attributeType : deviceType.getDeviceAttributes()) {
            hashMap.put(attributeType.getName(), attributeType.getValue());
        }
        return new Device(deviceType.getDeviceKey(), hashMap, deviceType.getDeviceCreateDate(), deviceType.getDeviceLastModifiedDate(), deviceType.getDeviceLastAuthenticatedDate());
    }

    public void forget() throws Exception {
        _forgetDevice(null).await();
    }

    public Device get() throws Exception {
        return (Device) _getDevice(null).await();
    }

    public ListDevicesResult list() throws Exception {
        return (ListDevicesResult) _listDevices(60, null).await();
    }

    public void updateStatus(String str, boolean z) throws Exception {
        _rememberDevice(str, z).await();
    }

    public void forget(Callback callback) {
        _forgetDevice(null).async(callback);
    }

    public Device get(String str) throws Exception {
        return (Device) _getDevice(str).await();
    }

    public ListDevicesResult list(Integer num, String str) throws Exception {
        return (ListDevicesResult) _listDevices(num, str).await();
    }

    public void updateStatus(String str, boolean z, Callback callback) {
        _rememberDevice(str, z).async(callback);
    }

    public void forget(String str) throws Exception {
        _forgetDevice(str).await();
    }

    public void get(Callback callback) {
        _getDevice(null).async(callback);
    }

    public void list(Callback callback) {
        _listDevices(60, null).async(callback);
    }

    public void updateStatus(boolean z) throws Exception {
        _rememberDevice(null, z).await();
    }

    public void forget(String str, Callback callback) {
        _forgetDevice(str).async(callback);
    }

    public void get(String str, Callback callback) {
        _getDevice(str).async(callback);
    }

    public void list(Integer num, String str, Callback callback) {
        _listDevices(num, str).async(callback);
    }

    public void updateStatus(boolean z, Callback callback) {
        _rememberDevice(null, z).async(callback);
    }
}

package com.amazonaws.mobileconnectors.cognitoidentityprovider;

import android.content.Context;
import android.os.Handler;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.exceptions.CognitoInternalErrorException;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.exceptions.CognitoNotAuthorizedException;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.exceptions.CognitoParameterInvalidException;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.handlers.GenericHandler;
import com.amazonaws.services.cognitoidentityprovider.model.DeviceType;
import com.amazonaws.services.cognitoidentityprovider.model.ForgetDeviceRequest;
import com.amazonaws.services.cognitoidentityprovider.model.GetDeviceRequest;
import com.amazonaws.services.cognitoidentityprovider.model.GetDeviceResult;
import com.amazonaws.services.cognitoidentityprovider.model.UpdateDeviceStatusRequest;
import com.amazonaws.services.cognitoidentityprovider.model.UpdateDeviceStatusResult;
import java.util.Date;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class CognitoDevice {
    private static final String DEVICE_NAME_ATTRIBUTE = "device_name";
    private static final String DEVICE_TYPE_NOT_REMEMBERED = "not_remembered";
    private static final String DEVICE_TYPE_REMEMBERED = "remembered";
    private final Context context;
    private final Date createDate;
    private CognitoUserAttributes deviceAttributes;
    private final String deviceKey;
    private Date lastAccessedDate;
    private Date lastModifiedDate;
    private final CognitoUser user;

    public class 1 implements Runnable {
        final /* synthetic */ GenericHandler val$callback;

        public class 1 implements Runnable {
            public 1() {
            }

            public void run() {
                1.this.val$callback.onSuccess();
            }
        }

        public class 2 implements Runnable {
            final /* synthetic */ Exception val$e;

            public 2(Exception exc) {
                this.val$e = exc;
            }

            public void run() {
                1.this.val$callback.onFailure(this.val$e);
            }
        }

        public 1(GenericHandler genericHandler) {
            this.val$callback = genericHandler;
        }

        public void run() {
            Runnable runnable;
            Handler handler = new Handler(CognitoDevice.access$000(CognitoDevice.this).getMainLooper());
            try {
                CognitoDevice cognitoDevice = CognitoDevice.this;
                CognitoDevice.access$300(CognitoDevice.this, CognitoDevice.access$200(cognitoDevice, CognitoDevice.access$100(cognitoDevice).getCachedSession()).getDevice());
                runnable = new 1();
            } catch (Exception e) {
                runnable = new 2(e);
            }
            handler.post(runnable);
        }
    }

    public class 2 implements Runnable {
        final /* synthetic */ GenericHandler val$callback;

        public class 1 implements Runnable {
            public 1() {
            }

            public void run() {
                2.this.val$callback.onSuccess();
            }
        }

        public class 2 implements Runnable {
            final /* synthetic */ Exception val$e;

            public 2(Exception exc) {
                this.val$e = exc;
            }

            public void run() {
                2.this.val$callback.onFailure(this.val$e);
            }
        }

        public 2(GenericHandler genericHandler) {
            this.val$callback = genericHandler;
        }

        public void run() {
            Runnable runnable;
            Handler handler = new Handler(CognitoDevice.access$000(CognitoDevice.this).getMainLooper());
            try {
                CognitoDevice cognitoDevice = CognitoDevice.this;
                CognitoDevice.access$400(cognitoDevice, CognitoDevice.access$100(cognitoDevice).getCachedSession());
                runnable = new 1();
            } catch (Exception e) {
                runnable = new 2(e);
            }
            handler.post(runnable);
        }
    }

    public class 3 implements Runnable {
        final /* synthetic */ GenericHandler val$callback;

        public class 1 implements Runnable {
            public 1() {
            }

            public void run() {
                3.this.val$callback.onSuccess();
            }
        }

        public class 2 implements Runnable {
            final /* synthetic */ Exception val$e;

            public 2(Exception exc) {
                this.val$e = exc;
            }

            public void run() {
                3.this.val$callback.onFailure(this.val$e);
            }
        }

        public 3(GenericHandler genericHandler) {
            this.val$callback = genericHandler;
        }

        public void run() {
            Runnable runnable;
            Handler handler = new Handler(CognitoDevice.access$000(CognitoDevice.this).getMainLooper());
            try {
                CognitoDevice cognitoDevice = CognitoDevice.this;
                CognitoDevice.access$500(cognitoDevice, CognitoDevice.access$100(cognitoDevice).getCachedSession(), "remembered");
                runnable = new 1();
            } catch (Exception e) {
                runnable = new 2(e);
            }
            handler.post(runnable);
        }
    }

    public class 4 implements Runnable {
        final /* synthetic */ GenericHandler val$callback;

        public class 1 implements Runnable {
            public 1() {
            }

            public void run() {
                4.this.val$callback.onSuccess();
            }
        }

        public class 2 implements Runnable {
            final /* synthetic */ Exception val$e;

            public 2(Exception exc) {
                this.val$e = exc;
            }

            public void run() {
                4.this.val$callback.onFailure(this.val$e);
            }
        }

        public 4(GenericHandler genericHandler) {
            this.val$callback = genericHandler;
        }

        public void run() {
            Runnable runnable;
            Handler handler = new Handler(CognitoDevice.access$000(CognitoDevice.this).getMainLooper());
            try {
                CognitoDevice cognitoDevice = CognitoDevice.this;
                CognitoDevice.access$500(cognitoDevice, CognitoDevice.access$100(cognitoDevice).getCachedSession(), "not_remembered");
                runnable = new 1();
            } catch (Exception e) {
                runnable = new 2(e);
            }
            handler.post(runnable);
        }
    }

    public CognitoDevice(DeviceType deviceType, CognitoUser cognitoUser, Context context) {
        this.deviceKey = deviceType.getDeviceKey();
        this.deviceAttributes = new CognitoUserAttributes(deviceType.getDeviceAttributes());
        this.createDate = deviceType.getDeviceCreateDate();
        this.lastModifiedDate = deviceType.getDeviceLastModifiedDate();
        this.lastAccessedDate = deviceType.getDeviceLastModifiedDate();
        this.user = cognitoUser;
        this.context = context;
    }

    public static /* synthetic */ Context access$000(CognitoDevice cognitoDevice) {
        return cognitoDevice.context;
    }

    public static /* synthetic */ CognitoUser access$100(CognitoDevice cognitoDevice) {
        return cognitoDevice.user;
    }

    public static /* synthetic */ GetDeviceResult access$200(CognitoDevice cognitoDevice, CognitoUserSession cognitoUserSession) {
        return cognitoDevice.getDeviceInternal(cognitoUserSession);
    }

    public static /* synthetic */ void access$300(CognitoDevice cognitoDevice, DeviceType deviceType) {
        cognitoDevice.updateThis(deviceType);
    }

    public static /* synthetic */ void access$400(CognitoDevice cognitoDevice, CognitoUserSession cognitoUserSession) {
        cognitoDevice.forgetDeviceInternal(cognitoUserSession);
    }

    public static /* synthetic */ UpdateDeviceStatusResult access$500(CognitoDevice cognitoDevice, CognitoUserSession cognitoUserSession, String str) {
        return cognitoDevice.updateDeviceStatusInternal(cognitoUserSession, str);
    }

    private void forgetDeviceInternal(CognitoUserSession cognitoUserSession) {
        if (cognitoUserSession == null || !cognitoUserSession.isValid()) {
            throw new CognitoNotAuthorizedException("User is not authorized");
        }
        if (this.deviceKey == null) {
            throw new CognitoParameterInvalidException("Device key is null");
        }
        ForgetDeviceRequest forgetDeviceRequest = new ForgetDeviceRequest();
        forgetDeviceRequest.setAccessToken(cognitoUserSession.getAccessToken().getJWTToken());
        forgetDeviceRequest.setDeviceKey(this.deviceKey);
        this.user.getCognitoIdentityProviderClient().forgetDevice(forgetDeviceRequest);
    }

    private GetDeviceResult getDeviceInternal(CognitoUserSession cognitoUserSession) {
        if (cognitoUserSession == null || !cognitoUserSession.isValid()) {
            throw new CognitoNotAuthorizedException("User is not authorized");
        }
        if (this.deviceKey == null) {
            throw new CognitoParameterInvalidException("Device key is null");
        }
        GetDeviceRequest getDeviceRequest = new GetDeviceRequest();
        getDeviceRequest.setAccessToken(cognitoUserSession.getAccessToken().getJWTToken());
        getDeviceRequest.setDeviceKey(this.deviceKey);
        return this.user.getCognitoIdentityProviderClient().getDevice(getDeviceRequest);
    }

    private UpdateDeviceStatusResult updateDeviceStatusInternal(CognitoUserSession cognitoUserSession, String str) {
        if (cognitoUserSession == null || !cognitoUserSession.isValid()) {
            throw new CognitoNotAuthorizedException("User is not authorized");
        }
        if (this.deviceKey == null) {
            throw new CognitoParameterInvalidException("Device key is invalid");
        }
        UpdateDeviceStatusRequest updateDeviceStatusRequest = new UpdateDeviceStatusRequest();
        updateDeviceStatusRequest.setAccessToken(cognitoUserSession.getAccessToken().getJWTToken());
        updateDeviceStatusRequest.setDeviceKey(this.deviceKey);
        updateDeviceStatusRequest.setDeviceRememberedStatus(str);
        return this.user.getCognitoIdentityProviderClient().updateDeviceStatus(updateDeviceStatusRequest);
    }

    private void updateThis(DeviceType deviceType) {
        if (deviceType == null) {
            throw new CognitoInternalErrorException("Service returned null object, this object was not updated");
        }
        if (!deviceType.getDeviceKey().equals(this.deviceKey)) {
            throw new CognitoInternalErrorException("Service error, this object was not updated");
        }
        this.deviceAttributes = new CognitoUserAttributes(deviceType.getDeviceAttributes());
        this.lastModifiedDate = deviceType.getDeviceLastModifiedDate();
        this.lastAccessedDate = deviceType.getDeviceLastModifiedDate();
    }

    public void doNotRememberThisDevice(GenericHandler genericHandler) {
        if (genericHandler == null) {
            throw new CognitoParameterInvalidException("callback is null");
        }
        try {
            updateDeviceStatusInternal(this.user.getCachedSession(), "not_remembered");
        } catch (Exception e) {
            genericHandler.onFailure(e);
        }
    }

    public void doNotRememberThisDeviceInBackground(GenericHandler genericHandler) {
        if (genericHandler == null) {
            throw new CognitoParameterInvalidException("callback is null");
        }
        new Thread(new 4(genericHandler)).start();
    }

    public void forgetDevice(GenericHandler genericHandler) {
        if (genericHandler == null) {
            throw new CognitoParameterInvalidException("callback is null");
        }
        try {
            forgetDeviceInternal(this.user.getCachedSession());
            genericHandler.onSuccess();
        } catch (Exception e) {
            genericHandler.onFailure(e);
        }
    }

    public void forgetDeviceInBackground(GenericHandler genericHandler) {
        if (genericHandler == null) {
            throw new CognitoParameterInvalidException("callback is null");
        }
        new Thread(new 2(genericHandler)).start();
    }

    public Date getCreateDate() {
        return this.createDate;
    }

    public void getDevice(GenericHandler genericHandler) {
        if (genericHandler == null) {
            throw new CognitoParameterInvalidException("callback is null");
        }
        try {
            updateThis(getDeviceInternal(this.user.getCachedSession()).getDevice());
            genericHandler.onSuccess();
        } catch (Exception e) {
            genericHandler.onFailure(e);
        }
    }

    public String getDeviceAttribute(String str) {
        try {
            return (String) this.deviceAttributes.getAttributes().get(str);
        } catch (Exception unused) {
            return null;
        }
    }

    public CognitoUserAttributes getDeviceAttributes() {
        return this.deviceAttributes;
    }

    public void getDeviceInBackground(GenericHandler genericHandler) {
        if (genericHandler == null) {
            throw new CognitoParameterInvalidException("callback is null");
        }
        new Thread(new 1(genericHandler)).start();
    }

    public String getDeviceKey() {
        return this.deviceKey;
    }

    public String getDeviceName() {
        return getDeviceAttribute("device_name");
    }

    public Date getLastAccessedDate() {
        return this.lastAccessedDate;
    }

    public Date getLastModifiedDate() {
        return this.lastModifiedDate;
    }

    public void rememberThisDevice(GenericHandler genericHandler) {
        if (genericHandler == null) {
            throw new CognitoParameterInvalidException("callback is null");
        }
        try {
            updateDeviceStatusInternal(this.user.getCachedSession(), "remembered");
        } catch (Exception e) {
            genericHandler.onFailure(e);
        }
    }

    public void rememberThisDeviceInBackground(GenericHandler genericHandler) {
        if (genericHandler == null) {
            throw new CognitoParameterInvalidException("callback is null");
        }
        new Thread(new 3(genericHandler)).start();
    }

    public CognitoDevice(String str, CognitoUserAttributes cognitoUserAttributes, Date date, Date date2, Date date3, CognitoUser cognitoUser, Context context) {
        this.deviceKey = str;
        this.deviceAttributes = cognitoUserAttributes;
        this.createDate = date;
        this.lastModifiedDate = date2;
        this.lastAccessedDate = date3;
        this.user = cognitoUser;
        this.context = context;
    }
}

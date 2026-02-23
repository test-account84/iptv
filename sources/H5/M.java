package H5;

import android.text.TextUtils;
import com.google.android.gms.common.api.Status;
import java.util.Arrays;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class m {
    public static Status a(String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            return new Status(17499);
        }
        String[] split = str.split(":", 2);
        split[0] = split[0].trim();
        if (split.length > 1 && (str2 = split[1]) != null) {
            split[1] = str2.trim();
        }
        List asList = Arrays.asList(split);
        return asList.size() > 1 ? b((String) asList.get(0), (String) asList.get(1)) : b((String) asList.get(0), null);
    }

    public static Status b(String str, String str2) {
        int i;
        str.hashCode();
        switch (str) {
            case "USER_CANCELLED":
                i = 18001;
                break;
            case "INVALID_RECIPIENT_EMAIL":
                i = 17033;
                break;
            case "WEB_CONTEXT_ALREADY_PRESENTED":
                i = 17057;
                break;
            case "INTERNAL_SUCCESS_SIGN_OUT":
                i = 17091;
                break;
            case "INVALID_IDP_RESPONSE":
            case "INVALID_LOGIN_CREDENTIALS":
            case "INVALID_PENDING_TOKEN":
                i = 17004;
                break;
            case "DYNAMIC_LINK_NOT_ACTIVATED":
                i = 17068;
                break;
            case "QUOTA_EXCEEDED":
                i = 17052;
                break;
            case "WEB_NETWORK_REQUEST_FAILED":
                i = 17061;
                break;
            case "INVALID_RECAPTCHA_VERSION":
                i = 17206;
                break;
            case "RECAPTCHA_NOT_ENABLED":
                i = 17200;
                break;
            case "EXPIRED_OOB_CODE":
                i = 17029;
                break;
            case "UNAUTHORIZED_DOMAIN":
                i = 17038;
                break;
            case "INVALID_OOB_CODE":
                i = 17030;
                break;
            case "MISSING_EMAIL":
                i = 17034;
                break;
            case "INVALID_CODE":
                i = 17044;
                break;
            case "TOKEN_EXPIRED":
                i = 17021;
                break;
            case "INVALID_TENANT_ID":
                i = 17079;
                break;
            case "ALTERNATE_CLIENT_IDENTIFIER_REQUIRED":
                i = 18002;
                break;
            case "INVALID_SESSION_INFO":
                i = 17046;
                break;
            case "SECOND_FACTOR_EXISTS":
                i = 17087;
                break;
            case "INVALID_EMAIL":
            case "INVALID_IDENTIFIER":
                i = 17008;
                break;
            case "ADMIN_ONLY_OPERATION":
                i = 17085;
                break;
            case "MISSING_OR_INVALID_NONCE":
                i = 17094;
                break;
            case "INVALID_CERT_HASH":
                i = 17064;
                break;
            case "NO_SUCH_PROVIDER":
                i = 17016;
                break;
            case "MFA_ENROLLMENT_NOT_FOUND":
                i = 17084;
                break;
            case "MISSING_PASSWORD":
                i = 17035;
                break;
            case "CREDENTIAL_TOO_OLD_LOGIN_AGAIN":
                i = 17014;
                break;
            case "TIMEOUT":
            case "<<Network Error>>":
                i = 17020;
                break;
            case "INVALID_REQ_TYPE":
                i = 17207;
                break;
            case "INVALID_RECAPTCHA_ACTION":
                i = 17203;
                break;
            case "OPERATION_NOT_ALLOWED":
            case "PASSWORD_LOGIN_DISABLED":
                i = 17006;
                break;
            case "WEB_INTERNAL_ERROR":
                i = 17062;
                break;
            case "SECOND_FACTOR_LIMIT_EXCEEDED":
                i = 17088;
                break;
            case "MISSING_MFA_ENROLLMENT_ID":
                i = 17082;
                break;
            case "USER_NOT_FOUND":
            case "EMAIL_NOT_FOUND":
                i = 17011;
                break;
            case "CAPTCHA_CHECK_FAILED":
                i = 17056;
                break;
            case "WEAK_PASSWORD":
                i = 17026;
                break;
            case "UNSUPPORTED_FIRST_FACTOR":
                i = 17089;
                break;
            case "INVALID_SENDER":
                i = 17032;
                break;
            case "MISSING_PHONE_NUMBER":
                i = 17041;
                break;
            case "INVALID_DYNAMIC_LINK_DOMAIN":
                i = 17074;
                break;
            case "MISSING_MFA_PENDING_CREDENTIAL":
                i = 17081;
                break;
            case "UNSUPPORTED_PASSTHROUGH_OPERATION":
                i = 17095;
                break;
            case "EMAIL_EXISTS":
                i = 17007;
                break;
            case "INVALID_ID_TOKEN":
                i = 17017;
                break;
            case "WEB_STORAGE_UNSUPPORTED":
                i = 17065;
                break;
            case "MISSING_CLIENT_TYPE":
                i = 17204;
                break;
            case "MISSING_RECAPTCHA_VERSION":
                i = 17205;
                break;
            case "UNVERIFIED_EMAIL":
                i = 17086;
                break;
            case "REJECTED_CREDENTIAL":
                i = 17075;
                break;
            case "INVALID_MFA_PENDING_CREDENTIAL":
                i = 17083;
                break;
            case "INVALID_VERIFICATION_PROOF":
                i = 17049;
                break;
            case "INVALID_PROVIDER_ID":
                i = 17071;
                break;
            case "CREDENTIAL_MISMATCH":
                i = 17002;
                break;
            case "WEB_CONTEXT_CANCELED":
                i = 17058;
                break;
            case "REQUIRES_SECOND_FACTOR_AUTH":
                i = 17078;
                break;
            case "MISSING_CLIENT_IDENTIFIER":
                i = 17093;
                break;
            case "INVALID_MESSAGE_PAYLOAD":
                i = 17031;
                break;
            case "RESET_PASSWORD_EXCEED_LIMIT":
            case "TOO_MANY_ATTEMPTS_TRY_LATER":
                i = 17010;
                break;
            case "INVALID_CUSTOM_TOKEN":
                i = 17000;
                break;
            case "INVALID_PASSWORD":
                i = 17009;
                break;
            case "INVALID_RECAPTCHA_TOKEN":
                i = 17202;
                break;
            case "SESSION_EXPIRED":
                i = 17051;
                break;
            case "MISSING_CODE":
                i = 17043;
                break;
            case "FEDERATED_USER_ID_ALREADY_LINKED":
                i = 17025;
                break;
            case "MISSING_RECAPTCHA_TOKEN":
                i = 17201;
                break;
            case "USER_DISABLED":
                i = 17005;
                break;
            case "INVALID_PHONE_NUMBER":
                i = 17042;
                break;
            case "INVALID_APP_CREDENTIAL":
                i = 17028;
                break;
            case "MISSING_CONTINUE_URI":
                i = 17040;
                break;
            case "MISSING_SESSION_INFO":
                i = 17045;
                break;
            case "EMAIL_CHANGE_NEEDS_VERIFICATION":
                i = 17090;
                break;
            case "UNSUPPORTED_TENANT_OPERATION":
                i = 17073;
                break;
            default:
                i = 17499;
                break;
        }
        if (i != 17499) {
            return new Status(i, str2);
        }
        if (str2 == null) {
            return new Status(i, str);
        }
        return new Status(i, str + ":" + str2);
    }
}

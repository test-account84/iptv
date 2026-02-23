package com.amplifyframework.auth.cognito.util;

import com.amazonaws.services.cognitoidentityprovider.model.AliasExistsException;
import com.amazonaws.services.cognitoidentityprovider.model.CodeDeliveryFailureException;
import com.amazonaws.services.cognitoidentityprovider.model.CodeMismatchException;
import com.amazonaws.services.cognitoidentityprovider.model.ExpiredCodeException;
import com.amazonaws.services.cognitoidentityprovider.model.InvalidParameterException;
import com.amazonaws.services.cognitoidentityprovider.model.InvalidPasswordException;
import com.amazonaws.services.cognitoidentityprovider.model.InvalidUserPoolConfigurationException;
import com.amazonaws.services.cognitoidentityprovider.model.LimitExceededException;
import com.amazonaws.services.cognitoidentityprovider.model.MFAMethodNotFoundException;
import com.amazonaws.services.cognitoidentityprovider.model.NotAuthorizedException;
import com.amazonaws.services.cognitoidentityprovider.model.PasswordResetRequiredException;
import com.amazonaws.services.cognitoidentityprovider.model.ResourceNotFoundException;
import com.amazonaws.services.cognitoidentityprovider.model.SoftwareTokenMFANotFoundException;
import com.amazonaws.services.cognitoidentityprovider.model.TooManyFailedAttemptsException;
import com.amazonaws.services.cognitoidentityprovider.model.TooManyRequestsException;
import com.amazonaws.services.cognitoidentityprovider.model.UserNotConfirmedException;
import com.amazonaws.services.cognitoidentityprovider.model.UserNotFoundException;
import com.amazonaws.services.cognitoidentityprovider.model.UsernameExistsException;
import com.amplifyframework.auth.AuthException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class CognitoAuthExceptionConverter {
    private CognitoAuthExceptionConverter() {
    }

    public static AuthException lookup(Exception exc, String str) {
        return exc instanceof UserNotFoundException ? new AuthException.UserNotFoundException(exc) : exc instanceof UserNotConfirmedException ? new AuthException.UserNotConfirmedException(exc) : exc instanceof UsernameExistsException ? new AuthException.UsernameExistsException(exc) : exc instanceof AliasExistsException ? new AuthException.AliasExistsException(exc) : exc instanceof InvalidPasswordException ? new AuthException.InvalidPasswordException(exc) : exc instanceof InvalidParameterException ? new AuthException.InvalidParameterException(exc) : exc instanceof InvalidUserPoolConfigurationException ? new AuthException.InvalidUserPoolConfigurationException(exc) : exc instanceof ExpiredCodeException ? new AuthException.CodeExpiredException(exc) : exc instanceof CodeMismatchException ? new AuthException.CodeMismatchException(exc) : exc instanceof CodeDeliveryFailureException ? new AuthException.CodeDeliveryFailureException(exc) : exc instanceof LimitExceededException ? new AuthException.LimitExceededException(exc) : exc instanceof MFAMethodNotFoundException ? new AuthException.MFAMethodNotFoundException(exc) : exc instanceof NotAuthorizedException ? new AuthException.NotAuthorizedException(exc) : exc instanceof ResourceNotFoundException ? new AuthException.ResourceNotFoundException(exc) : exc instanceof SoftwareTokenMFANotFoundException ? new AuthException.SoftwareTokenMFANotFoundException(exc) : exc instanceof TooManyFailedAttemptsException ? new AuthException.FailedAttemptsLimitExceededException(exc) : exc instanceof TooManyRequestsException ? new AuthException.TooManyRequestsException(exc) : exc instanceof PasswordResetRequiredException ? new AuthException.PasswordResetRequiredException(exc) : new AuthException(str, exc, "See attached exception for more details.");
    }
}

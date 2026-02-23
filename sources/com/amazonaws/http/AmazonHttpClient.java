package com.amazonaws.http;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.AmazonWebServiceRequest;
import com.amazonaws.AmazonWebServiceResponse;
import com.amazonaws.ClientConfiguration;
import com.amazonaws.Request;
import com.amazonaws.RequestClientOptions;
import com.amazonaws.Response;
import com.amazonaws.ResponseMetadata;
import com.amazonaws.handlers.CredentialsRequestHandler;
import com.amazonaws.handlers.RequestHandler2;
import com.amazonaws.internal.CRC32MismatchException;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.metrics.RequestMetricCollector;
import com.amazonaws.retry.RetryPolicy;
import com.amazonaws.util.AWSRequestMetrics;
import com.amazonaws.util.TimingInfo;
import com.amazonaws.util.URIBuilder;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class AmazonHttpClient {
    private static final String HEADER_SDK_RETRY_INFO = "aws-sdk-retry";
    private static final String HEADER_SDK_TRANSACTION_ID = "aws-sdk-invocation-id";
    private static final String HEADER_USER_AGENT = "User-Agent";
    private static final int HTTP_STATUS_MULTIPLE_CHOICES = 300;
    private static final int HTTP_STATUS_OK = 200;
    private static final int HTTP_STATUS_REQ_TOO_LONG = 413;
    private static final int HTTP_STATUS_SERVICE_UNAVAILABLE = 503;
    private static final int HTTP_STATUS_TEMP_REDIRECT = 307;
    private static final long TIME_MILLISEC = 1000;
    final ClientConfiguration config;
    final HttpClient httpClient;
    private final HttpRequestFactory requestFactory;
    private final RequestMetricCollector requestMetricCollector;
    private static final Log REQUEST_LOG = LogFactory.getLog("com.amazonaws.request");
    static final Log log = LogFactory.getLog(AmazonHttpClient.class);

    public AmazonHttpClient(ClientConfiguration clientConfiguration) {
        this(clientConfiguration, new UrlHttpClient(clientConfiguration));
    }

    public static String createUserAgentString(String str, String str2) {
        if (str.contains(str2)) {
            return str;
        }
        return str.trim() + " " + str2.trim();
    }

    private String getServerDateFromException(String str) {
        return str.substring(str.indexOf("(") + 1, str.indexOf(str.contains(" + 15") ? " + 15" : " - 15"));
    }

    private Throwable handleUnexpectedFailure(Throwable th, AWSRequestMetrics aWSRequestMetrics) {
        AWSRequestMetrics.Field field = AWSRequestMetrics.Field.Exception;
        aWSRequestMetrics.incrementCounter(field);
        aWSRequestMetrics.addProperty(field, th);
        return th;
    }

    private boolean isRequestSuccessful(HttpResponse httpResponse) {
        int statusCode = httpResponse.getStatusCode();
        return statusCode >= 200 && statusCode < 300;
    }

    private static boolean isTemporaryRedirect(HttpResponse httpResponse) {
        int statusCode = httpResponse.getStatusCode();
        String str = (String) httpResponse.getHeaders().get("Location");
        return (statusCode != 307 || str == null || str.isEmpty()) ? false : true;
    }

    private long pauseBeforeNextRetry(AmazonWebServiceRequest amazonWebServiceRequest, AmazonClientException amazonClientException, int i, RetryPolicy retryPolicy) {
        int i2 = i - 2;
        long delayBeforeNextRetry = retryPolicy.getBackoffStrategy().delayBeforeNextRetry(amazonWebServiceRequest, amazonClientException, i2);
        Log log2 = log;
        if (log2.isDebugEnabled()) {
            log2.debug("Retriable error detected, will retry in " + delayBeforeNextRetry + "ms, attempt number: " + i2);
        }
        try {
            Thread.sleep(delayBeforeNextRetry);
            return delayBeforeNextRetry;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new AmazonClientException(e.getMessage(), e);
        }
    }

    private boolean shouldRetry(AmazonWebServiceRequest amazonWebServiceRequest, InputStream inputStream, AmazonClientException amazonClientException, int i, RetryPolicy retryPolicy) {
        int i2 = i - 1;
        int maxErrorRetry = this.config.getMaxErrorRetry();
        if (maxErrorRetry < 0 || !retryPolicy.isMaxErrorRetryInClientConfigHonored()) {
            maxErrorRetry = retryPolicy.getMaxErrorRetry();
        }
        if (i2 >= maxErrorRetry) {
            return false;
        }
        if (inputStream == null || inputStream.markSupported()) {
            return retryPolicy.getRetryCondition().shouldRetry(amazonWebServiceRequest, amazonClientException, i2);
        }
        Log log2 = log;
        if (log2.isDebugEnabled()) {
            log2.debug("Content not repeatable");
        }
        return false;
    }

    public void afterError(Request request, Response response, List list, AmazonClientException amazonClientException) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((RequestHandler2) it.next()).afterError(request, response, amazonClientException);
        }
    }

    public void afterResponse(Request request, List list, Response response, TimingInfo timingInfo) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((RequestHandler2) it.next()).afterResponse(request, response);
        }
    }

    public Response execute(Request request, HttpResponseHandler httpResponseHandler, HttpResponseHandler httpResponseHandler2, ExecutionContext executionContext) {
        Response response;
        if (request.getHostPrefix() != null) {
            try {
                URI endpoint = request.getEndpoint();
                request.setEndpoint(URIBuilder.builder(endpoint).host(request.getHostPrefix() + endpoint.getHost()).build());
            } catch (URISyntaxException e) {
                Log log2 = log;
                if (log2.isDebugEnabled()) {
                    log2.debug("Failed to prepend host prefix: " + e.getMessage(), e);
                }
            }
        }
        if (executionContext == null) {
            throw new AmazonClientException("Internal SDK Error: No execution context parameter specified.");
        }
        List requestHandler2s = requestHandler2s(request, executionContext);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        try {
            response = executeHelper(request, httpResponseHandler, httpResponseHandler2, executionContext);
        } catch (AmazonClientException e2) {
            e = e2;
            response = null;
        }
        try {
            afterResponse(request, requestHandler2s, response, awsRequestMetrics.getTimingInfo().endTiming());
            return response;
        } catch (AmazonClientException e3) {
            e = e3;
            afterError(request, response, requestHandler2s, e);
            throw e;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:120:0x032d A[Catch: IOException -> 0x0335, TRY_LEAVE, TryCatch #30 {IOException -> 0x0335, blocks: (B:118:0x0327, B:120:0x032d), top: B:117:0x0327 }] */
    /* JADX WARN: Removed duplicated region for block: B:194:0x01ad A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0473  */
    /* JADX WARN: Removed duplicated region for block: B:54:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x03ec A[Catch: all -> 0x03ab, TRY_ENTER, TryCatch #6 {all -> 0x03ab, blocks: (B:61:0x03e2, B:64:0x03ec, B:65:0x0402, B:67:0x0444, B:81:0x0470, B:246:0x03a5, B:247:0x03aa), top: B:60:0x03e2 }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0444 A[Catch: all -> 0x03ab, TRY_LEAVE, TryCatch #6 {all -> 0x03ab, blocks: (B:61:0x03e2, B:64:0x03ec, B:65:0x0402, B:67:0x0444, B:81:0x0470, B:246:0x03a5, B:247:0x03aa), top: B:60:0x03e2 }] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0470 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0179 A[Catch: all -> 0x00da, Error -> 0x00e3, RuntimeException -> 0x00eb, IOException -> 0x0162, TRY_ENTER, TRY_LEAVE, TryCatch #25 {all -> 0x00da, blocks: (B:276:0x00c7, B:278:0x00d0, B:280:0x00d6, B:258:0x0144, B:28:0x0156, B:31:0x015e, B:34:0x016a, B:35:0x0170, B:86:0x0179, B:290:0x0103, B:291:0x0108), top: B:275:0x00c7 }] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0212  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.amazonaws.Response executeHelper(com.amazonaws.Request r27, com.amazonaws.http.HttpResponseHandler r28, com.amazonaws.http.HttpResponseHandler r29, com.amazonaws.http.ExecutionContext r30) {
        /*
            Method dump skipped, instructions count: 1162
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.http.AmazonHttpClient.executeHelper(com.amazonaws.Request, com.amazonaws.http.HttpResponseHandler, com.amazonaws.http.HttpResponseHandler, com.amazonaws.http.ExecutionContext):com.amazonaws.Response");
    }

    public void finalize() throws Throwable {
        shutdown();
        super.finalize();
    }

    public RequestMetricCollector getRequestMetricCollector() {
        return this.requestMetricCollector;
    }

    @Deprecated
    public ResponseMetadata getResponseMetadataForRequest(AmazonWebServiceRequest amazonWebServiceRequest) {
        return null;
    }

    public AmazonServiceException handleErrorResponse(Request request, HttpResponseHandler httpResponseHandler, HttpResponse httpResponse) throws IOException {
        AmazonServiceException amazonServiceException;
        String str;
        AmazonServiceException.ErrorType errorType;
        int statusCode = httpResponse.getStatusCode();
        try {
            amazonServiceException = (AmazonServiceException) httpResponseHandler.handle(httpResponse);
            REQUEST_LOG.debug("Received error response: " + amazonServiceException.toString());
        } catch (Exception e) {
            if (statusCode == 413) {
                str = "Request entity too large";
                amazonServiceException = new AmazonServiceException("Request entity too large");
                amazonServiceException.setServiceName(request.getServiceName());
                amazonServiceException.setStatusCode(413);
                errorType = AmazonServiceException.ErrorType.Client;
            } else {
                if (statusCode != 503 || !"Service Unavailable".equalsIgnoreCase(httpResponse.getStatusText())) {
                    if (e instanceof IOException) {
                        throw e;
                    }
                    throw new AmazonClientException("Unable to unmarshall error response (" + e.getMessage() + "). Response Code: " + statusCode + ", Response Text: " + httpResponse.getStatusText() + ", Response Headers: " + httpResponse.getHeaders(), e);
                }
                str = "Service unavailable";
                amazonServiceException = new AmazonServiceException("Service unavailable");
                amazonServiceException.setServiceName(request.getServiceName());
                amazonServiceException.setStatusCode(503);
                errorType = AmazonServiceException.ErrorType.Service;
            }
            amazonServiceException.setErrorType(errorType);
            amazonServiceException.setErrorCode(str);
        }
        amazonServiceException.setStatusCode(statusCode);
        amazonServiceException.setServiceName(request.getServiceName());
        amazonServiceException.fillInStackTrace();
        return amazonServiceException;
    }

    public Object handleResponse(Request request, HttpResponseHandler httpResponseHandler, HttpResponse httpResponse, ExecutionContext executionContext) throws IOException {
        try {
            AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
            AWSRequestMetrics.Field field = AWSRequestMetrics.Field.ResponseProcessingTime;
            awsRequestMetrics.startEvent(field);
            try {
                AmazonWebServiceResponse amazonWebServiceResponse = (AmazonWebServiceResponse) httpResponseHandler.handle(httpResponse);
                awsRequestMetrics.endEvent(field);
                if (amazonWebServiceResponse == null) {
                    throw new RuntimeException("Unable to unmarshall response metadata. Response Code: " + httpResponse.getStatusCode() + ", Response Text: " + httpResponse.getStatusText());
                }
                Log log2 = REQUEST_LOG;
                if (log2.isDebugEnabled()) {
                    log2.debug("Received successful response: " + httpResponse.getStatusCode() + ", AWS Request ID: " + amazonWebServiceResponse.getRequestId());
                }
                awsRequestMetrics.addProperty(AWSRequestMetrics.Field.AWSRequestID, amazonWebServiceResponse.getRequestId());
                return amazonWebServiceResponse.getResult();
            } catch (Throwable th) {
                awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ResponseProcessingTime);
                throw th;
            }
        } catch (Exception e) {
            throw new AmazonClientException("Unable to unmarshall response (" + e.getMessage() + "). Response Code: " + httpResponse.getStatusCode() + ", Response Text: " + httpResponse.getStatusText(), e);
        } catch (CRC32MismatchException e2) {
            throw e2;
        } catch (IOException e3) {
            throw e3;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:4:0x0025 A[Catch: RuntimeException -> 0x0022, TRY_ENTER, TRY_LEAVE, TryCatch #0 {RuntimeException -> 0x0022, blocks: (B:16:0x0014, B:4:0x0025), top: B:15:0x0014 }] */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.lang.String] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long parseClockSkewOffset(com.amazonaws.http.HttpResponse r4, com.amazonaws.AmazonServiceException r5) {
        /*
            r3 = this;
            java.util.Date r0 = new java.util.Date
            r0.<init>()
            java.util.Map r4 = r4.getHeaders()
            java.lang.String r1 = "Date"
            java.lang.Object r4 = r4.get(r1)
            java.lang.String r4 = (java.lang.String) r4
            r1 = 0
            if (r4 == 0) goto L25
            boolean r2 = r4.isEmpty()     // Catch: java.lang.RuntimeException -> L22
            if (r2 == 0) goto L1b
            goto L25
        L1b:
            java.util.Date r4 = com.amazonaws.util.DateUtils.parseRFC822Date(r4)     // Catch: java.lang.RuntimeException -> L20
            goto L31
        L20:
            r5 = move-exception
            goto L3e
        L22:
            r5 = move-exception
            r4 = r1
            goto L3e
        L25:
            java.lang.String r4 = r5.getMessage()     // Catch: java.lang.RuntimeException -> L22
            java.lang.String r4 = r3.getServerDateFromException(r4)     // Catch: java.lang.RuntimeException -> L22
            java.util.Date r4 = com.amazonaws.util.DateUtils.parseCompressedISO8601Date(r4)     // Catch: java.lang.RuntimeException -> L20
        L31:
            long r0 = r0.getTime()
            long r4 = r4.getTime()
            long r0 = r0 - r4
            r4 = 1000(0x3e8, double:4.94E-321)
            long r0 = r0 / r4
            return r0
        L3e:
            com.amazonaws.logging.Log r0 = com.amazonaws.http.AmazonHttpClient.log
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Unable to parse clock skew offset from response: "
            r1.append(r2)
            r1.append(r4)
            java.lang.String r4 = r1.toString()
            r0.warn(r4, r5)
            r4 = 0
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.http.AmazonHttpClient.parseClockSkewOffset(com.amazonaws.http.HttpResponse, com.amazonaws.AmazonServiceException):long");
    }

    public List requestHandler2s(Request request, ExecutionContext executionContext) {
        List<RequestHandler2> requestHandler2s = executionContext.getRequestHandler2s();
        if (requestHandler2s == null) {
            return Collections.emptyList();
        }
        for (RequestHandler2 requestHandler2 : requestHandler2s) {
            if (requestHandler2 instanceof CredentialsRequestHandler) {
                ((CredentialsRequestHandler) requestHandler2).setCredentials(executionContext.getCredentials());
            }
            requestHandler2.beforeRequest(request);
        }
        return requestHandler2s;
    }

    public void resetRequestAfterError(Request request, Exception exc) {
        if (request.getContent() == null) {
            return;
        }
        if (!request.getContent().markSupported()) {
            throw new AmazonClientException("Encountered an exception and stream is not resettable", exc);
        }
        try {
            request.getContent().reset();
        } catch (IOException unused) {
            throw new AmazonClientException("Encountered an exception and couldn't reset the stream to retry", exc);
        }
    }

    public void setUserAgent(Request request) {
        RequestClientOptions requestClientOptions;
        String clientMarker;
        String str = ClientConfiguration.DEFAULT_USER_AGENT;
        AmazonWebServiceRequest originalRequest = request.getOriginalRequest();
        String createUserAgentString = (originalRequest == null || (requestClientOptions = originalRequest.getRequestClientOptions()) == null || (clientMarker = requestClientOptions.getClientMarker(RequestClientOptions.Marker.USER_AGENT)) == null) ? str : createUserAgentString(str, clientMarker);
        if (!str.equals(this.config.getUserAgent())) {
            createUserAgentString = createUserAgentString(createUserAgentString, this.config.getUserAgent());
        }
        if (this.config.getUserAgentOverride() != null) {
            createUserAgentString = this.config.getUserAgentOverride();
        }
        request.addHeader("User-Agent", createUserAgentString);
    }

    public void shutdown() {
        this.httpClient.shutdown();
    }

    public AmazonHttpClient(ClientConfiguration clientConfiguration, HttpClient httpClient) {
        this.requestFactory = new HttpRequestFactory();
        this.config = clientConfiguration;
        this.httpClient = httpClient;
        this.requestMetricCollector = null;
    }

    @Deprecated
    public AmazonHttpClient(ClientConfiguration clientConfiguration, HttpClient httpClient, RequestMetricCollector requestMetricCollector) {
        this.requestFactory = new HttpRequestFactory();
        this.config = clientConfiguration;
        this.httpClient = httpClient;
        this.requestMetricCollector = requestMetricCollector;
    }

    @Deprecated
    public AmazonHttpClient(ClientConfiguration clientConfiguration, RequestMetricCollector requestMetricCollector) {
        this(clientConfiguration, new UrlHttpClient(clientConfiguration), requestMetricCollector);
    }
}

package retrofit2;

import java.io.IOException;
import okhttp3.Call;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import okio.ForwardingSource;
import okio.Okio;
import okio.Source;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
final class OkHttpCall implements Call {
    private final Object[] args;
    private final Call.Factory callFactory;
    private volatile boolean canceled;
    private Throwable creationFailure;
    private boolean executed;
    private okhttp3.Call rawCall;
    private final RequestFactory requestFactory;
    private final Converter responseConverter;

    public class 1 implements okhttp3.Callback {
        final /* synthetic */ Callback val$callback;

        public 1(Callback callback) {
            this.val$callback = callback;
        }

        private void callFailure(Throwable th) {
            try {
                this.val$callback.onFailure(OkHttpCall.this, th);
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }

        public void onFailure(okhttp3.Call call, IOException iOException) {
            callFailure(iOException);
        }

        public void onResponse(okhttp3.Call call, okhttp3.Response response) {
            try {
                try {
                    this.val$callback.onResponse(OkHttpCall.this, OkHttpCall.this.parseResponse(response));
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            } catch (Throwable th2) {
                Utils.throwIfFatal(th2);
                callFailure(th2);
            }
        }
    }

    public static final class ExceptionCatchingResponseBody extends ResponseBody {
        private final ResponseBody delegate;
        IOException thrownException;

        public class 1 extends ForwardingSource {
            public 1(Source source) {
                super(source);
            }

            public long read(Buffer buffer, long j) throws IOException {
                try {
                    return super.read(buffer, j);
                } catch (IOException e) {
                    ExceptionCatchingResponseBody.this.thrownException = e;
                    throw e;
                }
            }
        }

        public ExceptionCatchingResponseBody(ResponseBody responseBody) {
            this.delegate = responseBody;
        }

        public void close() {
            this.delegate.close();
        }

        public long contentLength() {
            return this.delegate.contentLength();
        }

        public MediaType contentType() {
            return this.delegate.contentType();
        }

        public BufferedSource source() {
            return Okio.buffer(new 1(this.delegate.source()));
        }

        public void throwIfCaught() throws IOException {
            IOException iOException = this.thrownException;
            if (iOException != null) {
                throw iOException;
            }
        }
    }

    public static final class NoContentResponseBody extends ResponseBody {
        private final long contentLength;
        private final MediaType contentType;

        public NoContentResponseBody(MediaType mediaType, long j) {
            this.contentType = mediaType;
            this.contentLength = j;
        }

        public long contentLength() {
            return this.contentLength;
        }

        public MediaType contentType() {
            return this.contentType;
        }

        public BufferedSource source() {
            throw new IllegalStateException("Cannot read raw response body of a converted body.");
        }
    }

    public OkHttpCall(RequestFactory requestFactory, Object[] objArr, Call.Factory factory, Converter converter) {
        this.requestFactory = requestFactory;
        this.args = objArr;
        this.callFactory = factory;
        this.responseConverter = converter;
    }

    private okhttp3.Call createRawCall() throws IOException {
        okhttp3.Call newCall = this.callFactory.newCall(this.requestFactory.create(this.args));
        if (newCall != null) {
            return newCall;
        }
        throw new NullPointerException("Call.Factory returned null.");
    }

    public void cancel() {
        okhttp3.Call call;
        this.canceled = true;
        synchronized (this) {
            call = this.rawCall;
        }
        if (call != null) {
            call.cancel();
        }
    }

    public void enqueue(Callback callback) {
        okhttp3.Call call;
        Throwable th;
        Utils.checkNotNull(callback, "callback == null");
        synchronized (this) {
            try {
                if (this.executed) {
                    throw new IllegalStateException("Already executed.");
                }
                this.executed = true;
                call = this.rawCall;
                th = this.creationFailure;
                if (call == null && th == null) {
                    try {
                        okhttp3.Call createRawCall = createRawCall();
                        this.rawCall = createRawCall;
                        call = createRawCall;
                    } catch (Throwable th2) {
                        th = th2;
                        Utils.throwIfFatal(th);
                        this.creationFailure = th;
                    }
                }
            } catch (Throwable th3) {
                throw th3;
            }
        }
        if (th != null) {
            callback.onFailure(this, th);
            return;
        }
        if (this.canceled) {
            call.cancel();
        }
        call.enqueue(new 1(callback));
    }

    public Response execute() throws IOException {
        okhttp3.Call call;
        synchronized (this) {
            try {
                if (this.executed) {
                    throw new IllegalStateException("Already executed.");
                }
                this.executed = true;
                RuntimeException runtimeException = this.creationFailure;
                if (runtimeException != null) {
                    if (runtimeException instanceof IOException) {
                        throw ((IOException) runtimeException);
                    }
                    if (runtimeException instanceof RuntimeException) {
                        throw runtimeException;
                    }
                    throw ((Error) runtimeException);
                }
                call = this.rawCall;
                if (call == null) {
                    try {
                        call = createRawCall();
                        this.rawCall = call;
                    } catch (RuntimeException | Error | IOException e) {
                        Utils.throwIfFatal(e);
                        this.creationFailure = e;
                        throw e;
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (this.canceled) {
            call.cancel();
        }
        return parseResponse(call.execute());
    }

    public boolean isCanceled() {
        boolean z = true;
        if (this.canceled) {
            return true;
        }
        synchronized (this) {
            try {
                okhttp3.Call call = this.rawCall;
                if (call == null || !call.isCanceled()) {
                    z = false;
                }
            } finally {
            }
        }
        return z;
    }

    public synchronized boolean isExecuted() {
        return this.executed;
    }

    public Response parseResponse(okhttp3.Response response) throws IOException {
        ResponseBody body = response.body();
        okhttp3.Response build = response.newBuilder().body(new NoContentResponseBody(body.contentType(), body.contentLength())).build();
        int code = build.code();
        if (code < 200 || code >= 300) {
            try {
                return Response.error(Utils.buffer(body), build);
            } finally {
                body.close();
            }
        }
        if (code == 204 || code == 205) {
            body.close();
            return Response.success((Object) null, build);
        }
        ExceptionCatchingResponseBody exceptionCatchingResponseBody = new ExceptionCatchingResponseBody(body);
        try {
            return Response.success(this.responseConverter.convert(exceptionCatchingResponseBody), build);
        } catch (RuntimeException e) {
            exceptionCatchingResponseBody.throwIfCaught();
            throw e;
        }
    }

    public synchronized Request request() {
        okhttp3.Call call = this.rawCall;
        if (call != null) {
            return call.request();
        }
        RuntimeException runtimeException = this.creationFailure;
        if (runtimeException != null) {
            if (runtimeException instanceof IOException) {
                throw new RuntimeException("Unable to create request.", this.creationFailure);
            }
            if (runtimeException instanceof RuntimeException) {
                throw runtimeException;
            }
            throw ((Error) runtimeException);
        }
        try {
            okhttp3.Call createRawCall = createRawCall();
            this.rawCall = createRawCall;
            return createRawCall.request();
        } catch (IOException e) {
            this.creationFailure = e;
            throw new RuntimeException("Unable to create request.", e);
        } catch (Error e2) {
            e = e2;
            Utils.throwIfFatal(e);
            this.creationFailure = e;
            throw e;
        } catch (RuntimeException e3) {
            e = e3;
            Utils.throwIfFatal(e);
            this.creationFailure = e;
            throw e;
        }
    }

    public OkHttpCall clone() {
        return new OkHttpCall(this.requestFactory, this.args, this.callFactory, this.responseConverter);
    }
}

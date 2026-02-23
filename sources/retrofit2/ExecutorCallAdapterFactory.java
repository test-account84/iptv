package retrofit2;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.concurrent.Executor;
import okhttp3.Request;
import retrofit2.CallAdapter;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
final class ExecutorCallAdapterFactory extends CallAdapter.Factory {
    final Executor callbackExecutor;

    public class 1 implements CallAdapter {
        final /* synthetic */ Type val$responseType;

        public 1(Type type) {
            this.val$responseType = type;
        }

        public Type responseType() {
            return this.val$responseType;
        }

        public Call adapt(Call call) {
            return new ExecutorCallbackCall(ExecutorCallAdapterFactory.this.callbackExecutor, call);
        }
    }

    public static final class ExecutorCallbackCall implements Call {
        final Executor callbackExecutor;
        final Call delegate;

        public class 1 implements Callback {
            final /* synthetic */ Callback val$callback;

            public class 1 implements Runnable {
                final /* synthetic */ Response val$response;

                public 1(Response response) {
                    this.val$response = response;
                }

                public void run() {
                    if (ExecutorCallbackCall.this.delegate.isCanceled()) {
                        1 r0 = 1.this;
                        r0.val$callback.onFailure(ExecutorCallbackCall.this, new IOException("Canceled"));
                    } else {
                        1 r02 = 1.this;
                        r02.val$callback.onResponse(ExecutorCallbackCall.this, this.val$response);
                    }
                }
            }

            public class 2 implements Runnable {
                final /* synthetic */ Throwable val$t;

                public 2(Throwable th) {
                    this.val$t = th;
                }

                public void run() {
                    1 r0 = 1.this;
                    r0.val$callback.onFailure(ExecutorCallbackCall.this, this.val$t);
                }
            }

            public 1(Callback callback) {
                this.val$callback = callback;
            }

            public void onFailure(Call call, Throwable th) {
                ExecutorCallbackCall.this.callbackExecutor.execute(new 2(th));
            }

            public void onResponse(Call call, Response response) {
                ExecutorCallbackCall.this.callbackExecutor.execute(new 1(response));
            }
        }

        public ExecutorCallbackCall(Executor executor, Call call) {
            this.callbackExecutor = executor;
            this.delegate = call;
        }

        public void cancel() {
            this.delegate.cancel();
        }

        public void enqueue(Callback callback) {
            Utils.checkNotNull(callback, "callback == null");
            this.delegate.enqueue(new 1(callback));
        }

        public Response execute() throws IOException {
            return this.delegate.execute();
        }

        public boolean isCanceled() {
            return this.delegate.isCanceled();
        }

        public boolean isExecuted() {
            return this.delegate.isExecuted();
        }

        public Request request() {
            return this.delegate.request();
        }

        public Call clone() {
            return new ExecutorCallbackCall(this.callbackExecutor, this.delegate.clone());
        }
    }

    public ExecutorCallAdapterFactory(Executor executor) {
        this.callbackExecutor = executor;
    }

    public CallAdapter get(Type type, Annotation[] annotationArr, Retrofit retrofit) {
        if (CallAdapter.Factory.getRawType(type) != Call.class) {
            return null;
        }
        return new 1(Utils.getCallResponseType(type));
    }
}

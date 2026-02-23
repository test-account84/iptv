package retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.concurrent.CompletableFuture;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;
import retrofit2.CallAdapter;

@IgnoreJRERequirement
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
final class CompletableFutureCallAdapterFactory extends CallAdapter.Factory {
    static final CallAdapter.Factory INSTANCE = new CompletableFutureCallAdapterFactory();

    @IgnoreJRERequirement
    public static final class BodyCallAdapter implements CallAdapter {
        private final Type responseType;

        public class 1 extends CompletableFuture {
            final /* synthetic */ Call val$call;

            public 1(Call call) {
                this.val$call = call;
            }

            public boolean cancel(boolean z) {
                if (z) {
                    this.val$call.cancel();
                }
                return super.cancel(z);
            }
        }

        public class 2 implements Callback {
            final /* synthetic */ CompletableFuture val$future;

            public 2(CompletableFuture completableFuture) {
                this.val$future = completableFuture;
            }

            public void onFailure(Call call, Throwable th) {
                b.a(this.val$future, th);
            }

            public void onResponse(Call call, Response response) {
                if (response.isSuccessful()) {
                    c.a(this.val$future, response.body());
                } else {
                    b.a(this.val$future, new HttpException(response));
                }
            }
        }

        public BodyCallAdapter(Type type) {
            this.responseType = type;
        }

        public Type responseType() {
            return this.responseType;
        }

        public CompletableFuture adapt(Call call) {
            1 r0 = new 1(call);
            call.enqueue(new 2(r0));
            return r0;
        }
    }

    @IgnoreJRERequirement
    public static final class ResponseCallAdapter implements CallAdapter {
        private final Type responseType;

        public class 1 extends CompletableFuture {
            final /* synthetic */ Call val$call;

            public 1(Call call) {
                this.val$call = call;
            }

            public boolean cancel(boolean z) {
                if (z) {
                    this.val$call.cancel();
                }
                return super.cancel(z);
            }
        }

        public class 2 implements Callback {
            final /* synthetic */ CompletableFuture val$future;

            public 2(CompletableFuture completableFuture) {
                this.val$future = completableFuture;
            }

            public void onFailure(Call call, Throwable th) {
                b.a(this.val$future, th);
            }

            public void onResponse(Call call, Response response) {
                c.a(this.val$future, response);
            }
        }

        public ResponseCallAdapter(Type type) {
            this.responseType = type;
        }

        public Type responseType() {
            return this.responseType;
        }

        public CompletableFuture adapt(Call call) {
            1 r0 = new 1(call);
            call.enqueue(new 2(r0));
            return r0;
        }
    }

    public CallAdapter get(Type type, Annotation[] annotationArr, Retrofit retrofit) {
        if (CallAdapter.Factory.getRawType(type) != a.a()) {
            return null;
        }
        if (!(type instanceof ParameterizedType)) {
            throw new IllegalStateException("CompletableFuture return type must be parameterized as CompletableFuture<Foo> or CompletableFuture<? extends Foo>");
        }
        ParameterizedType parameterUpperBound = CallAdapter.Factory.getParameterUpperBound(0, (ParameterizedType) type);
        if (CallAdapter.Factory.getRawType(parameterUpperBound) != Response.class) {
            return new BodyCallAdapter(parameterUpperBound);
        }
        if (parameterUpperBound instanceof ParameterizedType) {
            return new ResponseCallAdapter(CallAdapter.Factory.getParameterUpperBound(0, parameterUpperBound));
        }
        throw new IllegalStateException("Response must be parameterized as Response<Foo> or Response<? extends Foo>");
    }
}

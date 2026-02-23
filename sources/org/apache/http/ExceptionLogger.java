package org.apache.http;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public interface ExceptionLogger {
    public static final ExceptionLogger NO_OP = new 1();
    public static final ExceptionLogger STD_ERR = new 2();

    public static class 1 implements ExceptionLogger {
        public void log(Exception exc) {
        }
    }

    public static class 2 implements ExceptionLogger {
        public void log(Exception exc) {
            exc.printStackTrace();
        }
    }

    void log(Exception exc);
}

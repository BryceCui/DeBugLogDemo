package com.example.mingren.debuglogdemo;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by mingren on 2017/12/14.
 */

public final class Debug {
    private static boolean isDebug = true;//判断是否打印log
    private static String mClassName;//类名
    private static String mMethodName;//方法名
    private static int mLineNumber;//行数

    private static void getMethodNames(StackTraceElement[] stackTraceElementps) {
        mClassName = stackTraceElementps[1].getFileName();
        mMethodName = stackTraceElementps[1].getMethodName();
        mLineNumber = stackTraceElementps[1].getLineNumber();
        //http://m.blog.csdn.net/wenzhi20102321/article/details/78138399
    }

    /**
     * 获取当前文件的基本信息
     */
    private static StringBuffer getFileInfo() {
        getMethodNames(new Throwable().getStackTrace());//获取获取包含文件名、方法名、行数的对象数据
        StringBuffer buffer = new StringBuffer();
        buffer.append(mMethodName);
        buffer.append("(").append(mClassName).append(":").append(mLineNumber).append(")");
        return buffer;
    }
    //各种Log打印
    public static void e(Object o) {
        if (isDebug) {
            StringBuffer buffer = getFileInfo();
            Log.e("TAG", buffer + "打印：------      " + o.toString());
        }
    }



    public static void e(int i) {
        if (isDebug) {
            StringBuffer buffer = getFileInfo();
            Log.e("TAG", buffer + "打印：------      " + i);
        }
    }

    public static void e(float i) {
        if (isDebug) {
            StringBuffer buffer = getFileInfo();
            Log.e("TAG",  buffer +"打印：------      " + i);
        }
    }

    public static void e(boolean b) {
        if (isDebug) {
            StringBuffer buffer = getFileInfo();
            Log.e("TAG",  buffer +"打印：------      " + b);
        }
    }

    //各种土司
    public static void ts(Context context, Object object) {
        if (isDebug) {
            Toast.makeText(context, object + "", Toast.LENGTH_SHORT).show();
        }
    }

    public static void tsl(Context context, Object object) {
        if (isDebug)
            Toast.makeText(context, object + "", Toast.LENGTH_LONG).show();
    }

}

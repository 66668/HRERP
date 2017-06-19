package com.huirong.utils;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

/**
 * ͳ统一管理log类
 * 在代码中要打印log,就直接DebugUtil.debug(....).然后如果发布的时候,就直接把这个类的DEBUG 改成false,这样所有的log就不会再打印在控制台.
 * 
 */
public class LogUtils {
	
	private static final String TAG = "SJY";
	
	private static final boolean LOGGER = true;

	public static void v(String tag, String msg) {
		if (LOGGER) {
			Log.v(TAG, "<----"+tag + "-->" + msg);
		}
	}

	public static void d(String tag, String msg) {
		if (LOGGER) {
			Log.d(TAG, "<----"+tag + "---->" + msg);
		}
	}

	public static void i(String tag, String msg) {
		if (LOGGER) {
			Log.i(TAG, "<----"+tag + "---->" + msg);
		}
	}

	public static void w(String tag, String msg) {
		if (LOGGER) {
			Log.v(TAG, "<----"+tag + "---->" + msg);
		}
	}

	public static void e(String tag, String msg) {
		if (LOGGER) {
			Log.e(TAG, "<----"+tag + "---->" + msg);
		}
	}

	public static void e(String tag, String msg, Throwable tr) {
		if (LOGGER) {
			Log.e(TAG,  "<----"+tag + "---->" + msg);
		}
	}


	public static void toast(Context context, String content) {
		if (LOGGER) {
			Toast.makeText(context, content, Toast.LENGTH_SHORT).show();
		}
	}

}

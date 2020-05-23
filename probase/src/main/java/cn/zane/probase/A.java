package cn.zane.probase;

import android.os.Build;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * created by zhangshi on 2020/5/23.
 */
public class A {
    /**
     * 反射 禁止弹窗
     */
    public static void disableAPIDialog() {
        if (Build.VERSION.SDK_INT < 28)
            return;
        try {
            Class clazz = Class.forName("android.app.ActivityThread");
            Method currentActivityThread = clazz.getDeclaredMethod("currentActivityThread");
            currentActivityThread.setAccessible(true);
            Object activityThread = currentActivityThread.invoke(null);
            Field mHiddenApiWarningShown = clazz.getDeclaredField("mHiddenApiWarningShown");
            mHiddenApiWarningShown.setAccessible(true);
            mHiddenApiWarningShown.setBoolean(activityThread, true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

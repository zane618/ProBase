package cn.zane.probase.systembug

import android.os.Build

/**
 * created by zhangshi on 2020-04-02.
 */
object DetectedProblemsWithAPI {
    /**
     * 反射 禁止弹窗
     */
    fun disableAPIDialog() {
        if (Build.VERSION.SDK_INT < 28) return
        try {
            val clazz = Class.forName("android.app.ActivityThread")
            val currentActivityThread =
                clazz.getDeclaredMethod("currentActivityThread")
            currentActivityThread.isAccessible = true
            val activityThread = currentActivityThread.invoke(null)
            val mHiddenApiWarningShown =
                clazz.getDeclaredField("mHiddenApiWarningShown")
            mHiddenApiWarningShown.isAccessible = true
            mHiddenApiWarningShown.setBoolean(activityThread, true)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}
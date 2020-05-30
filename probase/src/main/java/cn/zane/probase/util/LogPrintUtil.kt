package cn.zane.probase.util

import android.util.Log

/**
 * created by zhangshi on 2020/5/30.
 */
object LogPrintUtil {
    var isPrintLog = true

    fun zhangshi(msg: String) {
        if (isPrintLog) {
            Log.e("zhangshi", msg)
        }
    }
}
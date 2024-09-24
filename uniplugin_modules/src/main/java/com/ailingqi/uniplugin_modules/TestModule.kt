package com.ailingqi.uniplugin_modules

import android.app.Activity
import android.content.Intent
import com.alibaba.fastjson.JSONObject
import io.dcloud.feature.uniapp.annotation.UniJSMethod
import io.dcloud.feature.uniapp.bridge.UniJSCallback
import io.dcloud.feature.uniapp.common.UniModule

class TestModule : UniModule() {
    // 运行在UI线程
    @UniJSMethod(uiThread = true)
    fun testAsyncFunc(options: JSONObject, callback: UniJSCallback? = null) {
        println("异步方法调用成功--$options")
        if (callback != null) {
            val data = JSONObject()
            data["message"] = "异步方法调用成功"
            callback.invoke(data)
        }
    }

    // 运行在JS线程
    @UniJSMethod(uiThread = false)
    fun testSyncFunc(options: JSONObject): JSONObject {
        println("异步方法调用成功--$options")
        return JSONObject().apply {
            put("message", "同步方法调用成功")
        }
    }

    @UniJSMethod(uiThread = true)
    fun gotoNativePage() {
        if (mUniSDKInstance != null && mUniSDKInstance.context is Activity) {
            println("调用跳转至原生Activity页面成功")
            val intent = Intent(mUniSDKInstance.context, NativePageActivity::class.java)
            (mUniSDKInstance.context as Activity).startActivityForResult(intent, REQUEST_CODE)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == REQUEST_CODE && data != null && data.hasExtra("respond")) {
            println("原生页面返回UniAPP成功--" + data.getStringExtra("respond"))
        } else {
            super.onActivityResult(requestCode, resultCode, data)
        }
    }

    companion object {
        const val REQUEST_CODE = 1000
    }
}
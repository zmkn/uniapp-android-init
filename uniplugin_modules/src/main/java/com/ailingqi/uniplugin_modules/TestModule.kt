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
        println("testAsyncFunc--$options")
        if (callback != null) {
            val data = JSONObject()
            data["code"] = "success"
            callback.invoke(data)
        }
    }

    // 运行在JS线程
    @UniJSMethod(uiThread = false)
    fun testSyncFunc(): JSONObject {
        return JSONObject().apply {
            put("code", "success")
        }
    }

    @UniJSMethod(uiThread = true)
    fun gotoNativePage() {
        if (mUniSDKInstance != null && mUniSDKInstance.context is Activity) {
            val intent = Intent(mUniSDKInstance.context, NativePageActivity::class.java)
            (mUniSDKInstance.context as Activity).startActivityForResult(intent, REQUEST_CODE)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == REQUEST_CODE && data != null && data.hasExtra("respond")) {
            println("原生页面返回----" + data.getStringExtra("respond"))
        } else {
            super.onActivityResult(requestCode, resultCode, data)
        }
    }

    companion object {
        const val REQUEST_CODE = 1000
    }
}
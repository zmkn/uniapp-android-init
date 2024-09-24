package com.ailingqi.uniplugin_modules

import android.app.Application
import io.dcloud.feature.uniapp.UniAppHookProxy
import io.dcloud.feature.uniapp.UniSDKEngine

class HookProxy : UniAppHookProxy {
    override fun onCreate(application: Application?) {
        // 当前uni应用进程回调 仅触发一次 多进程不会触发
        UniSDKEngine.registerUniModule("TestModule", TestModule::class.java)
    }

    override fun onSubProcessCreate(application: Application?) {
        // 其他子进程初始化回调 可用于初始化需要子进程初始化需要的逻辑
    }
}
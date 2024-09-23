package com.ailingqi.uniplugin_modules

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.TextView

class NativePageActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val rootView = FrameLayout(this)
        val textView = TextView(this).apply {
            text = "点击我将返回 并携带参数返回"
            setOnClickListener {
                val intent = Intent()
                intent.putExtra("respond", "我是原生页面")
                setResult(TestModule.REQUEST_CODE, intent)
                finish()
            }
        }
        rootView.addView(
            textView,
            FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 300)
        )
        setContentView(rootView)
    }
}
package com.swu.zzm.android5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        //获取传递过来的Intent数据
        val first = intent.getIntExtra("first",0)
        val second = intent.getIntExtra("second",0)

        //实现按钮的点击事件
        mCalculateBtn.setOnClickListener {
            //开始计算
            val result = first + second

            //将结果回调给上一个页面
            Intent().apply {
                putExtra("result",result)
            }.also {
                setResult(0,it)
                //返回上一个页面
                finish()
            }
        }
    }
}
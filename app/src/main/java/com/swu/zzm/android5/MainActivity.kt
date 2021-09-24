package com.swu.zzm.android5

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.jvm.java as java

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //给按钮添加点击事件
        mNextBtn.setOnClickListener {
            //跳转到下一个界面 进行计算
            Intent().apply {
                //设置值
                putExtra("first",mFirst.text.toString().toInt())
                putExtra("second",mSecond.text.toString().toInt())

                //设置从哪个页面跳转到哪个页面
                setClass(this@MainActivity,DetailActivity::class.java)

                //跳转
                //startActivity(this)
                startActivityForResult(this,123)
            }
        }

        //分享按钮点击事件
        mSharedBtn.setOnClickListener {
            Intent().apply {
                action = "zzm.wechat"
                data = Uri.parse("content: 今天完成了Activity界面跳转")
            }.also {
                //startActivity(it)
                startActivityForResult(it,456)
            }
        }
    }

    //接收回调数据
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 123){
            data?.getIntExtra("result",0).also {
                mResult.text = it.toString()
            }
        }else if (requestCode == 456){
            //分享界面
            data?.getStringExtra("shareResult").also {
                //弹出提示框
                Toast.makeText(this,it,Toast.LENGTH_LONG).show()
            }
        }
    }

}
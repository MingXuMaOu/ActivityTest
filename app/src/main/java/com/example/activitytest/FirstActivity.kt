package com.example.activitytest

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_first.*

class FirstActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)

        button1.setOnClickListener {
//            Toast.makeText(this,"You Click button 1",Toast.LENGTH_SHORT).show()
//            finish()
//            val intent = Intent(this,SecondActivity::class.java)
//            val intent = Intent("com.example.activitytest.ACTION_START")
//            intent.addCategory("com.example.activity.MY_CATEGORY")
//            val intent = Intent(Intent.ACTION_VIEW)
//            intent.data = Uri.parse("https://www.baidu.com")
//            val intent = Intent(Intent.ACTION_DIAL)
//            intent.data = Uri.parse("tel:10086")
//            val data = "Hello SecondActivity"
            val intent = Intent(this,SecondActivity::class.java)
//            intent.putExtra("extra_data",data)
//            startActivity(intent)
            startActivityForResult(intent,1)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when(requestCode){
            1 -> when(resultCode){
                RESULT_OK -> {
                    val returnData = data?.getStringExtra("data_return")
                    Log.d("FirstActivity", "onActivityResult: return data is $returnData")
                }
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main,menu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.add_item -> Toast.makeText(this,"You clicked Add",Toast.LENGTH_SHORT).show()
            R.id.remove_item -> Toast.makeText(this,"You click Remove",Toast.LENGTH_SHORT).show()
        }
        return true
    }
}
package com.kmt.labstarter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.kmt.labstarter.database.AppDatabase
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        doAsync {

            val database = AppDatabase.getInstance(context = this@MainActivity)
            val customers = database.studentDao().all

            uiThread {
                Toast.makeText(this@MainActivity, customers.get(0).firstName, Toast.LENGTH_SHORT).show()
//                mAdapter!!.addAll(customers)
            }
        }
    }
}

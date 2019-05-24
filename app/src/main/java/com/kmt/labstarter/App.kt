package com.kmt.labstarter

import android.app.Application
import com.kmt.labstarter.database.AppDatabase
import com.kmt.labstarter.database.entities.Student
import org.jetbrains.anko.doAsync

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        doAsync {
            val database = AppDatabase.getInstance(context = this@App)

            if (database.studentDao().all.isEmpty()) {
                val students: MutableList<Student> = mutableListOf()
                for (index: Int in 0..20) {
                    val client = Student(index, "Name" + index, "Surname" + index)
                    students.add(index, client)
                }
                database.studentDao().insertAll(students = students)
            }
        }
    }

}
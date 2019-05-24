package com.kmt.labstarter.database.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.kmt.labstarter.database.entities.Student

@Dao
interface StudentDao {

    @get:Query("SELECT * FROM student")
    val all: List<Student>

    @Query("SELECT * FROM student WHERE uid IN (:studentsId)")
    fun loadAllByIds(studentsId: Array<Int>): List<Student>

    @Query("SELECT * FROM customer WHERE first_name LIKE :first AND " + "last_name LIKE :last LIMIT 1")
    fun findByName(first: String, last: String): Student

    @Insert
    fun insertAll(students: List<Student>)

    @Delete
    fun delete(client: Student)

}
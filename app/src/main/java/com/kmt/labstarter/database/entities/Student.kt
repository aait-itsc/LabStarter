package com.kmt.labstarter.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Student constructor(uid: Int, firstName: String, lastName: String) {

    @PrimaryKey
    var uid: Int = uid

    @ColumnInfo(name = "first_name")
    var firstName: String? = firstName

    @ColumnInfo(name = "last_name")
    var lastName: String? = lastName
}
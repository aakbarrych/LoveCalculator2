package com.example.lovecalculator2.remote

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

//{
//    "fname": "John",
//    "sname": "Alice",
//    "percentage": "46",
//    "result": "Can choose someone better."
//}
@Entity(tableName = "love_model")
data class LoveModel(
    @SerializedName("fname")
    var firstName: String,
    @SerializedName("sname")
    var secondName: String,
    var percentage: String,
    var result: String,
    @PrimaryKey(autoGenerate = true)
    val id: Int?
): java.io.Serializable

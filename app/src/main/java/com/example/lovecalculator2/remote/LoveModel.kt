package com.example.lovecalculator2.remote

import com.google.gson.annotations.SerializedName

//{
//    "fname": "John",
//    "sname": "Alice",
//    "percentage": "46",
//    "result": "Can choose someone better."
//}

data class LoveModel(
    @SerializedName("fname")
    var firstName: String,
    @SerializedName("sname")
    var secondName: String,
    var percentage: String,
    var result: String
): java.io.Serializable

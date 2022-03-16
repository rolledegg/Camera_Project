package smu.app.bookreviewapp.model

import com.google.gson.annotations.SerializedName

data class Book (
    @SerializedName("itemId") val id:Long,
    @SerializedName("title") val title:String,
    @SerializedName("discription") val discription:String,
    @SerializedName("coverSmallUrl") val coverSmallUrl:String
)
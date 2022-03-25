package smu.app.bookreviewapp.model

import com.google.gson.annotations.SerializedName

data class SearchBookDto (
    @SerializedName("title") val title: String,
    @SerializedName("items") val books: List<Book>
        )
package com.stmik.myrecyclerview


interface BookApi {

    @GET("book.json")
    suspend fun getBooks() : Response<List<Book>>
}


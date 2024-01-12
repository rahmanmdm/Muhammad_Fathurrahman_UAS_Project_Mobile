package com.stmik.myrecyclerview
import android.os.Parcel
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class Book(
    @SerializedName("title")
    val name: String,
    @SerializedName("desc")
    val description: String,
    @SerializedName("image")
    val photo: String
) : Parcelable

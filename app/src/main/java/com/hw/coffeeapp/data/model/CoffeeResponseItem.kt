package com.hw.coffeeapp.data.model


import android.os.Parcel
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "coffee_response")
data class CoffeeResponseItem(
    @PrimaryKey(autoGenerate = true)
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("description")
    val description: String? = null,
    @SerializedName("image")
    val image: String? = null,
    @SerializedName("title")
    val title: String? = null,
    @SerializedName("ingredients" )
    var ingredients : List<String> = listOf()
): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        TODO("ingredients")
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(id)
        parcel.writeString(description)
        parcel.writeString(image)
        parcel.writeString(title)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<CoffeeResponseItem> {
        override fun createFromParcel(parcel: Parcel): CoffeeResponseItem {
            return CoffeeResponseItem(parcel)
        }

        override fun newArray(size: Int): Array<CoffeeResponseItem?> {
            return arrayOfNulls(size)
        }
    }
}
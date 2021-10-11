package com.example.mypingoceanapplication

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class ProfileResponse(
    @SerializedName("id")
    var id: String? = null,
    @SerializedName("name")
    var name: String? = null,
    @SerializedName("email")
    var email: String? = null,
    @SerializedName("phone")
    var phone: String? = null,
    @SerializedName("avatar")
    var avatar: String? = null,
    @SerializedName("position")
    var position: String? = null,
    @SerializedName("company_name")
    var company_name: String? = null,
    @SerializedName("timezone")
    var timezone: String? = null,
    @SerializedName("sections")
    var sections: List<String>? = null,
    @SerializedName("alert_email")
    var alert_email: String? = null,
    @SerializedName("send_system_notifications")
    var send_system_notifications: Boolean? = null
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.createStringArrayList(),
        parcel.readString(),
        parcel.readValue(Boolean::class.java.classLoader) as? Boolean
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(id)
        parcel.writeString(name)
        parcel.writeString(email)
        parcel.writeString(phone)
        parcel.writeString(avatar)
        parcel.writeString(position)
        parcel.writeString(company_name)
        parcel.writeString(timezone)
        parcel.writeStringList(sections)
        parcel.writeString(alert_email)
        parcel.writeValue(send_system_notifications)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ProfileResponse> {
        override fun createFromParcel(parcel: Parcel): ProfileResponse {
            return ProfileResponse(parcel)
        }

        override fun newArray(size: Int): Array<ProfileResponse?> {
            return arrayOfNulls(size)
        }
    }
}
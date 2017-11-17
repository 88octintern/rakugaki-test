package com.example.rakugaki

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable
import java.util.*

/**
 * Created by daisuke on 2017/01/11.
 */

open class Photo : Serializable {

    @Expose
    @SerializedName("id")
    var id: Long = 0

    @Expose
    @SerializedName("body")
    var body: String? = null

    @Expose
    @SerializedName("user_id")
    var userId: Long = 0

    @Expose
    @SerializedName("user_name")
    var userName: String? = null

    @Expose
    @SerializedName("name")
    var name: String? = null

    @Expose
    @SerializedName("image_thumbnail_url")
    var imageThumbnailUrl: String? = null

    @Expose
    @SerializedName("image_url")
    var imageUrl: String? = null

    @Expose
    @SerializedName("editable_flg")
    var isEditableFlg: Boolean = false

    @Expose
    @SerializedName("created_at")
    var createdAt: Date? = null

    @Expose
    @SerializedName("updated_at")
    var updatedAt: Date? = null

    @Expose
    @SerializedName("originated_at")
    var originatedAt: Date? = null

    var isSelected: Boolean = false


    companion object {
        fun getPhoto(photoid: Long? = null): Photo? {
            return null
        }
    }
}
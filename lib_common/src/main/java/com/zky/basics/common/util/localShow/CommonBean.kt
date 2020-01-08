package com.zky.basics.common.util.localShow

import android.os.Parcel
import android.os.Parcelable
import android.text.TextUtils

/**
 * Created by lk
 * Date 2019-11-11
 * Time 17:44
 * Detail:
 */
//本地图片视频
class AlbumFile() : Parcelable, Comparable<AlbumFile> {


    var TYPE_INvarID = 0
    var TYPE_IMAGE = 1
    var TYPE_VIDEO = 2
    var localFile = false
    /**
     * File path.
     */
    var path: String = ""
    /**
     * File name.
     */
    var name: String? = null
    /**
     * Title.
     */
    var title: String? = null
    /**
     * Folder id.
     */
    var bucketId: Int = 0
    /**
     * Folder mName.
     */
    var bucketName: String? = null
    /**
     * File mime type.
     */
    var mimeType: String? = null
    /**
     * Add date.
     */
    var addDate: Long = 0
    /**
     * Modify date.
     */
    var modifyDate: Long = 0
    /**
     * Latitude
     */
    var latitude: Float = 0f
    /**
     * Longitude.
     */
    var longitude: Float = 0f
    /**
     * Size.
     */
    var size: Long = 0
    /**
     * Duration.
     */
    var duration: Long = 0
    /**
     * Thumb path.
     */
    var thumbPath: String? = null
    /**
     * UI width.
     */
    var width: Int = 0
    /**
     * UI height.
     */
    var height: Int = 0
    /**
     * MediaType;
     */
    var mediaType: Int = 0
    /**
     * Checked.
     */
    var checked: Boolean = false
    /**
     * Enabled.
     */
    var enable = true
    //
    var filter = path

    constructor(parcel: Parcel) : this() {
        localFile = parcel.readByte() != 0.toByte()
        path = parcel.readString()
        name = parcel.readString()
        title = parcel.readString()
        bucketId = parcel.readInt()
        bucketName = parcel.readString()
        mimeType = parcel.readString()
        addDate = parcel.readLong()
        modifyDate = parcel.readLong()
        latitude = parcel.readFloat()
        longitude = parcel.readFloat()
        size = parcel.readLong()
        duration = parcel.readLong()
        thumbPath = parcel.readString()
        width = parcel.readInt()
        height = parcel.readInt()
        mediaType = parcel.readInt()
        checked = parcel.readByte() != 0.toByte()
        enable = parcel.readByte() != 0.toByte()
        filter = parcel.readString()
    }

    override operator fun compareTo(other: AlbumFile): Int {
        val time = addDate - other.addDate
        return if (time > 0)
            -1
        else
            1
    }

    override fun equals(obj: Any?): Boolean {
        if (obj != null && obj is AlbumFile) {
            if (!TextUtils.isEmpty(filter) && !TextUtils.isEmpty(obj.filter)) {
                return filter == obj.filter
            }
        }
        return super.equals(obj)
    }

    override fun hashCode(): Int {
        val key = "$bucketId$path"
        return key.hashCode()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeByte(if (localFile) 1 else 0)
        parcel.writeString(path)
        parcel.writeString(name)
        parcel.writeString(title)
        parcel.writeInt(bucketId)
        parcel.writeString(bucketName)
        parcel.writeString(mimeType)
        parcel.writeLong(addDate)
        parcel.writeLong(modifyDate)
        parcel.writeFloat(latitude)
        parcel.writeFloat(longitude)
        parcel.writeLong(size)
        parcel.writeLong(duration)
        parcel.writeString(thumbPath)
        parcel.writeInt(width)
        parcel.writeInt(height)
        parcel.writeInt(mediaType)
        parcel.writeByte(if (checked) 1 else 0)
        parcel.writeByte(if (enable) 1 else 0)
        parcel.writeString(filter)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<AlbumFile> {
        override fun createFromParcel(parcel: Parcel): AlbumFile {
            return AlbumFile(parcel)
        }

        override fun newArray(size: Int): Array<AlbumFile?> {
            return arrayOfNulls(size)
        }
    }

}
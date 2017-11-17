package com.example.rakugaki

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log

/**
 * Created by daisuke on 2017/10/23.
 * rakugaki in photo.
 */
class RakugakiPhoto{

    private var intent: Intent? = null

    companion object {
        val PHOTO_REQUEST_CODE = 692

        val KEY_RAKUGAKI_PHOTO = "key_rakugaki_photo"

        val EXTRA_RAKUGAKI_PHOTO = "extra_rakugaki_photo"

        val EXTRA_RAKUGAKI_PHOTO_ROTATE = "extra_rakugaki_photo_rotate"

        fun builder(): RakugakiPhotoBuilder {
            return RakugakiPhotoBuilder()
        }
    }

    //builder
    class RakugakiPhotoBuilder{

        var rakugakiPhotoOptions: Bundle = Bundle()
        var rakugakiIntent = Intent()

        fun setImageUrl(urlString:String?): RakugakiPhotoBuilder {
            rakugakiPhotoOptions.putString(EXTRA_RAKUGAKI_PHOTO,urlString)
            return this
        }

        fun setImageRotate(rotate:Float): RakugakiPhotoBuilder {
            Log.v("test", "setImageRotate rotate=${rotate}")
            rakugakiPhotoOptions.putFloat(EXTRA_RAKUGAKI_PHOTO_ROTATE,rotate)
            return this
        }

        fun start(activity:Activity,requestCode:Int){
            if (PermissionsUtils.checkWriteStoragePermission(activity)) {
                activity.startActivityForResult(getIntent(activity),requestCode)
            }
        }

        fun getIntent(context: Context):Intent{
            return RakugakiPhotoActivity.createIntent(context, rakugakiPhotoOptions)
        }

    }

}
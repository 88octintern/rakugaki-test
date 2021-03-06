package com.example.rakugaki

import android.content.Context
import android.databinding.BaseObservable
import android.databinding.Bindable
import android.graphics.Bitmap
import android.support.v4.content.ContextCompat
import android.view.View

/**
 * Created by 88oct on 2017/10/13.
 */
class PhotoEditViewModel(var photo: Photo?, var rakugaki: RakugakiCore? = null) : BaseObservable() {

    @get:Bindable
    var imageUrl: String? = null
        set(value) {
            field = value
            notifyPropertyChanged(BR.imageUrl)
        }

    @get:Bindable
    var pentable: Boolean = false
        set(value) {
            field = value
            if (value) {
                palettable = true
            } else if (charactable) {
                palettable = false
            }
            notifyPropertyChanged(BR.pentable)
        }

    @get:Bindable
    var redPentable: Boolean = false
        set(value) {
            field = value
            notifyPropertyChanged(BR.redPentable)
        }

    @get:Bindable
    var bluePentable: Boolean = false
        set(value) {
            field = value
            notifyPropertyChanged(BR.bluePentable)
        }

    @get:Bindable
    var blackPentable: Boolean = false
        set(value) {
            field = value
            notifyPropertyChanged(BR.blackPentable)
        }

    @get:Bindable
    var whitePentable: Boolean = false
        set(value) {
            field = value
            notifyPropertyChanged(BR.whitePentable)
        }

    @get:Bindable
    var charactable: Boolean = false
        set(value) {
            field = value
            if (value) {
                palettable = true
            } else if (pentable) {
                palettable = false
            }
            notifyPropertyChanged(BR.charactable)
        }

    @get:Bindable
    var palettable: Boolean = false
        set(value) {
            field = value
            notifyPropertyChanged(BR.palettable)
        }

    @get:Bindable
    var menuVisibility: Int = View.VISIBLE
        set(value) {
            field = value
            notifyPropertyChanged(BR.menuVisibility)
        }

    @get:Bindable
    var deletable: Boolean = false
        set(value) {
            field = value
            notifyPropertyChanged(BR.deletable)
        }

    var callback: Callback? = null

    init {
        imageUrl = photo?.imageUrl
    }

    fun setColor(color: Int, context: Context){

        when(color){
            ContextCompat.getColor(context, R.color.red) ->{
                redPentable = true
                bluePentable = false
                whitePentable = false
                blackPentable = false
                rakugaki?.setRedColor()
            }
            ContextCompat.getColor(context, R.color.blue) ->{
                redPentable = false
                bluePentable = true
                whitePentable = false
                blackPentable = false
                rakugaki?.setBlueColor()
            }
            ContextCompat.getColor(context, R.color.black) ->{
                redPentable = false
                bluePentable = false
                whitePentable = false
                blackPentable = true
                rakugaki?.setBlackColor()
            }
            ContextCompat.getColor(context, R.color.white) ->{
                redPentable = false
                bluePentable = false
                whitePentable = true
                blackPentable = false
                rakugaki?.setWhiteColor()
            }
        }

    }

    fun onClickPentable(view: View) {
        val rakugaki = rakugaki ?: return
        if(!rakugaki.isEnabled ) return

        pentable = !pentable
        if (pentable || charactable) {
            menuVisibility = View.GONE
            callback?.enableCancel()
        } else {
            menuVisibility = View.VISIBLE
            callback?.enableBack()
        }

        redPentable = true
        bluePentable = false
        whitePentable = false
        blackPentable = false
        pentable = true
        rakugaki.callback = object : RakugakiCore.Callback {
            override fun canSave() {
                rakugaki.freehandStart().setRedColor()
                rakugaki.callback = null
            }
        }
        if (rakugaki.isFreehandNull()) {
            rakugaki.freehandStart().setRedColor()
        } else {
            val end = rakugaki.freehandEnd()
            if(!end){
                rakugaki.freehandStart().setRedColor()
            }
        }
    }

    fun onClickRedPentable(view: View) {
        val rakugaki = rakugaki ?: return
        if(!rakugaki.isEnabled ) return

        redPentable = true
        bluePentable = false
        whitePentable = false
        blackPentable = false
        if (pentable) {
            rakugaki.callback = object : RakugakiCore.Callback {
                override fun canSave() {
                    rakugaki.freehandStart().setRedColor()
                    rakugaki.callback = null
                }
            }
            if (rakugaki.isFreehandNull()) {
                rakugaki.freehandStart().setRedColor()
            } else {
                val end = rakugaki.freehandEnd()
                if(!end){
                    rakugaki.freehandStart().setRedColor()
                }
            }
        } else if (charactable) {
            rakugaki.setRedColor()
        }
    }

    fun onClickBluePentable(view: View) {
        val rakugaki = rakugaki ?: return
        if(!rakugaki.isEnabled ) return

        bluePentable = true
        redPentable = false
        whitePentable = false
        blackPentable = false
        if (pentable) {
            rakugaki.callback = object : RakugakiCore.Callback {
                override fun canSave() {
                    rakugaki.freehandStart().setBlueColor()
                    rakugaki.callback = null
                }
            }
            if (rakugaki.isFreehandNull()) {
                rakugaki.freehandStart().setBlueColor()
            } else {
                val end = rakugaki.freehandEnd()
                if(!end){
                    rakugaki.freehandStart().setBlueColor()
                }
            }
        } else if (charactable) {
            rakugaki.setBlueColor()
        }
    }

    fun onClickBlackPentable(view: View) {
        val rakugaki = rakugaki ?: return
        if(!rakugaki.isEnabled ) return

        blackPentable = true
        bluePentable = false
        whitePentable = false
        redPentable = false
        if (pentable) {
            rakugaki.callback = object : RakugakiCore.Callback {
                override fun canSave() {
                    rakugaki.freehandStart().setBlackColor()
                    rakugaki.callback = null
                }
            }
            if (rakugaki.isFreehandNull()) {
                rakugaki.freehandStart().setBlackColor()
            } else {
                val end = rakugaki.freehandEnd()
                if(!end){
                    rakugaki.freehandStart().setBlackColor()
                }
            }
        } else if (charactable) {
            rakugaki.setBlackColor()
        }
    }

    fun onClickWhitePentable(view: View) {
        val rakugaki = rakugaki ?: return
        if(!rakugaki.isEnabled ) return

        whitePentable = true
        bluePentable = false
        redPentable = false
        blackPentable = false
        if (pentable) {
            rakugaki.callback = object : RakugakiCore.Callback {
                override fun canSave() {
                    rakugaki.freehandStart().setWhiteColor()
                    rakugaki.callback = null
                }
            }
            if (rakugaki.isFreehandNull()) {
                rakugaki.freehandStart().setWhiteColor()
            } else {
                val end = rakugaki.freehandEnd()
                if(!end){
                    rakugaki.freehandStart().setWhiteColor()
                }
            }
        } else if (charactable) {
            rakugaki.setWhiteColor()
        }
    }

    fun setCharactable(){
        val rakugaki = rakugaki ?: return
        if(!rakugaki.isEnabled ) return

        charactable = true
        if (pentable || charactable) {
            menuVisibility = View.GONE
            callback?.enableCancel()
        } else {
            menuVisibility = View.VISIBLE
            callback?.enableBack()
        }
        redPentable = true
        bluePentable = false
        whitePentable = false
        blackPentable = false
    }

    fun onClickCharactable(view: View) {
        val rakugaki = rakugaki ?: return
        if(!rakugaki.isEnabled ) return

        setCharactable()
        rakugaki?.fixed()
        rakugaki?.freetextStart()
    }

    fun toMenu() {
        redPentable = false
        bluePentable = false
        whitePentable = false
        blackPentable = false

        pentable = false
        charactable = false
        menuVisibility = View.VISIBLE
    }

    fun onClickEnd(view: View) {
        charactable = false
        whitePentable = false
        bluePentable = false
        redPentable = false
        blackPentable = false
        pentable = false
        rakugaki?.freehandEnd()
    }

    fun onClickRewind(view: View) {
        println("onClickRewind")
        val rakugaki = rakugaki ?: return

        if (!rakugaki.isFreehandNull()) {
            rakugaki.freehandEnd()
        } else if (!rakugaki.isFreetextNull()) {
            rakugaki.freetextEnd()
        } else {
            rakugaki.rewind()
        }

        rakugaki.callback = object : RakugakiCore.Callback {
            override fun canSave() {
                println("callback canSave()")
                rakugaki.callback = null
                rakugaki.rewind()

                blackPentable = false
                bluePentable = false
                whitePentable = false
                redPentable = false
            }
        }
    }

    fun sendFile(view: View) {

    }

    interface Callback {
        fun enableCancel()

        fun enableBack()
    }

    companion object {
    }
}
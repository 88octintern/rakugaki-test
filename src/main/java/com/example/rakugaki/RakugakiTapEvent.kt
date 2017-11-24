package com.example.rakugaki

import android.view.View

/**
 * Created by daisuke on 2016/07/29.
 */
class RakugakiTapEvent constructor(val event: RakugakiEvent, val view: View){

    enum class RakugakiEvent{
        TEXTABLE,DRAGGING,RELEASED
    }

}
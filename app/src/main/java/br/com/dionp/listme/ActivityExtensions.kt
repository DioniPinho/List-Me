package br.com.dionp.listme

import android.app.Activity
import android.support.design.widget.Snackbar
import android.view.View

fun Activity.showSnack(view: View, msg:String){
    Snackbar.make(view, msg, Snackbar.LENGTH_SHORT).show()
}
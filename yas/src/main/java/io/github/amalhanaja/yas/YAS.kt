package io.github.amalhanaja.yas

import android.graphics.Color
import android.support.annotation.ColorInt
import android.support.annotation.DrawableRes
import android.support.design.widget.Snackbar
import android.support.v4.content.ContextCompat
import android.view.Gravity
import android.view.View
import android.widget.TextView

/**
 * Created by doy on 11/11/17.
 * Email : amalhanaja@gmail.com
 * Created On : 11/11/17.
 */

class YAS {
    companion object {
        fun make(view: View, message: Message.() -> Unit): Snackbar{
            val msg = Message().apply { message() }
            return Snackbar.make(view, msg.text ?: "", Snackbar.LENGTH_INDEFINITE).apply {
                msg.duration?.let { setDuration(it) }
                this.view.apply {
                    msg.backgroundColor?.let { setBackgroundColor(it) }
                }
                this.view.findViewById<TextView>(android.support.design.R.id.snackbar_text).apply {
                    msg.color?.let { setTextColor(it) }
                    setCompoundDrawablesWithIntrinsicBounds(msg.icon ?: 0, 0, 0, 0)
                    gravity = Gravity.CENTER
                    compoundDrawablePadding = 16
                }
            }
        }
        fun make(view: View, message: Message.() -> Unit, action: Action.() -> Unit): Snackbar{
            val msg = Message().apply { message() }
            val act = Action().apply { action() }
            return Snackbar.make(view, msg.text ?: "", Snackbar.LENGTH_INDEFINITE).apply {
                msg.duration?.let { setDuration(it) }
                this.view.apply {
                    msg.backgroundColor?.let { setBackgroundColor(it) }
                }
                this.view.findViewById<TextView>(android.support.design.R.id.snackbar_text).apply {
                    msg.color?.let { setTextColor(it) }
                    setCompoundDrawablesWithIntrinsicBounds(msg.icon ?: 0, 0, 0, 0)
                    gravity = Gravity.CENTER
                    compoundDrawablePadding = 16
                }
                act.color?.let { this.setActionTextColor(it) }
                act.dismiss()?.invoke(this.dismiss())
                setAction(act.text, act.clickHolder)
            }
        }

        fun error(view: View, message: String): Snackbar = make(view, {
            text = message
            color = ContextCompat.getColor(view.context, android.R.color.white)
            icon = R.drawable.ic_error
            backgroundColor = Color.rgb(243,70,70)
            duration = Snackbar.LENGTH_SHORT

        }, {
            text = "DISMISS"
            color = ContextCompat.getColor(view.context, android.R.color.white)
            onClick { dismiss() }
        })
        fun success(view: View, message: String): Snackbar = make(view, {
            text = message
            color = ContextCompat.getColor(view.context, android.R.color.white)
            backgroundColor = Color.rgb(92, 174, 83)
            duration = Snackbar.LENGTH_SHORT
            icon = R.drawable.ic_success
        })

        fun warning(view: View, message: String): Snackbar = make(view, {
            text = message
            color = ContextCompat.getColor(view.context, android.R.color.white)
            backgroundColor = Color.rgb(254, 196, 23)
            duration = Snackbar.LENGTH_SHORT
            icon = R.drawable.ic_warning
        })

        fun info(view: View, message: String): Snackbar = make(view, {
            text = message
            color = ContextCompat.getColor(view.context, android.R.color.white)
            backgroundColor = Color.rgb(106, 74, 182)
            duration = Snackbar.LENGTH_SHORT
            icon = R.drawable.ic_info
        })

        fun normal(view: View, message: String): Snackbar = make(view, {
            text = message
            color = ContextCompat.getColor(view.context, android.R.color.white)
            duration = Snackbar.LENGTH_SHORT
        })
    }

    class Message {
        var text: String? = null
        @ColorInt
        var color: Int? = null
        @DrawableRes
        var icon: Int? = null
        @ColorInt
        var backgroundColor: Int? = null
        var duration: Int? = null
    }

    class Action {
        internal var clickHolder: ((View) -> Unit)? = null
        var text: String? = null
        @ColorInt
        var color: Int? = null
        fun onClick(init: (View)-> Unit) {
            clickHolder = init
        }
        fun dismiss(): (Unit.() -> Unit)? = null
//        fun dismiss(init: Unit.() -> Unit){
//            init.invoke(Unit)
//        }
    }

}
//class YAS internal constructor(){
//    companion object {
//        private var _snackbar: Snackbar? = null
//        fun make(view: View, init: (YAS.() -> Unit)): Snackbar {
//            _snackbar = Snackbar.make(view, "", Duration.INDEFINED)
//            YAS(init)
//            return _snackbar!!
//        }
//        fun error(view: View, message: String, duration: Int = Duration.SHORT): Snackbar {
//            return make(view, {
//                message {
//                    text = message
//                    color = ContextCompat.getColor(view.context, android.R.color.white)
//                }
//                duration { SHORT }
//            })
//        }
//    }
//    constructor(init: YAS.() -> Unit) : this() {
//        YAS().init()
//    }
//
//    private var messageHolder: Message? = null
//    private var backgroundColorHolder: Int = 0x000000
//    fun duration(init: Duration.() -> Int){
//        val duration = Duration.init()
//        _snackbar?.duration = duration
//    }
//    private var action: Action? = null
//
//    val isShown: Boolean = _snackbar?.isShown ?: false
//    val isShownOrQueued: Boolean = _snackbar?.isShownOrQueued ?: false
//    fun dismiss() {
//        if (isShownOrQueued or isShown) {
//            _snackbar?.dismiss()
//        }
//    }
//
//    fun message(init: Message.() -> Unit){
//        messageHolder = Message().apply(init)
//        _snackbar?.setText(messageHolder!!.text)
//        _snackbar?.view?.findViewById<TextView>(android.support.design.R.id.snackbar_text)
//                ?.setTextColor(messageHolder!!.color)
//    }
//
//    fun action(init: Action.() -> Unit){
//        action = Action().apply { init() }
//    }
//
//    class Message {
//        var text: String = ""
//        var color: Int = Color.parseColor("#FFFFFF")
//    }
//
//    class Action {
//        var text: String = ""
//        var color: Int = 0xFFFFFF
//        fun onClick(l: (View) -> Unit) {
//
//        }
//    }
//}
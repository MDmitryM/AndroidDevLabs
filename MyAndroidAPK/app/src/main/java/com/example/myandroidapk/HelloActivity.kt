package com.example.myandroidapk
import android.app.Activity
import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.core.graphics.alpha
import kotlinx.android.synthetic.main.hello_activity_xml.*
import kotlinx.android.synthetic.main.hello_activity_xml.view.*

class HelloActivity: Activity()
{
    override fun onCreate(savedInstanceState:Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.hello_activity_xml)
        button_Nikita.setOnClickListener{
            val strCounter = textViewCounter1.text.toString()
            var intCounter =  strCounter.toInt()
            intCounter++
            textViewCounter1.text = intCounter.toString()
            textViewCounter2.text = intCounter.toString()

        }
    }

    fun button1Clicked(view: View)
    {

        _ALPHA-=10;
        if (_ALPHA < 0 || _ALPHA > 255 )
            _ALPHA += 10
        val strPushed = "Pushed!"

        if (button1.text != strPushed)
        {
            button1.text = strPushed
        }
        val strCounter = textViewCounter1.text.toString()

        var intCounter =  strCounter.toInt()
        intCounter++


        framelayout.setBackgroundColor(Color.argb(_ALPHA, 0, 0, 0))


        textViewCounter1.text = intCounter.toString()
    }

    var _ALPHA : Int = 0;
    fun button2Clicked(view: View)
    {
        _ALPHA += 10;
        if (_ALPHA < 0 || _ALPHA > 255 )
            _ALPHA -= 10
        val strCounter = textViewCounter2.text.toString()

        var intCounter =  strCounter.toInt()
        intCounter++
        framelayout.setBackgroundColor(Color.argb(_ALPHA, 0, 0,0))
        textViewCounter2.text = intCounter.toString()
    }

    fun buttonClrClicked(view: View)
    {
        _ALPHA = 0;
        framelayout.setBackgroundColor(Color.argb(_ALPHA, 0, 0,0))
        textViewCounter1.text = "0";
        textViewCounter2.text = "0";
    }
}

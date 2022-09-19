package com.example.myandroidapk
import android.app.Activity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.hello_activity_xml.*

class HelloActivity: Activity()
{
    override fun onCreate(savedInstanceState:Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.hello_activity_xml)
    }

    fun button1Clicked(view: View)
    {
        val strPushed = "Pushed!"

        if (button1.text != strPushed)
        {
            button1.text = strPushed
        }
        val strCounter = textViewCounter1.text.toString()

        var intCounter =  strCounter.toInt()
        intCounter++

        textViewCounter1.text = intCounter.toString()
    }

    fun button2Clicked(view: View)
    {
        val strCounter = textViewCounter2.text.toString()

        var intCounter =  strCounter.toInt()
        intCounter++

        textViewCounter2.text = intCounter.toString()
    }

    fun buttonClrClicked(view: View)
    {
        textViewCounter1.text = "0";
        textViewCounter2.text = "0";
    }
}

package com.bignerdranch.android.convertor

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


private const val TAG = "MainActivity"
private const val KEY_INDEX1 = "price"
var price = ""

class MainActivity : AppCompatActivity() {
    private lateinit var price_input: EditText
    private lateinit var current_sale: TextView
    private lateinit var sale_scrol: SeekBar
    private lateinit var ok_button: Button
    private lateinit var dollar: RadioButton
    private lateinit var evro: RadioButton
    private lateinit var pound: RadioButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        price_input = findViewById(R.id.price_input)
        current_sale = findViewById(R.id.current_sale)
        sale_scrol = findViewById(R.id.scroll)
        ok_button = findViewById(R.id.ok_button)
        var str = sale_scrol.progress.toString() + "%"
        current_sale.text = str
        var progressChangedValue = 0
        sale_scrol.setOnSeekBarChangeListener(object : OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                progressChangedValue = progress
                str = progressChangedValue.toString() + "%"
                current_sale.text = str
            }
            override fun onStartTrackingTouch(seekBar: SeekBar) {
            }
            override fun onStopTrackingTouch(seekBar: SeekBar) {
                str = progressChangedValue.toString() + "%"
                current_sale.text = str
            }
        })
        var kurs = 1
        dollar = findViewById(R.id.radio_d);
        dollar.setOnClickListener {
            kurs = 75
        }
        evro = findViewById(R.id.radio_e);
        evro.setOnClickListener {
            kurs = 90
        }
        pound = findViewById(R.id.radio_f);
        pound.setOnClickListener {
            kurs = 100
        }
        if (savedInstanceState != null) {
            price_input.append(savedInstanceState.getString(KEY_INDEX1, ""))
        }
        ok_button.setOnClickListener {
            if (price_input.text.toString() == "")
            {
                Toast.makeText(this, "Введите цену!", Toast.LENGTH_SHORT).show()
            }
            else
            {
                price = price_input.text.toString()
                var res = (price.toFloat()-price.toFloat()*progressChangedValue)/kurs
            }
        }
    }
    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart() called")
    }
    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume() called")
    }
    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause() called")
    }
    override fun onSaveInstanceState(savedInstanceState: Bundle)
    {
        super.onSaveInstanceState(savedInstanceState)
        Log.i(TAG, "onSaveInstanceState")
        savedInstanceState.putString(KEY_INDEX1, price)
    }
    override fun onStop() {
        super.onStop()
        Log.d(TAG,"onStop() called")
    }
    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG,"onDestroy() called")
    }
}
package com.bignerdranch.android.convertor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.SeekBar
import android.widget.TextView

private const val TAG = "MainActivity"
private const val KEY_INDEX1 = "currentIndex"
var price = ""

class MainActivity : AppCompatActivity() {
    private lateinit var price_input: EditText
    private lateinit var current_sale: TextView
    private lateinit var sale_scrol: SeekBar
    private lateinit var ok_button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        price_input = findViewById(R.id.price_input)
        current_sale = findViewById(R.id.current_sale)
        sale_scrol = findViewById(R.id.scroll)
        ok_button.setOnClickListener {
            if (price_input.text.toString() == "")
            {
                // Здесь код, если EditText пуст
            }
            else
            {
                // если есть текст, то здесь другой код
                price = price_input.text.toString()
                current_sale.text = price
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
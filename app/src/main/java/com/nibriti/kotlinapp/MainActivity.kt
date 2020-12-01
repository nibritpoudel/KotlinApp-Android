package com.nibriti.kotlinapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    //Initialize values
    private lateinit var etFirst: EditText
    private lateinit var etSecond: EditText
    private lateinit var btnCalculate: Button
    private lateinit var tvResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Assign values
        etFirst = findViewById(R.id.etFirst)
        etSecond = findViewById(R.id.etSecond)
        btnCalculate = findViewById(R.id.btnCalculate)
        tvResult = findViewById(R.id.tvResult)

        btnCalculate.setOnClickListener {

            //Validation
            if (checkEmptyValues()) {
                retrieveData()
            }

//            Toast.makeText(this, "Sum is $result", Toast.LENGTH_LONG).show()
        }

    }

    private fun checkEmptyValues() : Boolean {
        var flag = true
        if(TextUtils.isEmpty(etFirst.text)){
            etFirst.error = "Please enter first number"
            etFirst.requestFocus()
            flag = false
        } else if(TextUtils.isEmpty(etSecond.text)){
            etSecond.error = "Please enter second number"
            etSecond.requestFocus()
            flag = false}
        return flag
    }

    private fun retrieveData(){
        // retrieve values from edit text
        val first: Int = etFirst.text.toString().toInt()
        val second: Int = etSecond.text.toString().toInt()
        calculateSum(first,second)
    }

    private fun calculateSum(first: Int, second : Int){
        val result = first + second
        tvResult.text = result.toString()
    }
}
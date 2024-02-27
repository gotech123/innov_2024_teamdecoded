package com.example.e_calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView

class HomeScreen : AppCompatActivity() {

    private lateinit var distanceEditText: EditText
    private lateinit var travelBySpinner: Spinner
    private lateinit var insteadOfSpinner: Spinner
    private lateinit var resultTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_screen)

        distanceEditText = findViewById(R.id.editTextText4)
        travelBySpinner = findViewById(R.id.spinner2)
        insteadOfSpinner = findViewById(R.id.spinner3)
        resultTextView = findViewById(R.id.textView11)

        val spinnerData = listOf("Bicycle", "Bus", "Train")
        val spinnerData2 = listOf("car", "Bike", "flight")

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, spinnerData)
        val adapter2 = ArrayAdapter(this, android.R.layout.simple_spinner_item, spinnerData2)

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        travelBySpinner.adapter = adapter
        insteadOfSpinner.adapter = adapter2

        travelBySpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: android.view.View?, position: Int, id: Long) {
                updateResultTextView()
            }

            override fun onNothingSelected(parent: AdapterView<*>) {

            }
        }

        insteadOfSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: android.view.View?, position: Int, id: Long) {
                updateResultTextView()
            }

            override fun onNothingSelected(parent: AdapterView<*>) {

            }
        }

        distanceEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                updateResultTextView()
            }

            override fun afterTextChanged(s: Editable?) {

            }
        })
    }

    private fun updateResultTextView() {
        val distance = distanceEditText.text.toString().toFloatOrNull() ?: return
        val travelBy = travelBySpinner.selectedItem.toString()
        val insteadOf = insteadOfSpinner.selectedItem.toString()

        resultTextView.text = (distance * 8.89 * 2.5 ).toString()

    }
}
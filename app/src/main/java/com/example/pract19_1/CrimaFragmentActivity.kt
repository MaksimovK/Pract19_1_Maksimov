package com.example.pract19_1

import android.os.Bundle
import android.support.v4.app.Fragment
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText

class CrimaFragmentActivity: Fragment() {
    private lateinit var crime: Crime
    private lateinit var titleField: EditText
    private lateinit var dateButton: Button
    private lateinit var solvedCheckBox: CheckBox

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        crime = Crime()
    }
    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle? ): View? {
        val view = inflater.inflate(R.layout.activity_crima_fragment, container, false)
        titleField = view.findViewById(R.id.crime_title) as EditText
        dateButton = view.findViewById(R.id.crime_data) as Button
        solvedCheckBox = view.findViewById(R.id.crime_solved) as CheckBox
        dateButton.apply {
            text = crime.date.toString()
            isEnabled = false
        }
        return view
    }

    override fun onStart() {
        super.onStart()
        val titleWatcher = object : TextWatcher
        {
            override fun beforeTextChanged(
                sequence: CharSequence?,
                start: Int, count: Int,
                after: Int) {

            }
            override fun onTextChanged(
                sequence: CharSequence?,
                start: Int, before: Int,
                count: Int) {
                crime.title = sequence.toString()
            }

            override fun afterTextChanged(sequence: Editable?) {

            }
        }
        titleField.addTextChangedListener(titleWatcher)
        solvedCheckBox.apply {
            setOnCheckedChangeListener { _, isChecked -> crime.solved = isChecked
                dateButton.apply {
                    isEnabled = isChecked
                }
            }
        }
    }

}
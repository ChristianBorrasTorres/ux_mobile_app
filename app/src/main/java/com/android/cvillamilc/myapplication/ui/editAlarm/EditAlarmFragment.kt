package com.android.cvillamilc.myapplication.ui.editAlarm

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.android.cvillamilc.myapplication.R
import com.android.cvillamilc.myapplication.databinding.FragmentEditAlarmBinding
import com.google.android.material.textfield.TextInputLayout
import java.util.Calendar

class EditAlarmFragment : Fragment(), DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener {

    private var _binding: FragmentEditAlarmBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val configSuggestionsViewModel =
            ViewModelProvider(this).get(EditAlarmViewModel::class.java)

        _binding = FragmentEditAlarmBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val spinnerAMPM1: Spinner = root.findViewById(R.id.spinner_ampm1)
        // Create an ArrayAdapter using the string array and a default spinner layout
        getContext()?.let {
            ArrayAdapter.createFromResource(
                it,
                R.array.am_pm_array,
                android.R.layout.simple_spinner_item
            ).also { adapter ->
                // Specify the layout to use when the list of choices appears
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                // Apply the adapter to the spinner
                spinnerAMPM1.adapter = adapter
            }
        }

        val date = root.findViewById<TextInputLayout>(R.id.date_picker)

        date.setOnClickListener { showDatePickerDialog() }

        val buttonContinue = root.findViewById<Button>(R.id.button_continue)

        buttonContinue.setOnClickListener {
            root.findNavController().navigate(R.id.action_navigation_edit_alarm_to_navigation_suggestions)
        }

        val buttonCancel = root.findViewById<Button>(R.id.button_cancel)

        buttonCancel.setOnClickListener {
            root.findNavController().navigate(R.id.action_editAlarmFragment_to_homeFragment)
        }

        return root
    }



    private fun showDatePickerDialog() {
        val datePicker = DatePickerFragment {day, month, year -> onDateSelected(day, month, year)}
        datePicker.show(childFragmentManager, "datePicker")
    }
    fun onDateSelected(day:Int, month:Int, year:Int){

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onDateSet(p0: DatePicker?, p1: Int, p2: Int, p3: Int) {
        TODO("Not yet implemented")
    }

    override fun onTimeSet(p0: TimePicker?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }
}
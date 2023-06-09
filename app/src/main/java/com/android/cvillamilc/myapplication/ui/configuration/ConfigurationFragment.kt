package com.android.cvillamilc.myapplication.ui.configuration

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ImageButton
import android.widget.Spinner
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.android.cvillamilc.myapplication.R
import com.android.cvillamilc.myapplication.databinding.FragmentConfigurationBinding
import com.android.cvillamilc.myapplication.ui.configSuggestions.ConfigSuggestionsFragment
import com.android.cvillamilc.myapplication.ui.editAlarm.EditAlarmFragment


class ConfigurationFragment : Fragment() {

    private var _binding: FragmentConfigurationBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val editAlarmViewModel =
            ViewModelProvider(this).get(ConfigurationViewModel::class.java)

        _binding = FragmentConfigurationBinding.inflate(inflater, container, false)
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

        val buttonCancel = root.findViewById<Button>(R.id.button_cancel)
        buttonCancel.setOnClickListener {
            root.findNavController().navigate(R.id.action_configurationFragment_to_homeFragment)
        }
        val buttonContinue = root.findViewById<Button>(R.id.button_continue)
        buttonContinue.setOnClickListener {
            root.findNavController().navigate(R.id.action_configurationFragment_to_configSuggestionFragment)
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
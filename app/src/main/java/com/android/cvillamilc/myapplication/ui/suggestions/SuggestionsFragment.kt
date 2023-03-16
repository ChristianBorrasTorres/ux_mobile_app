package com.android.cvillamilc.myapplication.ui.suggestions

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.android.cvillamilc.myapplication.R
import com.android.cvillamilc.myapplication.databinding.FragmentSuggestionsBinding


class SuggestionsFragment : Fragment() {

    private var _binding: FragmentSuggestionsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val suggestionsViewModel =
            ViewModelProvider(this).get(SuggestionsViewModel::class.java)

        _binding = FragmentSuggestionsBinding.inflate(inflater, container, false)
        val root: View = binding.root


        val timeOne = root.findViewById<ImageView>(R.id.time_one)

        timeOne.setOnClickListener { showTimePickerDialog() }

        val timeTwo = root.findViewById<ImageView>(R.id.time_two)

        timeTwo.setOnClickListener { showTimePickerDialog() }

        val timeThree = root.findViewById<ImageView>(R.id.time_three)

        timeThree.setOnClickListener { showTimePickerDialog() }


        return root
    }

    private fun showTimePickerDialog() {
        val timePicker = TimePickerFragment { onTimeSelected(it) }
        timePicker.show(childFragmentManager, "time")
    }

    private fun onTimeSelected(time:String){

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
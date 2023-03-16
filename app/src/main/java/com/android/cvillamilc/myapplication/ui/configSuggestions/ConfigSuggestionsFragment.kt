package com.android.cvillamilc.myapplication.ui.configSuggestions

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.android.cvillamilc.myapplication.R
import com.android.cvillamilc.myapplication.databinding.FragmentConfigSuggestionsBinding

class ConfigSuggestionsFragment : Fragment() {

    private var _binding: FragmentConfigSuggestionsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val configSuggestionsViewModel =
            ViewModelProvider(this).get(ConfigSuggestionsViewModel::class.java)

        _binding = FragmentConfigSuggestionsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val deliverOne = root.findViewById<ImageView>(R.id.drogueria_uno)

        deliverOne.setOnClickListener {
            root.findNavController().navigate(R.id.action_navigation_config_suggestions_to_navigation_deliver)
        }

        val deliverTwo = root.findViewById<ImageView>(R.id.drogueria_dos)

        deliverTwo.setOnClickListener {
            root.findNavController().navigate(R.id.action_navigation_config_suggestions_to_navigation_deliver)
        }

        val deliverThree = root.findViewById<ImageView>(R.id.drogueria_tres)

        deliverThree.setOnClickListener {
            root.findNavController().navigate(R.id.action_navigation_config_suggestions_to_navigation_deliver)
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
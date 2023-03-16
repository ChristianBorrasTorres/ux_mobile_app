package com.android.cvillamilc.myapplication.ui.deliver

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.android.cvillamilc.myapplication.R
import com.android.cvillamilc.myapplication.databinding.FragmentDeliverBinding

class DeliverFragment : Fragment() {
    private var _binding: FragmentDeliverBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val deliverViewModel =
            ViewModelProvider(this).get(DeliverViewModel::class.java)

        _binding = FragmentDeliverBinding.inflate(inflater, container, false)
        val root: View = binding.root


        val buttonCancel = root.findViewById<Button>(R.id.button_cancel)
        buttonCancel.setOnClickListener {
            root.findNavController().navigate(R.id.action_navigation_deliver_to_navigation_config_suggestions)
        }

        val buttonContinue = root.findViewById<Button>(R.id.button_accept)
        buttonContinue.setOnClickListener {
            root.findNavController().navigate(R.id.action_navigation_deliver_to_navigation_home)
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
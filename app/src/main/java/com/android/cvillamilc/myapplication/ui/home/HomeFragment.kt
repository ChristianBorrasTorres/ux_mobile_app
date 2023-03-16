package com.android.cvillamilc.myapplication.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.android.cvillamilc.myapplication.R
import com.android.cvillamilc.myapplication.databinding.FragmentHomeBinding
import com.android.cvillamilc.myapplication.ui.editAlarm.EditAlarmFragment

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        //val homeViewModel =
        //    ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val bundle = Bundle()
        bundle.putString("typeKey", "Editar")

        val crearAlarma = root.findViewById<TextView>(R.id.crear_alarma)

        crearAlarma.setOnClickListener {

            root.findNavController().navigate(R.id.action_homeFragment_to_editAlarmFragment)
        }
        val lista = root.findViewById<TextView>(R.id.lista)

        lista.setOnClickListener {
            root.findNavController().navigate(R.id.action_navigation_home_to_navigation_suggestions)
        }

        val vencidos = root.findViewById<TextView>(R.id.vencidos)

        vencidos.setOnClickListener {
            root.findNavController().navigate(R.id.action_navigation_home_to_navigation_configuration)
        }


        /*val textView: TextView = binding.textHome
        homeViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }*/
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
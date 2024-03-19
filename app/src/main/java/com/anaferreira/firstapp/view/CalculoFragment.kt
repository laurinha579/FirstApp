package com.anaferreira.firstapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.anaferreira.firstapp.R
import com.anaferreira.firstapp.databinding.ActivityMainBinding
import com.anaferreira.firstapp.databinding.FragmentCalculoBinding
import java.time.LocalDate


class CalculoFragment : Fragment() {
      private var _binding: FragmentCalculoBinding? = null
      private val  binding: FragmentCalculoBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCalculoBinding.inflate(inflater, container, false)
        return binding.root
        // Inflate the layout for this fragment
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnEnviar.setOnClickListener {
            var nome = binding.edtNome.editableText.toString ()

            binding.tdNome.text = "Nome:" + nome

            var anoNascimento = binding.edtAnoNascimento.editableText.toString()
            var anoAtual = LocalDate.now().year
            var idade = anoAtual - anoNascimento.toInt()

            binding.tdIdade.text = "Idade: ${idade}"
        }
    }


}
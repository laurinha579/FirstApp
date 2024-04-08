package com.anaferreira.firstapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.anaferreira.firstapp.databinding.FragmentCalculoBinding
import com.anaferreira.firstapp.service.model.Pessoa
import com.anaferreira.firstapp.viewmodel.PessoaViewModel
import java.time.LocalDate


class PessoaFragment : Fragment() {
    private val viewModel: PessoaViewModel by viewModels()

    private var _binding: FragmentCalculoBinding? = null
    private val binding: FragmentCalculoBinding get() = _binding!!

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
            val nome = binding.edtNome.editableText.toString()
            val anoNascimento = binding.edtAnoNascimento.editableText.toString()
            if (nome != "" && anoNascimento != "") {

                binding.tdNome.text = "Nome:" + nome


                val anoAtual = LocalDate.now().year
                val idade = anoAtual - anoNascimento.toInt()

                binding.tdIdade.text = "Idade: ${idade}"

                val pessoa = Pessoa(
                    nome = nome,
                    idade = idade
                )

                viewModel.insert(pessoa)

                binding.edtNome.editableText.clear()
                binding.edtAnoNascimento.editableText.clear()
            } else {
                Toast.makeText(requireContext(), "Digite os dados", Toast.LENGTH_LONG).show()
            }
        }
    }


}
package com.anaferreira.firstapp.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.anaferreira.firstapp.databinding.FragmentVerificaBinding


class VerificaFragment : Fragment() {

    private var _binding: FragmentVerificaBinding? = null
    private val binding: FragmentVerificaBinding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentVerificaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnEnviar.setOnClickListener {
            var email = binding.edtEmail.editableText.toString()

            var telefone = binding.edtTelefone.editableText.toString()

            if (email.contains("@") && (email.contains(".com"))) {
                binding.tvEmail.text = "Email valido:" + email
            } else {
                binding.tvEmail.text = "Email invalido:"
            }
            if (telefone.length == 11) {
                binding.tvTelefone.text = "telefone valido:" + telefone
            } else {
                binding.tvTelefone.text = "telefone invalido :"
            }
        }
    }
}

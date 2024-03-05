package com.anaferreira.firstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.anaferreira.firstapp.databinding.ActivityMainBinding
import com.anaferreira.firstapp.databinding.TelaLinearBinding
import java.time.LocalDate

class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val  binding:ActivityMainBinding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnEnviar.setOnClickListener {
            var nome = binding.edtNome.editableText.toString ()

            binding.tdNome.text = "Nome:" + nome

            var anoNascimento = binding.edtAnoNascimento.editableText.toString()
            var anoAtual = LocalDate.now().year
            var idade = anoAtual - anoNascimento.toInt()

            binding.tdIdade.text = "Idade: ${idade}"
        }

        binding.btnEnviar.setOnClickListener {
            var email = binding.edtEmail.editableText.toString ()

            var telefone = binding.edtTelefone.editableText.toString ()

            if(email.contains("@") && (email.contains(".com"))){
                binding.tvEmail.text = "Email valido:" + email
            }else{
                binding.tvEmail.text="Email invalido:"
            }
            if(telefone.length == 11){
                binding.tvTelefone.text= "telefone valido:" + telefone
            }else{
                binding.tvTelefone.text= "telefone invalido :"
            }
        }
    }
}
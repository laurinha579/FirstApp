package com.anaferreira.firstapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.anaferreira.firstapp.R
import com.anaferreira.firstapp.databinding.FragmentAllPessoasBinding
import com.anaferreira.firstapp.view.adapter.PessoaAdapter
import com.anaferreira.firstapp.viewmodel.AllPessoaViewModel


class AllPessoasFragment : Fragment() {

    // Chamar a viewmodel
    private val viewModel: AllPessoaViewModel by viewModels()

    //Chamar o adapter
    private lateinit var adapter: PessoaAdapter

    // Criar o binding

    private var _binding: FragmentAllPessoasBinding? = null
    private val binding: FragmentAllPessoasBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //Configurar o binding
        _binding = FragmentAllPessoasBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Quando clicar em algum intem da lista
        adapter = PessoaAdapter(viewModel.pessoaList.value) {pessoa ->
            val pessoaBundle = Bundle()
            pessoaBundle.putInt("pessoaId" , pessoa.id)
            arguments = pessoaBundle
            findNavController().navigate(R.id.pessoaDetailFragment, arguments)

        }

        //Configurar a recycler
        val recycler = binding.rvPessoas
        recycler.layoutManager = LinearLayoutManager(requireContext())
        recycler.adapter = adapter

        //Observa para adicionar um item na lista quando for adicionado
        viewModel.pessoaList.observe(viewLifecycleOwner) {
            adapter.updatePessoa(it)
        }

        // Navegar para a tela de cadastro de pessoa
        binding.btnAdd.setOnClickListener {
            findNavController().navigate(R.id.pessoaFragment)
        }

        // Carregar as pessoas cadastradas
        viewModel.loadPessoas()
    }
}
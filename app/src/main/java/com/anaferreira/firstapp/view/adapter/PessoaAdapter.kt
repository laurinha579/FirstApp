package com.anaferreira.firstapp.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.anaferreira.firstapp.databinding.ListItemPessoaBinding
import com.anaferreira.firstapp.service.model.Pessoa

class PessoaAdapter (pessoas: List<Pessoa>?, private val clickListener:(Pessoa) -> Unit) :
RecyclerView.Adapter<PessoaAdapter.PessoaViewHolder>(){

    private var pessoaList: List<Pessoa> = arrayListOf()


    class PessoaViewHolder(private val binding: ListItemPessoaBinding) :
            RecyclerView.ViewHolder(binding.root) {
                fun bind(pessoa: Pessoa, clickListener:(Pessoa) -> Unit ) {
                    binding.tvNome.text = pessoa.nome
                    binding.tvNome.text = pessoa.idade.toString()
                    binding.tvfaixaEtaria.text = pessoa.faixaEtaria

                    if (pessoa.sexo == "Masculino"){
                        binding.imgBoy.visibility = View.VISIBLE
                        binding.imgGirl.visibility = View.VISIBLE
                    }else{
                        binding.imgBoy.visibility = View.GONE
                        binding.imgGirl.visibility = View.VISIBLE

                    }

                    binding.root.setOnClickListener(){
                        clickListener(pessoa)
                    }


                }
            }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PessoaViewHolder {
        val listItemPessoaBinding = ListItemPessoaBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return PessoaViewHolder(listItemPessoaBinding)
    }

    override fun getItemCount(): Int {
       return pessoaList.count()
    }

    override fun onBindViewHolder(holder: PessoaViewHolder, position: Int) {
        holder.bind(pessoaList[position], clickListener)
    }

        fun updatePessoa(list: List<Pessoa>){
            pessoaList = list
            notifyDataSetChanged()
        }
    }

package com.example.projetogrande.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.fragment.NavHostFragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.projetogrande.R
import com.example.projetogrande.ViewModels.ContaViewmodel
import com.example.projetogrande.models.Conta
import kotlinx.android.synthetic.main.recyclerview_resource.view.*

class RecViewContaAdapter (
    private val listaConta: List<Conta>

)
    : RecyclerView.Adapter<RecViewContaAdapter.ContaViewHolder>()
{
    private lateinit var contaViewmodel: ContaViewmodel

    class ContaViewHolder(itemView: View):
        RecyclerView.ViewHolder(itemView)  {
        val viewContaNome : TextView =  itemView.textViewValorConta
        val viewContaValor  : TextView = itemView.textViewNomeConta
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContaViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recyclerview_resource, parent, false)
        val contaViewHolder = ContaViewHolder(view)

        return  contaViewHolder
    }

    override fun onBindViewHolder(holder: ContaViewHolder, position: Int) {
        val conta = listaConta[position]
        holder.viewContaNome.text = conta.nome
        holder.viewContaValor.text = conta.valor
        holder.itemView.setOnClickListener{
            actionClick(conta)
        }


    }
    override fun getItemCount(): Int = listaConta.size

    fun actionClick(conta: Conta){
        findNavController().navigate(R.id.createconta)
    }
}

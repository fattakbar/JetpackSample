package com.zendev.jetpacksample.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.zendev.jetpacksample.databinding.ViewRepoListItemBinding
import com.zendev.jetpacksample.model.Item
import com.zendev.jetpacksample.view.adapter.viewHolders.RepoListViewHolder
import com.zendev.jetpacksample.view.ui.repolist.RepoListViewModel

class RepoListAdapter(private val repoListViewModel: RepoListViewModel) : RecyclerView.Adapter<RepoListViewHolder>() {
    var repoList: List<Item> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoListViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val dataBinding = ViewRepoListItemBinding.inflate(inflater, parent, false)
        return RepoListViewHolder(dataBinding, repoListViewModel)
    }

    override fun getItemCount() = repoList.size

    override fun onBindViewHolder(holder: RepoListViewHolder, position: Int) {
        holder.setup(repoList[position])
    }

    fun updateRepoList(repoList: List<Item>) {
        this.repoList = repoList
        notifyDataSetChanged()
    }
}
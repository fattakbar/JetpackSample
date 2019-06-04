package com.zendev.jetpacksample.view.ui.repolist

import androidx.lifecycle.MutableLiveData
import com.zendev.jetpacksample.model.Item
import com.zendev.jetpacksample.model.RepoRepository
import com.zendev.jetpacksample.view.base.BaseViewModel

class RepoListViewModel : BaseViewModel() {
    val repoListLive = MutableLiveData<List<Item>>()

    fun fetchRepoList() {
        dataLoading.value = true
        RepoRepository.getInstance().getRepoList { isSuccess, response ->
            dataLoading.value = false
            if (isSuccess) {
                repoListLive.value = response?.items
                empty.value = false
            } else {
                empty.value = true
            }
        }
    }
}
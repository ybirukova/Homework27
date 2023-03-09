package com.example.homework27.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.homework27.data.BreedRepositoryImpl
import com.example.homework27.data.CatRepositoryImpl
import com.example.homework27.domain.models.BreedData
import com.example.homework27.domain.models.CatData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CatViewModel @Inject constructor(
    private val catRepository: CatRepositoryImpl,
    private val breedRepository: BreedRepositoryImpl
) : ViewModel() {

    private val _catLiveData = MutableLiveData<List<CatData>>()
    val catLiveData: LiveData<List<CatData>> get() = _catLiveData

    private val _breedLiveData = MutableLiveData<List<BreedData>>()
    val breedLiveData: LiveData<List<BreedData>> get() = _breedLiveData

    private val _breedNamesLiveData = MutableLiveData<List<String>>()
    val breedNamesLiveData: LiveData<List<String>> get() = _breedNamesLiveData

    fun getImagesUrl(id: String) {
        viewModelScope.launch {
            val pic = catRepository.getImagesUrl(id)
            _catLiveData.value = pic
        }
    }

    fun getListOfBreeds() {
        viewModelScope.launch {
            val breedList = breedRepository.getListOfBreeds()
            _breedLiveData.value = breedList
        }
    }

    fun getListOfBreedNames() {
        viewModelScope.launch {
            val breedNamesList = breedRepository.getListOfBreedNames()
            _breedNamesLiveData.value = breedNamesList
        }
    }
}
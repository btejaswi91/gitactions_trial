package com.example.gitactionstrial


import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

data class UserData(val name: String = "", val age: String = "", val submitted: Boolean = false)

class UserFormViewModel : ViewModel() {

    private val _userData = MutableStateFlow(UserData())
    val userData: StateFlow<UserData> = _userData

    fun updateName(name: String) {
        _userData.value = _userData.value.copy(name = name)
    }

    fun updateAge(age: String) {
        _userData.value = _userData.value.copy(age = age)
    }

    fun submit() {
        _userData.value = _userData.value.copy(submitted = true)
    }

    fun reset() {
        _userData.value = UserData()
    }
}

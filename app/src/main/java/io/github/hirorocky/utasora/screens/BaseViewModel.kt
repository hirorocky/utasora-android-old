package io.github.hirorocky.utasora.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import timber.log.Timber

open class BaseViewModel : ViewModel() {
    fun launchCatching(block: suspend CoroutineScope.() -> Unit) =
        viewModelScope.launch(
            CoroutineExceptionHandler { _, throwable ->
                Timber.e(ERROR_TAG, throwable.message.orEmpty())
            },
            block = block,
        )

    companion object {
        const val ERROR_TAG = "ERROR ON VIEWMODEL"
    }
}

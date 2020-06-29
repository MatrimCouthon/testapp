package com.ren.testapp.domain.search

import com.ren.testapp.domain.Service
import io.reactivex.Single
import javax.inject.Inject

interface LoadWordUseCase {
    fun loadWords(word: String): Single<List<Search>>
}

class LoadWordUseCaseImpl @Inject constructor(
    private val service: Service
) : LoadWordUseCase {
    override fun loadWords(word: String) = service.search(word)
}
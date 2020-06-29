package com.ren.testapp.domain.meaning

import com.ren.testapp.domain.Service
import io.reactivex.Single
import javax.inject.Inject

interface LoadDetailsUseCase {
    fun loadDetails(id: Int): Single<MeaningDetails>
}

class LoadDetailsUseCaseImpl @Inject constructor(
    private val service: Service
) : LoadDetailsUseCase {
    override fun loadDetails(id: Int): Single<MeaningDetails> = service.getDetails(id).map {
        it.first()
    }
}
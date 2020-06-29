package com.ren.testapp.domain

import com.ren.testapp.domain.meaning.MeaningDetails
import com.ren.testapp.domain.search.Search
import io.reactivex.Single

interface Service {
    fun search(word: String): Single<List<Search>>
    fun getDetails(id: Int): Single<List<MeaningDetails>>
}
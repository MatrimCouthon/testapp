package com.ren.testapp.data

import com.ren.testapp.data.meaning.MeaningDetailsResponse
import com.ren.testapp.data.meaning.MeaningDetailsResponseTransformer
import com.ren.testapp.data.search.SearchResponse
import com.ren.testapp.data.search.SearchResponseTransformer
import com.ren.testapp.domain.Service
import com.ren.testapp.domain.meaning.MeaningDetails
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query
import javax.inject.Inject

class ServiceImpl @Inject constructor(
    private val api: Api,
    private val searchResponseTransformer: SearchResponseTransformer,
    private val meaningDetailsResponseTransformer: MeaningDetailsResponseTransformer
) : Service {

    override fun search(word: String) = api.getMeaning(word).map {
        it.map { search ->
            searchResponseTransformer.transform(search)
        }
    }

    override fun getDetails(id: Int): Single<List<MeaningDetails>> = api.getDetails(id).map {
        it.map {
            meaningDetailsResponseTransformer.transform(it)
        }
    }

    interface Api {
        @GET("/api/public/v1/words/search")
        fun getMeaning(
            @Query("search") search: String
        ): Single<List<SearchResponse>>

        @GET("/api/public/v1/meanings")
        fun getDetails(
            @Query("ids") id: Int
        ): Single<List<MeaningDetailsResponse>>
    }

}
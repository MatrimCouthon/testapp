package com.ren.testapp

import com.ren.testapp.domain.Service
import com.ren.testapp.domain.search.LoadWordUseCaseImpl
import com.ren.testapp.domain.search.Search
import io.reactivex.Single
import org.junit.Before
import org.junit.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class LoadWordUseCaseTest {

    @Mock
    lateinit var service: Service

    @InjectMocks
    lateinit var loadWordUseCaseImpl: LoadWordUseCaseImpl


    private val details = listOf(Search(1, "", emptyList()), Search(2, "", emptyList()))
    private val text = "r"

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun testSyncTickets() {
        Mockito.`when`(service.search(text))
            .thenReturn(Single.fromCallable { details })

        loadWordUseCaseImpl.loadWords(text)
            .test()
            .assertValue { it.size == 2 }
            .assertComplete()

        verifyMethod()
    }

    private fun verifyMethod() {
        Mockito.verify(service).search(text)
    }
}
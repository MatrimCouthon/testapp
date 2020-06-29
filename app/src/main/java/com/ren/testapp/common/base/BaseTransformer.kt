package com.ren.testapp.common.base

interface BaseTransformer<T, R> {
    fun transform(data: T): R
}
package com.example.tests.api

import com.example.tests.shared.TestUser

open class BaseApiTest {

    protected val client: ArticleApiClient

    init {
        TestUser.initOnce()
        client = ArticleApiClient(TestUser.token)
    }
}

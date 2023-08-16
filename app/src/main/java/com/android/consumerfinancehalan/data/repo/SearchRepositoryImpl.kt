package com.android.consumerfinancehalan.data.repo

import com.android.consumerfinancehalan.data.service.ApiService
import com.android.consumerfinancehalan.domain.repo.SearchRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SearchRepositoryImpl @Inject constructor(service: ApiService): SearchRepository {
}
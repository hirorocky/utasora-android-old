package io.github.hirorocky.utasora.core.repository.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.github.hirorocky.utasora.core.repository.AccountService
import io.github.hirorocky.utasora.core.repository.StorageService
import io.github.hirorocky.utasora.core.repository.impl.AccountServiceImpl
import io.github.hirorocky.utasora.core.repository.impl.StorageServiceImpl

@Module
@InstallIn(SingletonComponent::class)
abstract class ServiceModule {
    @Binds
    abstract fun bindAccountService(impl: AccountServiceImpl): AccountService

    @Binds
    abstract fun bindStorageService(impl: StorageServiceImpl): StorageService
}

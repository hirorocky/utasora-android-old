package io.github.hirorocky.utasora.model.service.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.github.hirorocky.utasora.model.service.AccountService
import io.github.hirorocky.utasora.model.service.impl.AccountServiceImpl

@Module
@InstallIn(SingletonComponent::class)
abstract class ServiceModule {
    @Binds
    abstract fun provideAccountService(impl: AccountServiceImpl): AccountService
}

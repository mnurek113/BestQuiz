package com.code.knab.best_quiz.network.api

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

/**
 * Created by Michał on 21.04.2018.
 */
@Module
class NetworkApiModule {

    @Provides
    fun provideLectureApi(retrofit: Retrofit) = retrofit.create(LectureApi::class.java)

    @Provides
    fun provideQuestionListApi(retrofit: Retrofit) = retrofit.create(QuestionListApi::class.java)

    @Provides
    fun provideSingleQuestionApi(retrofit: Retrofit) = retrofit.create(SingleQuestionApi::class.java)

}
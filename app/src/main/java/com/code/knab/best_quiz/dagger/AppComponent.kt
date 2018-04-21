package com.code.knab.best_quiz.dagger

import com.code.knab.best_quiz.ui.lecture.dagger.LectureComponent
import com.code.knab.best_quiz.ui.lecture.dagger.LectureModule
import dagger.Component
import javax.inject.Singleton

/**
 * Created by Michał on 21.04.2018.
 */
@Component(modules = arrayOf(AppModule::class))
@Singleton
interface AppComponent {

    fun plus(lectureModule: LectureModule): LectureComponent

}
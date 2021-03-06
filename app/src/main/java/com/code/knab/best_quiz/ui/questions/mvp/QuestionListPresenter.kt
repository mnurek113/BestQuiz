package com.code.knab.best_quiz.ui.questions.mvp

import com.code.knab.best_quiz.network.json.Question
import com.code.knab.best_quiz.utils.rx.RxUtils
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableObserver

/**
 * Created by Michał on 21.04.2018.
 */
class QuestionListPresenter(private val view: QuestionListMVP.View,
                            private val model: QuestionListMVP.Model,
                            private val rxUtils: RxUtils): QuestionListMVP.Presenter {

    override val compositeDisposal: CompositeDisposable = CompositeDisposable()

    override fun load(lectureId: Int) {
        compositeDisposal.add(model.getQuestionList(lectureId)
                .subscribeOn(rxUtils.subscribeScheduler)
                .observeOn(rxUtils.observScheduler)
                .subscribeWith(LoadQuestionObserver()))
    }

    inner class LoadQuestionObserver: DisposableObserver<List<Question>>() {
        override fun onNext(questionList: List<Question>) {
            view.listLoaded(questionList)
        }

        override fun onComplete() {

        }

        override fun onError(e: Throwable) {
            view.handleErrorInView()
        }
    }

}
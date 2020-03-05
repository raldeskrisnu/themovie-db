package com.rlds.kitabisa_movie_test.utils

import androidx.annotation.Nullable
import io.reactivex.disposables.Disposable

class DisposableUtils {

    companion object {

        fun dispose(@Nullable disposable: Disposable?) {
            if (disposable != null && !disposable.isDisposed) {
                disposable.dispose()
            }
        }
    }

}
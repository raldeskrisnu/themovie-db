package com.rlds.kitabisa_movie_test.di.scope

import java.lang.annotation.RetentionPolicy
import java.lang.annotation.Retention
import javax.inject.Scope


@Scope
@Retention(RetentionPolicy.RUNTIME)
annotation class PerActivity
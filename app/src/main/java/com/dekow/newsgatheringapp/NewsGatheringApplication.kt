package com.dekow.newsgatheringapp

import android.app.Application
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent


@HiltAndroidApp
class NewsGatheringApplication(): Application()
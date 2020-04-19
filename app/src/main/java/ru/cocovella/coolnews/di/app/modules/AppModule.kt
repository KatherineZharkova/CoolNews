package ru.cocovella.coolnews.di.app.modules

import dagger.Module
import dagger.Provides
import ru.cocovella.coolnews.ui.App

@Module
class AppModule(val app: App) {

    @Provides
    fun app(): App {
        return app
    }

}
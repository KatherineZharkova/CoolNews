package ru.cocovella.coolnews.di.app

import dagger.Component
import ru.cocovella.coolnews.di.app.modules.ApiModule
import ru.cocovella.coolnews.di.app.modules.AppModule
import ru.cocovella.coolnews.di.app.modules.CiceroneModule
import ru.cocovella.coolnews.di.app.modules.DatabaseModule
import ru.cocovella.coolnews.di.app.modules.ImageModule
import ru.cocovella.coolnews.di.headlines.HeadlinesSubcomponent
import ru.cocovella.coolnews.mvp.presenter.MainPresenter
import ru.cocovella.coolnews.ui.activity.MainActivity
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        ApiModule::class,
        AppModule::class,
        CiceroneModule::class,
        DatabaseModule::class,
        ImageModule::class
    ]
)
interface AppComponent {
    fun headlinesSubcomponent(): HeadlinesSubcomponent

    fun inject(mainActivity: MainActivity)
    fun inject(mainPresenter: MainPresenter)
}
package com.zky.basics.common.util.dagger


import com.zky.basics.common.BaseKotlinApplication
import com.zky.basics.common.mvvm.daggermodel.ActivityModule
import com.zky.basics.common.mvvm.daggermodel.AppModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        AppModule::class,
        ActivityModule::class]
)
interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: BaseKotlinApplication): Builder

        fun build(): AppComponent
    }

    fun inject(application: BaseKotlinApplication)
}

package com.geektech.newsapp.extensions

import android.annotation.TargetApi
import android.content.Context
import android.os.Build
import java.util.*

class LocalHelper {

    fun setLocale(context: Context, language: String): Context {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            updateResource(context, language)
        } else {
            updateResourceLegacy(context, language)
        }
    }

    @TargetApi(Build.VERSION_CODES.N)
    fun updateResource(context: Context, language: String): Context {
        val locale = Locale(language)
        Locale.setDefault(locale)
        val configuration = context.resources.configuration
        configuration.setLocale(locale)
        configuration.setLayoutDirection(locale)
        return context.createConfigurationContext(configuration)
    }

    private fun updateResourceLegacy(context: Context, language: String): Context {
        val locale = Locale(language)
        Locale.setDefault(locale)
        val resources = context.resources
        val configuration = resources.configuration
        configuration.locale = locale
        configuration.setLayoutDirection(locale)
        resources.updateConfiguration(configuration, resources.displayMetrics)
        return context
    }
}
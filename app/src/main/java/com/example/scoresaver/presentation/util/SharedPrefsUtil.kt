package com.example.scoresaver.presentation.util

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit

object WidgetSharedPrefsUtil {
    private const val PREFS_NAME = "scoresaver"

    internal fun savePreferencesInfo(
        context: Context,
        settingsType: String,
        value: String

    ) {
        context.getSharedPreferences(name = PREFS_NAME,Context.MODE_PRIVATE).edit()
            .putString(PREFS_NAME + settingsType, value)
            .apply()
    }

    internal fun savePreferencesInfoOrderService(
        context: Context,
        settingsType: String,
        value: Boolean

    ) {
        context.getSharedPreferences(name = PREFS_NAME,Context.MODE_PRIVATE).edit()
            .putBoolean(PREFS_NAME + settingsType, value)
            .apply()
    }

    internal fun saveFirstViewOrderService(
        context: Context,
        settingsType: String,
        value: String
    ) {
        context.getSharedPreferences(name = PREFS_NAME,Context.MODE_PRIVATE).edit()
            .putString(PREFS_NAME + settingsType, value)
            .apply()
    }

    internal fun loadPreferences(context: Context, settingsType: String): String? {
        return context.getSharedPreferences(name = PREFS_NAME, Context.MODE_PRIVATE)
            .getString(PREFS_NAME + settingsType, null)
    }

    internal fun loadFirstViewOrderService(context: Context, settingsType: String): String? {
        return context.getSharedPreferences(name = PREFS_NAME, Context.MODE_PRIVATE)
            .getString(PREFS_NAME + settingsType, VIEW_TYPE_ORDER_SERVICE.NOT_VIEW.value)
    }

    internal fun loadViewOrderService(context: Context, settingsType: String): Boolean {
        return context.getSharedPreferences(name = PREFS_NAME, Context.MODE_PRIVATE)
            .getBoolean(PREFS_NAME + settingsType, false)
    }

    internal fun deletePref(context: Context, settingsType: String) {
        context.getSharedPreferences(name = PREFS_NAME, mode = 0).edit {
            remove(PREFS_NAME + settingsType)
        }
    }

    private fun Context.getSharedPreferences(name: String, mode: Int): SharedPreferences {
        return getSharedPreferences(name, mode)
    }
}

enum class SETTINGS_TYPE(val value: String) {
    TYPE_GAME("type_game"),
    ORDER_SERVICE("order_service"),
    FIRST_VIEW_ORDER_SERVICE("first_view_order_service"),
    TYPE_ADVANTAGES("type_advantages")
}

enum class VIEW_TYPE_ORDER_SERVICE(val value: String){
    VIEW("view"),
    NOT_VIEW("not_view")
}
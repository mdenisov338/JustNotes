package com.mdenisov338.justnotesapp


import android.app.Activity
import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.content.Intent
import android.widget.RemoteViews


/**
 * Implementation of App Widget functionality.
 */
class NoteWidget : AppWidgetProvider() {
    override fun onUpdate(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetIds: IntArray
    ) {

        updateAppWidget(context, appWidgetManager, appWidgetIds)
    }



    override fun onEnabled(context: Context) {
        // Enter relevant functionality for when the first widget is created
        val sharedPreference = context.getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
        val value = sharedPreference.getString("STRING_KEY", null)
        val views = RemoteViews(context.packageName, R.layout.note_widget)
        views.setTextViewText(R.id.appwidget_text, value)
    }

    override fun onDisabled(context: Context) {
        // Enter relevant functionality for when the last widget is disabled
        val sharedPreference = context.getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
        val value = sharedPreference.getString("STRING_KEY", null)
        val views = RemoteViews(context.packageName, R.layout.note_widget)
        views.setTextViewText(R.id.appwidget_text, value)

    }
}

internal fun updateAppWidget(
    context: Context,
    appWidgetManager: AppWidgetManager,
    appWidgetId: IntArray
) {

    val views = RemoteViews(context.packageName, R.layout.note_widget)
    val sharedPreference = context.getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
    val value = sharedPreference.getString("STRING_KEY", null)
    if(value != "") {
        views.setTextViewText(R.id.appwidget_text, value)
    } else {
        views.setTextViewText(R.id.appwidget_text, "JustNotes")
    }


    val launchIntent2 = context!!.packageManager.getLaunchIntentForPackage("com.mdenisov338.justnotesapp")
    val pendingIntent2 = PendingIntent.getActivity(context, 1, launchIntent2, PendingIntent.FLAG_UPDATE_CURRENT)
    views.setOnClickPendingIntent(R.id.appwidget_text, pendingIntent2)

    appWidgetManager.updateAppWidget(appWidgetId, views)

}


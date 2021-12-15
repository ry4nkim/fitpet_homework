package dev.ry4nkim.fitpet_homework.data.source.local.prefs

import android.content.SharedPreferences
import javax.inject.Inject

class PrefsHelperImpl @Inject constructor(
    private val prefs: SharedPreferences
) : PrefsHelper {

}
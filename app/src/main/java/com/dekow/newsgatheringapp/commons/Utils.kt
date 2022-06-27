package com.dekow.newsgatheringapp.commons



import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter


@RequiresApi(Build.VERSION_CODES.O)
val usersCurrentDate: String = getCurrentDate()


@RequiresApi(Build.VERSION_CODES.O)
fun getCurrentDate(): String {
    val current = LocalDateTime.now()

    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd") //"dd-MM-yyyy"

    val formattedDate = current.format(formatter)

    return formattedDate
}


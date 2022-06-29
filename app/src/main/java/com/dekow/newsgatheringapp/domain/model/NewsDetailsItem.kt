package com.dekow.newsgatheringapp.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
class NewsDetailsItem(
    val image: String? = null,
    val title:  String? = null,
    val headline:  String? = null,
    val time: String? = null,
    val author:  String? = null,
    val authorsImage: String? = null,//List<String>? = emptyList(), //checkOn
    val ratings:  String? = null,
    val sourcePublication: String? = null,
    val sectionName: String? = null,
    val bodyText: String? = null,
    val trailText: String? = null,
    val body: String? = null,
    val productionOffice: String? = null,
    val lastModified: String? = null,
): Parcelable

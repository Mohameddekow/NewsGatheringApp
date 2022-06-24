
package com.dekow.newsgatheringapp.domain.model.data_transfer_obj.wait

import com.google.gson.annotations.SerializedName

class GuardianFieldsT(
    val thumbnail: String,
    val headline: String,
    val htmlBody: String,
    val textBody: String,
    val trailText: String,
    val publication: String
)

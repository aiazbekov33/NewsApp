package com.geektech.newsapp.presentation.models

import android.os.Parcelable
import com.geektech.domain.models.SourceModel
import kotlinx.android.parcel.Parcelize

@Parcelize
data class SourceUI(
    var id: String?,
    var name: String
):Parcelable
fun SourceModel.toUi() = SourceUI(
    id,
    name
)


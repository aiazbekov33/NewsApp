package com.geektech.newsapp.presentation.models

import com.geektech.domain.models.SourceModel

data class SourceUI(
    var id: String?,
    var name: String
)
fun SourceModel.toUi() = SourceUI(
    id,
    name
)


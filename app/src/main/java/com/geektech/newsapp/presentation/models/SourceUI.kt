package com.geektech.newsapp.presentation.models

import com.geektech.newsapp.domain.models.SourceModel

data class SourceUI(
    var id: String?,
    var name: String
)
fun SourceModel.toUi() = SourceUI(
    id,
    name
)


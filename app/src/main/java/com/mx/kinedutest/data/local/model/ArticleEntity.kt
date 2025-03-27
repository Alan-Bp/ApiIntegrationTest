package com.mx.kinedutest.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "articles")
data class ArticleEntity(
    @PrimaryKey val id: String,
    val name: String,
    val color: String? = null,
    val capacity: String? = null,
    val price: Double? = null,
    val generation: String? = null,
    val year: Int? = null,
    val cpuModel: String? = null,
    val hardDiskSize: String? = null,
    val strapColour: String? = null,
    val caseSize: String? = null,
    val description: String? = null,
    val screenSize: Double? = null
)
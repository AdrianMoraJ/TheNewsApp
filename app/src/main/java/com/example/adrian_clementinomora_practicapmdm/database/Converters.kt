package com.example.adrian_clementinomora_practicapmdm.database

import androidx.room.TypeConverter
import com.example.adrian_clementinomora_practicapmdm.models.Source

class Converters {
    @TypeConverter
    fun fromSource(source: Source): String {
        return source.name
    }

    @TypeConverter
    fun toSource(name: String): Source{
        return Source(name, name)
    }
}
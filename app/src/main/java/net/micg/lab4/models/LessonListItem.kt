package net.micg.lab4.models

data class LessonListItem(
    val name: String,
    val time: String,
    val teacher: String,
    val classroom: String,
    val building: String
) : ScheduleListItem

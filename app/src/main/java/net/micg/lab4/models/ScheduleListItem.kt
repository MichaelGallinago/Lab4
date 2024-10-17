package net.micg.lab4.models

interface ScheduleListItem {
    @JvmInline
    value class DayTitleListItem(
        val dayOfWeek: DayOfWeek
    ) : ScheduleListItem
}

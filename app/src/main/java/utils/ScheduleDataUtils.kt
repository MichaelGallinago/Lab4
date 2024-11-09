package utils

import net.micg.lab4.models.DayOfWeek
import net.micg.lab4.models.LessonListItem
import net.micg.lab4.models.ScheduleListItem
import java.time.LocalDate
import java.util.Calendar

object ScheduleDataUtils {
    private val firstWeekSchedule =
        mapOf<ScheduleListItem.DayTitleListItem, List<ScheduleListItem>>(
            Pair(
                ScheduleListItem.DayTitleListItem(DayOfWeek.MONDAY), listOf(
                    LessonListItem(
                        "Базы Данных (Лек)",
                        "18:20-19:50",
                        "Барабанщиков С.А.",
                        "А-13",
                        "1"
                    ),
                    LessonListItem(
                        "Базы Данных (Пр)",
                        "19:55-21:25",
                        "Барабанщиков С.А.",
                        "А-13",
                        "1"
                    ),
                )
            ), Pair(
                ScheduleListItem.DayTitleListItem(DayOfWeek.TUESDAY), listOf(
                    LessonListItem(
                        "Управление IT-проектами и ЖЦ ПО (Лек)",
                        "18:20-19:50",
                        "Воробьёв В.",
                        "А-21",
                        "1"
                    ),
                    LessonListItem(
                        "Управление IT-проектами и ЖЦ ПО (Пр)",
                        "19:55-21:25",
                        "Воробьёв В.",
                        "А-21",
                        "1"
                    ),
                )
            ), Pair(
                ScheduleListItem.DayTitleListItem(DayOfWeek.WEDNESDAY), listOf()
            ), Pair(
                ScheduleListItem.DayTitleListItem(DayOfWeek.THURSDAY), listOf(
                    LessonListItem(
                        "Разработка интернет приложений (Лек)",
                        "19:30-19:50",
                        "Повлеченков Е.",
                        "--",
                        "--"
                    ),
                    LessonListItem(
                        "Разработка интернет приложений (Пр)",
                        "19:55-21:25",
                        "Повлеченков Е.",
                        "--",
                        "--"
                    ),
                )
            ), Pair(
                ScheduleListItem.DayTitleListItem(DayOfWeek.FRIDAY), listOf(
                    LessonListItem(
                        "Экономика программной инженерии (Пр)",
                        "13:15-14:45",
                        "Dr. Who?",
                        "212",
                        "2"
                    ),
                    LessonListItem(
                        "Экономика программной инженерии (Лек)",
                        "15:00-16:30",
                        "Dr. Who?",
                        "212",
                        "2"
                    ),
                    LessonListItem(
                        "Экономика программной инженерии (Пр)",
                        "16:40-18:10",
                        "Dr. Who?",
                        "212",
                        "2"
                    ),
                    LessonListItem(
                        "Тестирование ПО (Лек)",
                        "19:30-21:00",
                        "Булавин Р.",
                        "--",
                        "--"
                    ),
                )
            ), Pair(
                ScheduleListItem.DayTitleListItem(DayOfWeek.SATURDAY), listOf(
                    LessonListItem(
                        "Тестирование ПО (Пр)",
                        "11:20-12:50",
                        "Булавин Р.",
                        "132",
                        "1"
                    ),
                    LessonListItem(
                        "Тестирование ПО (Пр)",
                        "13:15-14:45",
                        "Булавин Р.",
                        "132",
                        "1"
                    ),
                    LessonListItem(
                        "Android-разработка (Лек)",
                        "15:00-16:30",
                        "Веригин Н.",
                        "326",
                        "1"
                    ),
                    LessonListItem(
                        "Android-разработка (Пр)",
                        "16:40-18:10",
                        "Веригин Н.",
                        "326",
                        "1"
                    ),
                )
            )
        )
    private val secondWeekSchedule =
        mapOf<ScheduleListItem.DayTitleListItem, List<ScheduleListItem>>(
            Pair(
                ScheduleListItem.DayTitleListItem(DayOfWeek.MONDAY), listOf(
                    LessonListItem(
                        "Анализ Данных (Лек)",
                        "16:40 - 18:10",
                        "Мирасов С.А.",
                        "А-13",
                        "1"
                    ),
                    LessonListItem(
                        "Базы Данных (Пр)",
                        "18:20 - 19:50",
                        "Барабанщиков С.А.",
                        "А-13",
                        "1"
                    ),
                )
            ), Pair(
                ScheduleListItem.DayTitleListItem(DayOfWeek.TUESDAY), listOf(
                    LessonListItem(
                        "Управление IT-проектами и ЖЦ ПО (Лек)",
                        "18:20 - 19:50",
                        "Воробьёв В.",
                        "А-21",
                        "1"
                    ),
                    LessonListItem(
                        "Управление IT-проектами и ЖЦ ПО (Пр)",
                        "19:55 - 21:25",
                        "Воробьёв В.",
                        "А-21",
                        "1"
                    ),
                )
            ), Pair(
                ScheduleListItem.DayTitleListItem(DayOfWeek.WEDNESDAY), listOf(
                    LessonListItem(
                        "Базы Данных (Пр)",
                        "18:20 - 19:50",
                        "Барабанщиков С.А.",
                        "132",
                        "1"
                    ),
                    LessonListItem(
                        "Базы Данных (Пр)",
                        "19:55 - 21:25",
                        "Барабанщиков С.А.",
                        "132",
                        "1"
                    ),
                )
            ), Pair(
                ScheduleListItem.DayTitleListItem(DayOfWeek.THURSDAY), listOf(
                    LessonListItem(
                        "Разработка интернет приложений (Лек)",
                        "19:30 - 19:50",
                        "Повлеченков Е.",
                        "--",
                        "--"
                    ),
                    LessonListItem(
                        "Разработка интернет приложений (Пр)",
                        "19:55 - 21:25",
                        "Повлеченков Е.",
                        "--",
                        "--"
                    ),
                )
            ), Pair(
                ScheduleListItem.DayTitleListItem(DayOfWeek.FRIDAY), listOf(
                    LessonListItem(
                        "Анализ данных (Пр)",
                        "15:00 - 16:30",
                        "Мирасов С.А.",
                        "212",
                        "1"
                    ),
                    LessonListItem(
                        "Анализ данных (Пр)",
                        "16:40 - 18:10",
                        "Мирасов С.А.",
                        "212",
                        "1"
                    )
                )
            ), Pair(
                ScheduleListItem.DayTitleListItem(DayOfWeek.SATURDAY), listOf(
                    LessonListItem(
                        "Android-разработка (Лек)",
                        "15:00 - 16:30",
                        "Веригин Н.",
                        "326",
                        "1"
                    ),
                    LessonListItem(
                        "Android-разработка (Пр)",
                        "16:40 - 18:10",
                        "Веригин Н.",
                        "326",
                        "1"
                    ),
                )
            )
        )

    fun getScheduleForThisWeek(): List<ScheduleListItem> = getCurrentSchedule().flatMap {
        getDayScheduleFromThisPair(it.toPair())
    }

    private fun getCurrentSchedule() =
        if ((Calendar.getInstance().get(Calendar.WEEK_OF_YEAR)) % 2 == 0)
            firstWeekSchedule else secondWeekSchedule

    fun getScheduleForThisDay(): List<ScheduleListItem> {
        val currentDayOfWeek = LocalDate.now().dayOfWeek.ordinal
        return getDayScheduleFromThisPair(
            getCurrentSchedule().entries.find {
                it.key.dayOfWeek.ordinal == currentDayOfWeek
            }?.toPair() ?: Pair(
                ScheduleListItem.DayTitleListItem(DayOfWeek.SUNDAY), emptyList()
            )
        )
    }

    private fun getDayScheduleFromThisPair(
        pair: Pair<ScheduleListItem.DayTitleListItem, List<ScheduleListItem>>
    ): List<ScheduleListItem> {
        val resultDaySchedule = mutableListOf<ScheduleListItem>()

        resultDaySchedule.add(pair.first)

        if (pair.second.isEmpty()) {
            resultDaySchedule.add(
                LessonListItem(
                    "Выходной", "", "", "", ""
                )
            )
        } else {
            resultDaySchedule.addAll(pair.second)
        }

        return resultDaySchedule
    }
}

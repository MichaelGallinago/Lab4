package net.micg.lab4.ui

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import net.micg.lab4.databinding.LessonItemBinding
import net.micg.lab4.models.LessonListItem
import net.micg.lab4.models.ScheduleListItem
import net.micg.lab4.models.ScheduleViewType
import androidx.annotation.IntDef
import net.micg.lab4.databinding.DayItemBinding

class ScheduleAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var data = listOf<ScheduleListItem>()

    @SuppressLint("NotifyDataSetChanged")
    fun submitValue(list: List<ScheduleListItem>) {
        data = list
        notifyDataSetChanged()
    }

    override fun getItemCount() = data.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            ScheduleViewType.Lesson.ordinal -> LessonElementViewHolder(
                LessonItemBinding.inflate(layoutInflater, parent, false)
            )

            ScheduleViewType.DayTitle.ordinal -> DayTitleElementViewHolder(
                parent.context, DayItemBinding.inflate(layoutInflater, parent, false)
            )

            else -> error(ERROR_MESSAGE)
        }
    }

    override fun getItemViewType(position: Int) = when (data[position]) {
        is ScheduleListItem.DayTitleListItem -> ScheduleViewType.DayTitle
        is LessonListItem -> ScheduleViewType.Lesson
        else -> error(ERROR_MESSAGE)
    }.ordinal

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is DayTitleElementViewHolder ->
                holder.onBind(data[position] as ScheduleListItem.DayTitleListItem)

            is LessonElementViewHolder ->
                holder.onBind(data[position] as LessonListItem)
        }
    }

    companion object {
        private const val ERROR_MESSAGE = "There is no such type for list element"
    }

    class DayTitleElementViewHolder(
        private val context: Context,
        private val binding: DayItemBinding,
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(dayTitleItem: ScheduleListItem.DayTitleListItem) {
            binding.title.text = context.getText(dayTitleItem.dayOfWeek.nameId)
        }
    }

    class LessonElementViewHolder(private val binding: LessonItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        private val uiList = with(binding) {
            listOf(time, teacher, building, buildingIndex, classroom, classroomIndex)
        }

        fun onBind(item: LessonListItem) {
            binding.name.text = item.name

            if (item.time == "") {
                setUiVisibility(View.GONE)
                return
            }

            setUiVisibility(View.VISIBLE)

            with(binding) {
                time.text = item.time
                teacher.text = item.teacher
                buildingIndex.text = item.building
                classroomIndex.text = item.classroom
            }
        }

        private fun setUiVisibility(@Visibility visibility: Int) = uiList.forEach {
            it.visibility = visibility
        }

        companion object {
            @IntDef(View.VISIBLE, View.INVISIBLE, View.GONE)
            @Retention(AnnotationRetention.SOURCE)
            annotation class Visibility
        }
    }
}

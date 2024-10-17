package net.micg.lab4.ui

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

    fun submitValue(list: List<ScheduleListItem>) {
        data = list
        notifyDataSetChanged()
    }

    override fun getItemCount() = data.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            ScheduleViewType.Lesson.ordinal -> {
                val binding = LessonItemBinding.inflate(layoutInflater, parent, false)
                LessonElementViewHolder(binding)
            }

            ScheduleViewType.DayTitle.ordinal -> {
                val binding = DayItemBinding.inflate(layoutInflater, parent, false)
                DayTitleElementViewHolder(parent.context, binding)
            }

            else -> error("There is now such type for list element")
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (data[position]) {
            is ScheduleListItem.DayTitleListItem -> ScheduleViewType.DayTitle
            is LessonListItem -> ScheduleViewType.Lesson
            else -> error("There is now such type for list element")
        }.ordinal
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is LessonElementViewHolder -> {
                holder.onBind(data[position] as LessonListItem)
            }

            is DayTitleElementViewHolder -> {
                holder.onBind(data[position] as ScheduleListItem.DayTitleListItem)
            }
        }
    }

    class LessonElementViewHolder(
        private val binding: LessonItemBinding,
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(item: LessonListItem) {
            binding.name.text = item.name

            if (item.time == "") {
                setUiVisibility(View.GONE)
                return
            }

            setUiVisibility(View.VISIBLE)

            binding.time.text = item.time
            binding.teacher.text = item.teacher
            binding.classroom.text = item.classroom
        }

        private fun setUiVisibility(@Visibility visibility: Int) {
            binding.time.visibility = visibility
            binding.teacher.visibility = visibility
            binding.classroom.visibility = visibility
            binding.classroomIndex.visibility = visibility
            binding.building.visibility = visibility
            binding.buildingIndex.visibility = visibility
        }

        companion object {
            @IntDef(View.VISIBLE, View.INVISIBLE, View.GONE)
            @Retention(AnnotationRetention.SOURCE)
            annotation class Visibility
        }
    }

    class DayTitleElementViewHolder(
        private val context: Context,
        private val binding: DayItemBinding,
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(dayTitleItem: ScheduleListItem.DayTitleListItem) {
            binding.title.text = context.getText(dayTitleItem.dayOfWeek.nameId)
            binding.date.text = context.getText(dayTitleItem.dayOfWeek.nameId) //TODO: date
        }
    }
}
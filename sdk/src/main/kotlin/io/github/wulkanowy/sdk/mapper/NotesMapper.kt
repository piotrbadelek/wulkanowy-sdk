package io.github.wulkanowy.sdk.mapper

import io.github.wulkanowy.api.toLocalDate
import io.github.wulkanowy.sdk.mobile.dictionaries.Dictionaries
import io.github.wulkanowy.sdk.pojo.Note
import io.github.wulkanowy.sdk.toLocalDate
import io.github.wulkanowy.api.notes.Note as ScrapperNote
import io.github.wulkanowy.sdk.mobile.notes.Note as ApiNote

fun List<ApiNote>.mapNotes(dictionaries: Dictionaries): List<Note> {
    return map {
        Note(
            date = it.entryDate.toLocalDate(),
            content = it.content,
            category = dictionaries.noteCategories.singleOrNull { cat -> cat.id == it.noteCategoryId }?.name.orEmpty(),
            teacherSymbol = dictionaries.teachers.singleOrNull { teacher -> teacher.id == it.employeeId }?.code.orEmpty(),
            teacher = "${it.employeeName} ${it.employeeSurname}"
        )
    }
}

fun List<ScrapperNote>.mapNotes(): List<Note> {
    return map {
        Note(
            date = it.date.toLocalDate(),
            teacher = it.teacher,
            teacherSymbol = it.teacherSymbol,
            category = it.category,
            content = it.content
        )
    }
}
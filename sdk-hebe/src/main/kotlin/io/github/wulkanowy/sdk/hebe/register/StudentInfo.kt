package io.github.wulkanowy.sdk.hebe.register

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class StudentInfo(

    @SerialName("Capabilities")
    val capabilities: List<String>,

    @SerialName("ClassDisplay")
    val classDisplay: String,

    @SerialName("ConstituentUnit")
    val constituentUnit: ConstituentUnit,

    @SerialName("Educators")
    val educators: List<Educator>,

    @SerialName("FullSync")
    val fullSync: Boolean,

    @SerialName("InfoDisplay")
    val infoDisplay: String,

    @SerialName("Journal")
    val journal: Journal,

    @SerialName("Login")
    val login: Login,

    @SerialName("Partition")
    val partition: String,

    @SerialName("Periods")
    val periods: List<Period>,

    @SerialName("Pupil")
    val pupil: Pupil,

    @SerialName("SenderEntry")
    val senderEntry: SenderEntry,

    @SerialName("TopLevelPartition")
    val topLevelPartition: String,

    @SerialName("Unit")
    val unit: Unit,
) {

    @Serializable
    data class ConstituentUnit(

        @SerialName("Address")
        val address: String,

        @SerialName("Id")
        val id: Int,

        @SerialName("Name")
        val name: String,

        @SerialName("Patron")
        val patron: String,

        @SerialName("SchoolTopic")
        val schoolTopic: String,

        @SerialName("Short")
        val short: String,
    )

    @Serializable
    data class Educator(

        @SerialName("Id")
        val id: String,

        @SerialName("Initials")
        val initials: String,

        @SerialName("LoginId")
        val loginId: Int,

        @SerialName("Name")
        val name: String,

        @SerialName("Surname")
        val surname: String,

        @SerialName("Roles")
        val roles: List<Role>,
    ) {
        @Serializable
        data class Role(

            @SerialName("Address")
            val address: String,

            @SerialName("AddressHash")
            val addressHash: String,

            @SerialName("ClassSymbol")
            val classSymbol: String,

            @SerialName("ConstituentUnitSymbol")
            val constituentUnitSymbol: String,

            @SerialName("Initials")
            val initials: String,

            @SerialName("Name")
            val name: String,

            @SerialName("RoleName")
            val roleName: String,

            @SerialName("RoleOrder")
            val roleOrder: Int,

            @SerialName("Surname")
            val surname: String,

            @SerialName("UnitSymbol")
            val unitSymbol: String?,
        )
    }

    @Serializable
    data class Journal(

        @SerialName("Id")
        val id: Int,

        @SerialName("YearStart")
        val yearStart: PeriodDate,

        @SerialName("YearEnd")
        val yearEnd: PeriodDate,
    )

    @Serializable
    data class PeriodDate(

        @SerialName("Date")
        val date: String,

        @SerialName("DateDisplay")
        val dateDisplay: String,

        @SerialName("Time")
        val time: String,

        @SerialName("Timestamp")
        val timestamp: Long,
    )

    @Serializable
    data class Login(

        @SerialName("DisplayName")
        val displayName: String,

        @SerialName("FirstName")
        val firstName: String,

        @SerialName("Id")
        val id: Int,

        @SerialName("LoginRole")
        val loginRole: String,

        @SerialName("SecondName")
        val secondName: String?,

        @SerialName("Surname")
        val surname: String,

        @SerialName("Value")
        val value: String,
    )

    @Serializable
    data class Period(

        @SerialName("Current")
        val current: Boolean,

        @SerialName("End")
        val end: PeriodDate,

        @SerialName("Id")
        val id: Int,

        @SerialName("Last")
        val last: Boolean,

        @SerialName("Level")
        val level: Int,

        @SerialName("Number")
        val number: Int,

        @SerialName("Start")
        val start: PeriodDate,
    )

    @Serializable
    data class Pupil(

        @SerialName("FirstName")
        val firstName: String,

        @SerialName("Id")
        val id: Int,

        @SerialName("LoginId")
        val loginId: Int,

        @SerialName("LoginValue")
        val loginValue: String,

        @SerialName("SecondName")
        val secondName: String,

        @SerialName("Sex")
        val sex: Boolean,

        @SerialName("Surname")
        val surname: String,
    )

    @Serializable
    data class SenderEntry(

        @SerialName("Address")
        val address: String,

        @SerialName("AddressHash")
        val addressHash: String,

        @SerialName("Initials")
        val initials: String,

        @SerialName("LoginId")
        val loginId: Int,
    )

    @Serializable
    data class Unit(

        @SerialName("Address")
        val address: String,

        @SerialName("DisplayName")
        val displayName: String,

        @SerialName("Id")
        val id: Int,

        @SerialName("Name")
        val name: String,

        @SerialName("Patron")
        val patron: String,

        @SerialName("RestURL")
        val restUrl: String,

        @SerialName("Short")
        val short: String,

        @SerialName("Symbol")
        val symbol: String,
    )
}

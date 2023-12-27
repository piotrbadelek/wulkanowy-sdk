package io.github.wulkanowy.sdk.scrapper.login

import io.github.wulkanowy.sdk.scrapper.login.UrlGenerator.Site.BASE
import io.github.wulkanowy.sdk.scrapper.login.UrlGenerator.Site.HOME
import io.github.wulkanowy.sdk.scrapper.login.UrlGenerator.Site.LOGIN
import io.github.wulkanowy.sdk.scrapper.login.UrlGenerator.Site.MESSAGES
import io.github.wulkanowy.sdk.scrapper.login.UrlGenerator.Site.STUDENT
import io.github.wulkanowy.sdk.scrapper.login.UrlGenerator.Site.STUDENT_PLUS
import java.net.URL
import java.net.URLEncoder

internal class UrlGenerator(
    private val schema: String,
    private val host: String,
    private val domainSuffix: String,
    var symbol: String,
    var schoolId: String,
) {

    constructor(url: URL, domainSuffix: String, symbol: String, schoolId: String) : this(url.protocol, url.host, domainSuffix, symbol, schoolId)

    enum class Site {
        BASE,
        LOGIN,
        HOME,
        STUDENT,
        STUDENT_PLUS,
        MESSAGES,
        ;

        val isStudent: Boolean
            get() = this == STUDENT_PLUS || this == STUDENT
    }

    fun generate(type: Site): String {
        if (type == BASE) return "$schema://$host"
        return "$schema://${getSubDomain(type)}$domainSuffix.$host/$symbol/${if (type.isStudent) "$schoolId/" else ""}"
    }

    fun createLogoutEndpoints(): List<String> {
        return listOf(
            "$schema://uonetplus$domainSuffix.$host/$symbol/LoginEndpoint.aspx?logout=true",
            "$schema://uonetplus-logowanie.$host/$symbol/Fs/Ls?wa=wsignoutcleanup1.0",
            "$schema://cufs.$host/$symbol/Account/LogOff?wreply=${encode("$schema://uonetplus.$host/$symbol")}",
            "$schema://uonetplus$domainSuffix.$host/$symbol/loginendpoint.aspx?wa=wsignoutcleanup1.0",
        )
    }

    private fun encode(url: String) = URLEncoder.encode(url, "UTF-8")

    fun createReferer(type: Site): String {
        return when (type) {
            LOGIN -> "$schema://cufs$domainSuffix.$host/"
            STUDENT -> "$schema://uonetplus$domainSuffix.$host/"
            else -> ""
        }
    }

    private fun getSubDomain(type: Site): String {
        return when (type) {
            LOGIN -> "cufs"
            HOME -> "uonetplus"
            STUDENT -> "uonetplus-uczen"
            STUDENT_PLUS -> "uonetplus-uczenplus"
            MESSAGES -> "uonetplus-wiadomosciplus"
            else -> error("unknown")
        }
    }
}

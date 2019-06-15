package io.github.wulkanowy.sdk.messages

import com.google.gson.annotations.SerializedName

data class Recipient(

    @SerializedName("LoginId")
    val loginId: Int,

    @SerializedName("Nazwa")
    val name: String
)

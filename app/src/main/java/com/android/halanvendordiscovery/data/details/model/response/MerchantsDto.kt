package com.android.halanvendordiscovery.data.details.model.response

import com.google.gson.annotations.SerializedName

data class MerchantsDto(
    @SerializedName("merchants" ) var merchants : ArrayList<Merchant> = arrayListOf(),
    @SerializedName("count"     ) var count     : Int?                 = null
)

data class Merchant (
    @SerializedName("id"                ) var id              : String?   = null,
    @SerializedName("name"              ) var name            : String?   = null,
    @SerializedName("arabic_name"       ) var arabicName      : String?   = null,
    @SerializedName("creation_date"     ) var creationDate    : Int?      = null,
    @SerializedName("status"            ) var status          : Int?      = null,
    @SerializedName("address"           ) var address         : String?   = null,
    @SerializedName("governorate"       ) var governorate     : String?   = null,
    @SerializedName("longitude"         ) var longitude       : Double?   = null,
    @SerializedName("latitude"          ) var latitude        : Double?   = null,
    @SerializedName("phone_number"      ) var phoneNumber     : String?   = null,
    @SerializedName("branch_head_name"  ) var branchHeadName  : String?   = null,
    @SerializedName("branch_head_phone" ) var branchHeadPhone : String?   = null,
    @SerializedName("categories"        ) var categories      : String?   = null,
    @SerializedName("merchant_id"       ) var merchantId      : String?   = null,
    @SerializedName("vendor"            ) var vendor          : Vendor?   = Vendor(),
    @SerializedName("location"          ) var location        : Location? = Location()
)

data class Vendor (
    @SerializedName("id"               ) var id             : String?  = null,
    @SerializedName("address"          ) var address        : String?  = null,
    @SerializedName("governorate"      ) var governorate    : String?  = null,
    @SerializedName("name"             ) var name           : String?  = null,
    @SerializedName("arabicName"       ) var arabicName     : String?  = null,
    @SerializedName("marketingName"    ) var marketingName  : String?  = null,
    @SerializedName("phoneNumber"      ) var phoneNumber    : String?  = null,
    @SerializedName("description"      ) var description    : String?  = null,
    @SerializedName("lat"              ) var lat            : Double?  = null,
    @SerializedName("long"             ) var long           : Double?  = null,
    @SerializedName("displayed_on_app" ) var displayedOnApp : Boolean? = null

)

data class Location (
    @SerializedName("lat" ) var lat : Double? = null,
    @SerializedName("lon" ) var lon : Double? = null
)
package com.patikadev.deneme1.model_json

class User {

    var name = "Ali"
    var surname = "Gürelli"
    val age = 30
    var car  : Car = Car()
    val qualifications: List<String> = listOf("Android", "Googling", "Flutter")
    val addresses: List<Address> = listOf(
        Address(1001, "Beyoğlu", "İstanbul", null),
        Address(1010, "Bornava", "İzmir", 34440)
    )

}
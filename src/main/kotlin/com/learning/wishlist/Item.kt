package com.learning.wishlist

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
data class Item(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long,
    var name: String,
    var need: Int,
    var want: Int,
    var likelyToUse: Int,
    val price: Double
) {
    constructor(): this(0, "dummyName", 0, 0, 0, 0.0)
}
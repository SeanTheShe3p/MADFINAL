package com.example.finasprintsproject

class User {
    var username: String? = null
    var cleanDate: String? = null
    var moveinDate: String? = null
    var position: String? = null
    var uid: String? = null

    constructor() {}

    constructor(
        username: String?,
        cleanDate: String?,
        moveinDate: String?,
        position: String,
        uid: String?
    ) {
        this.username = username
        this.cleanDate = cleanDate
        this.moveinDate = moveinDate
        this.position = position
        this.uid = uid
    }
}
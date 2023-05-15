package com.example.pract19_1

import java.util.*

class Crime(var id: UUID = UUID.randomUUID(), var date: Date = Date()){
    var title: String = ""
    var solved: Boolean = false

    constructor(id: UUID, title: String, date: Date, solved: Boolean): this(id, date) {
        this.id = id
        this.title = title
        this.date = date
        this.solved = solved

    }
}
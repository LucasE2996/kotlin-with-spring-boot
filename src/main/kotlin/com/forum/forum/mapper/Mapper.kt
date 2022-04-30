package com.forum.forum.mapper

interface Mapper<T, U> {

    fun map(t: T): U

}

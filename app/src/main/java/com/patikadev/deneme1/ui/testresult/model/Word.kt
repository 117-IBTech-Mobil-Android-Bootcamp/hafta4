package com.patikadev.deneme1.ui.testresult.model

import java.io.Serializable

data class Word(
    val isCorrect : Boolean,
    val actualWord: String,
    val meaining: String,
    var isInDeck : Boolean = false
) : Serializable


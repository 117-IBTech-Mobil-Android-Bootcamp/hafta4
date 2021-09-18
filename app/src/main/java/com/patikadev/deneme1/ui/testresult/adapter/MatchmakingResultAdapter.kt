package com.patikadev.deneme1.ui.testresult.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.patikadev.deneme1.R
import com.patikadev.deneme1.ui.testresult.model.Word

class MatchmakingResultAdapter(private val wordList: List<Word>, private val block : (Word, Int) -> Unit ) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    private val DEFAULT_CARD_VIEW = 0
    private val SECOND_CARD_VIEW = 1



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == DEFAULT_CARD_VIEW)
            WordViewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.row_word, parent, false)
            )
        else
            SecondViewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.row_card_as_choice, parent, false)
            )

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        val word = this.wordList[position]
        when (getItemViewType(position)) {
            DEFAULT_CARD_VIEW -> {
               (holder as WordViewHolder).apply {
                   setData(word)
                   setOnItemClickListener(word, this@MatchmakingResultAdapter.block)
               }

            }
            SECOND_CARD_VIEW -> { (holder as SecondViewHolder).setData(word) }
        }


    }


    override fun getItemCount(): Int = this.wordList.size

    override fun getItemViewType(position: Int): Int {

        val word = wordList[position]
        return if (word.isCorrect) {
            DEFAULT_CARD_VIEW
        } else SECOND_CARD_VIEW

    }

    fun notifyChanges(clickedItem: Word) {
        val clickedIndex = this.wordList.indexOf(clickedItem)
        notifyItemInserted(clickedIndex)

    }

    fun removeItem(clickedItem: Word) {
        val clickedIndex = this.wordList.indexOf(clickedItem)
        notifyItemRemoved(clickedIndex)
    }
}

class WordViewHolder(rootView: View) : RecyclerView.ViewHolder(rootView) {

    val imageStatus = rootView.findViewById<AppCompatImageView>(R.id.imageview_status)
    val textview_actualword = rootView.findViewById<AppCompatTextView>(R.id.textview_actualword)
    val textview_meaning = rootView.findViewById<AppCompatTextView>(R.id.textview_meaing)
    val imageview_is_in_deck = rootView.findViewById<AppCompatImageView>(R.id.imageview_is_in_deck)


    fun setData(word: Word) {
        imageStatus.setImageResource(if (word.isCorrect) R.drawable.ic_success_outline else R.drawable.wrong_outline)
        textview_actualword.text = word.actualWord
        textview_meaning.text = word.meaining
        imageview_is_in_deck.setImageResource(if (word.isInDeck) R.drawable.ic_added_to_deck else R.drawable.ic_add_to_deck)
    }

    fun setOnItemClickListener(
        word: Word,
        block: (Word, Int) -> Unit
    ) {
        imageview_is_in_deck.setOnClickListener {

            block.invoke(word, it.id)
        }

        imageStatus.setOnClickListener {
            //itemClickListener!!.onItemClicked(word, it.id)
        }
    }

}


class SecondViewHolder(rootView: View) : RecyclerView.ViewHolder(rootView) {

    val textview_actualword = rootView.findViewById<AppCompatTextView>(R.id.textview_actualword)

    fun setData(word: Word) {
        textview_actualword.text = word.actualWord
    }


}
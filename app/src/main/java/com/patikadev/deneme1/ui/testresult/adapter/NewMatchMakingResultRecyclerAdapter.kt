package com.patikadev.deneme1.ui.testresult.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import com.patikadev.deneme1.R
import com.patikadev.deneme1.base.BaseRecyclerAdapter
import com.patikadev.deneme1.ui.testresult.model.Word

class NewMatchMakingResultRecyclerAdapter (val mContext : Context, mList : List<Word>, val block: (Word) -> Unit): BaseRecyclerAdapter<Word, NewMatchMakingResultRecyclerAdapter.WordViewHolder>(mList, block)
{


    override fun bind(bindedObject: Word, holder: WordViewHolder) {
        holder.setData(bindedObject)
        holder.setOnClickListener(bindedObject, block)
    }


    override fun getViewHolder(container : ViewGroup): WordViewHolder  = WordViewHolder(LayoutInflater.from(mContext).inflate(R.layout.row_word, container, false), block)

    inner class WordViewHolder(rootView: View, block: (Word) -> Unit) : BaseViewHolder(rootView, block) {


        val imageStatus = rootView.findViewById<AppCompatImageView>(R.id.imageview_status)
        val textview_actualword = rootView.findViewById<AppCompatTextView>(R.id.textview_actualword)
        val textview_meaning = rootView.findViewById<AppCompatTextView>(R.id.textview_meaing)
        val imageview_is_in_deck = rootView.findViewById<AppCompatImageView>(R.id.imageview_is_in_deck)


        override fun setData(model: Word) {
            super.setData(model)
            imageStatus.setImageResource(if (model.isCorrect) R.drawable.ic_success_outline else R.drawable.wrong_outline)
            textview_actualword.text = model.actualWord
            textview_meaning.text = model.meaining
            imageview_is_in_deck.setImageResource(if (model.isInDeck) R.drawable.ic_added_to_deck else R.drawable.ic_add_to_deck)
        }


    }



}
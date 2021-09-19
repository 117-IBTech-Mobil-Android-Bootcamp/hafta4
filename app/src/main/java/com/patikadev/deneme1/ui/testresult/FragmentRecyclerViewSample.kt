package com.patikadev.deneme1.ui.testresult

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.patikadev.deneme1.ui.activities.HomeActivity
import com.patikadev.deneme1.R
import com.patikadev.deneme1.base.BaseFragment
import com.patikadev.deneme1.ui.testresult.adapter.NewMatchMakingResultRecyclerAdapter
import com.patikadev.deneme1.ui.testresult.model.Word
import kotlinx.android.synthetic.main.fragment_recyclerview_sample.*

class FragmentRecyclerViewSample : BaseFragment() {


    private lateinit var matchmakingResultAdapter: NewMatchMakingResultRecyclerAdapter

    override fun getLayoutID(): Int  = R.layout.fragment_recyclerview_sample

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        prepareView()

    }

    override fun prepareView() {
        (requireActivity() as HomeActivity).hideNavigation()


        val word = Word(true, "book", "kitap")
        val word2 = Word(true, "red", "kırmıız")
        val word3 = Word(false, "come", "gelmek")
        val word4 = Word(false, "bring", "getirmek")
        val word5 = Word(true, "notice", "farkında varmak")
        val word6 = Word(false, "realize", "farkında varmak")
        val word7 = Word(false, "pressure", "basınç")
        val word9 = Word(true, "desk", "kitap")
        val word99 = Word(true, "terminal", "kırmıız")
        val word91 = Word(false, "pull request", "gelmek")
        val word92 = Word(false, "make", "getirmek")
        val word93 = Word(true, "gone", "farkında varmak")
        val word94 = Word(false, "implement", "farkında varmak")
        val word95 = Word(false, "pressure", "basınç")


        val list = mutableListOf(word, word2 ,word3, word4 , word5, word6, word7, word9, word99, word91, word92, word93, word94, word95)


        matchmakingResultAdapter = NewMatchMakingResultRecyclerAdapter(requireContext(), list){
            Toast.makeText(requireContext(), "Tıklandı -- >${it.actualWord}", Toast.LENGTH_SHORT).show()
        }

       /* matchmakingResultAdapter = MatchmakingResultAdapter(list){clickedObject, itemID ->
            when(itemID){
                R.id.imageview_status -> {
                    Toast.makeText(requireContext(), "tıklanan status ${clickedObject.isCorrect}", Toast.LENGTH_SHORT).show()

                }
                R.id.imageview_is_in_deck ->{
                    /*Toast.makeText(requireContext(), "tıklanan word ${clickedObject.actualWord}", Toast.LENGTH_SHORT).show()
                    matchmakingResultAdapter.removeItem(clickedObject)
                    list.remove(clickedObject)*/
                    AlertDialog.Builder(this@FragmentRecyclerViewSample.requireContext())
                        .setTitle("Bilgi")
                        .setMessage("Tıklanan item'ın çevirisi ${clickedObject.meaining}")
                        .setCancelable(false)
                        .setPositiveButton("Tamam"
                        ) { dialog, _ -> dialog.dismiss() }
                        .show()

                }
            }
        }*/

        val linearLayoutManager = GridLayoutManager(requireContext(), 1)
        recyclerview.layoutManager = linearLayoutManager
        recyclerview.adapter  = matchmakingResultAdapter

        //isnpectData(list)
    }


    override fun isNavigationbarVisible() = false


    /* private fun isnpectData(list: List<Word>) {
         if (list.isNullOrEmpty()) {
             recyclerview.gone()

         }
     }*/
}
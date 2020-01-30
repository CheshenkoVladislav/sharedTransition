package com.example.changerecyclervieworientation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import android.transition.ChangeBounds
import android.transition.ChangeImageTransform


class Fragment1: Fragment() {

    private lateinit var lm: LinearLayoutManager

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.activity_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lm = LinearLayoutManager(context, LinearLayoutManager.VERTICAL,
            false)
        rv.layoutManager = lm
        val adapter = MainActivity.Adapter()
        rv.adapter = adapter
        btn.setOnClickListener {

//            val changeImageTransform =
//                TransitionInflater.from(context).inflateTransition(R.transition.change_image_transform)
//            val changeBoundsTransform =
//                TransitionInflater.from(context).inflateTransition(R.transition.change_bounds)

            sharedElementReturnTransition = ChangeBounds()
            sharedElementEnterTransition = ChangeImageTransform()
            exitTransition = ChangeBounds()

            val fragment2 = Fragment2()
            // Setup transition on second fragment
            fragment2.sharedElementEnterTransition = ChangeBounds()
            fragment2.enterTransition = ChangeBounds();

            val firstVisiblePosition = lm.findFirstVisibleItemPosition()
            val lastVisiblePosition = lm.findLastVisibleItemPosition()
            val transaction = fragmentManager!!.beginTransaction()
                .replace(R.id.container, fragment2, fragment2::class.java.simpleName)
                .addToBackStack("name")
            for (i in firstVisiblePosition..lastVisiblePosition) {
                val holderForAdapterPosition =
                    rv.findViewHolderForAdapterPosition(i) as MainActivity.Adapter.Holder
                val itemView = holderForAdapterPosition.itemView
                transaction.addSharedElement(itemView, "unique_key_$i")
            }
            transaction.commit()
        }
    }
}
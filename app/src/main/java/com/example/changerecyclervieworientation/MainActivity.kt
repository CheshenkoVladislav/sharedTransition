package com.example.changerecyclervieworientation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {

    private lateinit var lm: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.cont)
        val fragment1 = Fragment1()
        supportFragmentManager.beginTransaction()
            .add(R.id.container, fragment1, Fragment1::class.java.simpleName)
            .commit()
//        lm = LinearLayoutManager(this, LinearLayoutManager.VERTICAL,
//            false)
//        rv.layoutManager = lm
//        val adapter = Adapter()
//        rv.adapter = adapter
//        btn.setOnClickListener {
//            val firstVisiblePosition = lm.findFirstVisibleItemPosition()
//            val lastVisiblePosition = lm.findLastVisibleItemPosition()
//            val pairs = ArrayList<Pair<View, String>>()
//            for (i in firstVisiblePosition..lastVisiblePosition) {
//                val holderForAdapterPosition =
//                    rv.findViewHolderForAdapterPosition(i) as Adapter.Holder
//                val itemView = holderForAdapterPosition.itemView
//                pairs.add(Pair(itemView, "unique_key_$i"))
//            }
//            val bundle = ActivityOptions.makeSceneTransitionAnimation(
//                this,
//                *pairs.toTypedArray()
//            ).toBundle()
//            val fragment1 = Fragment1()
//            supportFragmentManager.beginTransaction()
//                .add(fragment1, Fragment1::class.java.simpleName)
//                .commit()
//            startActivity(Intent(this, ScndActivity::class.java), bundle)
//        }
    }

    override fun onResume() {
        super.onResume()
    }

    class Adapter : RecyclerView.Adapter<Adapter.Holder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder =
            Holder(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.item_item,
                    parent,
                    false
                )
            )

        override fun getItemCount(): Int = 10

        override fun onBindViewHolder(holder: Holder, position: Int) {
            holder.bind(position)
        }

        class Holder(view: View) : RecyclerView.ViewHolder(view) {

            fun bind(position: Int) {
                itemView.transitionName = "unique_key_$position"
            }
        }
    }
}

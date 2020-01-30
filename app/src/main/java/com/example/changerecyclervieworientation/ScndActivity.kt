package com.example.changerecyclervieworientation

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class ScndActivity: AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val lm = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,
            false)
        rv.layoutManager = lm
        val adapter = MainActivity.Adapter()
        rv.adapter = adapter
        btn.setOnClickListener {

            //            val currentOrientation = lm.orientation
//            if (currentOrientation == LinearLayoutManager.VERTICAL) {
//                lm.orientation = LinearLayoutManager.HORIZONTAL
//            } else {
//                lm.orientation = LinearLayoutManager.VERTICAL
//            }
//            adapter.notifyItemRangeChanged(1, adapter?.itemCount ?: 0)
        }
        supportPostponeEnterTransition()
        rv.post {
            supportStartPostponedEnterTransition()
        }
    }
}
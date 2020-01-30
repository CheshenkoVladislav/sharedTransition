package com.example.changerecyclervieworientation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class Fragment2: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.activity_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val lm = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL,
            false)
        rv.layoutManager = lm
        val adapter = MainActivity.Adapter()
        rv.adapter = adapter
        btn.setOnClickListener {
        }
        postponeEnterTransition()
    }

    override fun onStart() {
        super.onStart()
        rv.post {
            startPostponedEnterTransition()
        }
    }
}
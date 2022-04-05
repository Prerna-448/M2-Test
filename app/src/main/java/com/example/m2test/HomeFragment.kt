package com.example.m2test

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HomeFragment : Fragment() {

    lateinit var recyclerView: RecyclerView
//    lateinit var layoutManager: RecyclerView.LayoutManager
    lateinit var adapter: MyAdapter

    var array: ArrayList<ModelClass> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        recyclerView = view.findViewById(R.id.my_recycler)


        var data1 = ModelClass(
            "Prerna",
            "Cabinet Fiji MoU for",
            "Weather",
            "Okhla Phase 1",
            "https://cdn.zeplin.io/610ccdbb463f716192391cbc/assets/24627ca5-7c0a-442b-821d-e90f1849545f.png"
        )
        var data2 = ModelClass(
            "Prerna",
            "Cabinet Fiji MoU for",
            "Event",
            "Lajpat Nagar",
            "https://cdn.zeplin.io/610ccdbb463f716192391cbc/assets/97eea924-ab5f-4c0a-bb47-dff6ef8932cf.png"
        )
        var data3 = ModelClass(
            "Prerna",
            "Cabinet Fiji MoU for",
            "Crime",
            "Okhla Phase 2",
            "https://cdn.zeplin.io/610ccdbb463f716192391cbc/assets/2fd442a3-b630-4958-9d7c-cb4326dfe509.png"
        )
        var data4 = ModelClass(
            "Prerna",
            "Cabinet Fiji MoU for",
            "Traffic",
            "Saket",
            "https://cdn.zeplin.io/610ccdbb463f716192391cbc/assets/5d8df8b7-5d7c-40df-836e-beefedf8af04.png"
        )
        var data5 = ModelClass(
            "Prerna",
            "Cabinet Fiji MoU for",
            "Weather",
            "Okhla Phase 1",
            "https://cdn.zeplin.io/610ccdbb463f716192391cbc/assets/24627ca5-7c0a-442b-821d-e90f1849545f.png"
        )
        var data6 = ModelClass(
            "Prerna",
            "Cabinet Fiji MoU for",
            "Event",
            "Lajpat Nagar",
            "https://cdn.zeplin.io/610ccdbb463f716192391cbc/assets/97eea924-ab5f-4c0a-bb47-dff6ef8932cf.png"
        )
        var data7 = ModelClass(
            "Prerna",
            "Cabinet Fiji MoU for",
            "Crime",
            "Okhla Phase 2",
            "https://cdn.zeplin.io/610ccdbb463f716192391cbc/assets/2fd442a3-b630-4958-9d7c-cb4326dfe509.png"
        )
        var data8 = ModelClass(
            "Prerna",
            "Cabinet Fiji MoU for",
            "Traffic",
            "Saket",
            "https://cdn.zeplin.io/610ccdbb463f716192391cbc/assets/5d8df8b7-5d7c-40df-836e-beefedf8af04.png"
        )


        array.add(data1)
        array.add(data2)
        array.add(data3)
        array.add(data4)
        array.add(data5)
        array.add(data6)
        array.add(data7)
        array.add(data8)



        recyclerView.layoutManager = GridLayoutManager(context, 2)

        adapter = MyAdapter(activity as Context, array)

        recyclerView.adapter = adapter

        return view
    }

}
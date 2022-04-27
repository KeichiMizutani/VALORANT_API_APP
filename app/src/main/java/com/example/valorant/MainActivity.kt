package com.example.valorant

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.valorant.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var recyclerView: RecyclerView

    val puuid = "rVOQ-oI3-4muYPzwWjdimwHhXYEiRI7mPrHM5OapNcz54UDS2RssPR2sS2PM58zZvXbRd0c_12LD3A"
    var playerId = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).apply { setContentView(this.root) }

        // dummy data
        val textList = listOf(
            listOf(
                "https://media.valorant-api.com/agents/22697a3d-45bf-8dd7-4fec-84a9e28c69d7/displayicon.png",
                "Bind",
                "2022/04/27",
                "16",
                "16",
                "28/24/5",
                "1.2",
                "19",
                "151",
                "226"
            ),
            listOf(
                "https://media.valorant-api.com/agents/22697a3d-45bf-8dd7-4fec-84a9e28c69d7/displayicon.png",
                "Breeze",
                "2022/04/26",
                "16",
                "14",
                "24/18/4",
                "1.3",
                "24",
                "136",
                "215"
            ),
            listOf(
                "https://media.valorant-api.com/agents/22697a3d-45bf-8dd7-4fec-84a9e28c69d7/displayicon.png",
                "Breeze",
                "2022/04/26",
                "13",
                "9",
                "15/16/2",
                "0.9",
                "15",
                "129",
                "210"
            ),
            listOf(
                "https://media.valorant-api.com/agents/add6443a-41bd-e414-f6ad-e58d267f4e95/displayicon.png",
                "Haven",
                "2022/04/20",
                "13",
                "10",
                "36/12/8",
                "3.0",
                "23",
                "288",
                "478"
            ),
            listOf(
                "https://media.valorant-api.com/agents/707eab51-4836-f488-046a-cda6bf494859/displayicon.png",
                "Icebox",
                "2022/04/20",
                "5",
                "13",
                "14/13/3",
                "1.1",
                "19",
                "161",
                "243"
            ),
            listOf(
                "https://media.valorant-api.com/agents/1e58de9c-4950-5125-93e9-a0aee9f98746/displayicon.png",
                "Ascent",
                "2022/04/19",
                "3",
                "13",
                "21/10/3",
                "2.1",
                "10",
                "322",
                "473"
            ),
            listOf(
                "https://media.valorant-api.com/agents/add6443a-41bd-e414-f6ad-e58d267f4e95/displayicon.png",
                "Fracture",
                "2022/04/19",
                "11",
                "13",
                "24/17/10",
                "1.4",
                "15",
                "187",
                "307"
            ),
            listOf(
                "https://media.valorant-api.com/agents/5f8d3a7f-467b-97f3-062c-13acf203c006/displayicon.png",
                "Fracture",
                "2022/04/12",
                "13",
                "9",
                "30/13/3",
                "2.3",
                "22",
                "257",
                "380"
            ),
            listOf(
                "https://media.valorant-api.com/agents/a3bfb853-43b2-7238-a4f1-ad90e9e46bcc/displayicon.png",
                "Split",
                "2022/04/12",
                "2",
                "13",
                "11/8/2",
                "1.4",
                "30",
                "204",
                "293"
            ),
        )

        recyclerView = findViewById(R.id.recycler_view)
        recyclerView.adapter = RecyclerAdapter(textList)
        recyclerView.layoutManager = LinearLayoutManager(this)
    }
}
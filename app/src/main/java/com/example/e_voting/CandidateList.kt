package com.example.e_voting

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.firebase.ui.database.FirebaseRecyclerOptions
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.Query

class CandidateList : AppCompatActivity() {

    lateinit var rvCandidateList : RecyclerView
    lateinit var  adapter : CandidateAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_candidate_list)


        rvCandidateList = findViewById(R.id.RecyclerCandidate)

        rvCandidateList.setLayoutManager(LinearLayoutManager(this))


        //
        val query: Query = FirebaseDatabase.getInstance().reference.child("Candidate")
        val options: FirebaseRecyclerOptions<candidateModel> =
            FirebaseRecyclerOptions.Builder<candidateModel>()
                .setQuery(query, candidateModel::class.java)
                .build()
        adapter = CandidateAdapter(options)
        rvCandidateList.setAdapter(adapter)



    }
    override fun onStart() {
        super.onStart()
        adapter.startListening()
    }

    override fun onStop() {
        super.onStop()
        adapter.stopListening()
    }
}
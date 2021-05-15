package com.example.e_voting

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.firebase.ui.firestore.FirestoreRecyclerAdapter
import com.firebase.ui.firestore.FirestoreRecyclerOptions
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query

class ElectionCampaign : AppCompatActivity() {
    lateinit var recylerCampaign : RecyclerView
    var adapter: FirestoreRecyclerAdapter<*, *>? = null

    lateinit var fb : FirebaseFirestore
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_election_campaign)

        recylerCampaign = findViewById(R.id.RecyclerCampaign)
        fb = FirebaseFirestore.getInstance()
        var query : Query = fb.collection("Rally")
        var Option : FirestoreRecyclerOptions<CampaignModel> = FirestoreRecyclerOptions.Builder<CampaignModel>()
                .setQuery(query,CampaignModel::class.java).build()

        adapter = object : FirestoreRecyclerAdapter<CampaignModel, ProductViewHolder>(Option) {
            override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
                val inflater = LayoutInflater.from(parent.context)
                val view: View = inflater.inflate(R.layout.sample_list_item, parent, false)
                return ProductViewHolder(view)
            }

            protected override fun onBindViewHolder(holder: ProductViewHolder, position: Int, model: CampaignModel) {
            holder.name.setText(model.getSender())
                holder.txtCampaign.setText(model.getCampaign())
            }
        }
        recylerCampaign.setHasFixedSize(true)
        recylerCampaign.setLayoutManager(LinearLayoutManager(this))
        recylerCampaign.setAdapter(adapter)


    }

    private class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var txtCampaign: TextView

        var name: TextView

        init {
            txtCampaign = itemView.findViewById(R.id.txtCampaign)

            name = itemView.findViewById(R.id.txtSender)
        }
    }

    override fun onStart() {
        super.onStart()
        adapter!!.startListening()
    }

    override fun onStop() {
        super.onStop()
        if (adapter != null) {
            adapter!!.stopListening()
        }
    }
}

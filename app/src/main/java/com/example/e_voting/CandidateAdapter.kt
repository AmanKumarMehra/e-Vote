package com.example.e_voting

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.firebase.ui.database.FirebaseRecyclerAdapter
import com.firebase.ui.database.FirebaseRecyclerOptions


class CandidateAdapter(options: FirebaseRecyclerOptions<candidateModel>) :
    FirebaseRecyclerAdapter<candidateModel, CandidateAdapter.viewHolder>(
        options
    ) {
    protected override fun onBindViewHolder(
        holder: CandidateAdapter.viewHolder,
        position: Int,
        model: candidateModel
    ) {
        holder.txtCandidateName.setText(model.getName())
        holder.txtPartyName.setText(model.getPartyName())
        Glide.with(holder.imgCandidate.getContext()).load(model.getImgCandidate())
            .into(holder.imgCandidate)
        Glide.with(holder.imgPartySymbol.getContext()).load(model.getPartySymbol())
            .into(holder.imgPartySymbol)

        holder.btnCastVote.setOnClickListener(View.OnClickListener {
            //TODO Voting logics
        })


    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CandidateAdapter.viewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view: View = inflater.inflate(R.layout.list_candidate, parent, false)
        return viewHolder(view)
    }

    inner class viewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var txtCandidateName: TextView
        var txtPartyName: TextView
        var imgCandidate: ImageView
        var imgPartySymbol: ImageView
        var btnCastVote : Button

        init {
            txtCandidateName = itemView.findViewById(R.id.txtCandidateName)
            imgCandidate = itemView.findViewById(R.id.profile_image)
            txtPartyName = itemView.findViewById(R.id.txtPartyName)
            imgPartySymbol = itemView.findViewById(R.id.imgPartySymbol)
            btnCastVote = itemView.findViewById(R.id.btnCastVote)

        }
    }
}
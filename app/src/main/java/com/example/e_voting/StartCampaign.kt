package com.example.e_voting

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.FirebaseFirestore
import java.util.*

class StartCampaign : AppCompatActivity() {

    lateinit var btnUploadCampaign: Button
    lateinit var CampaignDetails: EditText
    lateinit var AuthorName : EditText
    lateinit var fb : FirebaseFirestore
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start_campaign)

        btnUploadCampaign = findViewById(R.id.btnUploadCampaign)

        CampaignDetails = findViewById(R.id.etCampaignDetails)
        AuthorName = findViewById(R.id.etAuthor)

        btnUploadCampaign.setOnClickListener(View.OnClickListener {
            var campaign = CampaignDetails.editableText.toString()
            var author = AuthorName.editableText.toString()
            Toast.makeText(this,"Successfully Uploaded",Toast.LENGTH_LONG).show()

            uploadCampaign(campaign,author)



        })


    }


    fun uploadCampaign(campaign: String,author:String){
        fb = FirebaseFirestore.getInstance()


        val listQuery: MutableMap<String, Any> = HashMap()
        listQuery["campaign"] = campaign
        listQuery["sender"] = author

        fb.collection("Rally").add(listQuery)

        var i = Intent(this, ElectionCampaign::class.java)
        startActivity(i)



    }
}
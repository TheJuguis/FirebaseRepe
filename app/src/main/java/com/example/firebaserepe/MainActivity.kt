package com.example.firebaserepe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val database = Firebase.database
        val myRef = database.reference

        myRef.child("ejemplo").child("1").setValue(Card("1","rojo","corazones"))
        myRef.child("ejemplo").child("2").setValue(Card("9","negro","diamantes"))
        myRef.child("ejemplo").child("3").setValue(Card("3","rojo","diamantes"))



        myRef.child("usuarios").child("1").setValue(Users("1","Lalo","Lalo@correo.com"))
        myRef.child("usuarios").child("2").setValue(Users("2","Juan","Juan@correo.com"))
        myRef.child("usuarios").child("3").setValue(Users("3","Pedro","Pedro@correo.com"))


        myRef.child("ejemplo").child("3").get().addOnSuccessListener {response ->
            Log.e("firebaseResponse",response.value.toString())
        }.addOnFailureListener{
            Log.e("firebaseResponse","Error getting data",it)
        }

        myRef.child("usuarios").child("2").get().addOnSuccessListener {response ->
            Log.e("firebaseResponse",response.value.toString())
        }.addOnFailureListener{
            Log.e("firebaseResponse","Error getting data",it)
        }
    }
}
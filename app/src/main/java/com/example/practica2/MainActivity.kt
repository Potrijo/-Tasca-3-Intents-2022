package com.example.practica2

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.AlarmClock
import android.provider.ContactsContract
import android.provider.MediaStore
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

private const val TAG = "MyActivity"

class MainActivity : AppCompatActivity() {

    var textazo = ""
    var numeroVista = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        var btnCall = findViewById<Button>(R.id.button19)
        var btnLink = findViewById<Button>(R.id.button20)
        var btnMap = findViewById<Button>(R.id.button21)
        var btnAlarm = findViewById<Button>(R.id.button23)
        var btnPhoto = findViewById<Button>(R.id.button25)
        var btnContacts = findViewById<Button>(R.id.button24)


        btnCall.setOnClickListener {
            val number = findViewById<TextView>(R.id.editTextTextPersonName2)
            val callIntent = Intent(Intent.ACTION_DIAL)
            callIntent.setData(Uri.parse("tel:"+number.text.toString()))
            startActivity(callIntent)
        }

        btnLink.setOnClickListener{
            val link = findViewById<TextView>(R.id.editTextTextPersonName)
            val linkIntent = Intent(Intent.ACTION_VIEW)
            linkIntent.data = Uri.parse("https://"+link.text.toString()+"/")
            startActivity(linkIntent)

        }

        btnMap.setOnClickListener{

            // https://developers.google.com/maps/documentation/urls/android-intents
            // https://www.youtube.com/watch?v=aiBiKPfwWtI&ab_channel=GameAppStudio
            val uri = Uri.parse("geo:41.6716, 1.8641")
            val locationIntent = Intent(Intent.ACTION_VIEW, uri)
            locationIntent.setPackage("com.google.android.apps.maps")
            startActivity(locationIntent)

        }

        btnAlarm.setOnClickListener{
            val intent = Intent(AlarmClock.ACTION_SHOW_ALARMS)
            startActivity(intent)

        }

        btnPhoto.setOnClickListener {
            val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            try{
                startActivity(takePictureIntent)
            }
            catch (e: ActivityNotFoundException){
                val toast = Toast.makeText(applicationContext, "Photo app not found", Toast.LENGTH_SHORT)
            }

        }

        btnContacts.setOnClickListener {
            val contactsIntent = Intent(Intent.ACTION_PICK)
            contactsIntent.type = ContactsContract.Contacts.CONTENT_TYPE
            startActivity(contactsIntent)
        }

    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart")


    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume")

    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause")


    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop")

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy")

    }

    override fun onSaveInstanceState(outState: Bundle) {
        Log.d(TAG, "OnSaveInstanceSte")

        super.onSaveInstanceState(outState)

    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        Log.d(TAG, "OnRestore")
        super.onRestoreInstanceState(savedInstanceState)

    }

}
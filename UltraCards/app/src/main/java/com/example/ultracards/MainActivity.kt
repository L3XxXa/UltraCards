package com.example.ultracards

import android.app.PendingIntent
import android.nfc.NfcAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {
    private lateinit var buttonEmulate: Button
    private lateinit var buttonSetup: Button
    private lateinit var nfcAdapter: NfcAdapter
    private lateinit var pendingIntent: PendingIntent
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        buttonEmulate = findViewById(R.id.buttonEmulate)
        buttonEmulate.setOnClickListener{

        }
        buttonSetup = findViewById(R.id.buttonSetUp)
    }
}
package com.example.ultracards

import android.app.AlertDialog
import android.app.PendingIntent
import android.content.Intent
import android.content.IntentFilter
import android.nfc.NfcAdapter
import android.nfc.Tag
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var buttonEmulate: Button
    private lateinit var buttonSetup: Button
    private lateinit var nfcAdapter: NfcAdapter
    private lateinit var pendingIntent: PendingIntent
    private var writingMode: Boolean = false
    private var tagID = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        buttonEmulate = findViewById(R.id.buttonEmulate)
        buttonSetup = findViewById(R.id.buttonSetUp)
        buttonSetup.setOnClickListener{
            nfcAdapter = NfcAdapter.getDefaultAdapter(this)
            Toast.makeText(this, "aboba", Toast.LENGTH_SHORT).show()
            pendingIntent = PendingIntent.getActivity(this, 0, Intent(this, MainActivity :: class.java), 0)
            enableWritingMode()
            AlertDialog.Builder(this).setTitle("Touch card for setup").setOnCancelListener {
                disableWritingMode()
            }.create().show()
        }

    }

    private fun enableWritingMode() {
        writingMode = true
        var tagDetected = IntentFilter(NfcAdapter.ACTION_TAG_DISCOVERED)
        var writeTagFilters = arrayOf(IntentFilter(tagDetected))
        nfcAdapter.enableForegroundDispatch(this, pendingIntent, writeTagFilters, null)
    }

    private fun disableWritingMode(){
        writingMode = false
        nfcAdapter.disableForegroundDispatch(this)
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        if (writingMode && NfcAdapter.ACTION_TAG_DISCOVERED.equals(intent)){
            var detectedTag = intent.getParcelableExtra<Tag>(NfcAdapter.EXTRA_TAG)

        }
    }

    private fun converter(){}
}
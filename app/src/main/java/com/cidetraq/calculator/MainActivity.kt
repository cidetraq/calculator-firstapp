package com.cidetraq.calculator

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.DialogFragment

interface OnClickListener

class MainActivity : AppCompatActivity() {

    private lateinit var dialog: AlertDialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        createAlertDialog()
        var btnAbout = findViewById<Button>(R.id.btnAbout)
        btnAbout.setOnClickListener{
            dialog.show()
        }
    }

    fun launchCalc(view: View){
        val intent = Intent(this, calcScreen::class.java)
        startActivity(intent)
    }

    fun createAlertDialog() {
        dialog = AlertDialog.Builder(this).setCancelable(true).setMessage("A Nicholas Network® App. Uses parser from https://github.com/RotBolt/KParser ").setNegativeButton("Cancel") {_, _ -> }.create()
    }
}
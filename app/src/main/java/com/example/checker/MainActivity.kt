package com.example.checker

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.checker.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //to select either yes or no
        binding.button1.setOnClickListener{
            val builder1= AlertDialog.Builder(this)
            builder1.setTitle("Are you Sure?")
            builder1.setMessage("Do you wants to close the app?")
            builder1.setIcon(R.drawable.baseline_block_24)
            builder1.setPositiveButton("Yes",DialogInterface.OnClickListener{dialogInterface, i ->
                finish()
            })
            builder1.setNegativeButton("No",DialogInterface.OnClickListener{dialogInterface, i ->
            })
            builder1.show()
        }

        //to select single choice
        binding.button2.setOnClickListener{
            val choices= arrayOf("dodha","Rasmalai","Halwa","Barfi","Kaju katli")
            val builder2= AlertDialog.Builder(this)
            builder2.setTitle("Tell me about your favourite sweet?")
            builder2.setSingleChoiceItems(choices,0,DialogInterface.OnClickListener{dialog,which->
                Toast.makeText(this,"you clicked on the ${choices[which]}",Toast.LENGTH_SHORT).show()
            })
            builder2.setPositiveButton("Submit",DialogInterface.OnClickListener{dialogInterface, i ->

            })
            builder2.setNegativeButton("Reject",DialogInterface.OnClickListener{dialogInterface, i ->
            })
            builder2.show()
        }

        //to select multiple choices
        binding.button3.setOnClickListener{
            val choices= arrayOf("dodha","Rasmalai","Halwa","Barfi","Kaju katli")
            val builder2= AlertDialog.Builder(this)
            builder2.setTitle("Tell me about your favourite sweet?")
            builder2.setMultiChoiceItems(choices,null,DialogInterface.OnMultiChoiceClickListener{dialog,which,isChecked->
                Toast.makeText(this,"you clicked on the ${choices[which]}",Toast.LENGTH_SHORT).show()
            })
            builder2.setPositiveButton("Submit",DialogInterface.OnClickListener{dialogInterface, i ->
            })
            builder2.setNegativeButton("Reject",DialogInterface.OnClickListener{dialogInterface, i ->
            })
            builder2.show()
        }

    }

}
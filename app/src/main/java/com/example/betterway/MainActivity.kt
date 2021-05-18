package com.example.betterway


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.core.widget.addTextChangedListener
import com.example.betterway.FirstActivity.Companion.NAME_EXTRAs
import com.example.betterway.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding :ActivityMainBinding
    private val adapter = ContactAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpData(binding)




        title = intent.getStringExtra(NAME_EXTRAs)





    }
    fun setUpData(binding: ActivityMainBinding){
        binding.contactRv.adapter = adapter
        val builder=AlertDialog.Builder(this)
        val inflater = this.layoutInflater
        val view= layoutInflater.inflate(R.layout.add_contact_dialog, null)
        builder.setView(view)

        val name =view.findViewById<TextView>(R.id.nameEt)
        val no = view.findViewById<TextView>(R.id.numberEt)
        val saveButton =view.findViewById<Button>(R.id.saveBt)
        no.addTextChangedListener(object : TextWatcher{
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                saveButton.isEnabled=s?.length ==11

            }

        }
        )
        val alertDialog =builder.create()

        saveButton.setOnClickListener {
            val contact =Contact(name.text.toString(),no.text.toString())
            val contacts = mutableListOf(contact)
            adapter.setupCont(contacts)
            alertDialog.dismiss()
        }
        binding.fab.setOnClickListener{
            alertDialog.show()
        }

    }
}
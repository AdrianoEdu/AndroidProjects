package com.example.androidproject01

import Product
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.androidproject01.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        binding.btnSave.setOnClickListener()
        {
            Log.d("MainActivity", "Save button pressed");

            if(!binding.PTxtName.text.isEmpty())
            {
                binding.txtViewName.text = binding.PTxtName.text
                binding.txtViewDescription.text = binding.PTxtDescription.text
                binding.txtViewCode.text = binding.PTxtCode.text
                binding.txtViewPrice.text = binding.PTxtPrice.text
            }
            else
            {
                Toast.makeText(this,"Please, enter the name", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("MainActivity", "onStart")
    }
    override fun onResume() {
        super.onResume()
        Log.d("MainActivity", "onResume")
    }
    override fun onPause() {
        super.onPause()
        Log.d("MainActivity", "onPause")
    }
    override fun onStop() {
        super.onStop()
        Log.d("MainActivity", "onStop")
    }
    override fun onRestart() {
        super.onRestart()
        Log.d("MainActivity", "onRestart")
    }
    override fun onDestroy() {
        super.onDestroy()
        Log.d("MainActivity", "onDestroy")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.d("MainActivity", "onSaveInstanceState")

        val product = Product(
            name = binding.PTxtName.text.toString(),
            description = binding.PTxtDescription.text.toString(),
            code = binding.PTxtCode.text.toString(),
            price = binding.PTxtPrice.text.toString().toDouble())
        outState.putSerializable("product", product)
    }
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        Log.d("MainActivity", "onRestoreInstanceState")

        val product = savedInstanceState.getSerializable("product") as Product
        binding.txtViewName.text = product.name
        binding.txtViewDescription.text = product.description
        binding.txtViewCode.text = product.code
        binding.txtViewPrice.text = product.price.toString()
    }

}
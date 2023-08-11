package com.example.diceapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.diceapp.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var selectedDieSides = 4
    private var selectedDieRolls = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.roleOptionsRadioGroup.setOnCheckedChangeListener { id, checkedId ->
            when (checkedId) {
                R.id.singleRadioButton ->{
                    selectedDieRolls = 1
                }
                R.id.doubleRadioButton -> {
                    selectedDieRolls = 2
                }
            }
        }

        binding.diceOptionsRadioGroup.setOnCheckedChangeListener { id, checkedId ->
            when (checkedId) {
                R.id.dice4RadioButton ->{
                    selectedDieSides = 4
                }
                R.id.dice6RadioButton -> {
                    selectedDieSides = 6
                }
                R.id.dice8RadioButton -> {
                    selectedDieSides = 8
                }
                R.id.dice10RadioButton -> {
                    selectedDieSides = 10
                }
                R.id.dice12RadioButton -> {
                    selectedDieSides = 12
                }
                R.id.dice20RadioButton -> {
                    selectedDieSides = 20
                }
            }
        }


        binding.rollButton.setOnClickListener {
            var result = "Result: "
            var value = Random().nextInt(selectedDieSides-1)
            result += value.toString()
            if(selectedDieRolls==2){
                value = Random().nextInt(selectedDieSides-1)
                result += ", $value"
            }
            binding.resultTextView.text = result
        }


    }
}
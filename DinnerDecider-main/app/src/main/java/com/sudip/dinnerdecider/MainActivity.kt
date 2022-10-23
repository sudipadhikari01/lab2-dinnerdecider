package com.sudip.dinnerdecider

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlin.random.Random

class MainActivity : AppCompatActivity(), OnClickListener {
    //default food list
    private var defaultFoods = arrayOf("Pizza", "Burger", "Chicken", "Sandwich", "Indian")

    private lateinit var newFoodEditTxt: EditText
    private lateinit var foodNameTxtView: TextView

    private val foodNameList = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()

    }

    fun initView() {
        //initialize the views
        val addFoodBtn: Button = findViewById(R.id.addFoodBtn)
        latestFoodTxt = findViewById(R.id.latestFoodTxt)
        foodNameTxtView = findViewById(R.id.foodNameTxt)
        val decideBtn: Button = findViewById(R.id.decideBtn)

        //add all the default foods into the  list of array
        foodNameList.addAll(defaultFoods)

        // click listener added to the buttons
        addFoodBtn.setOnClickListener(this)
        decideBtn.setOnClickListener(this)
    }

    //onclick listner added for the view
    override fun onClick(view: View?) {
        when (view!!.id) {
            R.id.addFoodBtn -> {
                onAddFoodButtonClicked()
            }
            R.id.decideBtn -> {
                onDecideButtonClicked()
            }
        }
    }

    //click listner when food button is clicked
    private fun onAddFoodButtonClicked() {
        if (!newFoodEditTxt.text.isNullOrEmpty()) {
            foodNameList.add(newFoodEditTxt.text.toString())
            newFoodEditTxt.text.clear()
        }
    }

    private fun onDecideButtonClicked() {
        //get random number with the range form 0 to foodList size
        val randomNumberIndex = Random.nextInt(0, foodNameList.size)


        val dinnerFoodName = foodNameList[randomNumberIndex]

        //set value to the text view randomly
        foodNameTxtView.text = dinnerFoodName
    }

}
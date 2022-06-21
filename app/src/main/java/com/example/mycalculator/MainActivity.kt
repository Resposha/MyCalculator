package com.example.mycalculator

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_zero.setOnClickListener { setTextFields("0") }
        button_one.setOnClickListener { setTextFields("1") }
        button_two.setOnClickListener { setTextFields("2") }
        button_three.setOnClickListener { setTextFields("3") }
        button_four.setOnClickListener { setTextFields("4") }
        button_five.setOnClickListener { setTextFields("5") }
        button_six.setOnClickListener { setTextFields("6") }
        button_seven.setOnClickListener { setTextFields("7") }
        button_eight.setOnClickListener { setTextFields("8") }
        button_nine.setOnClickListener { setTextFields("9") }
        button_plus.setOnClickListener { setTextFields("+") }
        button_minus.setOnClickListener { setTextFields("-") }
        button_multiplied.setOnClickListener { setTextFields("*") }
        button_division.setOnClickListener { setTextFields("/") }
        button_openingbrace.setOnClickListener { setTextFields("(") }
        button_closingbrace.setOnClickListener { setTextFields(")") }
        button_dot.setOnClickListener { setTextFields(".") }

        button_allclean.setOnClickListener {
            button_expression.text = ""
            button_result.text = ""
        }

        button_backspace.setOnClickListener {
            val str = button_expression.text.toString()
            if(str.isNotEmpty())
                button_expression.text = str.substring(0, str.length - 1)

            button_result.text = ""
        }

        button_equals.setOnClickListener {
            try {
                val expression = ExpressionBuilder(button_expression.text.toString()).build()
                val result = expression.evaluate()

                val longResult = result.toLong()
                if(result == longResult.toDouble())
                    button_result.text = longResult.toString()
                else
                    button_result.text = result.toString()
            } catch (e:Exception) {
                Log.d("Ошибка", "Сообщение: ${e.message}")
            }
        }
    }

        fun setTextFields(str: String) {
            if(button_result.text != "") {
                button_expression.text = button_result.text
                button_result.text = ""
            }

            button_expression.append(str)
        }

}

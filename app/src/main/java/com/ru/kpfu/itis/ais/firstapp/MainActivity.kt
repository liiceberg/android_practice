package com.ru.kpfu.itis.ais.firstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.TextView

/*
Вам нужно будет сделать верстку с помощью ConstraintLayout.  На экране есть кнопка(button) и поля ввода(EditText) для
имени(text), поле не может быть пустым. Максимальное кол-во символов - 50
роста(число), значение должно быть больше 0 и меньше 250
веса(число с плавающей точкой), значение должно быть больше 0 и меньше 250
возраста(число), значение должно быть больше 0 и меньше 150
На основе этих данных вам нужно просчитать кол-во калорий\ндс\ипотеки\гороскоп\ндфл и т.д. Формула может быть любой, но все 4 входных данных должны быть использованы для подсчета результата.

При нажатии на кнопку, поля должны валидироваться.

Результат можно выводить или в LogCat, или в TextView на этом же экране.
Формат результата "Ответ: $value". Если валидация не прошла, то выводить "Данные введены некорректно."
 */

/*
для мужчин: 10 х вес (кг) + 6,25 x рост (см) – 5 х возраст (г) + 5;
для женщин: 10 x вес (кг) + 6,25 x рост (см) – 5 x возраст (г) – 161.
 */
class MainActivity : AppCompatActivity() {
    private lateinit var name: EditText
    private lateinit var age: EditText
    private lateinit var weight: EditText
    private lateinit var height: EditText
    private lateinit var gender: RadioGroup

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        name = findViewById(R.id.editName)
        age = findViewById(R.id.editAge)
        weight = findViewById(R.id.editWeight)
        height = findViewById(R.id.editHeight)
        gender = findViewById(R.id.radioGroup)

        val btn : Button = findViewById(R.id.button)
        val result : TextView = findViewById(R.id.result_text)

        btn.setOnClickListener {
            val value = calculate()
            if (value == null) {
                result.text = "Incorrect data, please try again"
            }
            else {
                val nameValue = name.text.toString()
                result.text = "$nameValue, your perfect calorie content is $value"
            }
        }

    }

    private fun calculate() : Double? {
        val heightValue = height.text.toString().toIntOrNull()
        val ageValue = age.text.toString().toIntOrNull()
        val weightValue = weight.text.toString().toDoubleOrNull()

        if (name.text.toString().length in 1..50 &&
            heightValue != null && heightValue in 1 .. 249 &&
            ageValue != null && ageValue in 1 .. 149 &&
            weightValue != null && weightValue in 1.0 .. 249.0) {
            var value : Double = 10 * weightValue + 6.25 * heightValue - 5 * ageValue
            if (gender.checkedRadioButtonId == R.id.maleRadioButton) {
                value += 5
            }
            else {
                value -= 161
            }
            return value
        }
        return null
    }

}
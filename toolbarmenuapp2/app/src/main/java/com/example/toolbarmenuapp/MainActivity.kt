package com.example.toolbarmenuapp

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var toolbar: MaterialToolbar
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: CountryAdapter
    private var clickCount = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Инициализация Toolbar
        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        // Обработка нажатия на иконку навигации
        toolbar.setNavigationOnClickListener {
            showExitDialog()
        }

        // Инициализация RecyclerView
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Создание списка стран
        val countries = listOf(
            Country("Россия", "Москва", "146 млн", "🇷🇺"),
            Country("США", "Вашингтон", "331 млн", "🇺🇸"),
            Country("Китай", "Пекин", "1.4 млрд", "🇨🇳"),
            Country("Япония", "Токио", "126 млн", "🇯🇵"),
            Country("Германия", "Берлин", "83 млн", "🇩🇪"),
            Country("Франция", "Париж", "67 млн", "🇫🇷"),
            Country("Италия", "Рим", "60 млн", "🇮🇹"),
            Country("Испания", "Мадрид", "47 млн", "🇪🇸"),
            Country("Великобритания", "Лондон", "67 млн", "🇬🇧"),
            Country("Канада", "Оттава", "38 млн", "🇨🇦"),
            Country("Австралия", "Канберра", "26 млн", "🇦🇺"),
            Country("Бразилия", "Бразилиа", "213 млн", "🇧🇷"),
            Country("Индия", "Нью-Дели", "1.4 млрд", "🇮🇳"),
            Country("Южная Корея", "Сеул", "52 млн", "🇰🇷"),
            Country("Мексика", "Мехико", "129 млн", "🇲🇽"),
            Country("Турция", "Анкара", "85 млн", "🇹🇷"),
            Country("Казахстан", "Астана", "19 млн", "🇰🇿"),
            Country("Аргентина", "Буэнос-Айрес", "45 млн", "🇦🇷"),
            Country("Египет", "Каир", "102 млн", "🇪🇬"),
            Country("ОАЭ", "Абу-Даби", "10 млн", "🇦🇪")
        )

        // Установка адаптера с обработчиком нажатий
        adapter = CountryAdapter(countries) { country ->
            handleCountryClick(country)
        }
        recyclerView.adapter = adapter
    }

    // Обработка нажатия на карточку страны
    private fun handleCountryClick(country: Country) {
        clickCount++

        when (clickCount % 3) {
            1 -> {
                // Первое нажатие - Toast
                Toast.makeText(
                    this,
                    "🌍 Вы выбрали ${country.name}",
                    Toast.LENGTH_SHORT
                ).show()
            }
            2 -> {
                // Второе нажатие - Snackbar
                Snackbar.make(
                    findViewById(R.id.mainLayout),
                    "✈️ Хотите посетить ${country.capital}?",
                    Snackbar.LENGTH_LONG
                ).setAction("ДА") {
                    Toast.makeText(this, "🎉 Отличный выбор!", Toast.LENGTH_SHORT).show()
                }.show()
            }
            0 -> {
                // Третье нажатие - Dialog
                AlertDialog.Builder(this)
                    .setTitle("${country.flag} ${country.name}")
                    .setMessage(
                        "Столица: ${country.capital}\n" +
                                "Население: ${country.population}\n\n" +
                                "Интересный факт: ${country.name} - удивительная страна " +
                                "с богатой историей и культурой!"
                    )
                    .setPositiveButton("Узнать больше") { dialog, _ ->
                        Toast.makeText(this, "📚 Откройте браузер для подробностей", Toast.LENGTH_SHORT).show()
                        dialog.dismiss()
                    }
                    .setNegativeButton("Закрыть") { dialog, _ ->
                        dialog.dismiss()
                    }
                    .setIcon(android.R.drawable.ic_dialog_info)
                    .show()
            }
        }
    }

    // Диалог выхода при нажатии на кнопку "Назад"
    private fun showExitDialog() {
        AlertDialog.Builder(this)
            .setTitle("🚪 Выход")
            .setMessage("Вы действительно хотите выйти из приложения?")
            .setPositiveButton("Да") { _, _ ->
                finish()
            }
            .setNegativeButton("Нет") { dialog, _ ->
                dialog.dismiss()
            }
            .setIcon(android.R.drawable.ic_dialog_alert)
            .show()
    }

    // Создание меню
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    // Обработка нажатий на пункты меню
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_search -> {
                Snackbar.make(
                    findViewById(R.id.mainLayout),
                    "🔍 Функция поиска скоро будет доступна!",
                    Snackbar.LENGTH_SHORT
                ).show()
                true
            }
            R.id.action_settings -> {
                AlertDialog.Builder(this)
                    .setTitle("⚙️ Настройки")
                    .setMessage("Здесь будут настройки приложения:\n\n• Язык интерфейса\n• Тема оформления\n• Уведомления")
                    .setPositiveButton("OK") { dialog, _ ->
                        dialog.dismiss()
                    }
                    .show()
                true
            }
            R.id.action_exit -> {
                showExitDialog()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
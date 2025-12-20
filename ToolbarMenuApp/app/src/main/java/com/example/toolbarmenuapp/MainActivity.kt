package com.example.toolbarmenuapp

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var toolbar: MaterialToolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Находим Toolbar по ID
        toolbar = findViewById(R.id.toolbar)

        // Устанавливаем Toolbar как ActionBar
        setSupportActionBar(toolbar)

        // Обработка нажатия на иконку навигации (стрелка назад)
        toolbar.setNavigationOnClickListener {
            showMessage("Back pressed")
        }
    }

    // Метод для создания меню (добавляет меню в Toolbar)
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    // Метод для обработки нажатий на пункты меню
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_search -> {
                showMessage("Поиск выбран")
                true
            }
            R.id.action_settings -> {
                showMessage("Настройки выбраны")
                true
            }
            R.id.action_exit -> {
                showMessage("Выход выбран")
                // Можно добавить выход из приложения:
                // finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    // Вспомогательный метод для показа сообщений
    private fun showMessage(message: String) {
        // Вариант 1: Toast (всплывающее сообщение)
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

        // Вариант 2: Snackbar (сообщение внизу экрана)
        // Раскомментируйте, если хотите использовать Snackbar:
        // Snackbar.make(findViewById(android.R.id.content), message, Snackbar.LENGTH_SHORT).show()
    }
}
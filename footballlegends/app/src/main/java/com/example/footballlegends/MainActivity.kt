package com.example.footballlegends

import android.media.MediaPlayer
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.GridView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var toolbar: MaterialToolbar
    private lateinit var gridView: GridView
    private lateinit var adapter: PlayerAdapter
    private var mediaPlayer: MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Инициализация Toolbar
        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        // Инициализация GridView
        gridView = findViewById(R.id.gridView)

        // Создание списка футболистов
        val players = listOf(
            Player("Cristiano Ronaldo", "⚽", "Португалия", "5 Золотых мячей", R.raw.goal_sound),
            Player("Lionel Messi", "🏆", "Аргентина", "8 Золотых мячей", R.raw.whistle_sound),
            Player("Neymar Jr", "🇧🇷", "Бразилия", "Звезда Бразилии", R.raw.crowd_cheer),
            Player("Kylian Mbappé", "⚡", "Франция", "Чемпион мира 2018", R.raw.goal_sound),
            Player("Erling Haaland", "🤖", "Норвегия", "Машина голов", R.raw.whistle_sound),
            Player("Kevin De Bruyne", "🎯", "Бельгия", "Мастер пасов", R.raw.crowd_cheer),
            Player("Mohamed Salah", "👑", "Египет", "Египетский король", R.raw.goal_sound),
            Player("Luka Modrić", "🧙", "Хорватия", "Золотой мяч 2018", R.raw.whistle_sound),
            Player("Robert Lewandowski", "🎖️", "Польша", "Бомбардир", R.raw.crowd_cheer),
            Player("Karim Benzema", "💎", "Франция", "Элегантный нападающий", R.raw.goal_sound),
            Player("Sadio Mané", "🌟", "Сенегал", "Африканская звезда", R.raw.whistle_sound),
            Player("Harry Kane", "🏴󠁧󠁢󠁥󠁮󠁧󠁿", "Англия", "Капитан сборной", R.raw.crowd_cheer)
        )

        // Установка адаптера
        adapter = PlayerAdapter(this, players) { player ->
            handlePlayerClick(player)
        }
        gridView.adapter = adapter
    }

    // Обработка нажатия на футболиста
    private fun handlePlayerClick(player: Player) {
        // Остановить предыдущий звук
        mediaPlayer?.release()

        // Воспроизвести звук
        try {
            mediaPlayer = MediaPlayer.create(this, player.soundResource)
            mediaPlayer?.start()

            mediaPlayer?.setOnCompletionListener {
                it.release()
            }
        } catch (e: Exception) {
            Toast.makeText(this, "Звук недоступен", Toast.LENGTH_SHORT).show()
        }

        // Показать информацию о игроке
        Snackbar.make(
            findViewById(R.id.mainLayout),
            "${player.emoji} ${player.name} - ${player.description}",
            Snackbar.LENGTH_LONG
        ).setAction("ИНФО") {
            showPlayerDialog(player)
        }.show()
    }

    // Диалог с информацией об игроке
    private fun showPlayerDialog(player: Player) {
        AlertDialog.Builder(this)
            .setTitle("${player.emoji} ${player.name}")
            .setMessage(
                "Страна: ${player.country}\n" +
                        "Достижение: ${player.description}\n\n" +
                        "Один из величайших футболистов современности!"
            )
            .setPositiveButton("Статистика") { dialog, _ ->
                Toast.makeText(this, "📊 Просмотр статистики ${player.name}", Toast.LENGTH_SHORT).show()
                dialog.dismiss()
            }
            .setNegativeButton("Закрыть") { dialog, _ ->
                dialog.dismiss()
            }
            .setIcon(android.R.drawable.ic_dialog_info)
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
                Toast.makeText(this, "🔍 Поиск игроков", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.action_favorites -> {
                Toast.makeText(this, "⭐ Избранные игроки", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.action_settings -> {
                AlertDialog.Builder(this)
                    .setTitle("⚙️ Настройки")
                    .setMessage("• Звуковые эффекты\n• Тема оформления\n• Уведомления")
                    .setPositiveButton("OK") { dialog, _ ->
                        dialog.dismiss()
                    }
                    .show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer?.release()
        mediaPlayer = null
    }
}
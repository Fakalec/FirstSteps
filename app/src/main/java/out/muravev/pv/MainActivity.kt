package out.muravev.pv

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.ListView
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

//    lateinit var inputText: TextView
    lateinit var fromEditText: EditText
    lateinit var toListView: ListView
    lateinit var addBtn: TextView

    /**
     * onCreate() вызывается при первом создании или перезапуске Activity
     * задаётся внешний вид Activity (UI) через метод setContentView().
     * инициализируются представления и модели
     * представления связываются с необходимыми данными и ресурсами
     */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("M_MainActivity", "onCreate")

        toListView = list_view
        fromEditText = edit_text
        addBtn = add_button

        addBtn.setOnClickListener { toListView.addFooterView(fromEditText) }
    }

    fun onClick(v: View?) {
        if (v?.id == R.id.add_button){
            var text = fromEditText.addTextChangedListener(toListView)}
    }
}

//
//    /**
//     * onRestart() вызывается если Activity возвращается в приоритетный режим после
//     * вызова onStop(), т.е. вызывается после того, как Activity была остановлена и снова была
//     * запущена пользователем. Всегда сопровождается вызовом метода onStart().
//     * используется для специальных действий, которые должны выполняться только при
//     * повторном запуске Activity
//     */
//
//    override fun onRestart() {
//        super.onRestart()
//        Log.d("M_MainActivity", "onRestart")
//    }
//
//    /**
//     * onStart() UI еще не виден пользователю, но вскоре будет виден, вызывается
//     * непосредственно перед тем, как Activity становится видимой пользователю.
//     * чтение из базы данных
//     * запуск сложной анимации
//     * запуск потоков, отслеживания показаний датчиков, запросов к GPS, сервисов или
//     * других процессов, которые нужны исключительно для обновления
//     * пользовательского интерфейса
//     */
//
//    override fun onStart() {
//        super.onStart()
//        Log.d("M_MainActivity", "onStart")
//    }
//
//    /**
//     * onResume() вызывается, когда Activity начнет взаимодействовать с пользователем.
//     * запуск воспроизведения анимации, аудио и видео
//     * регистрации любых BroadcastReceiver или других процессов, которые вы
//     * освободили/приостановили в onPause()
//     * выполнение любых другие инициализации, которые должны происходить, когда
//     * Activity вновь активна.
//     */
//
//    override fun onResume() {
//        super.onResume()
//        Log.d("M_MainActivity", "onResume")
//    }
//
//    /**
//     * onPause() вызывается после сворачивания текущей активности или перехода к новому.
//     * От onPause() можно перейти к вызову либо onResume(), либо onStop().
//     * остановка анимации, аудио и видео
//     * сохранение состояния пользовательского ввода (легкие процессы)
//     * сохранение в DB если данные должны быть доступны в новой Activity
//     * остановка сервисов, подписок, BroadcastReceiver
//     */
//
//    override fun onPause() {
//        super.onPause()
//        Log.d("M_MainActivity", "onPause")
//    }
//
//    /**
//     * onStop() вызывается, когда Activity становится невидимым для пользователя.
//     * Это может произойти при её уничтожении, или если была запущена другая Activity
//     * (существующая или новая) перекрывшая окно текущей Activity.
//     * запись в базу данных
//     * приостановка сложной анимации
//     * приостановка потоков, отслеживания показаний датчиков, запросов к GPS, таймеров,
//     * сервисов или других процессов, которые нужны исключительно для обновления
//     * пользовательского интерфейса
//     */
//
//    override fun onStop() {
//        super.onStop()
//        Log.d("M_MainActivity", "onStop")
//    }
//
//    /**
//     * OnDestroy() вызывается по окончании работы Activity (пользователь закрывает
//     * приложение через клавишу back, или удаляет из списка активных приложений), при
//     * вызове метода finish()
//     * высвобождение ресурсов
//     * дополнительная перестраховка если ресурсы не были выгружены или процессы не
//     * были остановлены ранее
//     */
//
//    override fun onDestroy() {
//        super.onDestroy()
//        Log.d("M_MainActivity", "onDestroy")
//    }
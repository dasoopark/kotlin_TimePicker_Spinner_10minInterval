package kr.co.korearental.kotlin_timepicker_spinner_10mininterval

import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        timer.setOnClickListener{

            val cal = Calendar.getInstance()


            val timeSetListener = TimePickerDialog.OnTimeSetListener { timePicker, hour, minute ->
                cal.set(Calendar.HOUR_OF_DAY, hour)
                cal.set(Calendar.MINUTE, minute)
                    }


            val timePickerDialog : TimePickerDialog
            var hour = Calendar.getInstance()[Calendar.HOUR_OF_DAY]
            val minute = CustomTimePickerDialog.getRoundedMinute(Calendar.getInstance()[Calendar.MINUTE] + CustomTimePickerDialog.TIME_PICKER_INTERVAL)

            if(minute == 0){
                hour += 1
            }

            //Theme_Holo_Light_Dialog_NoActionBar-> Timepicker 를 Spinner 형태로 전환
            timePickerDialog = CustomTimePickerDialog(this, android.R.style.Theme_Holo_Light_Dialog_NoActionBar,timeSetListener, hour, minute,true)
            timePickerDialog.getWindow()?.setBackgroundDrawableResource(android.R.color.transparent) //무늬 이쁘게 해주는거
            timePickerDialog.setTitle("예약 시간 선택")
            timePickerDialog.show()
        }
    }
}
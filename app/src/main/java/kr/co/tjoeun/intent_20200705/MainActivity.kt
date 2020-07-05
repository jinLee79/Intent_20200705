package kr.co.tjoeun.intent_20200705

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        1. 첫번째 화면 버튼 누르면, 화면 전환(이동시키기)
        moveToFirstBtn.setOnClickListener {

//            비행기 티켓 발권 (출발 / 도착)
            val myIntent =  Intent(this, FirstActivity::class.java)  //Kotlin은 new 키워드 없이 생성자 생성
//            실제로 출발하기
            startActivity(myIntent)

        }

//        2. 두번째 화면 버튼 누르면
        sendToSecondBtn.setOnClickListener {

//            입력한 메세지 받아오기
            val inputMessage = messageEdt.text.toString()

//            두번째 화면으로 이동하기
            val myIntent = Intent(this, SecondActivity::class.java)
            myIntent.putExtra("message", inputMessage)
            startActivity(myIntent)

        }
    }
}
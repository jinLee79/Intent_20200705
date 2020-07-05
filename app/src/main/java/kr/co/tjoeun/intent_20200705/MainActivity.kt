package kr.co.tjoeun.intent_20200705

import android.app.Activity
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

//        3. 닉네임 변경 버튼 누르면
        changeNickBtn.setOnClickListener {

//            닉네임 변경 화면으로 가야함. Intent
            val myIntent = Intent(this, EditNickNameActivity::class.java)

//            화면으로 이동 => 단순히 조회 이동 X
//            데이터를 받으러 (결과를 받으러) 가는 이동 => 뭘 받으러 가는지 명시.
//            받을 데이터 (요청) 구별 고유 숫자: requestCode

//            어떤 결과 ? => 새 닉네임을 얻으러. (1000: 새 닉네임)  -- 왕복 티켓임
            startActivityForResult(myIntent, 1000)
        }
    }

//    MainActivity로 복귀하는 모든 시점에 실행되는 함수.
//    ex. 닉네임을 받으러 갔다 => OK로 돌아와도 실행
//    ex. 닉네임을 받으러 갔다 => 취소로 돌아와도 실행
//    ex. 비번을 변경하러 갔다가 => OK로 돌아와도 실행

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) { //?는 null일 수도 있다 | ?없으면 null일 가능성 없다
        super.onActivityResult(requestCode, resultCode, data)

//        어떤걸 가지러 다녀온 건지 학인 (닉네임 인지)
        if (requestCode == 1000) {

//            완료를 누른게 맞는지
            if (resultCode == Activity.RESULT_OK) {

//                결과로 받아온 닉네임을 텍스트뷰에 적용
                val newNickName = data?.getStringExtra("nick") //data != null 일 때만 실행해주세요. NullPointerException 방지
                nickNameTxt.text = newNickName

            }
        }
    }

}
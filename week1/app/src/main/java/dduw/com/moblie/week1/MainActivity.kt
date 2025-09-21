package dduw.com.moblie.week1

import android.graphics.Color
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import dduw.com.moblie.week1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)


        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val imgHappy: ImageView = findViewById(R.id.img_happy)
        val txtHappy: TextView = findViewById(R.id.txt_happy)

        val imgExciting: ImageView = findViewById(R.id.img_exciting)
        val txtExciting: TextView = findViewById(R.id.txt_exciting)

        val imgNormal: ImageView = findViewById(R.id.img_normal)
        val txtNormal: TextView = findViewById(R.id.txt_normal)

        val imgAnxiety: ImageView = findViewById(R.id.img_anxiety)
        val txtAnxiety: TextView = findViewById(R.id.txt_anxiety)

        val imgAngry: ImageView = findViewById(R.id.img_angry)
        val txtAngry: TextView = findViewById(R.id.txt_angry)

        // 함수 호출을 통해 각 쌍에 리스너 설정
        setupImageClick(imgHappy, txtHappy, "#F5F0D9")
        setupImageClick(imgExciting, txtExciting, "#D6EAF8")
        setupImageClick(imgNormal, txtNormal, "#BFC9DE")
        setupImageClick(imgAnxiety, txtAnxiety, "#C8E6C9")
        setupImageClick(imgAngry, txtAngry, "#E79198")
    }

    // 이 함수는 ImageView 클릭 시 TextView 색상을 변경하는 기능을 수행
    private fun setupImageClick(imageView: ImageView, textView: TextView, colorCode: String) {
        imageView.setOnClickListener {
            // 모든 텍스트뷰 색상을 초기화하는 로직은 필요에 따라 추가

            // 클릭된 텍스트뷰의 색상만 변경
            val newColor = Color.parseColor(colorCode)
            textView.setTextColor(newColor)

            Toast.makeText(this, "색상이 변경되었습니다", Toast.LENGTH_SHORT).show()
        }
    }
}
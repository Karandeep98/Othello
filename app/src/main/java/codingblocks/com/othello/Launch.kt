package codingblocks.com.othello

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_launch.*

class Launch : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launch)
        newgame.setOnClickListener {
            val l=Intent(this,MainActivity::class.java)
            startActivity(l)
        }
        about.setOnClickListener {
            val l=Intent(this,About::class.java)
            startActivity(l)
        }
        settings.setOnClickListener {
            val l=Intent(this,Settings::class.java)
            startActivity(l)
        }
    }
}

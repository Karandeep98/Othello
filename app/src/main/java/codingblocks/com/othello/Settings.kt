package codingblocks.com.othello

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_settings.*

class Settings : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        handicap1.setOnClickListener {
            val l= Intent(this,MainActivity::class.java)
            l.putExtra("handicap",1)
            startActivity(l)
        }
        handicap2.setOnClickListener {
            val l= Intent(this,MainActivity::class.java)
            l.putExtra("handicap",2)
            startActivity(l)
        }
        handicap3.setOnClickListener {
            val l= Intent(this,MainActivity::class.java)
            l.putExtra("handicap",3)
            startActivity(l)
        }
        handicap4.setOnClickListener {
            val l= Intent(this,MainActivity::class.java)
            l.putExtra("handicap",4)
            startActivity(l)
        }
    }
}

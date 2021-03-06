package codingblocks.com.othello

import android.content.Intent
import android.graphics.Color.rgb
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.activity_themes.*

class Themes : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_themes)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        orangebutton.setOnClickListener {

            val l= Intent(this,MainActivity::class.java)
            l.putExtra("themeColor",orangebutton.text.toString())
            startActivity(l)
        }
        magentabutton.setOnClickListener {
            val l= Intent(this,MainActivity::class.java)
            l.putExtra("themeColor",magentabutton.text.toString())
            startActivity(l)
        }
        bluebutton.setOnClickListener {
            val l= Intent(this,MainActivity::class.java)
            l.putExtra("themeColor",bluebutton.text.toString())
            startActivity(l)
        }
        greenbutton.setOnClickListener {
            val l= Intent(this,MainActivity::class.java)
            l.putExtra("themeColor",greenbutton.text.toString())
            startActivity(l)
        }
    }
}

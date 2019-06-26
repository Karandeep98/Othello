package codingblocks.com.othello

import android.graphics.Color.rgb
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.core.view.marginBottom
import androidx.core.view.setMargins
import androidx.core.view.updateLayoutParams
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        var buttonArray = arrayOfNulls<Array<Button>?>(64)
        var buttonArray = Array(8) {
            Array(8) {
                Button(this)
            }
        }


        var count=1
        var countblack=2
        var countwhite=2
        for (i in 0..7) {
            for (j in 0..7) {
                val buttonId = "button_$i$j"
                val resId: Int = resources.getIdentifier(buttonId, "id", packageName)
                buttonArray[i][j] = findViewById(resId)
                buttonArray[i][j].textSize = 36F
// Initiailising the starting 4 buttons
                buttonArray[i][j].setBackgroundColor(rgb(49, 191, 42))
                val param = buttonArray[i][j].layoutParams as LinearLayout.LayoutParams
                param.setMargins(1)
                buttonArray[3][3].text = "⚪"
                buttonArray[3][4].text = "⚫"
                buttonArray[4][4].text = "⚪"
                buttonArray[4][3].text = "⚫"
//                var legit ="⚫"
//                for (a in 0 until 7){
//                    for (b in 0 until 7){
//                        if(buttonArray[a][b].text=="⚫"){
//                            if(buttonArray[a][b+1].text=="⚪"){
//
//                            }
//                        }
//                    }
//                }

                buttonArray[i][j].setOnClickListener {
                    if (buttonArray[i][j].text == "") {
                        var row = i
                        var column = j
                        if (count % 2 == 0) {
                            buttonArray[i][j].text = "⚫"
                            countblack++

                            //loop for vertical down for black
                            for (k in 0 until row - 1) {
                                if (buttonArray[k][j].text == "⚫") {
                                    if (buttonArray[k + 1][j].text == "⚪") {
                                        buttonArray[k + 1][j].text = "⚫"
                                        countblack++
                                        countwhite--
                                    }
                                }
                            }
                            // loop for vertical up for black
                            for (l in 7 downTo row +1) {
                                if (buttonArray[l][j].text == "⚫") {
                                    if (buttonArray[l - 1][j].text == "⚪") {
                                        buttonArray[l - 1][j].text = "⚫"
                                        countblack++
                                        countwhite--
                                    }

                                }
                            }
                            //loop for horizontal right for black
                            for (k in 0 until column - 1) {
                                if (buttonArray[i][k].text == "⚫") {
                                    if (buttonArray[i][k + 1].text == "⚪") {
                                        buttonArray[i][k + 1].text = "⚫"
                                        countblack++
                                        countwhite--
                                    }
                                }
                            }
                            //loop for horizontal left for black
                            for (l in 7 downTo column +1) {
                                if (buttonArray[i][l].text == "⚫") {
                                    if (buttonArray[i][l - 1].text == "⚪") {
                                        buttonArray[i][l - 1].text = "⚫"
                                        countblack++
                                        countwhite--
                                    }

                                }
                            }
                            //loop for left diagonal  downwards in black

                                var l = column + 1
                                var k = row + 1
                                while (k < 8 && l < 8 && k > row && l > column && buttonArray[k][l].text != "") {
                                    if (buttonArray[k][l].text == "⚫") {
                                        if (buttonArray[k - 1][l - 1].text == "⚪") {
                                            buttonArray[k - 1][l - 1].text = "⚫"
                                            countblack++
                                            countwhite--
                                        }
                                        k--
                                        l--
                                    } else {
                                        l++
                                        k++
                                    }
                                }
                            //loop for left diagonal  upwards in black
                            k=row-1
                            l=column-1
                            while (k >=0 && l >=0 && k < row && l < column && buttonArray[k][l].text != "") {
                                if (buttonArray[k][l].text == "⚫") {
                                    if (buttonArray[k + 1][l + 1].text == "⚪") {
                                        buttonArray[k + 1][l + 1].text = "⚫"
                                        countblack++
                                        countwhite--
                                    }
                                    k++
                                    l++
                                } else {
                                    l--
                                    k--
                                }
                            }
                            //loop for right diagonal downwards in black
                             l = column + 1
                             k = row - 1
                            while (k >=0 && l < 8 && k < row && l > column && buttonArray[k][l].text != "") {
                                if (buttonArray[k][l].text == "⚫") {
                                    if (buttonArray[k + 1][l - 1].text == "⚪") {
                                        buttonArray[k + 1][l - 1].text = "⚫"
                                        countblack++
                                        countwhite--
                                    }
                                    k++
                                    l--
                                } else {
                                    l++
                                    k--
                                }
                            }
                            //loop for right diagonal upwards in black
                            k=row+1
                            l=column-1
                            while (k <8 && l >=0 && k > row && l < column && buttonArray[k][l].text != "") {
                                if (buttonArray[k][l].text == "⚫") {
                                    if (buttonArray[k - 1][l + 1].text == "⚪") {
                                        buttonArray[k - 1][l + 1].text = "⚫"
                                        countblack++
                                        countwhite--
                                    }
                                    k--
                                    l++
                                } else {
                                    l--
                                    k++
                                }
                            }
                        }
                        else {
                            buttonArray[i][j].text = "⚪"
                            countwhite++
                            // loop for vertical down for white
                            for (k in 0 until row - 1) {
                                if (buttonArray[k][j].text == "⚪") {
                                    if (buttonArray[k + 1][j].text == "⚫") {
                                        buttonArray[k + 1][j].text = "⚪"
                                        countwhite++
                                        countblack--
                                    }

                                }
                            }
                            // loop for vertical up for white
                            for (l in 7 downTo row + 1) {
                                if (buttonArray[l][j].text == "⚪") {
                                    if (buttonArray[l - 1][j].text == "⚫") {
                                        buttonArray[l - 1][j].text = "⚪"
                                        countblack--
                                        countwhite++
                                    }

                                }
                            }
                            //loop for horizontal right for white
                            for (k in 0 until  column- 1) {
                                if (buttonArray[i][k].text == "⚪") {
                                    if (buttonArray[i][k + 1].text == "⚫") {
                                        buttonArray[i][k + 1].text = "⚪"
                                        countwhite++
                                        countblack--
                                    }

                                }
                            }
                            //loop for horizontal right for white
                            for (l in 7 downTo column + 1) {
                                if (buttonArray[i][l].text == "⚪") {
                                    if (buttonArray[i][l - 1].text == "⚫") {
                                        buttonArray[i][l - 1].text = "⚪"
                                        countblack--
                                        countwhite++
                                    }

                                }
                            }
                            //loop for left diagonal downwards in white
                            var l=column+1
                            var k=row+1
                            while(k<8&&l<8&&k>row&&l>column&&buttonArray[k][l].text != ""){
                                if (buttonArray[k][l].text == "⚪") {
                                    if (buttonArray[k - 1][l - 1].text == "⚫") {
                                        buttonArray[k - 1][l - 1].text = "⚪"
                                        countblack--
                                        countwhite++
                                    }
                                    k--
                                    l--
                                }
                                else {
                                    l++
                                    k++
                                }
                            }
                            //loop for left diagonal  upwards in white
                            k=row-1
                            l=column-1
                            while (k >=0 && l >=0 && k < row && l < column && buttonArray[k][l].text != "") {
                                if (buttonArray[k][l].text == "⚪") {
                                    if (buttonArray[k + 1][l + 1].text == "⚫") {
                                        buttonArray[k + 1][l + 1].text = "⚪"
                                        countblack--
                                        countwhite++
                                    }
                                    k++
                                    l++
                                } else {
                                    l--
                                    k--
                                }
                            }
                            //loop for right diagonal downwards in white
                            l = column + 1
                            k = row - 1
                            while (k >=0 && l < 8 && k < row && l > column && buttonArray[k][l].text != "") {
                                if (buttonArray[k][l].text == "⚪") {
                                    if (buttonArray[k + 1][l - 1].text == "⚫") {
                                        buttonArray[k + 1][l - 1].text = "⚪"
                                        countblack--
                                        countwhite++
                                    }
                                    k++
                                    l--
                                } else {
                                    l++
                                    k--
                                }
                            }
                            //loop for right diagonal upwards in black
                            k=row+1
                            l=column-1
                            while (k <8 && l >=0 && k > row && l < column && buttonArray[k][l].text != "") {
                                if (buttonArray[k][l].text == "⚪") {
                                    if (buttonArray[k - 1][l + 1].text == "⚫") {
                                        buttonArray[k - 1][l + 1].text = "⚪"
                                        countblack--
                                        countwhite++
                                    }
                                    k--
                                    l++
                                } else {
                                    l--
                                    k++
                                }
                            }

                        }
                        //Displaying count of white
                            if (countwhite < 10)
                                tvwhite.text = tvwhite.text.substring(0, tvwhite.text.length - 2) + "0" + countwhite
                            else
                                tvwhite.text = tvwhite.text.substring(0, tvwhite.text.length - 2) + countwhite
                        //Displaying count of black
                            if (countblack < 10)
                                tvblack.text = tvblack.text.substring(0, tvblack.text.length - 2) + "0" + countblack
                            else
                                tvblack.text = tvblack.text.substring(0, tvblack.text.length - 2) + countblack
                        count++

                        //calculating the winner
                        if(countblack+countwhite==64||countblack==0||countwhite==0){
                            if(countblack>countwhite||countwhite==0)
                                Toast.makeText(this,"Black Won!!",Toast.LENGTH_LONG).show()
                            else if(countblack<countwhite||countblack==0)
                                Toast.makeText(this,"White Won!!",Toast.LENGTH_LONG).show()
                            else
                                Toast.makeText(this,"Match Tied!!",Toast.LENGTH_LONG).show()
                        }
                    }
                }

            }
        }
        buttonreset.setOnClickListener {
            countblack=2
            countwhite=2
            tvwhite.text=tvwhite.text.substring(0,tvwhite.text.length-2)+"0"+countwhite
            tvblack.text=tvblack.text.substring(0,tvblack.text.length-2)+"0"+countblack


            for (i in 0..7) {
                for (j in 0..7) {
                    buttonArray[i][j].text=""
                    // Initiailising the starting 4 buttons
                    buttonArray[3][3].text="⚪"
                    buttonArray[3][4].text="⚫"
                    buttonArray[4][4].text="⚪"
                    buttonArray[4][3].text="⚫"

                }
            }
        }

    }
}

package io.github.amalhanaja.yetanothersnackbar

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import io.github.amalhanaja.yas.YAS
import kotlinx.android.synthetic.main.activity_yasexample.*

class YASExampleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_yasexample)
        button.text = "SUCCESS"
        button.setOnClickListener {
            YAS.success(it, "Success Message")
                    .show()
        }
        button2.text = "ERROR"
        button2.setOnClickListener {
            YAS.error(it, "Error Message")
                    .show()
        }
        button3.text = "WARNING"
        button3.setOnClickListener{
            YAS.warning(it, "Beware The Alien")
                    .show()
        }
        button4.text = "INFO"
        button4.setOnClickListener{
            YAS.info(it, "FOR YOUR INFORMATION")
                    .show()
        }
        button5.text = "NORMAL"
        button5.setOnClickListener{
            YAS.normal(it, "Normal Snackbar")
                    .show()
        }
    }
}

package com.epitech.cashmanager

<<<<<<< HEAD
<<<<<<< HEAD
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
=======
=======
>>>>>>> parent of 85b35e8... new version with navigation
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import java.util.*
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> parent of 85b35e8... new version with navigation
=======
>>>>>>> parent of 85b35e8... new version with navigation

=======
import com.epitech.stdlib.Logger
>>>>>>> parent of 77ab87e... Merge branch 'model' of https://github.com/ChoppyDev/cash-manager into model
=======
import com.epitech.stdlib.Logger
>>>>>>> parent of 77ab87e... Merge branch 'model' of https://github.com/ChoppyDev/cash-manager into model
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
<<<<<<< HEAD
<<<<<<< HEAD
    }
=======
=======
>>>>>>> parent of 85b35e8... new version with navigation
        val button: Button = findViewById(R.id.button2)
        val i = Intent(this, RegisterActivity::class.java)
        button.setOnClickListener {
            startActivity(i)
        }
        println("iso test ${Locale.getDefault()}")
        //Logger.noCommit("TESTSTSTSTTSTSTS")
    }


<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> parent of 85b35e8... new version with navigation
=======
>>>>>>> parent of 85b35e8... new version with navigation
=======

>>>>>>> parent of 77ab87e... Merge branch 'model' of https://github.com/ChoppyDev/cash-manager into model
=======

>>>>>>> parent of 77ab87e... Merge branch 'model' of https://github.com/ChoppyDev/cash-manager into model
}

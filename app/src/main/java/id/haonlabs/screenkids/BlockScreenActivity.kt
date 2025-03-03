package id.haonlabs.screenkids

import android.os.Bundle
import android.text.InputType
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class BlockScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_block_screen)

        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)
        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                Toast.makeText(
                    this@BlockScreenActivity,
                    "Layar diblokir! Masukkan PIN!",
                    Toast.LENGTH_SHORT
                ).show()
            }
        })

        findViewById<Button>(R.id.btnUnlock).setOnClickListener {
            showPinDialog()
        }
    }

    private fun showPinDialog() {
        val inputPin = EditText(this)
        inputPin.inputType = InputType.TYPE_CLASS_NUMBER

        AlertDialog.Builder(this).setTitle("Masukkan PIN").setView(inputPin)
            .setPositiveButton("OK") { _, _ ->
                if (inputPin.text.toString() == "1234") {
                    finish()
                } else {
                    Toast.makeText(this, "PIN Salah", Toast.LENGTH_SHORT).show()
                }
            }.setCancelable(false).show()
    }
}
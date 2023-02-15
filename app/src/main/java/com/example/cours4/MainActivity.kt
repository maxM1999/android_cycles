package com.example.cours4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.LinearLayout

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private val TAG : String = MainActivity::class.java.simpleName;
    var linearLayout: LinearLayout? = null;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.i(TAG, "OnCreate");

        linearLayout = LinearLayout(this);
        var params = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.WRAP_CONTENT,
            LinearLayout.LayoutParams.WRAP_CONTENT);

        linearLayout?.orientation = LinearLayout.VERTICAL;

        val button : Button = Button(this);
        button.setOnClickListener(this)
        button.setText("Change activity")
        button.setLayoutParams(params)

        linearLayout?.addView(button)

        addContentView(linearLayout, params)
    }

    // implémenté de l'interface
    override fun onClick(p0: View?) {
        val intent: Intent = Intent(this, Activity2::class.java)
        startActivity(intent)
    }

    override fun onStart() {
        super.onStart()

        Log.i(TAG, "OnStart");
    }

    override fun onResume() {
        super.onResume()

        Log.i(TAG, "OnResume");
    }

    override fun onPause() {
        super.onPause()

        Log.i(TAG, "OnPause");
    }

    override fun onStop() {
        super.onStop()

        Log.i(TAG, "OnStop");
    }

    override fun onDestroy() {
        super.onDestroy()

        Log.i(TAG, "OnDestroy");
    }
}
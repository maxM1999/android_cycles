package com.example.cours4

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText

import android.widget.LinearLayout
import androidx.fragment.app.DialogFragment
import java.lang.ClassCastException

class NameDialog : DialogFragment(){
    interface NameDialogListener {
        fun onNameEntered(name:String)
    }

    // permet d'éviter d'utiliser le ? avant les propriétés
    private lateinit var listener : NameDialogListener


    override fun onAttach(context: Context) {
        super.onAttach(context)
        try{
            listener = context as NameDialogListener
        } catch(e:ClassCastException){
            throw ClassCastException("$context must implement NameDialogListener")
        }
    }

    // appelé automatiquement quand on créer l'objet dans une activity
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        // sert de constructeur de boite de dialogue
        val builder = AlertDialog.Builder(requireActivity())
        builder.setTitle("Enter your name")
        val input = EditText(requireActivity())
        builder.setView(input)
        builder.setPositiveButton("OK"){_,_ ->
            listener.onNameEntered(input.text.toString())
        }

        builder.setNegativeButton("Yeet"){_,_ ->
            dialog?.cancel()
        }

        return builder.create()
    }
}
class MainActivity : AppCompatActivity(), View.OnClickListener, NameDialog.NameDialogListener {

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

//        // Zone image
//        val imageView = ImageView(this)
//        imageView.layoutParams = params
//
//        // Lien vers une image sur internet
//        val url = "https://upload.wikimedia.org/wikipedia/commons/0/01/LinuxCon_Europe_Linus_Torvalds_03_%28cropped%29.jpg"
//
//        // Récupère la main loop?
//        val handler = Handler(Looper.getMainLooper())
//
//        // Prépare un thread pour une exécution
//        val executor = Executors.newSingleThreadExecutor()
//
//        // Sur le thread,
//        executor.execute {
//            try{
//                // Récupère les valeurs de l'image
//                val inputStream = URL(url).openStream()
//
//                // Créer l'image
//                val drawable = Drawable.createFromStream(inputStream, "myName")
//
//                // Envoie l'image dans l'imageView.
//                handler.post {
//                    imageView.setImageDrawable(drawable)
//                }
//            }catch(e:Exception){
//                e.printStackTrace()
//            }
//        }

        // dialogue


        val button : Button = Button(this);
        button.setOnClickListener(this)
        button.setText("Show dialog")
        button.setLayoutParams(params)
        button.tag = "OpDialogue"

        linearLayout?.addView(button)


        addContentView(linearLayout, params)
    }

    // implémenté de l'interface
    override fun onClick(p0: View?) {
        if(p0?.tag == "OpDialogue"){
            val dialog = NameDialog()
            dialog.show(supportFragmentManager, "NameDialog")
        }
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

    override fun onNameEntered(name: String) {
        Log.i(TAG, name)
    }
}
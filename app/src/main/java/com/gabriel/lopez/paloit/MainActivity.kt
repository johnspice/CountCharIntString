package com.gabriel.lopez.paloit

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AlertDialog
import com.gabriel.lopez.paloit.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnComputenum.setOnClickListener{
            if(binding.tieNumber.text.toString().length >13 &&
                binding.tieNumber.text.toString().length<17 &&
                !binding.tieNumber.text.toString().equals("")){
                compute(binding.tieNumber.text.toString())
            }else showAlert("Longitud invalida, debe estar entre 14 y 16 digitos")
        }

    }

    private fun compute(numero:String){
        val map: MutableMap<Char, Int> = LinkedHashMap()
        for (c in numero.toCharArray()) {
            if (map.containsKey(c)) {
                map[c] = map[c]!! + 1
            } else {
                map[c] = 1
            }
        }
        val maxVeces: Int = Collections.max(map.values)
        var luckyNum=""
        for (clave in map.keys) {
            val valor: Int? = map.get(clave)
            if(valor==maxVeces)luckyNum="$clave"
            Log.i("Compute", "num:$clave =>$valor veces")
        }
        binding.tvShownum.text="Número de la Suerte:$luckyNum"
    }

    private fun showAlert(ms:String){
        val builder = AlertDialog.Builder(this)
        builder.setMessage(ms)
            .setPositiveButton("Ok",
                DialogInterface.OnClickListener { dialog, id ->

                })
        builder.show()
    }
}
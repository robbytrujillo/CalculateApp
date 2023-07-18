package com.lws.robbycalculateapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

//import com.mfathi91.number2words.NumberToWordsConverter

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun clear(view: View) {

        val input1 = edt_angka1
        val input2 = edt_angka2
        val hasil = txt_hasil
        val terbilang = txt_terbilang

        input1.text = null
        input2.text = null
        hasil.text = "0"
        terbilang.text = null
    }

    fun tambah(view: View) {
        val input1 = edt_angka1.text.toString()
        val input2 = edt_angka2.text.toString()
        val hasil = txt_hasil
        val terbilang = txt_terbilang

        if (input1.isEmpty()) {
            edt_angka1.setError("Masukkan Angka Pertama")
        } else if (input2.isEmpty()) {
            edt_angka2.setError("Masukkan Angka Kedua")
        } else {

            var jumlah = input1.toDouble() + input2.toDouble()
            hasil.text = jumlah.toString()
            terbilang.text = convertToTerbilang(jumlah)
        }
    }

    fun kurang(view: View) {
        val input1 = edt_angka1.text.toString()
        val input2 = edt_angka2.text.toString()
        val hasil = txt_hasil
        val terbilang = txt_terbilang

        if (input1.isEmpty()) {
            edt_angka1.setError("Masukkan Angka Pertama")
        } else if (input2.isEmpty()) {
            edt_angka2.setError("Masukkan Angka Kedua")
        } else {

            var jumlah = input1.toDouble() - input2.toDouble()
            hasil.text = jumlah.toString()

            terbilang.text = convertToTerbilang(jumlah)
        }
    }

    fun kali(view: View) {
        val input1 = edt_angka1.text.toString()
        val input2 = edt_angka2.text.toString()
        val hasil = txt_hasil
        val terbilang = txt_terbilang

        if (input1.isEmpty()) {
            edt_angka1.setError("Masukkan Angka Pertama")
        } else if (input2.isEmpty()) {
            edt_angka2.setError("Masukkan Angka Kedua")
        } else {

            var jumlah = input1.toDouble() * input2.toDouble()
            hasil.text = jumlah.toString()

            terbilang.text = convertToTerbilang(jumlah)
        }
    }

    fun bagi(view: View) {
        val input1 = edt_angka1.text.toString()
        val input2 = edt_angka2.text.toString()
        val hasil = txt_hasil
        val terbilang = txt_terbilang

        if (input1.isEmpty()) {
            edt_angka1.setError("Masukkan Angka Pertama")
        } else if (input2.isEmpty()) {
            edt_angka2.setError("Masukkan Angka Kedua")
        } else {

            var jumlah = input1.toDouble() / input2.toDouble()
            hasil.text = jumlah.toString()

            terbilang.text = convertToTerbilang(jumlah)
        }
    }

    fun modulus(view: View) {
        val input1 = edt_angka1.text.toString()
        val input2 = edt_angka2.text.toString()
        val hasil = txt_hasil
        val terbilang = txt_terbilang

        if (input1.isEmpty()) {
            edt_angka1.setError("Masukkan Angka Pertama")
        } else {
            var jumlah = input1.toDouble() / 100
            hasil.text = jumlah.toString()

            terbilang.text = convertToTerbilang(jumlah)

        }
    }

    fun convertToTerbilang(number: Double): String {
        val units = arrayOf("", "satu", "dua", "tiga", "empat", "lima", "enam", "tujuh", "delapan", "sembilan", "sepuluh", "sebelas")

        val numberInt = number.toInt()
        return when {
            numberInt < 12 -> units[numberInt]
            numberInt < 20 -> units[numberInt % 10] + " belas"
            numberInt < 100 -> units[numberInt / 10] + " puluh " + units[numberInt % 10]
            numberInt < 200 -> "seratus " + convertToTerbilang(number - 100)
            numberInt < 1000 -> units[numberInt / 100] + " ratus " + convertToTerbilang(number - (numberInt / 100 * 100))
            else -> ""
        }
    }
}
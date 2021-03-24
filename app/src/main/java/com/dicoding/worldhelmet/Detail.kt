package com.dicoding.worldhelmet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class Detail : AppCompatActivity() {

    companion object{
        const val EXTRA_IMAGE = "extra_image"
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_DESC = "extra_desc"
        const val EXTRA_YEAR = "extra_year"
        const val EXTRA_FEATURES = "extra_features"
        const val EXTRA_MATERIAL = "extra_material"
        const val EXTRA_HOMOLOGATION = "extra_homologation"
        const val EXTRA_GALLERY1 = "extra_gallery1"
        const val EXTRA_GALLERY2 = "extra_gallery2"
        const val EXTRA_GALLERY3 = "extra_gallery3"
        const val EXTRA_SIZE = "extra_size"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val actionBar = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)
        actionBar?.setDisplayShowTitleEnabled(false)

        val imgHelmet: ImageView = findViewById(R.id.img_item_detail)
        val imgGal1: ImageView = findViewById(R.id.img_gal_1)
        val imgGal2: ImageView = findViewById(R.id.img_gal_2)
        val imgGal3: ImageView = findViewById(R.id.img_gal_3)
        val tvHelmetName: TextView = findViewById(R.id.helmet_name)
        val tvYear: TextView = findViewById(R.id.helmet_year)
        val tvMaterial: TextView = findViewById(R.id.helmet_material)
        val tvFeatures: TextView = findViewById(R.id.helmet_features)
        val tvHomologation: TextView = findViewById(R.id.helmet_homologation)
        val tvSize: TextView = findViewById(R.id.helmet_size)
        val tvDesc: TextView = findViewById(R.id.helmet_description)
        val btnShare: Button = findViewById(R.id.btn_share)

        val image = intent.getIntExtra(EXTRA_IMAGE,0)
        val image1 = intent.getIntExtra(EXTRA_GALLERY1,0)
        val image2 = intent.getIntExtra(EXTRA_GALLERY2,0)
        val image3 = intent.getIntExtra(EXTRA_GALLERY3,0)
        val name = intent.getStringExtra(EXTRA_NAME)
        val year = intent.getStringExtra(EXTRA_YEAR)
        val features = intent.getStringExtra(EXTRA_FEATURES)
        val material = intent.getStringExtra(EXTRA_MATERIAL)
        val homologation = intent.getStringExtra(EXTRA_HOMOLOGATION)
        val size = intent.getStringExtra(EXTRA_SIZE)
        val description = intent.getStringExtra(EXTRA_DESC)

        imgHelmet.setImageResource(image)
        imgGal1.setImageResource(image1)
        imgGal2.setImageResource(image2)
        imgGal3.setImageResource(image3)
        tvHelmetName.text = name
        tvYear.text = year
        tvFeatures.text = features
        tvMaterial.text = material
        tvHomologation.text = homologation
        tvSize.text = size
        tvDesc.text = description

        btnShare.setOnClickListener{
            val intent= Intent()
            intent.action=Intent.ACTION_SEND
            intent.putExtra(Intent.EXTRA_TEXT,"Helmet Name: ${name}\nMaterial: ${material}\nSize: ${size}")
            intent.type="text/plain"
            startActivity(Intent.createChooser(intent,"Share To:"))
        }


    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.getItemId()) {
            android.R.id.home -> {
                finish()
                return true
            }

        }
        return super.onOptionsItemSelected(item)
    }
}
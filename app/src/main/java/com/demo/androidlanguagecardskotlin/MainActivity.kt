package com.demo.androidlanguagecardskotlin

import android.app.Activity
import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView

class MainActivity : Activity() {
    private val accent = Color.parseColor("#00838F")
    private val entries = listOf(
        Pair("Good morning", "Buenos días"),
Pair("Thank you", "Gracias"),
Pair("Where is the station?", "¿Dónde está la estación?")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val page = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(40, 56, 40, 32)
            setBackgroundColor(Color.rgb(248, 249, 250))
        }

        page.addView(TextView(this).apply {
            text = "Language Cards"
            textSize = 30f
            setTextColor(accent)
            setTypeface(null, android.graphics.Typeface.BOLD)
        })
        page.addView(TextView(this).apply {
            text = "Practice a few useful phrases"
            textSize = 16f
            setTextColor(Color.DKGRAY)
            setPadding(0, 8, 0, 24)
        })

        entries.forEachIndexed { index, entry ->
            val card = LinearLayout(this).apply {
                orientation = LinearLayout.VERTICAL
                setPadding(24, 20, 24, 20)
                setBackgroundColor(Color.WHITE)
                elevation = 3f
            }
            card.addView(TextView(this).apply {
                text = entry.first
                textSize = 19f
                setTextColor(Color.BLACK)
                setTypeface(null, android.graphics.Typeface.BOLD)
            })
            card.addView(TextView(this).apply {
                text = entry.second
                textSize = 14f
                setTextColor(Color.DKGRAY)
                setPadding(0, 8, 0, 0)
            })
            val params = LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            ).apply { bottomMargin = 16 }
            page.addView(card, params)
        }

        val footer = TextView(this).apply {
            text = "Demo app · Sample data only"
            textSize = 12f
            setTextColor(Color.GRAY)
            gravity = Gravity.CENTER
            setPadding(0, 16, 0, 0)
        }
        page.addView(footer)
        setContentView(page)
    }
}

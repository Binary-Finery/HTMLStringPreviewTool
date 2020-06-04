package com.spencerstudios.htmlstringpreviewtool.activities

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v4.text.HtmlCompat
import android.support.v7.app.AppCompatActivity
import android.text.Editable
import android.text.TextWatcher
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import com.spencerstudios.htmlstringpreviewtool.R
import com.spencerstudios.htmlstringpreviewtool.utilities.PrefUtils
import com.spencerstudios.htmlstringpreviewtool.utilities.setTagPresets
import com.spencerstudios.htmlstringpreviewtool.utilities.share
import com.spencerstudios.htmlstringpreviewtool.utilities.tagMap
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*


class MainActivity : AppCompatActivity(), TextWatcher, View.OnClickListener {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        setTagPresets(this, this, tagsParent)

        input.addTextChangedListener(this)
        input.setText(PrefUtils(this).setText())
    }

    private fun convertFromHtml(source: String) {
        tv.text = HtmlCompat.fromHtml(source, HtmlCompat.FROM_HTML_MODE_LEGACY)
    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        convertFromHtml("$s")
    }

    override fun afterTextChanged(s: Editable?) {
        /* unused method*/
    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        /* unused method*/
    }

    override fun onClick(v: View?) {
        val label = findViewById<TextView>(v?.id!!).text.toString()
        val tag = tagMap()[label]
        input.text.insert(input.selectionStart, tag)

        if (label != "break") {
            val cursorPos = input.selectionEnd
            when (label) {
                "color" -> input.setSelection(cursorPos - 9)
                "background" -> input.setSelection(cursorPos - 8)
                else -> input.setSelection(cursorPos - (tag!!.length / 2) - 1)
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_clear -> {
                input.setText("")
                true
            }
            R.id.action_share -> {
                share(this, input.text.toString())
                true
            }
            R.id.action_github ->{
                val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/Binary-Finery/HTMLStringPreviewTool"))
                startActivity(browserIntent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onBackPressed() {
        PrefUtils(this).saveText(input.text.toString())
        super.onBackPressed()
    }
}

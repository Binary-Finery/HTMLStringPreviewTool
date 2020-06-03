package com.spencerstudios.htmlstringpreviewtool.activities

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v4.text.HtmlCompat
import android.support.v7.app.AppCompatActivity
import android.text.Editable
import android.text.TextWatcher
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import com.spencerstudios.htmlstringpreviewtool.*
import com.spencerstudios.htmlstringpreviewtool.constants.exampleUsage
import com.spencerstudios.htmlstringpreviewtool.utilities.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity(), TextWatcher, View.OnClickListener {


    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        buildAllTags(this, this, tagsParent)

        tv_example_code.text = exampleUsage
        
        et_input.addTextChangedListener(this)
        et_input.setText(PrefUtils(this).setText())
    }

    private fun convertFromHtml(source: String) {
        tv.text = HtmlCompat.fromHtml(source, HtmlCompat.FROM_HTML_MODE_LEGACY)
    }

    override fun onBackPressed() {
        PrefUtils(this).saveText(et_input.text.toString())
        super.onBackPressed()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_clear -> {
                et_input.setText("")
                true
            }
            R.id.action_share -> {
                share(this, et_input.text.toString())
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        convertFromHtml(s.toString())
    }

    override fun afterTextChanged(s: Editable?) {/* used method*/
    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {/* used method*/
    }

    override fun onClick(v: View?) {
        val label = findViewById<TextView>(v?.id!!).text.toString()
        val tag = tagMap()[label]

        et_input.text.insert(et_input.selectionStart, tag)

        if (label != "break") {
            val cursorPos = et_input.selectionEnd
            if (label != "color")
                et_input.setSelection(cursorPos - (tag!!.length / 2) - 1)
            else et_input.setSelection(cursorPos - 9)
        }
    }
}

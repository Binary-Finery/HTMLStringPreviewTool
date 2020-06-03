package com.spencerstudios.htmlstringpreviewtool.utilities

import android.content.Context
import android.graphics.Color
import android.support.v4.content.res.ResourcesCompat
import android.util.TypedValue
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import com.spencerstudios.htmlstringpreviewtool.R

private fun buildTag(ctx: Context, label: String, uid: Int): TextView {

    val params = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT)
    params.setMargins(12, 8, 12, 8)

    return TextView(ctx).apply {
        setBackgroundResource(R.drawable.tag_background_drawable)
        typeface = ResourcesCompat.getFont(ctx, R.font.poppins_semibold)
        setTextColor(Color.WHITE)
        setTextSize(TypedValue.COMPLEX_UNIT_SP, 12f)
        text = label
        layoutParams = params
        id = uid
    }
}

fun buildAllTags(ctx: Context, clickListener: View.OnClickListener, ll: LinearLayout) {
    var id = 0
    for ((label, _) in tagMap()) {
        val tv = buildTag(ctx, label, id)
        id++
        tv.setOnClickListener(clickListener)
        ll.addView(tv)
    }
}
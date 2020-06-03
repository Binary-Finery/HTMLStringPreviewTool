package com.spencerstudios.htmlstringpreviewtool.utilities

import android.content.Context
import android.content.Intent

fun share(ctx: Context, body: String) {
    if (body.trim().isNotEmpty()) {
        val i = Intent().apply {
            action = Intent.ACTION_SEND
            type = "text/plain"
            putExtra(Intent.EXTRA_TEXT, body)
        }
        ctx.startActivity(Intent.createChooser(i, "share to..."))
    }
}
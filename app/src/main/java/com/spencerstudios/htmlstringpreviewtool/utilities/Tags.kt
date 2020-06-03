package com.spencerstudios.htmlstringpreviewtool.utilities

import kotlin.collections.LinkedHashMap

fun tagMap() : LinkedHashMap<String, String>{

    val tags = LinkedHashMap<String, String>()

    tags["bold"] = "<b></b>"
    tags["italic"] = "<i></i>"
    tags["underline"] = "<u></u>"
    tags["strike"] = "<strike></strike>"
    tags["small"] = "<small></small>"
    tags["big"] = "<big></big>"
    tags["color"] = "<font color =''></font>"
    tags["break"] = "<br>"
    tags["superscript"] = "<sup></sup>"
    tags["subscript"] = "<sub></sub>"
    tags["teletype"] = "<tt></tt>"
    tags["header 1"] = "<h1></h1>"
    tags["header 2"] = "<h2></h2>"
    tags["header 3"] = "<h3></h3>"
    tags["paragraph"] = "<p></p>"

    return tags
}
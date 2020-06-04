package com.spencerstudios.htmlstringpreviewtool.utilities

fun tagMap() : LinkedHashMap<String, String>{

    val tags = LinkedHashMap<String, String>()

    tags["bold"] = "<b></b>"
    tags["italic"] = "<i></i>"
    tags["underline"] = "<u></u>"
    tags["strike"] = "<strike></strike>"
    tags["small"] = "<small></small>"
    tags["big"] = "<big></big>"
    tags["color"] = "<font color =''></font>"
    tags["background"] = "<span style = background-color:></span>"
    tags["break"] = "<br>"
    tags["superscript"] = "<sup></sup>"
    tags["subscript"] = "<sub></sub>"
    tags["teletype"] = "<tt></tt>"
    tags["header 1"] = "<h1></h1>"
    tags["header 2"] = "<h2></h2>"
    tags["header 3"] = "<h3></h3>"
    tags["header 4"] = "<h4></h4>"
    tags["header 5"] = "<h5></h6>"
    tags["header 6"] = "<h6></h6>"
    tags["paragraph"] = "<p></p>"

    return tags
}
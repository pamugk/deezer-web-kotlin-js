package styles

import kotlinx.css.*
import styled.StyleSheet

object SharedStyles: StyleSheet("shared", isStatic = true) {
    val iconedButton by css {
        backgroundColor = Color.inherit
        border = "none"
        borderRadius = 50.pc
        color = Color.inherit
        cursor = Cursor.pointer
        fontSize = LinearDimension.inherit
        fontWeight = FontWeight.inherit
        marginRight = 1.rem
        padding(0.5.rem)
    }
}
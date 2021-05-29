package components

import kotlinx.css.*
import kotlinx.css.properties.*
import react.RBuilder
import styled.css
import styled.keyframes
import styled.styledDiv

fun RBuilder.spinner() = styledDiv {
    css {
        keyframes("spinner") { to { transform { rotate(359.deg) } } }
        animation("spinner", 0.75.s, Timing.linear, iterationCount = IterationCount.infinite)
        border(0.25.em, BorderStyle.solid, DeezerColors.mainFlatPink)
        borderRightColor = Color.transparent
        borderRadius = 50.pct
        display = Display.inlineBlock
        height = 2.rem
        margin(LinearDimension.auto)
        width = 2.rem
    }
}


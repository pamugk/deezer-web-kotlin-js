package components

import react.RBuilder
import react.RProps
import react.child
import react.functionalComponent
import styled.styledDiv

private val player = functionalComponent<RProps> {
    styledDiv {

    }
    styledDiv {

    }
    styledDiv {

    }
}

fun RBuilder.player() = child(player)
package components

import kotlinx.css.*
import react.RBuilder
import react.RProps
import react.child
import react.dom.button
import react.dom.div
import react.dom.span
import react.functionalComponent
import styled.*
import styles.SharedStyles

private object PlayerStyles: StyleSheet("player", isStatic = true) {
    val controls by css {
        backgroundColor = Color.inherit
        fontSize = LinearDimension("large")
    }

    val info by css {
        alignItems = Align.center
        display = Display.grid
        flex(1.0, 1.0, FlexBasis.auto)
        fontSize = LinearDimension("larger")
        columnGap = Gap(0.75.rem.value)
        gridTemplateColumns = GridTemplateColumns(GridAutoRows.maxContent, GridAutoRows.maxContent,
            GridAutoRows.auto, GridAutoRows.maxContent, GridAutoRows.maxContent, GridAutoRows.maxContent,
            GridAutoRows.maxContent)
        gridTemplateRows = GridTemplateRows(GridAutoRows.auto, GridAutoRows.maxContent)
        margin(0.px, LinearDimension.auto)
        maxWidth = 60.pc
    }

    val trackTime by css {
        color = DeezerColors.mainFlatGrey
        fontSize = LinearDimension("x-small")
        gridRow = GridRow("2")
    }

    val trackSlider by css {
        gridColumnStart = GridColumnStart("2")
        gridColumnEnd = GridColumnEnd("2")
        gridRow = GridRow("2")
        height = 2.px
    }
}

private val player = functionalComponent<RProps> {
    styledDiv {
        css { +PlayerStyles.controls }
        styledButton { css { +SharedStyles.iconedButton }; span("fas fa-step-backward") {} }
        styledButton { css { +SharedStyles.iconedButton }; span("fas fa-play") {} }
        styledButton { css { +SharedStyles.iconedButton }; span("fas fa-step-forward") {} }
    }
    styledDiv {
        css { +PlayerStyles.info }
        span{}; span{}; span{}
        styledButton { css { +SharedStyles.iconedButton }; span("fas fa-plus") {} }
        styledButton { css { +SharedStyles.iconedButton }; span("fas fa-heart") {} }
        styledButton { css { +SharedStyles.iconedButton }; span("fas fa-angry") {} }
        styledSpan{ css{ PlayerStyles.trackTime }; +"00:00" }
        styledDiv{ css{ PlayerStyles.trackSlider } }
        styledSpan{ css{ PlayerStyles.trackTime }; +"00:00" }
    }
    div {
        styledButton { css { +SharedStyles.iconedButton }; span("fas fa-repeat") {} }
        styledButton { css { +SharedStyles.iconedButton }; span("fas fa-random") {} }
        styledButton { css { +SharedStyles.iconedButton }; span("fas fa-volume-up") {} }
        styledButton { css { +SharedStyles.iconedButton }; span("fas fa-sliders-h") {} }
    }
}

fun RBuilder.player() = child(player)
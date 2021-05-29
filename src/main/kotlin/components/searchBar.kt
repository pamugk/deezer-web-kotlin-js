package components

import DeezerColors
import common.SearchProps
import kotlinx.css.*
import kotlinx.html.InputType
import kotlinx.html.js.onClickFunction
import kotlinx.html.js.onKeyUpFunction
import react.dom.i
import react.functionalComponent
import react.router.dom.RouteResultProps
import react.useState
import styled.*
import styles.SharedStyles

private object NavbarStyles: StyleSheet("navbar", isStatic = true) {
    val searchbar by css {
        backgroundColor = Color.inherit
        color = DeezerColors.mainFlatGrey
        display = Display.flex
        flex(1.0, 1.0, FlexBasis.auto)
        fontSize = LinearDimension.inherit
        marginRight = LinearDimension.auto
        maxWidth = 60.pc
    }

    val searchfield by css {
        border = "none"
        color = Color.inherit
        flex(1.0, 1.0, FlexBasis.auto)
        fontSize = LinearDimension.inherit
        marginRight = 1.rem
    }
}

val searchBar = functionalComponent<RouteResultProps<SearchProps>> { props ->
    val query by useState(props.match.params.query)

    styledDiv {
        css { NavbarStyles.searchbar }
        styledButton() {
            css { +SharedStyles.iconedButton }
            i("fas fa-search") { }
            attrs.onClickFunction = { props.history.push("/search/$query") }
            attrs.disabled = query.isEmpty()
        }
        styledInput(InputType.search) {
            css { NavbarStyles.searchfield }
            attrs.onKeyUpFunction = {  }
            attrs.placeholder = "Поиск"
            attrs.value = query
        }
        if (query.isNotEmpty()) {
            styledButton {
                css { +SharedStyles.iconedButton }
                i("fas fa-times-circle") { }
                attrs.onClickFunction = {  }
            }
        }
    }
    if (false) {
        styledButton {
            css { +SharedStyles.iconedButton }
            i("fas fa-bell") {}
        }
        styledButton {
            css { +SharedStyles.iconedButton }
            i("fas fa-user") {}
        }
    } else {
        styledButton {
            css{ +SharedStyles.iconedButton }
            i("fas fa-sign-in-alt") {}
        }
    }
}

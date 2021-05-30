package components

import DeezerColors
import common.SearchProps
import kotlinx.css.*
import kotlinx.html.InputType
import kotlinx.html.js.onClickFunction
import kotlinx.html.js.onInputFunction
import kotlinx.html.js.onKeyUpFunction
import org.w3c.dom.events.Event
import react.*
import react.dom.i
import react.dom.render
import react.router.dom.redirect
import react.router.dom.useHistory
import react.router.dom.useParams
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

private fun handleInputChange(e: Event, prevValue: String): String {
    val event = e.asDynamic().nativeEvent
    val data = (e.asDynamic().nativeEvent.data as String?).orEmpty()

    val caretPosition: Int = event.target.selectionStart - 1

    return if (data.isEmpty())
        prevValue.substring(0, caretPosition + 1) + prevValue.substring(caretPosition + 2)
    else prevValue.substring(0, caretPosition) + data + prevValue.substring(caretPosition)
}

private fun checkIfEnterPressed(e: Event): Boolean {
    return e.asDynamic().nativeEvent.key == "Enter"
}

private val searchBar = functionalComponent<RProps> {
    val history = useHistory()
    var query by useState(useParams<SearchProps>()?.query.orEmpty())

    styledDiv {
        css { +NavbarStyles.searchbar }
        styledButton() {
            css { +SharedStyles.iconedButton }
            i("fas fa-search") { }
            attrs.onClickFunction = {
                if (query.isNotBlank())
                    history.push("/search/$query")
            }
            attrs.disabled = query.isBlank()
        }
        styledInput(InputType.search) {
            css { +NavbarStyles.searchfield }
            attrs.onKeyUpFunction = {
                if (checkIfEnterPressed(it) and query.isNotBlank())
                    history.push("/search/$query")
            }
            attrs.onInputFunction = {
                query = handleInputChange(it, query)
            }
            attrs.placeholder = "Поиск"
            attrs.value = query
        }
        if (query.isNotEmpty()) {
            styledButton {
                css { +SharedStyles.iconedButton }
                i("fas fa-times-circle") { }
                attrs.onClickFunction = { query = "" }
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

fun RBuilder.searchBar() = child(searchBar)
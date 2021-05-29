package components

import SearchProps
import kotlinx.html.InputType
import react.functionalComponent
import styled.css
import styled.styledButton
import styled.styledDiv
import styled.styledInput

val searchBar = functionalComponent<SearchProps> { props ->
    styledDiv {
        css {  }
        styledButton {
            css { }
        }
        styledInput(InputType.search) {
            +props.query
        }
        styledButton {
            css { }
        }
    }
}

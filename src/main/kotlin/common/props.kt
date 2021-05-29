package common

import react.RProps

external interface IdProps: RProps {
    val id: Int
}

external interface SearchProps: RProps {
    val query: String
}
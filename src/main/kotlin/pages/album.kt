package pages

import IdProps
import react.RBuilder
import react.child
import react.functionalComponent

val album = functionalComponent<IdProps> {  }

inline fun RBuilder.album(crossinline handler: IdProps.() -> Unit) = child(album) {
    attrs.handler()
}
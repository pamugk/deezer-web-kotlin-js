package pages

import IdProps
import react.RBuilder
import react.child
import react.functionalComponent

val playlist = functionalComponent<IdProps> {  }

inline fun RBuilder.playlist(crossinline handler: IdProps.() -> Unit) = child(playlist) {
    attrs.handler()
}
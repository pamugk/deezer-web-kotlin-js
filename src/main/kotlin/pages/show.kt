package pages

import IdProps
import react.RBuilder
import react.child
import react.functionalComponent

val show = functionalComponent<IdProps> {  }

inline fun RBuilder.show(crossinline handler: IdProps.() -> Unit) = child(show) {
    attrs.handler()
}
package pages.artist

import react.RBuilder
import react.RProps
import react.child
import react.functionalComponent

private val relatedArtists = functionalComponent<RProps> {  }
fun RBuilder.relatedArtists() = child(relatedArtists)
package pages.artist

import IdProps
import react.RBuilder
import react.child
import react.functionalComponent
import react.router.dom.RouteResultProps
import react.router.dom.route
import react.router.dom.switch

val artist = functionalComponent<RouteResultProps<IdProps>> { props ->
    switch {
        route(props.match.path, exact = true) {
            discography()
        }
        route("${props.match.path}/biography") {
            biography()
        }
        route("${props.match.path}/related_artist") {
            relatedArtists()
        }
        route("${props.match.path}/related_playlist") {
            relatedPlaylists()
        }
        route("${props.match.path}/top_track") {
            topTracks()
        }
    }
}

inline fun RBuilder.artist(crossinline handler: RouteResultProps<IdProps>.() -> Unit) = child(artist) {
    attrs.handler()
}
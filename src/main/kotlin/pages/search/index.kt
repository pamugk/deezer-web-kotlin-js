package pages.search

import SearchProps
import react.RBuilder
import react.child
import react.functionalComponent
import react.router.dom.RouteResultProps
import react.router.dom.redirect
import react.router.dom.route
import react.router.dom.switch

val search = functionalComponent<RouteResultProps<SearchProps>> { props ->
    switch {
        route(props.match.path, exact = true) {
            overview()
        }
        route("${props.match.path}/album", exact = true) {
            albums()
        }
        route("${props.match.path}/artist", exact = true) {
            artists()
        }
        route("${props.match.path}/episode", exact = true) {
            episodes()
        }
        route("${props.match.path}/playlist", exact = true) {
            playlists()
        }
        route("${props.match.path}/profile", exact = true) {
            profiles()
        }
        route("${props.match.path}/radio", exact = true) {
            radios()
        }
        route("${props.match.path}/show", exact = true) {
            shows()
        }
        route("${props.match.path}/track", exact = true) {
            tracks()
        }
        redirect(to = props.match.path)
    }
}

inline fun RBuilder.search(crossinline handler: RouteResultProps<SearchProps>.() -> Unit) = child(search) {
    attrs.handler()
}
package pages.profile

import IdProps
import react.RBuilder
import react.child
import react.functionalComponent
import react.router.dom.RouteResultProps
import react.router.dom.redirect
import react.router.dom.route
import react.router.dom.switch

val profile = functionalComponent<RouteResultProps<IdProps>> { props ->
    switch {
        route(props.match.path, exact = true) {
            overview()
        }
        route("${props.match.path}/albums", exact = true) {
            albums()
        }
        route("${props.match.path}/artists", exact = true) {
            artists()
        }
        route("${props.match.path}/followers", exact = true) {
            followers()
        }
        route("${props.match.path}/followings", exact = true) {
            followings()
        }
        route("${props.match.path}/loved", exact = true) {
            loved()
        }
        route("${props.match.path}/playlists", exact = true) {
            playlists()
        }
        route("${props.match.path}/radios", exact = true) {
            radios()
        }
        route("${props.match.path}/shows", exact = true) {
            shows()
        }
        redirect(to = props.match.path)
    }
}

inline fun RBuilder.profile(crossinline handler: RouteResultProps<IdProps>.() -> Unit) = child(profile) {
    attrs.handler()
}
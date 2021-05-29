import components.player
import components.searchBar
import components.sideBar
import pages.*
import pages.account.account
import pages.album
import pages.artist.artist
import pages.channels
import pages.playlist
import pages.podcasts
import pages.profile.profile
import pages.search.search
import pages.show
import react.RBuilder
import react.RProps
import react.child
import react.dom.main
import react.functionalComponent
import react.router.dom.route
import react.router.dom.switch
import react.router.dom.withRouter
import styled.*

interface IdProps: RProps {
    val id: Int
}

interface SearchProps: RProps {
    val query: String
}

private val app = functionalComponent<RProps> {
    styledAside {
        sideBar()
    }
    styledNav {
        withRouter(searchBar)
    }
    main {
        switch {
            route("/", exact = true) {
                home()
            }
            route("/account", exact = true) {
                account()
            }
            route<IdProps>("/album/:id") {
                album {

                }
            }
            route<IdProps>("/artist/:id") {
                artist {

                }
            }
            route("/channels") {
                channels()
            }
            route<IdProps>("/playlist/:id") {
                playlist {

                }
            }
            route("/podcasts", exact = true) {
                podcasts()
            }
            route("/profile") {
                profile {

                }
            }
            route<SearchProps>("/search/:query") { props ->
                search {
                    history = props.history
                    location = props.location
                    match = props.match
                }
            }
            route<IdProps>("/show/:id") {
                show {

                }
            }
            route("*") {
                notFound()
            }
        }
    }
    styledFooter {
        player()
    }
}

fun RBuilder.app() = child(app)
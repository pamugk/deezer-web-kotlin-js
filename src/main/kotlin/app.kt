import components.player
import components.searchBar
import components.sideBar
import kotlinx.css.*
import kotlinx.css.properties.borderBottom
import kotlinx.css.properties.borderRight
import kotlinx.css.properties.borderTop
import kotlinx.html.MAIN
import pages.*
import pages.account.account
import pages.artist.artist
import pages.profile.profile
import pages.search.search
import react.RBuilder
import react.RProps
import react.child
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

private object AppStyleSheet: StyleSheet("app", isStatic = true) {
    val content by css {
        backgroundColor = Color.inherit
        display = Display.flex
        flexDirection = FlexDirection.column
        fontSize = LinearDimension.inherit
        gridColumn = GridColumn("2")
        gridRow = GridRow("2")
    }

    val drawer by css {
        backgroundColor = Color.inherit
        borderRight(LinearDimension("thin"), BorderStyle.solid, DeezerColors.mainFlatGrey)
        gridColumn = GridColumn("1")
        gridColumnStart = GridColumnStart("1")
        gridRowStart = GridRowStart("1")
        gridRowEnd = GridRowEnd("3")

        position = Position.sticky
        left = LinearDimension("0")
    }

    val footer by css {
        backgroundColor = Color.inherit
        borderTop(LinearDimension("thin"), BorderStyle.solid, DeezerColors.mainFlatGrey)
        fontSize = LinearDimension("larger")

        gridColumnStart = GridColumnStart("1")
        gridColumnEnd = GridColumnEnd("3")
        gridRow = GridRow("3")

        padding(1.rem, 1.5.rem)
        position = Position.sticky
        bottom = LinearDimension("0")
    }

    val navbar by css {
        alignItems = Align.center
        backgroundColor = Color.inherit
        borderBottom(LinearDimension("thin"), BorderStyle.solid, DeezerColors.mainFlatGrey)
        display = Display.flex
        fontSize = LinearDimension("large")
        gridColumn = GridColumn("2")
        gridRow = GridRow("1")
        height = LinearDimension.maxContent
        padding(0.5.rem, 1.rem)

        position = Position.sticky
        top = LinearDimension("0")
    }
}

inline fun RBuilder.styledMain(block: StyledDOMBuilder<MAIN>.() -> Unit) = styledTag(block) { MAIN(kotlinx.html.emptyMap, it) }

private val app = functionalComponent<RProps> {
    styledAside {
        css { +AppStyleSheet.drawer }
        sideBar()
    }
    styledNav {
        css { +AppStyleSheet.navbar }
        withRouter(searchBar)
    }
    styledMain {
        css { +AppStyleSheet.content }
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
        css { +AppStyleSheet.footer }
        player()
    }
}

fun RBuilder.app() = child(app)
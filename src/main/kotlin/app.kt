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
import styled.*

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
        display = Display.flex
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
        searchBar()
    }
    styledMain {
        css { +AppStyleSheet.content }
        switch {
            route<RProps>("/", exact = true, render = home)
            route<RProps>("/account", render = account)
            route("/album/:id", render = album)
            route("/artist/:id", render = artist)
            route<RProps>("/channels", render = channels)
            route("/playlist/:id", render = playlist)
            route<RProps>("/podcasts", exact = true, render = podcasts)
            route("/profile", render = profile)
            route("/search/:query", render = search)
            route("/show/:id", render = show)
            route("*") {
                notFound()
            }
        }
    }
    if (false) {
        styledFooter {
            css { +AppStyleSheet.footer }
            player()
        }
    }
}

fun RBuilder.app() = child(app)
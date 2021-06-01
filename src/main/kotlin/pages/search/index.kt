package pages.search

import api.`object`.playable.*
import api.`object`.search.PartialSearchResponse
import api.`object`.user.User
import apiInstance
import common.SearchProps
import components.spinner
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.css.*
import kotlinx.css.properties.TextDecoration
import kotlinx.css.properties.borderBottom
import react.*
import react.router.dom.*
import styled.*

private object SearchPageStyles: StyleSheet("search") {
    val tab by css {
        color = DeezerColors.mainFlatGrey
        fontSize = LinearDimension("medium")
        paddingBottom = 1.rem
        textDecoration = TextDecoration.none

        hover {
            borderBottom(LinearDimension("thin"), BorderStyle.solid, DeezerColors.mainFlatBlack)
            color = DeezerColors.mainFlatBlack
        }
    }

    val tabActive by css {
        name = "tab-active"

        borderBottom(LinearDimension("thin"), BorderStyle.solid, DeezerColors.mainFlatPink)
        color = DeezerColors.mainFlatBlack
    }

    val tabContainer by css {
        name = "tab-container"
        fontSize = LinearDimension.inherit
    }

    val tabPanel by css {
        name = "tab-panel"

        borderBottom(LinearDimension("thin"), BorderStyle.solid, DeezerColors.mainFlatGrey)
        display = Display.flex
        fontSize = LinearDimension.inherit
        paddingTop = 1.5.rem
    }

    val tabs by css {
        display = Display.inlineFlex
        fontSize = LinearDimension.inherit
        listStyleType = ListStyleType.none
        margin(LinearDimension.auto, LinearDimension.auto, 1.rem, LinearDimension.auto)
        paddingLeft = 0.px
    }
}

external interface SearchPageState: RState {
    var albumPrefetch: PartialSearchResponse<Album>?
    var artistPrefetch: PartialSearchResponse<Artist>?
    var playlistPrefetch: PartialSearchResponse<Playlist>?
    var profilePrefetch: PartialSearchResponse<User>?
    var radioPrefetch: PartialSearchResponse<Radio>?
    //val showPrefetch: PartialSearchResponse<Podcast>?
    var trackPrefetch: PartialSearchResponse<Track>?
}

class SearchPage(props: RouteResultProps<SearchProps>): RComponent<RouteResultProps<SearchProps>, SearchPageState>(props) {
    override fun componentDidMount() {
        GlobalScope.launch {
            launch {
                val albums = apiInstance.searchAlbums(props.match.params.query, limit = 5)
                setState { albumPrefetch = albums }
            }
            launch {
                val artists = apiInstance.searchArtists(props.match.params.query, limit = 5)
                setState { artistPrefetch = artists }
            }
            launch {
                val playlists = apiInstance.searchPlaylists(props.match.params.query, limit = 5)
                setState { playlistPrefetch = playlists }
            }
            launch {
                val profiles = apiInstance.searchUsers(props.match.params.query, limit = 5)
                setState { profilePrefetch = profiles }
            }
            launch {
                val radio = apiInstance.searchRadio(props.match.params.query, limit = 5)
                setState { radioPrefetch = radio }
            }
            launch {
                val tracks = apiInstance.searchTracks(props.match.params.query, limit = 5)
                setState { trackPrefetch = tracks }
            }
        }
    }

    override fun RBuilder.render() {
        if ((state.albumPrefetch == null)
            or (state.artistPrefetch == null)
            or (state.playlistPrefetch == null)
            or (state.profilePrefetch == null)
            or (state.radioPrefetch == null)
            //or (showPrefetch == null)
            or (state.trackPrefetch == null)) {
            spinner()
        } else {
            styledNav {
                css { +SearchPageStyles.tabPanel }
                styledUl {
                    css { +SearchPageStyles.tabs }
                    styledLi {
                        css { +SearchPageStyles.tabContainer }
                        navLink<RProps>(props.match.path,
                            className = "${SearchPageStyles.name}-${SearchPageStyles::tab.name}",
                            activeClassName = "${SearchPageStyles.name}-${SearchPageStyles::tabActive.name}", exact = true) { +"Всё" }
                    }
                    if (state.trackPrefetch!!.data.isNotEmpty()) {
                        styledLi {
                            css { +SearchPageStyles.tabContainer }
                            navLink<RProps>("${props.match.path}/track",
                                className = "${SearchPageStyles.name}-${SearchPageStyles::tab.name}",
                                activeClassName = "${SearchPageStyles.name}-${SearchPageStyles::tabActive.name}", exact = true) { +"Треки" }
                        }
                    }
                    if (state.playlistPrefetch!!.data.isNotEmpty()) {
                        styledLi {
                            css { +SearchPageStyles.tabContainer }
                            navLink<RProps>("${props.match.path}/playlist",
                                className = "${SearchPageStyles.name}-${SearchPageStyles::tab.name}",
                                activeClassName = "${SearchPageStyles.name}-${SearchPageStyles::tabActive.name}", exact = true) { +"Плейлисты" }
                        }
                    }
                    if (state.albumPrefetch!!.data.isNotEmpty()) {
                        styledLi {
                            css { +SearchPageStyles.tabContainer }
                            navLink<RProps>("${props.match.path}/album",
                                className = "${SearchPageStyles.name}-${SearchPageStyles::tab.name}",
                                activeClassName = "${SearchPageStyles.name}-${SearchPageStyles::tabActive.name}", exact = true) { +"Альбомы" }
                        }
                    }
                    if (state.artistPrefetch!!.data.isNotEmpty()) {
                        styledLi {
                            css { +SearchPageStyles.tabContainer }
                            navLink<RProps>("${props.match.path}/artist",
                                className = "${SearchPageStyles.name}-${SearchPageStyles::tab.name}",
                                activeClassName = "${SearchPageStyles.name}-${SearchPageStyles::tabActive.name}", exact = true) { +"Исполнители" }
                        }
                    }
                    if (state.profilePrefetch!!.data.isNotEmpty()) {
                        styledLi {
                            css { +SearchPageStyles.tabContainer }
                            navLink<RProps>("${props.match.path}/profile",
                                className = "${SearchPageStyles.name}-${SearchPageStyles::tab.name}",
                                activeClassName = "${SearchPageStyles.name}-${SearchPageStyles::tabActive.name}", exact = true) { +"Профили" }
                        }
                    }
                    /*styledLi {
                        css { +SearchPageStyles.tabContainer }
                        navLink<RProps>("${props.match.path}/channel",
                            className = "${SearchPageStyles.name}-${SearchPageStyles::tab.name}",
                            activeClassName = "${SearchPageStyles.name}-${SearchPageStyles::tabActive.name}", exact = true) { +"Каналы" }
                    }
                    styledLi {
                        css { +SearchPageStyles.tabContainer }
                        navLink<RProps>("${props.match.path}/show",
                            className = "${SearchPageStyles.name}-${SearchPageStyles::tab.name}",
                            activeClassName = "${SearchPageStyles.name}-${SearchPageStyles::tabActive.name}", exact = true) { +"Подкасты" }
                    }
                    styledLi {
                        css { +SearchPageStyles.tabContainer }
                        navLink<RProps>("${props.match.path}/episode",
                            className = "${SearchPageStyles.name}-${SearchPageStyles::tab.name}",
                            activeClassName = "${SearchPageStyles.name}-${SearchPageStyles::tabActive.name}", exact = true) { +"Выпуски" }
                    }*/
                    if (state.radioPrefetch!!.data.isNotEmpty()) {
                        styledLi {
                            css { +SearchPageStyles.tabContainer }
                            navLink<RProps>("${props.match.path}/radio",
                                className = "${SearchPageStyles.name}-${SearchPageStyles::tab.name}",
                                activeClassName = "${SearchPageStyles.name}-${SearchPageStyles::tabActive.name}", exact = true) { +"Миксы" }
                        }
                    }
                }
            }
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
                route("${props.match.path}/channel", exact = true) {
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
    }
}

inline fun RBuilder.searchPage(crossinline hander: RouteResultProps<SearchProps>.() -> Unit) = child(SearchPage::class){
    attrs.hander()
}
package components

import kotlinx.css.*
import kotlinx.css.properties.TextDecoration
import kotlinx.css.properties.Timing
import kotlinx.css.properties.borderLeft
import kotlinx.css.properties.s
import kotlinx.css.properties.transition
import react.RBuilder
import react.RProps
import react.dom.i
import react.dom.span
import react.router.dom.navLink
import styled.*

private object SidebarStyles: StyleSheet("sidebar", isStatic = true) {
    val deezerLogo by css {
        backgroundSize = "contain"
        backgroundRepeat = BackgroundRepeat.noRepeat
        cursor = Cursor.pointer
        display = Display.inlineBlock
        height = 32.px
        transition("background-image", 0.s, Timing.linear, 0.1.s)
        marginLeft = 1.5.rem
        width = 125.px

        position = Position.sticky
        top = 1.rem
    }

    val deezerLogoDay by css {
        backgroundImage = Image("url(/assets/deezer/logotype/DIGITAL_RGB/SVG/Deezer_Logo_RVB_Black.svg)")
    }

    val deezerLogoNight by css {
        backgroundImage = Image("url(/assets/deezer/logotype/DIGITAL_RGB/SVG/Deezer_Logo_RVB_White.svg)")
    }

    val navlink by css {
        cursor = Cursor.pointer
        padding(0.25.rem, 1.5.rem)
        textDecoration = TextDecoration.none

        hover {
            color = DeezerColors.mainFlatPink
        }
    }

    val navlinkPrimary by css {
        +navlink

        color = DeezerColors.mainFlatBlack
        fontSize = LinearDimension("large")
        fontWeight = FontWeight.bold
    }

    val navlinkSecondary by css {
        +navlink

        color = DeezerColors.mainFlatGrey
        fontSize = LinearDimension("larger")
        paddingLeft = 3.5.rem
    }

    val navlinkActive by css {
        borderLeft(LinearDimension("thick"), BorderStyle.solid, DeezerColors.mainFlatPink)
        color = DeezerColors.mainFlatPink
        padding(0.25.rem, 1.5.rem, 0.25.rem, 1.5.rem - 5.px)
    }

    val navlist by css {
        backgroundColor = Color.inherit
        listStyleType = ListStyleType.none
        marginTop = 2.rem
        padding(LinearDimension("0"))

        position = Position.sticky
        top = 1.rem + 32.px + 2.rem
    }

    val navitem by css {
        margin(1.5.rem, LinearDimension("0"))
    }
}

private val activeNavlinkClass = "${SidebarStyles.name}-${SidebarStyles::navlinkActive.name}"
private val primaryNavlinkClass = "${SidebarStyles.name}-${SidebarStyles::navlinkPrimary.name}"
private val secondaryNavlinkClass = "${SidebarStyles.name}-${SidebarStyles::navlinkSecondary.name}"

fun RBuilder.sideBar() {
    styledA {
        css {
            +SidebarStyles.deezerLogo
            if (true) +SidebarStyles.deezerLogoDay
            else +SidebarStyles.deezerLogoNight
        }
    }
    styledUl {
        css { +SidebarStyles.navlist }
        styledLi {
            css { +SidebarStyles.navitem }
            navLink<RProps>("/", className = primaryNavlinkClass, activeClassName = activeNavlinkClass, exact = true) {
                span {
                    i("fas fa-music"){}
                    +" Музыка"
                }
            }
        }
        styledLi {
            css { +SidebarStyles.navitem }
            navLink<RProps>("/podcasts", className = primaryNavlinkClass, activeClassName = activeNavlinkClass, exact = true) {
                span {
                    i("fas fa-microphone"){}
                    +" Подкасты"
                }
            }
        }
        styledLi {
            css { +SidebarStyles.navitem }
            navLink<RProps>("/channels/explore", className = primaryNavlinkClass, activeClassName = activeNavlinkClass, exact = true) {
                span {
                    i("fas fa-th-large"){}
                    +" Исследуйте"
                }
            }
        }
        if (false) {
            styledLi {
                css { +SidebarStyles.navitem }
                navLink<RProps>("/", className = primaryNavlinkClass, activeClassName = activeNavlinkClass) {
                    span {
                        i("fas fa-heart"){}
                        +" Избранное"
                    }
                }
                styledUl {
                    css { +SidebarStyles.navlist }
                    styledLi {
                        css { +SidebarStyles.navitem }
                        navLink<RProps>("/", className = secondaryNavlinkClass, activeClassName = activeNavlinkClass) {
                            span {
                                +"Любимые треки"
                            }
                        }
                    }
                    styledLi {
                        css { +SidebarStyles.navitem }
                        navLink<RProps>("/", className = secondaryNavlinkClass, activeClassName = activeNavlinkClass) {
                            span {
                                +"Плейлисты"
                            }
                        }
                    }
                    styledLi {
                        css { +SidebarStyles.navitem }
                        navLink<RProps>("/", className = secondaryNavlinkClass, activeClassName = activeNavlinkClass) {
                            span {
                                +"Альбомы"
                            }
                        }
                    }
                    styledLi {
                        css { +SidebarStyles.navitem }
                        navLink<RProps>("/", className = secondaryNavlinkClass, activeClassName = activeNavlinkClass) {
                            span {
                                +"Исполнители"
                            }
                        }
                    }
                }
            }
        }
    }
}
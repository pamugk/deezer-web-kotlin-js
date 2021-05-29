package components

import react.RBuilder
import react.dom.i
import react.dom.span
import styled.css
import styled.styledA
import styled.styledLi
import styled.styledUl

fun RBuilder.sideBar() {
    styledA { css {  } }
    styledUl {
        css {  }
        styledLi {
            css { }
            styledA {
                css {  }
                span {
                    i("fas fa-music"){}
                    +"Музыка"
                }
            }
        }
        styledLi {
            css {  }
            styledA {
                css {  }
                span {
                    i("fas fa-th-large"){}
                    +"Исследуйте"
                }
            }
        }
        styledLi {
            css {  }
            styledA {
                css {  }
                span {
                    i("fas fa-heart"){}
                    +"Избранное"
                }
            }
            styledUl {
                css {  }
                styledLi {
                    css {  }
                    styledA {
                        css {  }
                        span {
                            +"Любимые треки"
                        }
                    }
                }
                styledLi {
                    css {  }
                    styledA {
                        css {  }
                        span {
                            +"Плейлисты"
                        }
                    }
                }
                styledLi {
                    css {  }
                    styledA {
                        css {  }
                        span {
                            +"Альбомы"
                        }
                    }
                }
                styledLi {
                    css {  }
                    styledA {
                        css {  }
                        span {
                            +"Исполнители"
                        }
                    }
                }
            }
        }
    }
}
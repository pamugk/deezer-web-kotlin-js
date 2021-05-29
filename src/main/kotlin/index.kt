import react.dom.render
import kotlinx.browser.document
import kotlinx.browser.window
import kotlinx.css.*
import react.router.dom.browserRouter
import styled.injectGlobal

fun main() {
    window.onload = {
        injectGlobal("#root{${
            CSSBuilder().apply {
                backgroundColor = Color.white
                display = Display.grid
                gridTemplateColumns = GridTemplateColumns("${GridTemplateColumns.maxContent} ${GridTemplateColumns.auto}")
                gridTemplateRows = GridTemplateRows("${GridTemplateColumns.minContent} ${GridTemplateColumns.auto} ${GridTemplateColumns.minContent}")
            }
        }}")
        render(document.getElementById("root")) {
            browserRouter {
                app()
            }
        }
    }
}

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
                gridTemplateColumns = GridTemplateColumns(GridAutoRows.minContent, GridAutoRows.auto)
                gridTemplateRows = GridTemplateRows(GridAutoRows.minContent, GridAutoRows.auto, GridAutoRows.minContent)
            }
        }}")
        render(document.getElementById("root")) {
            browserRouter {
                app()
            }
        }
    }
}

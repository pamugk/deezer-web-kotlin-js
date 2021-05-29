import react.dom.render
import kotlinx.browser.document
import kotlinx.browser.window
import react.router.dom.browserRouter

fun main() {
    window.onload = {
        render(document.getElementById("root")) {
            browserRouter {
                app()
            }
        }
    }
}

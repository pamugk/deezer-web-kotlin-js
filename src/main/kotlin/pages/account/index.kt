package pages.account

import react.RBuilder
import react.RProps
import react.child
import react.functionalComponent
import react.router.dom.route
import react.router.dom.switch
import react.router.dom.useHistory
import react.router.dom.useLocation

private val account = functionalComponent<RProps> {
    switch {
        route("/account", exact = true) {
            personalData()
        }
        route("/account/apps", exact = true) {
            apps()
        }
        route("/account/country_selector", exact = true) {
            countrySelector()
        }
        route("/account/devices", exact = true) {
            devices()
        }
        route("/account/display", exact = true) {
            display()
        }
        route("/account/notifications", exact = true) {
            notifications()
        }
        route("/account/share", exact = true) {
            share()
        }
    }
}

fun RBuilder.account() = child(account)
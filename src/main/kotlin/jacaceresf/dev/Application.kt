package jacaceresf.dev

import io.ktor.server.engine.*
import io.ktor.server.netty.*
import jacaceresf.dev.plugins.*
import jacaceresf.dev.routes.configureBookRoutes

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0") {
        configureSerialization()
        configureBookRoutes()
    }.start(wait = true)
}

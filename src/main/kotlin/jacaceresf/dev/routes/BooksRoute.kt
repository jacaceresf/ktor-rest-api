package jacaceresf.dev.routes

import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*
import jacaceresf.dev.models.BookResponse
import jacaceresf.dev.models.orm.Book
import jacaceresf.dev.services.BookService


fun Application.configureBookRoutes() {
    routing {
        route("/api/books") {
            val bookService = BookService()
            getAllBooks(bookService)
        }
    }
}

private fun Book?.toBookResponse(): BookResponse? =
    this?.let { BookResponse(it.id!!, it.name, it.genre, it.isbn) }

fun Route.getAllBooks(bookService: BookService) {
    get {
        call.respond(message = bookService.findAllBooks().map { it.toBookResponse() })
    }
}
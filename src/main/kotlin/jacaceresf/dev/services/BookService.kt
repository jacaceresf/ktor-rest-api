package jacaceresf.dev.services

import jacaceresf.dev.models.orm.Book
import jacaceresf.dev.models.orm.Books
import org.ktorm.database.Database
import org.ktorm.dsl.eq
import org.ktorm.entity.find
import org.ktorm.entity.sequenceOf
import org.ktorm.entity.toSet

class BookService {

    private val database = Database.connect(
        url = "jdbc:postgresql://localhost:5432/postgres",
        driver = "org.postgresql.Driver",
        user = "postgres",
        password = "password"
    )

    fun findAllBooks(): Set<Book> = database.sequenceOf(Books).toSet()

    fun findBookByIsbn(isbn: String): Book? =
        database.sequenceOf(Books)
            .find { book -> book.isbn eq isbn }
}
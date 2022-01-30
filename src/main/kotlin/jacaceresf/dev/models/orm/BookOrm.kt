package jacaceresf.dev.models.orm

import org.ktorm.entity.Entity
import org.ktorm.schema.Table
import org.ktorm.schema.long
import org.ktorm.schema.varchar

// this represents the entity
interface Book : Entity<Book> {

    //this helps us to instantiate the entity, it overloads the 'invoke' operator, so we can create Book instances
    companion object : Entity.Factory<Book>()

    val id: Long?
    val name: String
    val genre: String
    val isbn: String
}

/// this helps to bind the table to the actual entity
object Books : Table<Book>("book") {
    val id = long("id").primaryKey().bindTo(Book::id)
    val name = varchar("name").bindTo(Book::name)
    val genre = varchar("genre").bindTo(Book::genre)
    val isbn = varchar("isbn").bindTo(Book::isbn)
}
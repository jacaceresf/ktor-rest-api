package jacaceresf.dev.models

import kotlinx.serialization.Serializable

@Serializable
data class BookResponse(
    val id: Long,
    val name: String,
    val genre: String,
    val isbn: String
)
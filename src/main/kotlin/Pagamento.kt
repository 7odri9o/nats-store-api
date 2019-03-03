import java.util.*

data class Pagamento(
    var id: UUID? = null,
    val valor: Float,
    val formaPagamento: String,
    val status: String)
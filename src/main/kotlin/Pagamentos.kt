import org.jetbrains.exposed.dao.UUIDTable

internal object Pagamentos : UUIDTable() {

    val valor = Pagamentos.decimal("valor", 10, 2)
    val formaPagamento = Pagamentos.varchar("formaPagamento", 20)
    val status = Pagamentos.varchar("status", 20)
}
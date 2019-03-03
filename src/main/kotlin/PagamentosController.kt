
import io.javalin.Context
import org.eclipse.jetty.http.HttpStatus
import org.jetbrains.exposed.sql.transactions.transaction

class PagamentosController {

    fun register(ctx: Context) {

        val pagamento = ctx.bodyAsClass(Pagamento::class.java)

        val pagamentoSalvo =  transaction {
            PagamentoTable.new {
                valor = pagamento.valor.toBigDecimal()
                status = pagamento.status
                formaPagamento = pagamento.formaPagamento
            }
        }
        ctx.status(HttpStatus.CREATED_201)
        ctx.json(convert(pagamentoSalvo))
    }

    private fun convert(pagamento: PagamentoTable?) : Pagamento {

        if (pagamento == null) throw IllegalArgumentException("Pagamento cannot be null")

        return Pagamento(
            id = pagamento.id.value,
            valor = pagamento.valor.toFloat(),
            formaPagamento = pagamento.formaPagamento,
            status = pagamento.status)
    }
}
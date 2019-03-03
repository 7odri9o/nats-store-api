import org.jetbrains.exposed.dao.Entity
import org.jetbrains.exposed.dao.EntityClass
import org.jetbrains.exposed.dao.EntityID
import java.util.*

class PagamentoTable(id: EntityID<UUID>) : Entity<UUID>(id) {
    companion object : EntityClass<UUID, PagamentoTable>(Pagamentos)

    var valor by Pagamentos.valor
    var formaPagamento by Pagamentos.formaPagamento
    var status by Pagamentos.status

}
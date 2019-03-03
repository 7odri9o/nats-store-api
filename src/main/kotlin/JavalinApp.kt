//import io.javalin.Javalin
//import org.eclipse.jetty.http.HttpStatus
//
//object JavalinApp {
//    @JvmStatic
//    fun main(args: Array<String>) {
//        val app = Javalin.create()
//            .port(7000)
//            .start()
//
//        app.post("/pagamentos") { ctx ->
//            val pagamento = ctx.bodyAsClass(Pagamento::class.java)
//            ctx.status(HttpStatus.CREATED_201)
//            ctx.json(pagamento)
//        }
//    }
//}
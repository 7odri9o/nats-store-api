import io.javalin.Javalin
import io.javalin.apibuilder.ApiBuilder.path
import io.javalin.apibuilder.ApiBuilder.post
import org.koin.standalone.KoinComponent

class Router(
    private val pagamentosController: PagamentosController) : KoinComponent {

    fun register(app: Javalin) {
        app.routes {
            path("pagamentos") {
//                get(":id", userController::getUser)
                post(pagamentosController::register)
            }
        }
    }


}
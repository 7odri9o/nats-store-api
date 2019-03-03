import org.koin.dsl.module.module

object ModulesConfig {

    private val configModule = module {
        single { ApplicationConfig() }
        single { Router(get()) }
    }

    private val pagamentoModule = module {
        single { PagamentosController() }
    }

    internal val allModules = listOf(
        ModulesConfig.configModule,
        ModulesConfig.pagamentoModule)
}
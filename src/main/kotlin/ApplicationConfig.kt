
import ModulesConfig.allModules
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import io.javalin.Javalin
import io.javalin.json.JavalinJackson
import org.koin.core.KoinProperties
import org.koin.standalone.KoinComponent
import org.koin.standalone.StandAloneContext
import org.koin.standalone.getProperty
import org.koin.standalone.inject

class ApplicationConfig : KoinComponent {

    private val router: Router by inject()

    fun setup() : Javalin {
        StandAloneContext.startKoin(allModules,
            KoinProperties(true, true)
        )

        DatabaseFactory.init(getDBConfig())

        return Javalin.create()
            .also { app ->
                this.configureMapper()
                app.enableCorsForAllOrigins()
                    .contextPath(getProperty("context"))
                router.register(app)
                app.port(getProperty("server_port"))
            }
    }

    private fun getDBConfig() : HikariDataSource {
        val config = HikariConfig()
        config.jdbcUrl = getProperty("jdbc.url")
        config.username = getProperty("db.username")
        config.password = getProperty("db.password")
        config.validate()
        return HikariDataSource(config)
    }

    private fun configureMapper() {
        JavalinJackson.configure(
            jacksonObjectMapper()
                .setSerializationInclusion(JsonInclude.Include.NON_EMPTY)
                .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS , false))


    }
}
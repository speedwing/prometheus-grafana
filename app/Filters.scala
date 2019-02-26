import com.google.inject.Inject
import javax.inject._
import org.lyranthe.prometheus.client.integration.play.filters.PrometheusFilter
import play.api.http.HttpFilters

@Singleton
class Filters @Inject()(prometheusFilter: PrometheusFilter) extends HttpFilters {

  val filters = Seq(prometheusFilter)

}

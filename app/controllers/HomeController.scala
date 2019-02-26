package controllers

import javax.inject._
import org.lyranthe.prometheus.client._
import play.api.mvc._

@Singleton
class HomeController @Inject()()(implicit val registry: Registry) extends InjectedController {

  val errorCounter = Counter(metric"error_total", "Count error").labels().register

  def get = Action {

    if (math.random() > .95) {
      errorCounter.inc()
      InternalServerError
    } else {
      Ok
    }

  }

  def getMetrics = Action {
    Ok(registry.outputText)
  }

}

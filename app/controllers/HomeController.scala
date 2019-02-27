package controllers

import javax.inject._
import org.lyranthe.prometheus.client._
import play.api.Logger
import play.api.mvc._

@Singleton
class HomeController @Inject()()(implicit val registry: Registry) extends InjectedController {

  private val Log = Logger(classOf[HomeController])

  val errorCounter = Counter(metric"error_total", "Count error").labels().register

  def get = Action {

    Log.info("Method called")

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

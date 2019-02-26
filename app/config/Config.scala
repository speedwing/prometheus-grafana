package config

import com.google.inject.AbstractModule
import org.lyranthe.prometheus.client.{DefaultRegistry, Registry}

class Config extends AbstractModule {

  override def configure(): Unit = {
    bind(classOf[Registry]).toInstance(DefaultRegistry())
  }


}

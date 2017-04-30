
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/toshitpanigrahi/testing_play/streammonitor/conf/routes
// @DATE:Sun Apr 30 10:08:15 EDT 2017

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._

import _root_.controllers.Assets.Asset
import _root_.play.libs.F

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:6
  HomeController_0: controllers.HomeController,
  // @LINE:9
  MinMonitorController_3: controllers.MinMonitorController,
  // @LINE:12
  MaxMonitorController_4: controllers.MaxMonitorController,
  // @LINE:15
  DisMonitorController_1: controllers.DisMonitorController,
  // @LINE:18
  GeoMonitorController_2: controllers.GeoMonitorController,
  // @LINE:34
  Assets_5: controllers.Assets,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:6
    HomeController_0: controllers.HomeController,
    // @LINE:9
    MinMonitorController_3: controllers.MinMonitorController,
    // @LINE:12
    MaxMonitorController_4: controllers.MaxMonitorController,
    // @LINE:15
    DisMonitorController_1: controllers.DisMonitorController,
    // @LINE:18
    GeoMonitorController_2: controllers.GeoMonitorController,
    // @LINE:34
    Assets_5: controllers.Assets
  ) = this(errorHandler, HomeController_0, MinMonitorController_3, MaxMonitorController_4, DisMonitorController_1, GeoMonitorController_2, Assets_5, "/")

  import ReverseRouteContext.empty

  def withPrefix(prefix: String): Routes = {
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, HomeController_0, MinMonitorController_3, MaxMonitorController_4, DisMonitorController_1, GeoMonitorController_2, Assets_5, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix, """controllers.HomeController.index"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """min_threshold/init""", """controllers.MinMonitorController.initialize"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """max_threshold/init""", """controllers.MaxMonitorController.initialize"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """distance/init""", """controllers.DisMonitorController.initialize"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """geofence/init""", """controllers.GeoMonitorController.initialize"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """min_threshold/monitor""", """controllers.MinMonitorController.monitor"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """max_threshold/monitor""", """controllers.MaxMonitorController.monitor"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """distance/monitor""", """controllers.DisMonitorController.monitor"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """geofence/monitor""", """controllers.GeoMonitorController.monitor"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.versioned(path:String = "/public", file:Asset)"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:6
  private[this] lazy val controllers_HomeController_index0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_HomeController_index0_invoker = createInvoker(
    HomeController_0.index,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "index",
      Nil,
      "GET",
      """ An example controller showing a sample home page""",
      this.prefix + """"""
    )
  )

  // @LINE:9
  private[this] lazy val controllers_MinMonitorController_initialize1_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("min_threshold/init")))
  )
  private[this] lazy val controllers_MinMonitorController_initialize1_invoker = createInvoker(
    MinMonitorController_3.initialize,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.MinMonitorController",
      "initialize",
      Nil,
      "POST",
      """ The controller for the min-threshold monitor initialization""",
      this.prefix + """min_threshold/init"""
    )
  )

  // @LINE:12
  private[this] lazy val controllers_MaxMonitorController_initialize2_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("max_threshold/init")))
  )
  private[this] lazy val controllers_MaxMonitorController_initialize2_invoker = createInvoker(
    MaxMonitorController_4.initialize,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.MaxMonitorController",
      "initialize",
      Nil,
      "POST",
      """ The controller for the max-threshold monitor initialization""",
      this.prefix + """max_threshold/init"""
    )
  )

  // @LINE:15
  private[this] lazy val controllers_DisMonitorController_initialize3_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("distance/init")))
  )
  private[this] lazy val controllers_DisMonitorController_initialize3_invoker = createInvoker(
    DisMonitorController_1.initialize,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.DisMonitorController",
      "initialize",
      Nil,
      "POST",
      """ The controller for the distance monitor initialization""",
      this.prefix + """distance/init"""
    )
  )

  // @LINE:18
  private[this] lazy val controllers_GeoMonitorController_initialize4_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("geofence/init")))
  )
  private[this] lazy val controllers_GeoMonitorController_initialize4_invoker = createInvoker(
    GeoMonitorController_2.initialize,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.GeoMonitorController",
      "initialize",
      Nil,
      "POST",
      """ The controller for the distance monitor initialization""",
      this.prefix + """geofence/init"""
    )
  )

  // @LINE:22
  private[this] lazy val controllers_MinMonitorController_monitor5_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("min_threshold/monitor")))
  )
  private[this] lazy val controllers_MinMonitorController_monitor5_invoker = createInvoker(
    MinMonitorController_3.monitor,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.MinMonitorController",
      "monitor",
      Nil,
      "POST",
      """ The controller for min-threshold monitoring""",
      this.prefix + """min_threshold/monitor"""
    )
  )

  // @LINE:25
  private[this] lazy val controllers_MaxMonitorController_monitor6_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("max_threshold/monitor")))
  )
  private[this] lazy val controllers_MaxMonitorController_monitor6_invoker = createInvoker(
    MaxMonitorController_4.monitor,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.MaxMonitorController",
      "monitor",
      Nil,
      "POST",
      """ The controller for max-threshold monitoring""",
      this.prefix + """max_threshold/monitor"""
    )
  )

  // @LINE:28
  private[this] lazy val controllers_DisMonitorController_monitor7_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("distance/monitor")))
  )
  private[this] lazy val controllers_DisMonitorController_monitor7_invoker = createInvoker(
    DisMonitorController_1.monitor,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.DisMonitorController",
      "monitor",
      Nil,
      "POST",
      """ The controller for distance monitoring""",
      this.prefix + """distance/monitor"""
    )
  )

  // @LINE:31
  private[this] lazy val controllers_GeoMonitorController_monitor8_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("geofence/monitor")))
  )
  private[this] lazy val controllers_GeoMonitorController_monitor8_invoker = createInvoker(
    GeoMonitorController_2.monitor,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.GeoMonitorController",
      "monitor",
      Nil,
      "POST",
      """ The controller for distance monitoring""",
      this.prefix + """geofence/monitor"""
    )
  )

  // @LINE:34
  private[this] lazy val controllers_Assets_versioned9_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned9_invoker = createInvoker(
    Assets_5.versioned(fakeValue[String], fakeValue[Asset]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "versioned",
      Seq(classOf[String], classOf[Asset]),
      "GET",
      """ Map static resources from the /public folder to the /assets URL path""",
      this.prefix + """assets/""" + "$" + """file<.+>"""
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:6
    case controllers_HomeController_index0_route(params) =>
      call { 
        controllers_HomeController_index0_invoker.call(HomeController_0.index)
      }
  
    // @LINE:9
    case controllers_MinMonitorController_initialize1_route(params) =>
      call { 
        controllers_MinMonitorController_initialize1_invoker.call(MinMonitorController_3.initialize)
      }
  
    // @LINE:12
    case controllers_MaxMonitorController_initialize2_route(params) =>
      call { 
        controllers_MaxMonitorController_initialize2_invoker.call(MaxMonitorController_4.initialize)
      }
  
    // @LINE:15
    case controllers_DisMonitorController_initialize3_route(params) =>
      call { 
        controllers_DisMonitorController_initialize3_invoker.call(DisMonitorController_1.initialize)
      }
  
    // @LINE:18
    case controllers_GeoMonitorController_initialize4_route(params) =>
      call { 
        controllers_GeoMonitorController_initialize4_invoker.call(GeoMonitorController_2.initialize)
      }
  
    // @LINE:22
    case controllers_MinMonitorController_monitor5_route(params) =>
      call { 
        controllers_MinMonitorController_monitor5_invoker.call(MinMonitorController_3.monitor)
      }
  
    // @LINE:25
    case controllers_MaxMonitorController_monitor6_route(params) =>
      call { 
        controllers_MaxMonitorController_monitor6_invoker.call(MaxMonitorController_4.monitor)
      }
  
    // @LINE:28
    case controllers_DisMonitorController_monitor7_route(params) =>
      call { 
        controllers_DisMonitorController_monitor7_invoker.call(DisMonitorController_1.monitor)
      }
  
    // @LINE:31
    case controllers_GeoMonitorController_monitor8_route(params) =>
      call { 
        controllers_GeoMonitorController_monitor8_invoker.call(GeoMonitorController_2.monitor)
      }
  
    // @LINE:34
    case controllers_Assets_versioned9_route(params) =>
      call(Param[String]("path", Right("/public")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned9_invoker.call(Assets_5.versioned(path, file))
      }
  }
}

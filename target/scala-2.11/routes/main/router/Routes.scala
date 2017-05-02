
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/toshitpanigrahi/testing_play/streammonitor/conf/routes
// @DATE:Sun Apr 30 23:38:53 EDT 2017

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
  Assets_4: controllers.Assets,
  // @LINE:10
  MinMonitorController_2: controllers.MinMonitorController,
  // @LINE:13
  MaxMonitorController_3: controllers.MaxMonitorController,
  // @LINE:16
  DisMonitorController_0: controllers.DisMonitorController,
  // @LINE:19
  GeoMonitorController_1: controllers.GeoMonitorController,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:6
    Assets_4: controllers.Assets,
    // @LINE:10
    MinMonitorController_2: controllers.MinMonitorController,
    // @LINE:13
    MaxMonitorController_3: controllers.MaxMonitorController,
    // @LINE:16
    DisMonitorController_0: controllers.DisMonitorController,
    // @LINE:19
    GeoMonitorController_1: controllers.GeoMonitorController
  ) = this(errorHandler, Assets_4, MinMonitorController_2, MaxMonitorController_3, DisMonitorController_0, GeoMonitorController_1, "/")

  import ReverseRouteContext.empty

  def withPrefix(prefix: String): Routes = {
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, Assets_4, MinMonitorController_2, MaxMonitorController_3, DisMonitorController_0, GeoMonitorController_1, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix, """controllers.Assets.at(path:String = "/public", file:String = "html/demo.html")"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """stylesheets/""" + "$" + """file<.+>""", """controllers.Assets.at(path:String = "/public/stylesheets", file:String)"""),
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
  private[this] lazy val controllers_Assets_at0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_Assets_at0_invoker = createInvoker(
    Assets_4.at(fakeValue[String], fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "at",
      Seq(classOf[String], classOf[String]),
      "GET",
      """ An example controller showing a sample home page""",
      this.prefix + """"""
    )
  )

  // @LINE:7
  private[this] lazy val controllers_Assets_at1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("stylesheets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_at1_invoker = createInvoker(
    Assets_4.at(fakeValue[String], fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "at",
      Seq(classOf[String], classOf[String]),
      "GET",
      """""",
      this.prefix + """stylesheets/""" + "$" + """file<.+>"""
    )
  )

  // @LINE:10
  private[this] lazy val controllers_MinMonitorController_initialize2_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("min_threshold/init")))
  )
  private[this] lazy val controllers_MinMonitorController_initialize2_invoker = createInvoker(
    MinMonitorController_2.initialize,
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

  // @LINE:13
  private[this] lazy val controllers_MaxMonitorController_initialize3_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("max_threshold/init")))
  )
  private[this] lazy val controllers_MaxMonitorController_initialize3_invoker = createInvoker(
    MaxMonitorController_3.initialize,
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

  // @LINE:16
  private[this] lazy val controllers_DisMonitorController_initialize4_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("distance/init")))
  )
  private[this] lazy val controllers_DisMonitorController_initialize4_invoker = createInvoker(
    DisMonitorController_0.initialize,
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

  // @LINE:19
  private[this] lazy val controllers_GeoMonitorController_initialize5_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("geofence/init")))
  )
  private[this] lazy val controllers_GeoMonitorController_initialize5_invoker = createInvoker(
    GeoMonitorController_1.initialize,
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

  // @LINE:23
  private[this] lazy val controllers_MinMonitorController_monitor6_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("min_threshold/monitor")))
  )
  private[this] lazy val controllers_MinMonitorController_monitor6_invoker = createInvoker(
    MinMonitorController_2.monitor,
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

  // @LINE:26
  private[this] lazy val controllers_MaxMonitorController_monitor7_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("max_threshold/monitor")))
  )
  private[this] lazy val controllers_MaxMonitorController_monitor7_invoker = createInvoker(
    MaxMonitorController_3.monitor,
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

  // @LINE:29
  private[this] lazy val controllers_DisMonitorController_monitor8_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("distance/monitor")))
  )
  private[this] lazy val controllers_DisMonitorController_monitor8_invoker = createInvoker(
    DisMonitorController_0.monitor,
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

  // @LINE:32
  private[this] lazy val controllers_GeoMonitorController_monitor9_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("geofence/monitor")))
  )
  private[this] lazy val controllers_GeoMonitorController_monitor9_invoker = createInvoker(
    GeoMonitorController_1.monitor,
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

  // @LINE:35
  private[this] lazy val controllers_Assets_versioned10_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned10_invoker = createInvoker(
    Assets_4.versioned(fakeValue[String], fakeValue[Asset]),
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
    case controllers_Assets_at0_route(params) =>
      call(Param[String]("path", Right("/public")), Param[String]("file", Right("html/demo.html"))) { (path, file) =>
        controllers_Assets_at0_invoker.call(Assets_4.at(path, file))
      }
  
    // @LINE:7
    case controllers_Assets_at1_route(params) =>
      call(Param[String]("path", Right("/public/stylesheets")), params.fromPath[String]("file", None)) { (path, file) =>
        controllers_Assets_at1_invoker.call(Assets_4.at(path, file))
      }
  
    // @LINE:10
    case controllers_MinMonitorController_initialize2_route(params) =>
      call { 
        controllers_MinMonitorController_initialize2_invoker.call(MinMonitorController_2.initialize)
      }
  
    // @LINE:13
    case controllers_MaxMonitorController_initialize3_route(params) =>
      call { 
        controllers_MaxMonitorController_initialize3_invoker.call(MaxMonitorController_3.initialize)
      }
  
    // @LINE:16
    case controllers_DisMonitorController_initialize4_route(params) =>
      call { 
        controllers_DisMonitorController_initialize4_invoker.call(DisMonitorController_0.initialize)
      }
  
    // @LINE:19
    case controllers_GeoMonitorController_initialize5_route(params) =>
      call { 
        controllers_GeoMonitorController_initialize5_invoker.call(GeoMonitorController_1.initialize)
      }
  
    // @LINE:23
    case controllers_MinMonitorController_monitor6_route(params) =>
      call { 
        controllers_MinMonitorController_monitor6_invoker.call(MinMonitorController_2.monitor)
      }
  
    // @LINE:26
    case controllers_MaxMonitorController_monitor7_route(params) =>
      call { 
        controllers_MaxMonitorController_monitor7_invoker.call(MaxMonitorController_3.monitor)
      }
  
    // @LINE:29
    case controllers_DisMonitorController_monitor8_route(params) =>
      call { 
        controllers_DisMonitorController_monitor8_invoker.call(DisMonitorController_0.monitor)
      }
  
    // @LINE:32
    case controllers_GeoMonitorController_monitor9_route(params) =>
      call { 
        controllers_GeoMonitorController_monitor9_invoker.call(GeoMonitorController_1.monitor)
      }
  
    // @LINE:35
    case controllers_Assets_versioned10_route(params) =>
      call(Param[String]("path", Right("/public")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned10_invoker.call(Assets_4.versioned(path, file))
      }
  }
}

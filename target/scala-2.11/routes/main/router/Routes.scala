
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/toshitpanigrahi/testing_play/streammonitor/conf/routes
// @DATE:Sat Apr 29 16:08:16 EDT 2017

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
  MinMonitorController_2: controllers.MinMonitorController,
  // @LINE:12
  MaxMonitorController_3: controllers.MaxMonitorController,
  // @LINE:15
  DisMonitorController_1: controllers.DisMonitorController,
  // @LINE:27
  Assets_4: controllers.Assets,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:6
    HomeController_0: controllers.HomeController,
    // @LINE:9
    MinMonitorController_2: controllers.MinMonitorController,
    // @LINE:12
    MaxMonitorController_3: controllers.MaxMonitorController,
    // @LINE:15
    DisMonitorController_1: controllers.DisMonitorController,
    // @LINE:27
    Assets_4: controllers.Assets
  ) = this(errorHandler, HomeController_0, MinMonitorController_2, MaxMonitorController_3, DisMonitorController_1, Assets_4, "/")

  import ReverseRouteContext.empty

  def withPrefix(prefix: String): Routes = {
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, HomeController_0, MinMonitorController_2, MaxMonitorController_3, DisMonitorController_1, Assets_4, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix, """controllers.HomeController.index"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """min_threshold/init""", """controllers.MinMonitorController.initialize"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """max_threshold/init""", """controllers.MaxMonitorController.initialize"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """distance/init""", """controllers.DisMonitorController.initialize"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """min_threshold/monitor""", """controllers.MinMonitorController.monitor"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """max_threshold/monitor""", """controllers.MaxMonitorController.monitor"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """distance/monitor""", """controllers.DisMonitorController.monitor"""),
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

  // @LINE:12
  private[this] lazy val controllers_MaxMonitorController_initialize2_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("max_threshold/init")))
  )
  private[this] lazy val controllers_MaxMonitorController_initialize2_invoker = createInvoker(
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
  private[this] lazy val controllers_MinMonitorController_monitor4_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("min_threshold/monitor")))
  )
  private[this] lazy val controllers_MinMonitorController_monitor4_invoker = createInvoker(
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

  // @LINE:21
  private[this] lazy val controllers_MaxMonitorController_monitor5_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("max_threshold/monitor")))
  )
  private[this] lazy val controllers_MaxMonitorController_monitor5_invoker = createInvoker(
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

  // @LINE:24
  private[this] lazy val controllers_DisMonitorController_monitor6_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("distance/monitor")))
  )
  private[this] lazy val controllers_DisMonitorController_monitor6_invoker = createInvoker(
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

  // @LINE:27
  private[this] lazy val controllers_Assets_versioned7_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned7_invoker = createInvoker(
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
    case controllers_HomeController_index0_route(params) =>
      call { 
        controllers_HomeController_index0_invoker.call(HomeController_0.index)
      }
  
    // @LINE:9
    case controllers_MinMonitorController_initialize1_route(params) =>
      call { 
        controllers_MinMonitorController_initialize1_invoker.call(MinMonitorController_2.initialize)
      }
  
    // @LINE:12
    case controllers_MaxMonitorController_initialize2_route(params) =>
      call { 
        controllers_MaxMonitorController_initialize2_invoker.call(MaxMonitorController_3.initialize)
      }
  
    // @LINE:15
    case controllers_DisMonitorController_initialize3_route(params) =>
      call { 
        controllers_DisMonitorController_initialize3_invoker.call(DisMonitorController_1.initialize)
      }
  
    // @LINE:18
    case controllers_MinMonitorController_monitor4_route(params) =>
      call { 
        controllers_MinMonitorController_monitor4_invoker.call(MinMonitorController_2.monitor)
      }
  
    // @LINE:21
    case controllers_MaxMonitorController_monitor5_route(params) =>
      call { 
        controllers_MaxMonitorController_monitor5_invoker.call(MaxMonitorController_3.monitor)
      }
  
    // @LINE:24
    case controllers_DisMonitorController_monitor6_route(params) =>
      call { 
        controllers_DisMonitorController_monitor6_invoker.call(DisMonitorController_1.monitor)
      }
  
    // @LINE:27
    case controllers_Assets_versioned7_route(params) =>
      call(Param[String]("path", Right("/public")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned7_invoker.call(Assets_4.versioned(path, file))
      }
  }
}

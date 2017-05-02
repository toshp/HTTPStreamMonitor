
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/toshitpanigrahi/testing_play/streammonitor/conf/routes
// @DATE:Sun Apr 30 23:38:53 EDT 2017

import play.api.routing.JavaScriptReverseRoute
import play.api.mvc.{ QueryStringBindable, PathBindable, Call, JavascriptLiteral }
import play.core.routing.{ HandlerDef, ReverseRouteContext, queryString, dynamicString }


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:6
package controllers.javascript {
  import ReverseRouteContext.empty

  // @LINE:6
  class ReverseAssets(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:6
    def at: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Assets.at",
      """
        function(path0,file1) {
        
          if (path0 == """ + implicitly[JavascriptLiteral[String]].to("/public") + """ && file1 == """ + implicitly[JavascriptLiteral[String]].to("html/demo.html") + """) {
            return _wA({method:"GET", url:"""" + _prefix + """"})
          }
        
          if (path0 == """ + implicitly[JavascriptLiteral[String]].to("/public/stylesheets") + """) {
            return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "stylesheets/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file1)})
          }
        
        }
      """
    )
  
    // @LINE:35
    def versioned: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Assets.versioned",
      """
        function(file1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[PathBindable[Asset]].javascriptUnbind + """)("file", file1)})
        }
      """
    )
  
  }

  // @LINE:10
  class ReverseMinMonitorController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:10
    def initialize: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.MinMonitorController.initialize",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "min_threshold/init"})
        }
      """
    )
  
    // @LINE:23
    def monitor: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.MinMonitorController.monitor",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "min_threshold/monitor"})
        }
      """
    )
  
  }

  // @LINE:13
  class ReverseMaxMonitorController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:13
    def initialize: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.MaxMonitorController.initialize",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "max_threshold/init"})
        }
      """
    )
  
    // @LINE:26
    def monitor: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.MaxMonitorController.monitor",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "max_threshold/monitor"})
        }
      """
    )
  
  }

  // @LINE:16
  class ReverseDisMonitorController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:16
    def initialize: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.DisMonitorController.initialize",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "distance/init"})
        }
      """
    )
  
    // @LINE:29
    def monitor: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.DisMonitorController.monitor",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "distance/monitor"})
        }
      """
    )
  
  }

  // @LINE:19
  class ReverseGeoMonitorController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:19
    def initialize: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.GeoMonitorController.initialize",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "geofence/init"})
        }
      """
    )
  
    // @LINE:32
    def monitor: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.GeoMonitorController.monitor",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "geofence/monitor"})
        }
      """
    )
  
  }


}

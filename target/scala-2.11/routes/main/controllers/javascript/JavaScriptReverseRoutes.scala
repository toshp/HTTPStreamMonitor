
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/toshitpanigrahi/testing_play/streammonitor/conf/routes
// @DATE:Sun Apr 30 10:08:15 EDT 2017

import play.api.routing.JavaScriptReverseRoute
import play.api.mvc.{ QueryStringBindable, PathBindable, Call, JavascriptLiteral }
import play.core.routing.{ HandlerDef, ReverseRouteContext, queryString, dynamicString }


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:6
package controllers.javascript {
  import ReverseRouteContext.empty

  // @LINE:34
  class ReverseAssets(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:34
    def versioned: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Assets.versioned",
      """
        function(file1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[PathBindable[Asset]].javascriptUnbind + """)("file", file1)})
        }
      """
    )
  
  }

  // @LINE:9
  class ReverseMinMonitorController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:9
    def initialize: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.MinMonitorController.initialize",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "min_threshold/init"})
        }
      """
    )
  
    // @LINE:22
    def monitor: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.MinMonitorController.monitor",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "min_threshold/monitor"})
        }
      """
    )
  
  }

  // @LINE:12
  class ReverseMaxMonitorController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:12
    def initialize: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.MaxMonitorController.initialize",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "max_threshold/init"})
        }
      """
    )
  
    // @LINE:25
    def monitor: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.MaxMonitorController.monitor",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "max_threshold/monitor"})
        }
      """
    )
  
  }

  // @LINE:6
  class ReverseHomeController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:6
    def index: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.index",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + """"})
        }
      """
    )
  
  }

  // @LINE:15
  class ReverseDisMonitorController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:15
    def initialize: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.DisMonitorController.initialize",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "distance/init"})
        }
      """
    )
  
    // @LINE:28
    def monitor: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.DisMonitorController.monitor",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "distance/monitor"})
        }
      """
    )
  
  }

  // @LINE:18
  class ReverseGeoMonitorController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:18
    def initialize: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.GeoMonitorController.initialize",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "geofence/init"})
        }
      """
    )
  
    // @LINE:31
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

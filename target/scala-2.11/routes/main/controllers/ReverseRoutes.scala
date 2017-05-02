
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/toshitpanigrahi/testing_play/streammonitor/conf/routes
// @DATE:Sun Apr 30 23:38:53 EDT 2017

import play.api.mvc.{ QueryStringBindable, PathBindable, Call, JavascriptLiteral }
import play.core.routing.{ HandlerDef, ReverseRouteContext, queryString, dynamicString }


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:6
package controllers {

  // @LINE:6
  class ReverseAssets(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:6
    def at(path:String, file:String): Call = {
    
      (path: @unchecked, file: @unchecked) match {
      
        // @LINE:6
        case (path, file) if path == "/public" && file == "html/demo.html" =>
          implicit val _rrc = new ReverseRouteContext(Map(("path", "/public"), ("file", "html/demo.html")))
          Call("GET", _prefix)
      
        // @LINE:7
        case (path, file) if path == "/public/stylesheets" =>
          implicit val _rrc = new ReverseRouteContext(Map(("path", "/public/stylesheets")))
          Call("GET", _prefix + { _defaultPrefix } + "stylesheets/" + implicitly[PathBindable[String]].unbind("file", file))
      
      }
    
    }
  
    // @LINE:35
    def versioned(file:Asset): Call = {
      implicit val _rrc = new ReverseRouteContext(Map(("path", "/public")))
      Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[PathBindable[Asset]].unbind("file", file))
    }
  
  }

  // @LINE:10
  class ReverseMinMonitorController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:10
    def initialize(): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "min_threshold/init")
    }
  
    // @LINE:23
    def monitor(): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "min_threshold/monitor")
    }
  
  }

  // @LINE:13
  class ReverseMaxMonitorController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:13
    def initialize(): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "max_threshold/init")
    }
  
    // @LINE:26
    def monitor(): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "max_threshold/monitor")
    }
  
  }

  // @LINE:16
  class ReverseDisMonitorController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:16
    def initialize(): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "distance/init")
    }
  
    // @LINE:29
    def monitor(): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "distance/monitor")
    }
  
  }

  // @LINE:19
  class ReverseGeoMonitorController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:19
    def initialize(): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "geofence/init")
    }
  
    // @LINE:32
    def monitor(): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "geofence/monitor")
    }
  
  }


}

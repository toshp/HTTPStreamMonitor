
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/toshitpanigrahi/testing_play/streammonitor/conf/routes
// @DATE:Tue Apr 25 17:30:53 EDT 2017


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}

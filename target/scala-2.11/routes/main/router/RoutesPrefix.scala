
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/toshitpanigrahi/testing_play/streammonitor/conf/routes
// @DATE:Sat Apr 29 16:08:16 EDT 2017


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

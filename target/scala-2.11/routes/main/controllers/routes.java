
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/toshitpanigrahi/testing_play/streammonitor/conf/routes
// @DATE:Sat Apr 29 16:08:16 EDT 2017

package controllers;

import router.RoutesPrefix;

public class routes {
  
  public static final controllers.ReverseAssets Assets = new controllers.ReverseAssets(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseMinMonitorController MinMonitorController = new controllers.ReverseMinMonitorController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseMaxMonitorController MaxMonitorController = new controllers.ReverseMaxMonitorController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseHomeController HomeController = new controllers.ReverseHomeController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseDisMonitorController DisMonitorController = new controllers.ReverseDisMonitorController(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final controllers.javascript.ReverseAssets Assets = new controllers.javascript.ReverseAssets(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseMinMonitorController MinMonitorController = new controllers.javascript.ReverseMinMonitorController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseMaxMonitorController MaxMonitorController = new controllers.javascript.ReverseMaxMonitorController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseHomeController HomeController = new controllers.javascript.ReverseHomeController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseDisMonitorController DisMonitorController = new controllers.javascript.ReverseDisMonitorController(RoutesPrefix.byNamePrefix());
  }

}

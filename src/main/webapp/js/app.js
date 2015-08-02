'use strict';

/* App Module */

var productApp = angular.module('productApp', [
  'ngRoute',
  'productControllers'
]);

productApp.config(['$routeProvider',
  function($routeProvider) {
    $routeProvider.
      when('/assessment', {
        templateUrl: 'partials/product-list.html',
        controller: 'ProductListCtrl'
      }).
      when('/questions/:assessmentId', {
        templateUrl: 'partials/product-detail.html',
        controller: 'ProductDetailCtrl'
      }).
      when('/assessmentcreate', {
          templateUrl: 'partials/product-create.html',
          controller: 'ProductCreateCtrl'
      }).
      otherwise({
        redirectTo: '/assessment'
      });
  }]);

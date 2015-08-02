'use strict';

/* Services */

var productServices = angular.module('productServices', ['ngResource']);

productServices.factory('Phone', ['$resource',
  function($resource){
    return $resource('phones/:phoneId.json', {}, {
      query: {method:'GET', params:{phoneId:'phones'}, isArray:true}
    });
  }]);

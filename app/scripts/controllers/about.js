'use strict';

/**
 * @ngdoc function
 * @name staffingApp.controller:AboutCtrl
 * @description
 * # AboutCtrl
 * Controller of the staffingApp
 */
angular.module('staffingApp')
  .controller('AboutCtrl', function ($scope) {
    $scope.awesomeThings = [
      'HTML5 Boilerplate',
      'AngularJS',
      'Karma'
    ];
  });

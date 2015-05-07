'use strict';

/**
 * @ngdoc function
 * @name staffingApp.controller:MainCtrl
 * @description
 * # MainCtrl
 * Controller of the staffingApp
 */
angular.module('staffingApp')
  .controller('MainCtrl', function ($scope, Login) {
    var self = this;

    $scope.awesomeThings = [
      'HTML5 Boilerplate',
      'AngularJS',
      'Karma'
    ];

    $scope.credentials = {};
    $scope.checkLogin = function() {
      var username = $scope.credentials.username,
        password = $scope.credentials.password;

      console.log("hello");
      Login.authenticate(username, password).then(function() {
        console.log("done");
      });
    }

  });

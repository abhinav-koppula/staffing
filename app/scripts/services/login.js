'use strict';

angular.module('staffingApp')
  .factory('Login', function LoginFactory($http, $cookies) {
    return {
      authenticate: function(username, password) {
        var credentials = {
          'username': username,
          'password': password
        };
        return $http({
          method: 'POST',
          url: '/api/login',
          data: credentials
        }).success(function(data) {
          console.log(data);
          $cookies["XSRF-TOKEN"] = data.authToken;

          var roleId = data.userDetail.role.id;
          if(roleId === 1) {

          } else if(roleId === 2) {



          } else if(roleId === 3) {

          } else {

          }
        }).error(function() {

        });
      }
    };
  });

﻿(function () {
    var NutricionizamFitnes = angular.module('NutricionizamFitnes');

    NutricionizamFitnes.controller('loginCtrl', ['$rootScope', '$scope', '$http', '$location', '$window', 'loginServis', '$httpParamSerializer', '$localStorage', function ($rootScope, $scope, $http, $location, $window, loginServis, $httpParamSerializer, $localStorage) {

        $scope.loginCredentials =
        {
            username: "",
            password: ""
        };

        $scope.logIn = function (username,password) {
            var creds = { "username": username, "password": password }
            alert("ussaoo");

            $http.post('http://localhost:8081/login', JSON.stringify(creds),
                            {
                             
                                headers: {
                                    'Content-Type': 'text/plain',
                                },
                                transformResponse: undefined
                            })
                            .then(response => {
                                alert($localStorage.nesto);
                                $http.defaults.headers.common.Authorization = response.headers('Authorization');
                                console.log(response.headers());
                                $localStorage.nesto = response.headers('Authorization');
                                
                                $window.location.href = '/#/registracija';
                            }, error => {
                                console.log(error)
                            });

        };
    }]);
}());

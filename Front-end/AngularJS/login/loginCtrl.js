(function () {
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
                                    'Content-Type': 'text/plain'
                                },
                                transformResponse: undefined
                            })
                            .then(response => {
                                $http.defaults.headers.common.Authorization = response.headers('Authorization');
                                $localStorage.token = response.headers('Authorization');
                                $window.location.href = '/#/';
                            }, error => {
                                console.log(error)
                            });

        };
    }]);
}());

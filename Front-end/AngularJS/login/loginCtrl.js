(function () {
    var NutricionizamFitnes = angular.module('NutricionizamFitnes');

    NutricionizamFitnes.controller('loginCtrl', ['$scope', 'loginServis', function ($scope, loginServis) {

        $scope.loginCredentials =
        {
            username: "",
            password: ""
        };

        $scope.logIn = function () {

           

            
        }
    }]);
}());

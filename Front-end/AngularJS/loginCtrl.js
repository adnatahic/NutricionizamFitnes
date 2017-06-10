var app = angular.module('NutricionizamFitnes');

app.controller('loginCtrl', ['$window', '$scope', '$http', function ($window, $scope, $http) {
    $scope.message = "";
    $scope.login = function () {
        //alert($scope.username + " " + $scope.password);
        $http({
            method: 'POST',
            url: '/login',
            contentType: "application/json",
            data: angular.toJson({ username: $scope.username, password: $scope.password }, true)

        }).success(function (data) {
            console.log(data);
            $scope.message = data;
            $window.location.href = '/korisnici/index.html';
        }).error(function (error) {
            console.log(error);
            alert("Pogresan username i/ili password!");
        });

    };

}]);
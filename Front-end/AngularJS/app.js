(function () {
    var NutricionizamFitnes = angular.module('NutricionizamFitnes', ['ngRoute']);

    NutricionizamFitnes.config(function ($routeProvider) {
        $routeProvider
            .when("/korisnici",
            {
                templateUrl: "korisnici/korisnici.html",
                controller: "korisniciCtrl"
            })
            .when("/treneri",
            {
                templateUrl: "treneri/treneri.html",
                controller: "treneriCtrl"
            })
            .when("/treneri",
            {
                templateUrl: "treneri/treneri.html",
                controller: "treneriCtrl"
            })
            .otherwise({ redirectTo: "/index.html" });
    });
}());
(function () {
    var NutricionizamFitnes = angular.module('NutricionizamFitnes', ['ngStorage','ngRoute']);

    NutricionizamFitnes.config(function ($routeProvider, $httpProvider) {
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
            .when("/login",
            {
                templateUrl: "login/login.html",
                controller: "loginCtrl"
            })
            .when("/registracija",
            {
                templateUrl: "registracija/registracija.html",
                controller: "registracijaCtrl"
            })
            .otherwise({ redirectTo: "/login" });

        $httpProvider.defaults.headers.common = {};
        $httpProvider.defaults.headers.post = {};
        $httpProvider.defaults.headers.put = {};
        $httpProvider.defaults.headers.patch = {};
       
    });
}());
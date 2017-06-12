(function () {
    var NutricionizamFitnes = angular.module('NutricionizamFitnes');

    NutricionizamFitnes.controller('registracijaCtrl', ['$scope', 'registracijaServis', function ($scope, registracijaServis) {

       
        $scope.registracija =
       {
           ime: "",
           prezime: "",
           email: "",
           password: ""
       };
        
        $scope.registrujKorisnika = function () {
            registracijaServis.list("users", $scope.registracija, 
                function (data) {
                    if (data) {
                        $scope.korisnici = data;
                    }
                });
        };
        

    }]);
}());

(function () {
    var NutricionizamFitnes = angular.module('NutricionizamFitnes');

    NutricionizamFitnes.controller('registracijaCtrl', ['$scope', 'registracijaServis', '$localStorage', function ($scope, registracijaServis, $localStorage) {

       
        $scope.registracija =
       {
           ime: "",
           prezime: "",
           username: "",
           email: "",
           password: ""
       };


        $scope.registrujKorisnika = function () {
            urldodaj = "dodaj/" + $scope.registracija.ime + "/" + $scope.registracija.prezime + "/" + $scope.registracija.username + "/" + $scope.registracija.password + "/" + $scope.registracija.email;
            registracijaServis.list(urldodaj, 
                function (data) {
                    if (data) {
                        alert("uspješno dodan korisnik " );
                    }
                    else alert("GREŠKAAA NEKA");
                });
        };
        

    }]);
}());

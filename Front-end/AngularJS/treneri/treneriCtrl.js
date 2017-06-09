(function () {
    var NutricionizamFitnes = angular.module('NutricionizamFitnes');

    NutricionizamFitnes.controller('treneriCtrl', ['$scope', 'treneriServis', function ($scope, treneriServis) {

        $scope.treneri =
        [
            {
                id: 1,
                godine: 29,
                spol: "zenski",
                edukacija: "Licenciran od GymWorld",
                iskustvo:10,
                brojKlijenata: 50,
                rejting:5
            },
            {
                id: 1,
                godine: 29,
                spol: "muski",
                edukacija: "Licencirani trener Herbalife-a",
                iskustvo: 10,
                brojKlijenata: 50,
                rejting: 3
            },
        ];
        $scope.selektuj = function (korisnik) {
            $scope.odabrani = korisnik;
        }
        //TODO
        $scope.editujKorisnika = function (korisnik) {
            userService.post("svi", korisnik, korisnik.id, 
                function (data) {
                    if (data) {
                        $scope.korisnici = data;
                    }
                });
        }
        $scope.otkazi = function (korisnik) {
            $scope.odabrani = null;
        }
        $scope.dajSveKorisnike = function () {
            userService.list("svi",
                function (data) {
                    if (data) {
                        $scope.korisnici = data;
                    }
                });
        };

    }]);
}());

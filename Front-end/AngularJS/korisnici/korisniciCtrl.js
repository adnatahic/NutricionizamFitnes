(function () {
    var NutricionizamFitnes = angular.module('NutricionizamFitnes');

    NutricionizamFitnes.controller('korisniciCtrl', ['$scope', 'korisniciServis', function ($scope, korisniciServis) {

        $scope.korisnici =
        [
            {
                id: 1,
                bolesti: "Pretilost",
                datumPristupa: new Date(2016, 2, 2, 12, 0, 0, 0),
                godine: 29,
                spol: "zenski",
                tezina: 70,
                visina: 150,
                zeljenaKilaza: 50
            },
            {
                id: 2,
                bolesti: "Mrsavost",
                datumPristupa: new Date(2016, 2, 2, 12, 0, 0, 0),
                godine: 29,
                spol: "zenski",
                tezina: 50,
                visina: 180,
                zeljenaKilaza: 70
            },
            {
                id: 1,
                bolesti: "Slabi misici",
                datumPristupa: new Date(2016, 2, 2, 12, 0, 0, 0),
                godine: 29,
                spol: "muski",
                tezina: 60,
                visina: 150,
                zeljenaKilaza: 60
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
    }]);
}());

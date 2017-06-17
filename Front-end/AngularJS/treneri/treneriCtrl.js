(function () {
    var NutricionizamFitnes = angular.module('NutricionizamFitnes');

    NutricionizamFitnes.controller('treneriCtrl', ['$scope', '$http', '$localStorage', 'treneriServis', function ($scope, $http, $localStorage, treneriServis) {
        $scope.listaNestalih = [];

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
            treneriServis.post("svi", korisnik, korisnik.id,
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
            treneriServis.list("svi",
                function (data) {
                    if (data) {
                        $scope.treneri = data;
                    }
                });
        };
        
        var serviceBase = "http://localhost:8081/";
        $scope.izlistajSveOsobe = function () {
            console.log("pozdrav");
            console.log($localStorage.nesto);
            var urlSveOsobe = serviceBase + 'korisnici/osobe/svi';

            $http({
                method: 'GET', url: urlSveOsobe, headers: {
                    'Authorization': $localStorage.nesto,
                }
            })
        .success(function (data) {
            $scope.listaOsoba = data;
        })
        };


        }]);
    }());

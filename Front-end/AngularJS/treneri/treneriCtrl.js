(function () {
    var NutricionizamFitnes = angular.module('NutricionizamFitnes');

    NutricionizamFitnes.controller('treneriCtrl', ['$scope', '$http', '$localStorage', 'treneriServis', function ($scope, $http, $localStorage, treneriServis) {

        var serviceBase = "http://localhost:8081/";
        $scope.listaTrenera = [];
        $scope.listaOsoba = [];

        $scope.trener = {
            id: "",
            brojKlijenata: "",
            edukacija: "",
            godine: "",
            iskustvo: "",
            spol: "",
            osoba: {
                id: "",
                email: "",
                ime: "",
                password: "",
                prezime: "",
                username: ""
            }
        };

        $scope.odabraniTrener = {
            id: "",
            brojKlijenata: "",
            edukacija: "",
            godine: "",
            iskustvo: "",
            spol: "",
            osoba: {
                id: "",
                email: "",
                ime: "",
                password: "",
                prezime: "",
                username: ""
            }
        };

        $scope.selektujTrenera = function (trener) {
            $scope.odabraniTrener = trener;
        }

        $scope.otkaziTrener = function () {
            console.log($scope.odabraniTrener);
            $scope.odabraniTrener = null;
            console.log($scope.odabraniTrener);
        }

        $scope.selektuj = function (korisnik) {
            $scope.odabrani = korisnik;
        }

        $scope.otkazi = function (korisnik) {
            $scope.odabrani = null;
        }


        $scope.izlistajSveOsobe = function () {
            console.log($localStorage.token);
            var urlSveOsobe = serviceBase + 'korisnici/osobe/svi';

            $http({
                method: 'GET', url: urlSveOsobe, headers: {
                    'Authorization': $localStorage.token,
                }
            })
        .success(function (data) {
            $scope.listaOsoba = data;
        })
        };

        $scope.izlistajSveTrenere = function () {
            console.log($localStorage.token);
            var urlSviTreneri = serviceBase + 'korisnici/treneri/svi';

            $http({
                method: 'GET', url: urlSviTreneri, headers: {
                    'Authorization': $localStorage.token,
                }
            })
        .success(function (data) {
            $scope.listaTrenera = data;
        })
        };

        $scope.dodajTrenera = function (spol, godine, edukacija, iskustvo) {
            console.log($localStorage.token);
            if (godine >= 18 && iskustvo > 0) {
                var urlDodajTrenera = serviceBase + 'korisnici/treneri/dodaj/' + spol + '/' + godine + '/' + edukacija + '/' + iskustvo + '/0/' + odabrani.id;
                console.log(urlDodajTrenera);
                $http({
                    method: 'GET', url: urlDodajTrenera, headers: {
                        'Authorization': $localStorage.token,
                    }
                })
            .success(function (data) {
                $scope.message = "Trener uspješno dodan!";
            })
            }
            else alert("Trener mora biti punoljetan.\nIskustvo mora biti pozitivan broj.");
        };

        $scope.izmijeniTrenera = function (trener) {
            $scope.trenerRandom = trener;
            console.log($localStorage.token);
            if (godine >= 18 && iskustvo > 0) {
                var urlIzmijeniTrenera = serviceBase + '/treneri/update/' + $scope.trenerRandom.id + '/' + $scope.trenerRandom.spol
                    + '/' + $scope.trenerRandom.godine + '/' + $scope.trenerRandom.edukacija +
                    '/' + $scope.trenerRandom.iskustvo + '/' + $scope.trenerRandom.broj_klijenta + '/'
                    + $scope.trenerRandom.osoba.id;
                console.log(urlIzmijeniTrenera);
                $http({
                    method: 'GET', url: urlIzmijeniTrenera, headers: {
                        'Authorization': $localStorage.token,
                    }
                })
            .success(function (data) {
                $scope.message = "Trener uspješno izmijenjen!";
            })
            }
            else alert("Trener mora biti punoljetan.\nIskustvo mora biti pozitivan broj.");
        };

    }]);
}());

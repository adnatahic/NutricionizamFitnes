(function () {
    var NutricionizamFitnes = angular.module('NutricionizamFitnes');

    NutricionizamFitnes.controller('treneriCtrl', ['$scope', '$http', '$localStorage', 'treneriServis', function ($scope, $http, $localStorage, treneriServis) {
        var odabrani = null;
        var odabraniTrener = null;
        var serviceBase = "http://localhost:8081/";
        $scope.listaTrenera = [];
        $scope.listaOsoba = [];

        $scope.selektujTrenera = function (trener) {
            odabraniTrener = trener;
            console.log(odabraniTrener);
        }

        $scope.otkaziTrener = function () {
            odabraniTrener = null;
        }

        $scope.selektuj = function (korisnik) {
            odabrani = korisnik;
        }
     
        $scope.otkazi = function (korisnik) {
            odabrani = null;
        }
        
        
        $scope.izlistajSveOsobe = function () {
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

        $scope.izlistajSveTrenere = function () {
            console.log($localStorage.nesto);
            var urlSviTreneri = serviceBase + 'korisnici/treneri/svi';

            $http({
                method: 'GET', url: urlSviTreneri, headers: {
                    'Authorization': $localStorage.nesto,
                }
            })
        .success(function (data) {
            $scope.listaTrenera = data;
        })
        };

        $scope.dodajTrenera = function (spol, godine, edukacija, iskustvo) {
            console.log($localStorage.nesto);
            var urlDodajTrenera = serviceBase + 'korisnici/treneri/dodaj/' + spol +'/'+ godine + '/' + edukacija + '/' + iskustvo + '/0/' + odabrani.id;
            console.log(urlDodajTrenera);
            $http({
                method: 'GET', url: urlDodajTrenera, headers: {
                    'Authorization': $localStorage.nesto,
                }
            })
        .success(function (data) {
            $scope.message = "Trener uspješno dodan!";
        })
        };

        }]);
    }());

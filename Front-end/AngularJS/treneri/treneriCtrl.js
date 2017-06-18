(function () {
    var NutricionizamFitnes = angular.module('NutricionizamFitnes');

    NutricionizamFitnes.controller('treneriCtrl', ['$scope', '$http', '$localStorage', 'treneriServis', function ($scope, $http, $localStorage, treneriServis) {
        
        var serviceBase = "http://localhost:8081/";
        $scope.listaTrenera = [];
        $scope.listaOsoba = [];

        $scope.trener =
            {
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
            console.log($scope.odabraniTrener);
        }

        $scope.otkaziTrener = function () {
            $scope.odabraniTrener = null;
        }

        $scope.selektuj = function (korisnik) {
            $scope.odabrani = korisnik;
        }
     
        $scope.otkazi = function (korisnik) {
            $scope.odabrani = null;
        }

        $scope.izbrisiTrenera = function (id) {
            console.log($localStorage.nesto);
            var urlSveOsobe = serviceBase + 'korisnici/treneri/izbrisi/' + id;

            $http({
                method: 'GET', url: urlSveOsobe, headers: {
                    'Authorization': $localStorage.nesto,
                }
            })
        .success(function (data) {
            $scope.listaOsoba = data;
        })
            
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

        $scope.dodajTrenera = function (trener) {
            $scope.trener = trener;
            console.log($localStorage.nesto);
            var urlDodajTrenera = serviceBase + 'korisnici/treneri/dodaj/' + $scope.trener.spol + '/' + $scope.trener.godine 
                + '/' + $scope.trener.edukacija + '/' + $scope.trener.iskustvo + '/' + $scope.trener.brojKlijenata + '/' + $scope.trener.osoba.id;
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

        $scope.izmijeniTrenera = function (trener) {
            $scope.trener = trener;
            console.log($localStorage.nesto);
            var urlDodajTrenera = serviceBase + 'korisnici/treneri/update/'+ $scope.trener.id +"/"+ $scope.trener.spol + '/' + $scope.trener.godine
                + '/' + $scope.trener.edukacija + '/' + $scope.trener.iskustvo + '/' + $scope.trener.brojKlijenata +'/'+ + $scope.trener.osoba.id;
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

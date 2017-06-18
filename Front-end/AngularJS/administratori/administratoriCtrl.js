(function () {
    var NutricionizamFitnes = angular.module('NutricionizamFitnes');

    NutricionizamFitnes.controller('administratoriCtrl', ['$scope', 'administratoriServis', '$window', function ($scope, administratoriServis, $window) {

     

        $scope.administrator =
            {
                id: "",
                osoba: {
                    id: "",
                    email: "",
                    ime: "",
                    password: "",
                    prezime: "",
                    username: ""
                }

            };

        $scope.administratori =
            [
                {
                    id: "",
                    osoba: {
                        id: "",
                        email: "",
                        ime: "",
                        password: "",
                        prezime: "",
                        username: ""
                    }

                }
            ];

       

        $scope.selektuj = function (korisnik) {
            $scope.administrator = korisnik;
            administratoriServis.list("administrator/izbrisi/" + $scope.administrator.id ,
                function (data) {
                    if (data) {
                        $scope.administratori = data;
                    }
                });
        }
   
        $scope.editujKorisnika = function (korisnik) {
            $scope.korisnik = korisnik;
            urlkorisnik = "korisnik/update/" + $scope.korisnik.id + "/" + $scope.korisnik.spol + "/" + $scope.korisnik.godine + "/" + $scope.korisnik.visina + "/" + $scope.korisnik.tezina + "/" + $scope.korisnik.zeljenaKilaza + "/"
            + $scope.korisnik.bolesti + "/"
            + $scope.korisnik.trener.id + "/"
            + $scope.korisnik.osoba.id;
            administratoriServis.list(urlkorisnik,
                function (data) {
                    if (data) {
                        alert("proslo");
                    }
                });
        }

        $scope.dodajKorisnika = function (korisnik) {
            $scope.korisnik = korisnik;
            var d = new Date();
            var datestring = d.getFullYear() + " " + (d.getMonth() + 1) + "-" + (d.getDay + 1);
            urlkorisnik = "korisnik/dodaj/" + $scope.korisnik.spol + "/" + $scope.korisnik.godine + "/" + $scope.korisnik.visina + "/"
                + $scope.korisnik.tezina + "/" + $scope.korisnik.zeljenaKilaza + "/"
            + $scope.korisnik.bolesti + "/"
            + $scope.korisnik.trener.id + "/"
            + $scope.korisnik.osoba.id;
            administratoriServis.list(urlkorisnik,
                function (data) {
                    if (data) {
                        alert("proslo");
                    }
                });
        }

        $scope.otkazi = function (korisnik) {
            $scope.odabrani = null;

        }


        $scope.otkaziKorisnici = function () {
            $scope.korisnik = null;
            $window.location.href = '#/korisnici';
        }



        $scope.init = function () {
            administratoriServis.list("administrator/svi",
                function (data) {
                    if (data) {
                        $scope.administratori = data;
                    }
                });

        };
        $scope.init2 = function () {
            administratoriServis.list("treneri/svi",
                function (data) {
                    if (data) {
                        $scope.treneri = data;
                    }
                });

            korisniciServis.list("osobe/svi",
                function (data) {
                    if (data) {
                        $scope.osobe = data;
                    }
                });


        };

        $scope.ucitajDodajNovog = function () {

            $window.location.href = '#/dodajNovogKorisnika';

        };

    }]);
}());

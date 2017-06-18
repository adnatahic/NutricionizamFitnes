(function () {
    var NutricionizamFitnes = angular.module('NutricionizamFitnes');

    NutricionizamFitnes.controller('korisniciCtrl', ['$scope', 'korisniciServis', '$window', '$route', function ($scope, korisniciServis, $window, $route) {

        $scope.korisnici =
        [
            {

            }
        ];

        $scope.osobe =
            [
                {
                    id: "",
                    email: "",
                    ime: "",
                    password: "",
                    prezime: "",
                    username: ""
                }
            ];

        $scope.korisnik =
        {
            id: "",
            bolesti: "",
            datumPristupa: "",
            godine: "",
            spol: "",
            tezina: "",
            visina: "",
            osoba: {
                id: "",
                email: "",
                ime: "",
                password: "",
                prezime: "",
                username: ""
            },
            trener: {
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
            }

        };

        $scope.treneri =
            [
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
                }
            ];

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

        $scope.trening =
            {

                id: "",
                opis: "",
                trajanje: "",
                vrsta: "",
                korisnik: {
                    id: "",
                    bolesti: "",
                    datumPristupa: "",
                    godine: "",
                    spol: "",
                    tezina: "",
                    visina: "",
                    zeljenaTezina: "",
                    osoba: {
                        id: "",
                        email: "",
                        ime: "",
                        password: "",
                        prezime: "",
                        username: ""
                    },
                    trener: {
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
                    }
                }
            };

        $scope.ishrana =
           {
               id: "",
               dorucak: "",
               rucak: "",
               uzina1: "",
               uzina2: "",
               vecera: "",
               korisnik: {
                   id: 1,
                   bolesti: "",
                   datumPristupa: "",
                   godine: "",
                   spol: "",
                   tezina: "",
                   visina: "",
                   zeljenaTezina: "",
                   osoba: {
                       id: "",
                       email: "",
                       ime: "",
                       password: "",
                       prezime: "",
                       username: ""
                   },
                   trener: {
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
                   }
               }
           };

        $scope.selektuj = function (korisnik) {
            $scope.odabrani = korisnik;
        }
        //TODO
        $scope.editujKorisnika = function (korisnik) {
            $scope.korisnik = korisnik;
            urlkorisnik = "korisnik/update/" + $scope.korisnik.id + "/" + $scope.korisnik.spol + "/" + $scope.korisnik.godine + "/" + $scope.korisnik.visina + "/" + $scope.korisnik.tezina + "/" + $scope.korisnik.zeljenaKilaza + "/"
            + $scope.korisnik.bolesti + "/"
            + $scope.korisnik.trener.id + "/"
            + $scope.korisnik.osoba.id;
            korisniciServis.list(urlkorisnik,
                function (data) {
                    if (data) {
                        alert("proslo");
                    }
                });
        }


        $scope.planiprogram = function (neki_korisnik) {

            $scope.korisnik_trener = neki_korisnik;
            $scope.trening.korisnik = neki_korisnik;

        }

        $scope.dodajPlaniprogram = function (korisnik) {
            $scope.trening = korisnik;
            urlkorisnik = "treninzi/dodaj/" + $scope.trening.korisnik.id + "/"
            + $scope.trening.trajanje + "/"
            + $scope.trening.vrsta + "/"
            + $scope.trening.opis;

            korisniciServis.listapp(urlkorisnik,
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
            korisniciServis.list(urlkorisnik,
                function (data) {
                    if (data) {
                        alert("Uspješno dodan korisnik!");
                        $window.location.href = '#/korisnici';
                    }
                });
        }

        $scope.otkazi = function (korisnik) {
            $scope.odabrani = null;
            $scope.ishrana = null;
            

        }


        $scope.ishranaFun = function (korisnik) {
            $scope.ishrana.korisnik = korisnik;
        }


        $scope.dodajPlanIshrane = function (ishrana) {
            $scope.ishrana = ishrana;

            urlkorisnik = "ishrana/dodaj/" + $scope.ishrana.dorucak + "/" + $scope.ishrana.rucak
                + "/" + $scope.ishrana.vecera + "/"
                + $scope.ishrana.uzina1 + "/" + $scope.ishrana.uzina2 + "/" + $scope.ishrana.korisnik.id;
            korisniciServis.listapp(urlkorisnik,
                function (data) {
                    alert("Uspješno kreiran plan ishrane!");
                    if (data) {
                        alert("Uspješno dodan plan ishrane!");
                        $window.location.href = '#/korisnici';
                    }
                });
        }

        $scope.otkaziKorisnici = function () {
            $scope.korisnik = null;
            $window.location.href = '#/korisnici';
        }



        $scope.init = function () {
            korisniciServis.list("korisnik/svi",
                function (data) {
                    if (data) {
                        $scope.korisnici = data;
                    }
                });

        };

        $scope.izbrisi = function (korisnik) {
            $scope.korisnik = korisnik;
            korisniciServis.list("korisnik/izbrisi/" + $scope.korisnik.id,
                function (data) {
                    if (data) {
                        $scope.korisnici = data;
                        alert("Uspješno izbrisan korisnik sa id-em: " + $scope.korisnik.id);
                        $route.reload();
                    }
                });

            $window.location.href = '#/korisnici';

        };
        $scope.init2 = function () {
            korisniciServis.list("treneri/svi",
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
            s

            $window.location.href = '#/dodajNovogKorisnika';

        };

    }]);
}());

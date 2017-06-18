(function () {
    var NutricionizamFitnes = angular.module('NutricionizamFitnes');

    NutricionizamFitnes.controller('statistikaCtrl', ['$scope', 'statistikaServis', '$http', '$localStorage', function ($scope, statistikaServis, $http, $localStorage) {

        var serviceBase = "http://localhost:8083/statistika/";

        $scope.rejting =
           {
               id: "",
               korisnik: "",
               trener: "",
               ocjena:""
           };

        $scope.init = function () {
            
            var urlSveOsobe = serviceBase + 'rejting/svi';

            $http({
                method: 'GET', url: urlSveOsobe, headers: {
                    'Authorization': $localStorage.nesto,
                }
            })
        .success(function (data) {
            $scope.listaRejtinga = data;
        })
        };

        $scope.ucitajPotrebno = function ()
        {
            $scope.korisnik();
            $scope.treneri();
        }

        $scope.korisnik = function () {

            var urlSveOsobe = serviceBase+ 'korisnik/svi';

            $http({
                method: 'GET', url: urlSveOsobe, headers: {
                    'Authorization': $localStorage.nesto,
                }
            })
        .success(function (data) {
            $scope.korisnici = data;
        })
        };

        $scope.dodajRejting = function (rejting) {
            $scope.rejting = rejting;

            var urlSveOsobe = serviceBase + 'rejting/dodaj/' + $scope.rejting.korisnik + '/'
            + $scope.rejting.trener + '/'
            + $scope.rejting.ocjena;

            $http({
                method: 'GET', url: urlSveOsobe, headers: {
                    'Authorization': $localStorage.nesto,
                }
            })
        .success(function (data) {
            $scope.rejting = data;
        })
        };


        $scope.treneri = function () {

            var urlSveOsobe =serviceBase+ 'treneri/svi';

            $http({
                method: 'GET', url: urlSveOsobe, headers: {
                    'Authorization': $localStorage.nesto,
                }
            })
        .success(function (data) {
            $scope.treneri = data;
        })
        };

    }]);

    NutricionizamFitnes.directive('starRating', function () {
        return {
            restrict: 'A',
            template: '<ul class="rating">' +
                '<li ng-repeat="star in stars" ng-class="star">' +
                '\u2605' +
                '</li>' +
                '</ul>',
            scope: {
                ratingValue: '=',
                max: '='
            },
            link: function (scope, elem, attrs) {
                scope.stars = [];
                for (var i = 0; i < scope.max; i++) {
                    scope.stars.push({
                        filled: i < scope.ratingValue
                    });
                }
            }
        }
    });
}());



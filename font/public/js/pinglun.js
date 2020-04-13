var app = angular.module('myApp', []);
app.controller('pinglun', function($scope,$compile, $http) {
    console.log(photoId)
    var vm=$scope
    $http({
        method: 'GET',
        url: 'http://localhost:8080/action/getPingLun?photoId='+photoId,
    }).then(function (response) {
        vm.pinglun=response.data.data
        var template=
            "    <script type=\"text/javascript\" src=\"js/star.js\"></script>\n" +
            "    <script type=\"text/javascript\" src=\"js/dan.js\"></script>"
       setTimeout(function () {
           $(".screen").append(template)

       },1)

    }, function (response) {
    });
        vm.add=function () {
        if(vm.ping!=null && vm.ping!='') {
            $http({
                method: 'POST',
                url: 'http://localhost:8080/action/pingLun',
                data: {
                    phone: phone,
                    photoId: photoId,
                    pinglun: vm.ping
                }
            }).then(function (response) {

            }, function (response) {
            });
        }
    }
}).directive('compile', function ($compile) {
    return function (scope, element, attrs) {
        scope.$watch(
            function (scope) {

                return scope.$eval(attrs.compile);
            },
            function (value) {
                element.html(value);
                $compile(element.contents())(scope);
            }
        );
    };
});

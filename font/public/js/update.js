var myApp = angular.module('recommand', ['ngCookies'])

myApp.controller('loginController', ['$scope', '$http', '$templateCache','$cookies','$cookieStore', function ($scope, $http, $templateCache,$cookies, $cookieStore) {
    var vm = $scope;
   vm.user=$cookieStore.get("user");
    vm.check_zh=function(){
        vm.loginUser=vm.loginUser.replace(/[\u4E00-\u9FA5]|[\uFE30-\uFFA0]/g,'');
    }
    function checkMobile(){

        var myreg=/^[1][3,4,5,7,8][0-9]{9}$/;
        if (!myreg.test(vm.user.username)) {
            swal("OMG!", "请填写正确的手机号", "error");
            return false;
        } else {
            return true;
        }
    }



    function checkPass(){

        var patrn=/^(\w){6,20}$/;
        if (!patrn.exec(vm.user.password)) {

            swal("OMG!", "只能输入6-20个字母、数字、下划线", "error");
            return false
        }
        return true
    }
    vm.update = function () {
        console.log(vm.user)
        if(checkMobile()){
            if(checkPass()){


                $http({
                    method: 'POST',
                    url: 'http://localhost:8080/user/update',
                    data: vm.user
                }).then(function (response) {

                    var status = response.data.code
                    if (status != 200) {
                        swal("OMG!", response.data.message, "error");

                    } else {
                        $cookieStore.put("user",vm.user)
                        swal({
                            title: "Good!",
                            text: '修改成功，即将为您跳转到首页',
                            imageUrl: "images/thumbs-up.jpg",
                            html: true,
                            timer: 3000,
                            showConfirmButton: false
                        });
                        setTimeout(function () {
                            window.location.href = "/";
                        },3000)

                    }

                }, function (response) {
                    console.log(response)
                });

            }

        }

        // checkPass()

    }




}]);

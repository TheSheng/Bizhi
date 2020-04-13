var myApp = angular.module('recommand', ['ngCookies'])

myApp.controller('loginController', ['$scope', '$http', '$templateCache','$cookies','$cookieStore', function ($scope, $http, $templateCache,$cookies, $cookieStore) {
    var vm = $scope
    vm.username=""
    vm.password=""
    vm.imgUrl=""
    vm.pattern="/[/u0391-/uFFE5]/gi"
    vm.check_zh=function(){
        vm.loginUser=vm.loginUser.replace(/[\u4E00-\u9FA5]|[\uFE30-\uFFA0]/g,'');
    }
    function checkMobile(){

        var myreg=/^[1][3,4,5,7,8][0-9]{9}$/;
        if (!myreg.test(vm.username)) {
            swal("OMG!", "请填写正确的手机号", "error");
            return false;
        } else {
            return true;
        }
    }
    vm.saoma=function() {
        vm.maCount=0
        vm.maStatu=true
        $http({
            method: 'GET',
            url: 'http://129.211.63.167:8080/services/news/saveMa',

        }).then(function (response) {

              getMa()

        }, function (response) {

        });

    }
    vm.maCount=0
    vm.reset=function(){
        jQuery("#erweima").attr("src","images/erweima.jpg")
        vm.statu=false
        vm.maCount=0
        vm.saoma()

    }

    vm.input="请输入验证码"

    vm.code=""
    vm.userId=""
    vm.toIndex=function (){
        if(vm.code==''){
            swal("别急","还未收到短信验证码","error")
            return
        }
        if(vm.input!=vm.code){
            swal("错误","短信验证码错误","error")
            return
        }

         vm.loginByDanxin()
    }
    vm.loginByDanxin=function(){
        $http({
            method: 'POST',
            url: 'http://localhost:8080/user/getByPhone',
            data:{
                username:vm.username
            }

        }).then(function (response) {
            vm.userId=response.data.data
            $cookieStore.put("user",vm.userId)
            swal({
                title: "Good!",
                text: '登录成功，即将为您跳转到首页',
                imageUrl: "images/thumbs-up.jpg",
                html: true,
                timer: 3000,
                showConfirmButton: false
            });
            setTimeout(function () {
                window.location.href = "/";
            },2000)
        }, function (response) {
            //console.log(response.data)
        });


    }
    vm.sendDuanxin=function(){
        $http({
            method: 'POST',
            url: 'http://localhost:8080/sendDuanxin',
            data:{
                username:vm.username
            }

        }).then(function (response) {
            rs=response.data
            //console.log(rs)


            vm.code=rs.data





        }, function (response) {
            //console.log(response.data)
        });
    }

    vm.huoqu=function(){
       if(checkMobile()){
           $http({
               method: 'GET',
               url: 'http://localhost:8080/user/hasRegister?phone='+vm.username,

           }).then(function (response) {
               //console.log(response.data)
               var rs=response.data.code
                if(rs!=200){
                    swal("错误",response.data.message,"error")
                    return
                }
               // vm.userId=rs['body']
               //  //console.log(vm.userId)
               //
                 vm.sendDuanxin()


           }, function (response) {
               //console.log(response)
           });
           return
       }else{
           swal("错误","请输入正确的手机号","error")
       }

    }
   vm.changeMa=function(){

       vm.imgUrl='images/login.jpg'
        vm.maStatu=false
    }
  function toLogin() {
      window.location.href="/login"
  }
    function  getMa() {
        if(vm.maStatu==false){
            return
        }
        vm.maCount=vm.maCount+1
        if(vm.maCount>30){
            swal("错误","二维码已失效","error")
            jQuery("#erweima").attr("src","images/guoqi.jpg")
            return
        }

        $http({
            method: 'GET',
            url: 'http://129.211.63.167:8080/services/news/getMa',

        }).then(function (response) {
                var rs=response.data


            if(rs==false){
               setTimeout(getMa,1000)
                return
            }
            $cookieStore.put("user","43")
            swal("Good","成功登录！","success")
            setTimeout(function () {
                window.location.href = "/";
            },2000)


        }, function (response) {
            //console.log(response)
        });
    }
    function checkPass(){

        var patrn=/^(\w){6,20}$/;
        if (!patrn.exec(vm.password)) {

            swal("OMG!", "只能输入6-20个字母、数字、下划线", "error");
            return false
        }
        return true
    }
    vm.login = function () {
        if(checkMobile()){
            if(checkPass()){

                requestdata = {
                    username: vm.username,
                    password: vm.password
                }
                //console.log(requestdata)
                $http({
                    method: 'POST',
                    url: 'http://localhost:8080/user/login',
                    data: requestdata
                }).then(function (response) {

                    var status = response.data.code
                    if (status != 200) {
                        swal("OMG!", response.data.message, "error");

                    } else {
                        $cookieStore.put("user",response.data.data)
                        swal({
                            title: "Good!",
                            text: '登录成功，即将为您跳转到首页',
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
                    //console.log(response)
                });

            }

        }

        // checkPass()

    }

    vm.register = function () {
        if(checkMobile()){
            if(checkPass()){
                requestdata = {
                    username: vm.username,
                    password: vm.password,
                    url:vm.imgUrl
                }
                //console.log(requestdata)
                $http({
                    method: 'POST',
                    url: 'http://localhost:8080/user/register',

                    data: requestdata
                }).then(function (response) {
                    var status = response.data.code
                    if (status != "200") {
                        swal("OMG!", response.data.message, "error");
                    }
                     else {
                        $cookieStore.put("user",response.data.data)
                        swal({
                            title: "Good!",
                            text: '注册成功，即将为您跳转到首页',
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
                    //console.log(response)
                });

            }

        }

        // checkPass()

    }


}]);

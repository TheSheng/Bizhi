var myApp = angular.module('recommand', ['ngCookies'])

myApp.controller('indexController', ['$scope', '$http', '$templateCache', '$cookies', '$cookieStore', '$compile', function ($scope, $http, $templateCache, $cookies, $cookieStore, $compile) {
    var vm = $scope
    var cookie = $cookieStore
    var contains = function(arr,obj) {
        var i = arr.length;
        while (i--) {
            if (arr[i] === obj) {
                return true;
            }
        }
        return false;
    }
    vm.user = cookie.get("user");
    if(null==vm.user){
        window.location.href="/login"
    }
    vm.isShuju=false
    vm.shuju=function(){
        vm.isShuju=true
    }

    vm.contain=function(type,newsId){
        newsId=newsId.toString()
        if(type=='zan'){
            if(contains(vm.zan,newsId)){
                return true
            }
            return  false
        }
        if(contains(vm.shoucang,newsId)){
            return true
        }
        return  false


    }

    vm.actionLeft=function(type,newsId,i){

        newsId=newsId.toString()
        if(type=='zan'){
          vm.zan.push(newsId)
            vm.leftList[i].zan=vm.leftList[i].zan+1
        }else if(type=='clearzan'){
           let index=vm.zan.indexOf(newsId)
           vm.zan.splice(index,1)
            vm.leftList[i].zan=vm.leftList[i].zan-1

        }else if(type=='shoucang'){
            vm.shoucang.push(newsId)
            vm.leftList[i].shoucang=vm.leftList[i].shoucang+1

        }else if(type=='clearshoucang'){
            let index=vm.shoucang.indexOf(newsId)
            vm.shoucang.splice(index,1)
            vm.leftList[i].shoucang=vm.leftList[i].shoucang-1
        }
        $http({
            method: 'GET',
            url: 'http://localhost:8080/action/action?username='+vm.user.username+'&type='+type+'&photoId='+newsId,
        }).then(function (response) {
        }, function (response) {
        });



    }
    vm.actionZhong=function(type,newsId,i){

        newsId=newsId.toString()
        if(type=='zan'){
            vm.zan.push(newsId)
            vm.zhongList[i].zan=vm.zhongList[i].zan+1
        }else if(type=='clearzan'){
            let index=vm.zan.indexOf(newsId)
            vm.zan.splice(index,1)
            vm.zhongList[i].zan=vm.zhongList[i].zan-1

        }else if(type=='shoucang'){
            vm.shoucang.push(newsId)
            vm.zhongList[i].shoucang=vm.zhongList[i].shoucang+1

        }else if(type=='clearshoucang'){
            let index=vm.shoucang.indexOf(newsId)
            vm.shoucang.splice(index,1)
            vm.zhongList[i].shoucang=vm.zhongList[i].shoucang-1
        }
        $http({
            method: 'GET',
            url: 'http://localhost:8080/action/action?username='+vm.user.username+'&type='+type+'&photoId='+newsId,
        }).then(function (response) {
        }, function (response) {
        });



    }
    vm.actionRight=function(type,newsId,i){

        newsId=newsId.toString()
        if(type=='zan'){
            vm.zan.push(newsId)
            vm.rightList[i].zan=vm.rightList[i].zan+1
        }else if(type=='clearzan'){
            let index=vm.zan.indexOf(newsId)
            vm.zan.splice(index,1)
            vm.rightList[i].zan=vm.rightList[i].zan-1

        }else if(type=='shoucang'){
            vm.shoucang.push(newsId)
            vm.rightList[i].shoucang=vm.rightList[i].shoucang+1

        }else if(type=='clearshoucang'){
            let index=vm.shoucang.indexOf(newsId)
            vm.shoucang.splice(index,1)
            vm.rightList[i].shoucang=vm.rightList[i].shoucang-1
        }
        $http({
            method: 'GET',
            url: 'http://localhost:8080/action/action?username='+vm.user.username+'&type='+type+'&photoId='+newsId,
        }).then(function (response) {
        }, function (response) {
        });



    }
    vm.actionLast=function(type,newsId,i){

        newsId=newsId.toString()
        if(type=='zan'){
            vm.zan.push(newsId)
            vm.lastList[i].zan=vm.lastList[i].zan+1
        }else if(type=='clearzan'){
            let index=vm.zan.indexOf(newsId)
            vm.zan.splice(index,1)
            vm.lastList[i].zan=vm.lastList[i].zan-1

        }else if(type=='shoucang'){
            vm.shoucang.push(newsId)
            vm.lastList[i].shoucang=vm.lastList[i].shoucang+1

        }else if(type=='clearshoucang'){
            let index=vm.shoucang.indexOf(newsId)
            vm.shoucang.splice(index,1)
            vm.lastList[i].shoucang=vm.lastList[i].shoucang-1
        }
        $http({
            method: 'GET',
            url: 'http://localhost:8080/action/action?username='+vm.user.username+'&type='+type+'&photoId='+newsId,
        }).then(function (response) {
        }, function (response) {
        });



    }
    vm.showTextLast=function(photoId,index){
        layer.open({
            title:false,
            type: 2,
            area: ['700px', '450px'],
            closeBtn:2,
            content: 'pinglun?photoId='+photoId+'&phone='+vm.user.username,
            cancel: function(){
                $http({
                    method: 'GET',
                    url: 'http://localhost:8080/action/getPingLunNum?photoId='+photoId,
                }).then(function (response) {
                    vm.lastList[index].pinglun=response.data.data
                }, function (response) {
                });
             },
            skin: 'layui-layer-molv'
        });
    }


    vm.showTextRight=function(photoId,index){
        layer.open({
            title:false,
            type: 2,
            area: ['700px', '450px'],
            closeBtn:2,
            content: 'pinglun?photoId='+photoId+'&phone='+vm.user.username,
            cancel: function(){
                $http({
                    method: 'GET',
                    url: 'http://localhost:8080/action/getPingLunNum?photoId='+photoId,
                }).then(function (response) {
                    vm.rightList[index].pinglun=response.data.data
                }, function (response) {
                });
            },
            skin: 'layui-layer-molv'
        });
    }
    vm.showTextZhong=function(photoId,index){
        layer.open({
            title:false,
            type: 2,
            area: ['700px', '450px'],
            closeBtn:2,
            content: 'pinglun?photoId='+photoId+'&phone='+vm.user.username,
            cancel: function(){
                $http({
                    method: 'GET',
                    url: 'http://localhost:8080/action/getPingLunNum?photoId='+photoId,
                }).then(function (response) {
                    vm.zhongList[index].pinglun=response.data.data
                }, function (response) {
                });
            },
            skin: 'layui-layer-molv'
        });
    }
    vm.showTextLeft=function(photoId,index){
        layer.open({
            title:false,
            type: 2,
            area: ['700px', '450px'],
            closeBtn:2,
            content: 'pinglun?photoId='+photoId+'&phone='+vm.user.username,
            cancel: function(){
                $http({
                    method: 'GET',
                    url: 'http://localhost:8080/action/getPingLunNum?photoId='+photoId,
                }).then(function (response) {
                    vm.leftList[index].pinglun=response.data.data
                }, function (response) {
                });
            },
            skin: 'layui-layer-molv'
        });
    }
    vm.local = ""
    $(".lan").click(function () {

        $(".active").removeClass("active")
        $(this).addClass("active")
        showMessage('看来你对' + $(this).text() + '更感兴趣');


    })
    vm.showMotai=false

    vm.member=function(){
         vm.showMotai=true

    }







    now = new Date(), hour = now.getHours()
    if (hour < 6) {
        vm.local = "凌晨好！"
    } else if (hour < 9) {
        vm.local = "早上好！"
    } else if (hour < 12) {
        vm.local = "上午好！"
    } else if (hour < 14) {
        vm.local = "中午好！"
    } else if (hour < 17) {
        vm.local = "下午好！"
    } else if (hour < 19) {
        vm.local = "傍晚好！"
    } else if (hour < 22) {
        vm.local = "晚上好！"
    } else {
        vm.local = "夜里好！"
    }


    vm.type = "人物明星"
    vm.page = 1;
    vm.size = 8;
    vm.out=function(){
        $cookieStore.remove("user")
        window.location.href="/login"
    }
    vm.newslist = new Array()
    vm.editTag = function (type) {
        vm.type = type
        vm.page=1
        vm.newslist=new Array()
        vm.leftList=new Array();
        vm.zhongList=new Array();
        vm.rightList=new Array();
        vm.lastList=new Array();
        vm.getnews()
    }
    vm.showAuthor=function(author){
        $(".active").removeClass("active")
        scrollTo(0, 0);
        vm.type = "作者"
        vm.page=0
        vm.newslist=new Array()
        vm.leftList=new Array();
        vm.zhongList=new Array();
        vm.rightList=new Array();
        vm.lastList=new Array();
        $http({
            method: 'GET',
            url: 'http://localhost:8080/photo/getByAuthor?author='+author,
        }).then(function (response) {
            // console.log(response.data)
            var newarray = response.data.data

            newarray.forEach(x =>
                vm.newslist.push(x)
            )
            vm.leftList=new Array();
            vm.zhongList=new Array();
            vm.rightList=new Array();
            vm.lastList=new Array();

            for(var i=0;i<vm.newslist.length;i++){
                if(i%4==0){
                    vm.leftList.push(vm.newslist[i])
                }
                else if(i%4==1){
                    vm.zhongList.push(vm.newslist[i])
                }
                else if(i%4==2){
                    vm.rightList.push(vm.newslist[i])
                }else if(i%4==3){
                    vm.lastList.push((vm.newslist[i]))
                }
            }

            // for(var i=0;i<vm.newslist.length;i++)
            // {
            //     vm.getHeight(i)
            // }




        }, function (response) {
        });


    }
    vm.like=null
    $('.form-control').bind('keyup', function(event) {
        if (event.keyCode == "13") {
            //回车执行查询
            vm.showEnter()
        }
    });
    vm.showEnter=function(){
        if(vm.like==null || vm.like==""){
            vm.like=null
            return
        }
        $(".active").removeClass("active")

        scrollTo(0, 0);
        vm.type = "查找"
        vm.page=0
        vm.newslist=new Array()
        vm.leftList=new Array();
        vm.zhongList=new Array();
        vm.rightList=new Array();
        vm.lastList=new Array();
        $http({
            method: 'GET',
            url: 'http://localhost:8080/photo/getByLike?like='+vm.like,
        }).then(function (response) {
            vm.like=null
            // console.log(response.data)
            var newarray = response.data.data
            if(newarray.length==0){
                swal("抱歉","没有找到您想要的信息，看点别的吧")
                return
            }
            newarray.forEach(x =>
                vm.newslist.push(x)
            )
            vm.leftList=new Array();
            vm.zhongList=new Array();
            vm.rightList=new Array();
            vm.lastList=new Array();

            for(var i=0;i<vm.newslist.length;i++){
                if(i%4==0){
                    vm.leftList.push(vm.newslist[i])
                }
                else if(i%4==1){
                    vm.zhongList.push(vm.newslist[i])
                }
                else if(i%4==2){
                    vm.rightList.push(vm.newslist[i])
                }else if(i%4==3){
                    vm.lastList.push((vm.newslist[i]))
                }
            }


            // var str = str($(window).html());
            // var newstr = str.replace(reg, "<font color=red>$1</font>");
            // document.write(newstr + "<br />");


            // for(var i=0;i<vm.newslist.length;i++)
            // {
            //     vm.getHeight(i)
            // }




        }, function (response) {
        });


    }

    vm.getClass=function(index)
    {
        if(index%4==0){
            return "left"
        }else if(index%4==1){
            return "zhong"
        }else{
            return "right"
        }
    }
    vm.totalPage=100;
    vm.leftList=new Array();
    vm.zhonglist=new Array();
    vm.rightList=new Array();
    vm.lastList=new Array();

    vm.getnews = function () {

        if(vm.page>vm.totalPage){
            showMessage('暂时没有更多了，一会再来看看吧');

            return
        }

        $http({
            method: 'POST',
            url: 'http://localhost:8080/photo/getByType',
            data: {
                "page": vm.page,
                "size": vm.size,
                "type": vm.type
            }
        }).then(function (response) {
            // console.log(response.data)

            vm.page = vm.page + 1
            var newarray = response.data.data.list
            vm.totalPage=response.data.data.totalPage


            newarray.forEach(x =>
                vm.newslist.push(x)
            )
            vm.leftList=new Array();
            vm.zhongList=new Array();
            vm.rightList=new Array();
            vm.lastList=new Array();

            for(var i=0;i<vm.newslist.length;i++){
                if(i%4==0){
                    vm.leftList.push(vm.newslist[i])
                }
                else if(i%4==1){
                    vm.zhongList.push(vm.newslist[i])
                }
                else if(i%4==2){
                    vm.rightList.push(vm.newslist[i])
                }else if(i%4==3){
                    vm.lastList.push((vm.newslist[i]))
                }
            }

            // for(var i=0;i<vm.newslist.length;i++)
            // {
            //     vm.getHeight(i)
            // }




        }, function (response) {

            scrollTo(0, 0);
        });
    }
    vm.getAction = function (type) {
        vm.type = "action"
        vm.page=0
        vm.newslist=new Array()
        vm.leftList=new Array();
        vm.zhongList=new Array();
        vm.rightList=new Array();
        vm.lastList=new Array();

        $http({
            method: 'GET',
            url: 'http://localhost:8080/action/getUserAction?type='+type+'&user='+vm.user.username,

        }).then(function (response) {
            // console.log(response.data)

            var newarray = response.data.data
            newarray.forEach(x =>
                vm.newslist.push(x)
            )
            vm.leftList=new Array();
            vm.zhongList=new Array();
            vm.rightList=new Array();
            vm.lastList=new Array();

            for(var i=0;i<vm.newslist.length;i++){
                if(i%4==0){
                    vm.leftList.push(vm.newslist[i])
                }
                else if(i%4==1){
                    vm.zhongList.push(vm.newslist[i])
                }
                else if(i%4==2){
                    vm.rightList.push(vm.newslist[i])
                }else if(i%4==3){
                    vm.lastList.push((vm.newslist[i]))
                }
            }

            // for(var i=0;i<vm.newslist.length;i++)
            // {
            //     vm.getHeight(i)
            // }




        }, function (response) {

            scrollTo(0, 0);
        });
    }

    vm.downImg=function(index,urlString,down){
        window.location.href='http://localhost:8080/photo/down?urlString='+urlString;
       var num=Number($(".dynamic-feed-item .more-action span").eq(index).html())
        $(".dynamic-feed-item .more-action  span").eq(index).html(num+1)
    }

    vm.downShow=function(index,last){
        $(".button").eq(last+index).css({
            display:"block"
        })
    }
    vm.downClear=function(index,last){
        $(".button").eq(last+index).css({
            display:"none"
        })
    }

    $http({
        method: 'GET',
        url: 'http://localhost:8080/action/getZanShoucang?username='+vm.user.username,
    }).then(function (response) {
        console.log(response.data)
        vm.zan=response.data.data.zan
        vm.shoucang=response.data.data.shoucang
        vm.getnews()
    }, function (response) {
    });



    $(window).scroll(function () {
            if(vm.type=="作者"){
                showMessage("作者只有这么多哦")
                return
            }
        if(vm.type=="查找"){
            showMessage("只能查到这么多哦")
            return
        }
        if(vm.type=="action"){
            showMessage("只能查到这么多哦")
            return
        }
            var scrollTop = $(this).scrollTop();
            var scrollHeight = $(document).height();
            var windowHeight = $(this).height();
            if (scrollTop + windowHeight == scrollHeight) {

                    vm.getnews()

            }


    });
}]);



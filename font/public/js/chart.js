var myApp = angular.module('chart', [])

myApp.controller('chartController', ['$scope', '$http', '$templateCache','$interval', function ($scope, $http, $templateCache,$interval) {
    var vm = $scope;

    var violet = '#DF99CA',
        red    = '#F0404C',
        green  = '#7CF29C';
     var   one ="#3150F2";
     var    two="#F266EC";

    // ------------------------------------------------------- //
    // Charts Gradients
    // ------------------------------------------------------ //
    var ctx1 = $("canvas").get(0).getContext("2d");
    var gradient1 = ctx1.createLinearGradient(150, 0, 150, 300);
    gradient1.addColorStop(0, 'rgba(210, 114, 181, 0.91)');
    gradient1.addColorStop(1, 'rgba(177, 62, 162, 0)');

    var gradient2 = ctx1.createLinearGradient(10, 0, 150, 300);
    gradient2.addColorStop(0, 'rgba(252, 117, 176, 0.84)');
    gradient2.addColorStop(1, 'rgba(250, 199, 106, 0.92)');
    var LINECHARTEXMPLE   = $('#lineChartExample');
    var lineChartExample = new Chart(LINECHARTEXMPLE, {
        type: 'line',
        options: {
            legend: {labels:{fontColor:"#777", fontSize: 12}},
            scales: {
                xAxes: [{
                    display: true,
                    gridLines: {
                        color: '#fff'
                    }
                }],
                yAxes: [{
                    display: true,

                    gridLines: {
                        color: '#fff'
                    }
                }]
            },
            responsive: true
        },
        data: {
            datasets: [
                {
                    label: "壁纸数目统计",
                    fill: true,
                    lineTension: 0.3,
                    backgroundColor: gradient1,
                    borderColor: 'rgba(210, 114, 181, 0.91)',
                    borderCapStyle: 'butt',
                    borderDash: [],
                    borderDashOffset: 0.0,
                    borderJoinStyle: 'miter',
                    borderWidth: 2,
                    pointBorderColor: gradient1,
                    pointBackgroundColor: "#fff",
                    pointBorderWidth: 2,
                    pointHoverRadius: 5,
                    pointHoverBackgroundColor: gradient1,
                    pointHoverBorderColor: "rgba(220,220,220,1)",
                    pointHoverBorderWidth: 2,
                    pointRadius: 1,
                    pointHitRadius: 10,
                    spanGaps: false
                }
            ]
        }
    });
    vm.getNumByType=function() {

        $http({
            method: 'GET',
            url: 'http://localhost:8080/charts/getNumByType',
        }).then(function (response) {
            var rs = response.data.data
            lineChartExample.data.labels=rs[0]
            lineChartExample.data.datasets[0].data=rs[1]
            lineChartExample.update()




        }, function (response) {
            console.log(response)
        });
    }
    vm.getNumByType()
    $interval(vm.getNumByType,1000*60*5)


    var PIECHART = $('#pieChart1');
    var myPieChart = new Chart(PIECHART, {
        type: 'doughnut',
        options: {
            cutoutPercentage: 50,
            legend: {
                display: false
            }
        },
        data: {
            labels: [
                "First",
                "Second",
                "Third"
            ],
            datasets: [
                {
                    data: [250, 200],
                    borderWidth: [0, 0],
                    backgroundColor: [
                        violet,
                        red
                    ],
                    hoverBackgroundColor: [
                        violet,
                        red
                    ]
                }]
        }
    });
    vm.getZeroShoucang=function() {

        $http({
            method: 'GET',
            url: 'http://localhost:8080/charts/getZeroShoucang',
        }).then(function (response) {
            var rs = response.data.data
            myPieChart.data.labels=['收藏数为0的壁纸','收藏数大于0的壁纸']
            myPieChart.data.datasets[0].data=rs
            myPieChart.update()




        }, function (response) {
            console.log(response)
        });
    }
    vm.getZeroShoucang()
    $interval(vm.getZeroShoucang,1000*60*5)



    // ------------------------------------------------------- //
    // Pie Chart
    // ------------------------------------------------------ //
    var PIECHART = $('#pieChart2');
    var myPieChart1 = new Chart(PIECHART, {
        type: 'doughnut',
        options: {
            cutoutPercentage: 50,
            legend: {
                display: false
            }
        },
        data: {
            labels: [
                "First",
                "Second"
            ],
            datasets: [
                {
                    data: [300, 50],
                    borderWidth: [0, 0],
                    backgroundColor: [
                        green,
                        one
                    ],
                    hoverBackgroundColor: [
                        green,
                        one
                    ]
                }]
        }
    });
    vm.getZeroZan=function() {

        $http({
            method: 'GET',
            url: 'http://localhost:8080/charts/getZeroZan',
        }).then(function (response) {
            var rs = response.data.data
            myPieChart1.data.labels=['点赞数为0的壁纸','点赞数大于0的壁纸']
            myPieChart1.data.datasets[0].data=rs
            myPieChart1.update()




        }, function (response) {
            console.log(response)
        });
    }
    vm.getZeroZan()
    $interval(vm.getZeroZan,1000*60*5)

    var BARCHARTEXMPLE    = $('#barChartExample1');
    var barChartExample = new Chart(BARCHARTEXMPLE, {
        type: 'bar',
        options: {
            scales: {
                xAxes: [{
                    display: true,
                    gridLines: {
                        color: '#fff'
                    }
                }],
                yAxes: [{
                    display: true,

                    gridLines: {
                        color: '#fff'
                    }
                }]
            },
            onClick : function(event, legendItem) {
                var index=legendItem[0]._index;
                var photo=vm.phots[index]
                console.log(barChartExample.options)
                var str="作者:"+photo.author+"<br>"+

                    "上传时间:"+photo.time+"<br>"+
                    "标题:"+photo.title+"<br>"+
                    "简介:"+photo.msg+"<br>"+
                    "点赞数:"+photo.zan+"<br>"+
                    "收藏数:"+photo.shoucang+"<br>"+
                    "评论数:"+photo.pinglun +"<br>"

                swal({
                    title: "壁纸详情",
                    text: str,
                    imageUrl: photo.photo,
                    imageSize:'200x200',
                    html: true,
                    timer: 5000,
                    showConfirmButton: true
                });

            }



        },


        data: {
            labels: ["1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14"],
            datasets: [
                {
                    label: "得分",
                    backgroundColor: [

                        gradient2,
                        violet,
                        red,
                        green,
                        one,
                        two,
                        gradient2,
                        violet,
                        red,
                        green,
                        one,
                        two,
                        gradient2,
                        violet,
                        red,
                        green,
                        one,
                        two,
                    ],
                    hoverBackgroundColor: [
                        gradient2,
                        violet,
                        red,
                        green,
                        one,
                        two,
                        gradient2,
                        violet,
                        red,
                        green,
                        one,
                        two,
                        gradient2,
                        violet,
                        red,
                        green,
                        one,
                        two,
                    ],
                    borderColor: [
                        gradient2,
                        violet,
                        red,
                        green,
                        one,
                        two,
                        gradient2,
                        violet,
                        red,
                        green,
                        one,
                        two,
                        gradient2,
                        violet,
                        red,
                        green,
                        one,
                        two,
                    ],
                    borderWidth: 1,
                }
            ]
        }
    })


    vm.getTen=function() {

        $http({
            method: 'GET',
            url: 'http://localhost:8080/charts/getScoreTen',
        }).then(function (response) {
            var rs = response.data.data
            barChartExample.data.datasets[0].data=rs[0]
            vm.phots=rs[1]
            barChartExample.update()




        }, function (response) {
            console.log(response)
        });
    }
    vm.getTen()
    $interval(vm.getTen,1000*60*5)




    var DOUGHNUTCHARTEXMPLE  = $('#doughnutChartExample');
    var pieChartExample = new Chart(DOUGHNUTCHARTEXMPLE, {
        type: 'doughnut',
        options: {
            cutoutPercentage: 80,
            responsive: true
        },
        data: {
            labels: [
                "A",
                "B",
                "C",
                "D"
            ],
            datasets: [
                {
                    data: [250, 50, 100, 40],
                    borderWidth: 0,
                    backgroundColor: [
                        violet,
                        red,
                        green,
                        one,
                        two,
                        '#df99ca',
                        '#c374ab',
                        "#a44e8a",
                        "#81376a"
                    ],
                    hoverBackgroundColor: [
                        violet,
                        red,
                        green,
                        one,
                        two,
                        '#df99ca',
                        '#c374ab',
                        "#a44e8a",
                        "#81376a"
                    ]
                }]
        }
    });
    vm.getZan=function() {
        $http({
            method: 'GET',
            url: 'http://localhost:8080/charts/getSumZan',
        }).then(function (response) {
            var rs = response.data.data
            pieChartExample.data.labels=rs[0]
            pieChartExample.data.datasets[0].data=rs[1]
            pieChartExample.update()




        }, function (response) {
            console.log(response)
        });
    }
    vm.getZan()
    $interval(vm.getZan,1000*60*5)

    var PIECHARTEXMPLE    = $('#pieChartExample');
    var pieChartExample2 = new Chart(PIECHARTEXMPLE, {
        type: 'pie',
        data: {
            labels: [
                "A",
                "B",
                "C",
                "D"
            ],
            datasets: [
                {
                    data: [300, 50, 100, 80],
                    borderWidth: 0,
                    backgroundColor: [
                        gradient2,
                        violet,
                        red,
                        green,
                        one,
                        two,
                        "#ee45eb"

                    ],
                    hoverBackgroundColor: [
                        gradient2,
                        violet,
                        red,
                        green,
                        one,
                        two,
                        "#ee45eb"

                    ]
                }]
        }
    });
    vm.getShoucang=function() {
        $http({
            method: 'GET',
            url: 'http://localhost:8080/charts/getSumShoucang',
        }).then(function (response) {
            var rs = response.data.data
            pieChartExample2.data.labels=rs[0]
            pieChartExample2.data.datasets[0].data=rs[1]
            pieChartExample2.update()




        }, function (response) {
            console.log(response)
        });
    }
    vm.getShoucang()
    $interval(vm.getShoucang,1000*60*5)








}]);

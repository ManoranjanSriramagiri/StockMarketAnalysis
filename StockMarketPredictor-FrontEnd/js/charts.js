/* --------------------------------------------------------
 Manoranjan Sriramgiri
 -----------------------------------------------------------*/

var resVal = [];
var stockapp = angular.module('stockApp', []);
stockapp.controller("stockController", function ($scope, $http,$location,$window) {

    $scope.loadDetails =function() {
        $http({
            method: 'GET',
            url: 'http://localhost:8080/v1/api/stockdata'
            //{TaskTitle}/{TaskDescription}/{TaskAssignee}/{TaskState}/{TaskEstimate}/{TaskActual}/{ProjectId}/
        }).success(function (response,status) {
                $scope.stocks1 = response;

        }).error(function (error) {
        });
    }

    $scope.trends=  function() {
        console.log("sak;fjdp")
        $http({
            method: 'GET',
            url: 'http://localhost:8080/v1/api/twittersentiment'

        }).success(function (response) {
            $scope.newsFeed = response[0];
            console.log($scope.newsFeed.tweets)
        }).error(function (error) {
            // alert("error : task ");

        });
    }

    $scope.biggestGainerCompany = function(){

        $http({
            method: 'GET',
            url: 'http://localhost:8080/v1/api/biggestgainer'
            //{TaskTitle}/{TaskDescription}/{TaskAssignee}/{TaskState}/{TaskEstimate}/{TaskActual}/{ProjectId}/
        }).success(function (response,status) {
            $scope.biggestLoserCompany()
            $scope.biggestGainerCompany = response;

        }).error(function (error) {
        });

    }

    $scope.biggestLoserCompany =function() {
        $http({
            method: 'GET',
            url: 'http://localhost:8080/v1/api/biggestloser'
            //{TaskTitle}/{TaskDescription}/{TaskAssignee}/{TaskState}/{TaskEstimate}/{TaskActual}/{ProjectId}/
        }).success(function (response,status) {
            $scope.avgModelAccuracy()
            $scope.biggestLoserCompany = response;

        }).error(function (error) {
        });

    }

    $scope.avgModelAccuracy =function() {
        $http({
            method: 'GET',
            url: 'http://localhost:8080/v1/api/avgmodelaccuracy'
            //{TaskTitle}/{TaskDescription}/{TaskAssignee}/{TaskState}/{TaskEstimate}/{TaskActual}/{ProjectId}/
        }).success(function (response,status) {
            $scope.avgModelAccuracy = response;

        }).error(function (error) {
        });

    }

    $scope.getGraph =function(){
        var sendd=[]
        $http({
            method: 'GET',
            url: 'http://localhost:8080/v1/api/stockhistory?company=AAPL'
        }).success(function (response,status) {
            sendd=response
            $scope.displayGraph(sendd);
            console.log(sendd)

        }).error(function (error) {
        });


    }

   /* $scope.displayGraph=function (graphData){

        var line = new Morris.Line({
            element: $scope.line1-chart,
            resize: true,
            data: graphData,
            xkey: 'y',
            ykeys: ['item1'],
            labels: ['Item 1'],
            lineColors: ['#3c8dbc'],
            hideHover: 'auto'
        });
    }
*/
    $scope.showDynamoGraph = function(cName){
        console.log(cName)

        console.log($location.host())
        var commonPath=$location.path('/'+$location.protocol()+'://'+$location.host()+':'+$location.port())
        $window.location.href=$location.path('/'+$location.protocol()+'://'+$location.host()+':'+$location.port())+'/StockMarketPredictor-FrontEnd/graph-appl.html'
        var dataArr = [];
        var urlCompanyName;
        if(cName == "CISCO"){
            urlCompanyName = "CSCO";
            console.log(commonPath)
            $window.location.href=commonPath+'/StockMarketPredictor-FrontEnd/graph-appl.html'
        }
        if(cName =="MICROSOFT"){
            urlCompanyName = "MSFT";
        }
        if(cName =="GOOGLE"){
            urlCompanyName = "GOOGL";
        }
        if(cName =="IBM"){
            urlCompanyName = "IBM";
        }
        if(cName =="FACEBOOK"){
            urlCompanyName = "FB";
        }
        if(cName =="INTUIT"){
            urlCompanyName = "INTU";
        }
        /*$http({
            method: 'GET',
            url: 'http://localhost:8080/v1/api/stockhistory?company='+urlCompanyName

        }).success(function (response2) {

            for (var i = 0; i < response2.length; i++) {
                dataArr.push([response2[i].y, response2[i].item1]);
            }
            console.log(dataArr)


        }).error(function (error) {
        });*/
    }


});



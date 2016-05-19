<%@ include file="../init.jspf" %>
<h2>${greeting} with TILES</h2>
<script  type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.0/angular.js">
</script>

<script>
 angular.module('todoApp', [])
      .controller('TodoListController', function($scope, $http) {
        $scope.testSubmit = function() {
            console.log("asdfasdf dsf ");

            $http({
              method: 'POST',
              url: '/test',
              data: {"test": "12.12.2016"}
            }).then(function successCallback(response) {
                // this callback will be called asynchronously
                // when the response is available
                console.log(response);
              }, function errorCallback(response) {
                // called asynchronously if an error occurs
                // or server returns response with an error status.
                console.log(response);
              });

        }
      });

</script>

<div ng-app="todoApp">
<section ng-controller="TodoListController">
<input ng-click="testSubmit()" type="button" value="SMITTI" />
</section>
</div>


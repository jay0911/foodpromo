var start = angular.module('ionicApp', ['ionic','ui.router','ion-datetime-picker','ng-currency'])
.config(function($stateProvider, $urlRouterProvider) {
  $stateProvider
    .state('tabs', {
      url: "/tab",
      abstract: true,
      templateUrl: "sidemenus/tabs.html"
    })
    .state('tabs.home', {
      url: "/home",
      views: {
        'menuContent': {
          templateUrl: "sidemenus/home.html"
        }
      }
    })
    .state('tabs.addproduct', {
      url: "/addproduct",
      views: {
        'menuContent': {
          templateUrl: "sidemenus/addproduct.html",
          controller: 'addproduct'
        }
      }
    })
    .state('tabs.editproduct', {
      url: "/editproduct",
      cache: false,
      views: {
        'menuContent': {
          templateUrl: "sidemenus/editproduct.html",
          controller: 'editproduct'
        }
      }
    })
    ;

   $urlRouterProvider.otherwise("/tab/home");
})
.controller('backController', function($scope, $ionicHistory,$state) {
	$scope.myGoBack = function() {
		/*		if($ionicHistory.currentStateName() == 'tabs.register'){
					$state.go('tabs.loginregister', {}, { location: false } );
				}*/
			};
});
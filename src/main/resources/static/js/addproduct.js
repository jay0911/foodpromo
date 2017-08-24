start.controller('addproduct', function($scope,$http,$state,$ionicPopup,$ionicLoading,$ionicPopover) {
	$scope.product = {
			  name:"",
			  price:0,
			  created:"yyyy-MM-dd"
	};
	$scope.searchval = {};
	$scope.onsubmit = function (){  
		  $ionicLoading.show({
		    	 template: ' <ion-spinner icon="ripple" class="spinner-assertive"></ion-spinner>'+
		            '<p>Loading ...</p>',
		          animation: 'fade-in',
		          noBackdrop: false,
		          maxWidth: 500,
		          showDelay: 0
		  });

		  $http.put('/product/saveProduct', JSON.stringify($scope.product)).then(function (data) {
				  var alertPopup = $ionicPopup.alert({
				        title: 'Saved',
				        template: 'Success!'
				  });
				  alertPopup.then(function(res) {
				        	//to do
				  });
		  }, function (data) {
				  console.log(data);
		  }).finally(function() {
				    // called no matter success or failure
			  $ionicLoading.hide();
		  });		  
	};
})
start.controller('editproduct', function($scope,$http,$state,$ionicPopup,$ionicLoading,$ionicPopover,$ionicListDelegate,$ionicModal) {
	$scope.searchval = {};
	$scope.product = [];
	$scope.edit = {};
	$ionicLoading.show({
   	 template: ' <ion-spinner icon="ripple" class="spinner-assertive"></ion-spinner>'+
           '<p>Loading ...</p>',
         animation: 'fade-in',
         noBackdrop: false,
         maxWidth: 500,
         showDelay: 0
	});

	$scope.clearSearch = function(){	  
		  $scope.searchval = {};
	};
	
    $scope.onItemDelete = function(item) {
    	console.log(item);
		$http.delete('/product/deleteProduct?id='+item.id).then(function (data) {
			console.log(data);
		}, function (data) {
			console.log(data);
		}).finally(function() {
			$scope.product.splice($scope.product.indexOf(item), 1);
		});   
    };
    
    $scope.onItemEdit = function(item) {
    	$ionicListDelegate.closeOptionButtons(); 	
    	$scope.edit.name = item.name;
    	$scope.edit.price = item.price;
    	$scope.edit.id = item.id;
    	$scope.currentindex = $scope.product.indexOf(item);
    	$scope.modaledit.show();
    };
    
	$ionicModal.fromTemplateUrl('templates/modal-edit.html', {
	    scope: $scope
	}).then(function(modal) {
	    $scope.modaledit = modal;
	});
	
	$scope.editme = function(item){
    	$scope.product.push({id:item.id
    		,name:item.name
    		,price:item.price
    	});
		$http.post('/product/editProduct', JSON.stringify(item)).then(function (data) {
			console.log(data);
			$scope.product.splice($scope.currentindex, 1);		
		}, function (data) {
			console.log(data);
		}).finally(function() {
				    // called no matter success or failure
		});
    	$scope.edit.name = "";
    	$scope.edit.price = "";
    	$scope.modaledit.hide();
	}
	
	var init = function () {
	    $http({
			  method: 'GET',
			  url: '/product/getAllProduct'
			}).then(function successCallback(response) {
			    console.log(response.data);
			    for (i=0;i<response.data.length;i++){
				    $scope.product.push(
				    		{
				    		name:response.data[i].name
				    		,id:response.data[i].id
				    		,price:response.data[i].price
				    		});
			    }  
			     $ionicLoading.hide(); 
			}, function errorCallback(response) {
				 console.log(response);
		});	
	};
	
	init();

})
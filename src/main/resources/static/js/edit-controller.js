mskApp.controller('EditController',
	function($scope, $window, $http){


		$scope.msk={};

		$scope.simpan = function() {
			$http.post('/tambah-msk', $scope.msk).then(sukses, gagal);

            function sukses(response){
                $window.location.href = '/';
            };
            function gagal(response){
                console.log(response);
            };
		};

		$scope.batal = function() {
			$window.location.href = "/";
		};

		$scope.updateById = function() {
			id=$window.location.search.split('=')[1];
			//console.log(nim);
			$scope.msk.id = id;

			$http.get("/get-msk-by-id/" + id).then(sukses, gagal);

			function sukses(response){
                //$window.location.href = '/';
                $scope.msk = response.data;
            };
            function gagal(response){
                console.log(response);
            };
		};

		$scope.updateById();

	});
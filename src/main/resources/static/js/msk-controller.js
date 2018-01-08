var mskApp= angular.module('MskApp', []);

mskApp.controller('MskController', 
    function($scope, $http, $window) {
        $scope.daftarMsk = [];
        $scope.updateDaftarMsk = function(){
            $http.get('/daftar-masuk').then(sukses, gagal);
            
            function sukses(response){
            	console.log(response);
            	//isidata mahasiswa
            	$scope.daftarMsk = response.data;
            };
            function gagal(response){
            	console.log(response);
        	};
        };

        $scope.ubah = function(msk){
            //console.log(msk);
            $window.location.href="/form-edit?id=" + msk.id;
        };
        
        $scope.hapus = function(msk){
            $http.delete('/hapus-data/' + msk.id).then(sukses, gagal);

            function sukses(response){
                $scope.updateDaftarMsk();
            } ;

            function gagal(response){
                console.log(response);
            } ;
        };

        $scope.keluar = function() {
            $http.get('/keluar').then(sukses, gagal);

            function sukses(response){
                $window.location.href="/";
                
                
            };
            function gagal(response){
                console.log(response);
            };
        

        };

        $scope.updateDaftarMsk();
    });
mskApp.controller('FormController', 
    function($scope, $http, $window){
        $scope.simpan = function() {
            //console.log('nim : '+ $scope.mhs.nim);
            //console.log('nama : '+ $scope.mhs.nama);
            //console.log('jurusan : '+ $scope.mhs.jurusan);

            $http.post('/tambah-msk', $scope.msk).then(sukses, gagal);

            function sukses(response){
                $window.location.href = '/';
            };
            function gagal(response){
                console.log(response);
            };
        };

        $scope.batal = function() {
            $window.location.href = '/';
        };
    });
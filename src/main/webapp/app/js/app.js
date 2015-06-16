(function(){
    var app = angular.module("companiesJS", ["companyTab","companyForm","loginForm"]);

    app.controller("CompaniesController", ["$http",
        function($http) {
            this.COMPANIES_API = "../api/companies";
            this.loading = false;
            this.newCompany = {};
            var companyCtrl = this;
            this.searchText = "";

            this.isLoading = function(){
                return this.loading;
            };

            this.noCompany = function(){
                return this.companies === undefined;
            };

            this.listCompanies = function(){
                this.loading = true;
                companyCtrl.result = {};
                $http.get(this.COMPANIES_API)
                    .success(function (data) {
                        if(data!=""){
                            companyCtrl.companies = data;
                        }
                    }).then(function () {
                        this.loading = false;
                    });
            };
            
            this.searchCompany = function(){
                companyCtrl.companies = {};
                $http.get(this.COMPANIES_API+"/"+this.searchText)
                    .success(function (data) {
                        companyCtrl.result = data;
                    });

            };

            this.addCompany = function(){
                    $http.post(this.COMPANIES_API, this.newCompany)
                    .then(function(){
                        companyCtrl.listCompanies();
                        companyCtrl.newCompany={};
                    });               

            };
  
            this.deleteCompany = function(id){
                this.loading = true;
                $http.delete(this.COMPANIES_API+"/"+id)
                    .then(function () {
                        this.loading = false;
                    });
                window.location.reload(false);

            };

        }]);

}());
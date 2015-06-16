(function () {
    var app = angular.module("companiesJS", ["companyForm", "companyTab", "loginForm"]);

    app.controller("CompaniesController", ["$http",
        function ($http) {
            this.COMPANIES_API = "../api/companies";
            this.loading = false;
            this.newCompany = {};
            var companyCtrl = this;
            this.searchText = "";

            this.isLoading = function () {
                return this.loading;
            };

            this.noCompany = function () {
                return this.companies === undefined;
            };

            this.listCompanies = function () {
                this.loading = true;
                companyCtrl.companies = {};
                $http.get(this.COMPANIES_API)
                    .success(function (data) {
                        if (data != "") {
                            companyCtrl.companies = data;
                        }
                    }).then(function () {
                        this.loading = false;
                    });
            };

            this.searchCompany = function () {
                companyCtrl.companies = {};
                $http.get(this.COMPANIES_API + "/find/" + this.searchText)
                    .success(function (data) {
                        if (data != "") {
                            companyCtrl.companies = data;
                        } else {
                            $http.get(companyCtrl.COMPANIES_API + "/results/json?name=" + companyCtrl.searchText)
                                .success(function (data) {
                                    if (data != "") {
                                        companyCtrl.companies = data;
                                    }
                                });
                        }
                    });

            };

            this.loadCompany = function (company) {
                this.newCompany = company;

            };

            this.addCompany = function () {
                $http.post(this.COMPANIES_API, this.newCompany)
                    .then(function () {
                        companyCtrl.listCompanies();
                        this.newCompany = {};
                    });

            };

            this.deleteCompany = function (id) {
                this.loading = true;
                $http.delete(this.COMPANIES_API + "/" + id)
                    .then(function () {
                        this.loading = false;
                    });
                window.location.reload(false);

            };

        }]);

    app.directive("companies", function () {
        return {
            restrict: "E",

            templateUrl: "companies.html",
            controller: function () {
                this.tab = 1;

                this.isSet = function (checkTab) {
                    return this.tab === checkTab;
                };

                this.setTab = function (activeTab) {
                    this.tab = activeTab;
                };
            },
            controllerAs: "tab"
        };
    });

    app.controller("UsersController", ["$http",
        function ($http) {
            this.USERS_API = "../api/users";
            this.loading = false;
            var userCtrl = this;

            this.listUsers = function () {
                this.loading = true;
                userCtrl.users = {};
                $http.get(this.USERS_API)
                    .success(function (data) {
                        if (data != "") {
                            userCtrl.users = data;
                        }
                    }).then(function () {
                        this.loading = false;
                    });
            }
        }]);

    app.directive("users", function () {
        return {
            restrict: "E",

            templateUrl: "users.html",
            controller: function () {
                this.tab = 1;

                this.isSet = function (checkTab) {
                    return this.tab === checkTab;
                };

                this.setTab = function (activeTab) {
                    this.tab = activeTab;
                };
            },
            controllerAs: "tab"
        };
    });

    app.controller("WorkoffersController", ["$http",
        function ($http) {
            this.WORK_OFFERS_API = "../api/workOffers";
            var workOfferCtrl = this;

            this.listWorkOffers = function () {
                this.loading = true;
                workOfferCtrl.workOffers = {};
                $http.get(this.WORK_OFFERS_API)
                    .success(function (data) {
                        if (data != "") {
                            workOfferCtrl.workOffers= data;
                            console.log(workOfferCtrl.workOffers);
                        }
                    })
            }
        }]);

    app.directive("workoffers", function () {
        return {
            restrict: "E",

            templateUrl: "workoffers.html",
            controller: function () {
                this.tab = 1;

                this.isSet = function (checkTab) {
                    return this.tab === checkTab;
                };

                this.setTab = function (activeTab) {
                    this.tab = activeTab;
                };
            },
            controllerAs: "tab"
        };
    });

}());
Ext.define("TrackCar.view.importA.ImportTelphone",{
    extend: "TrackCar.view.importA.Import",

    requires: [
        "TrackCar.view.importA.ImportTelphoneController",
        "TrackCar.view.importA.ImportTelphoneModel"
    ],

    controller: "import-importtelphone",
    viewModel: {
        type: "import-importtelphone"
    }
});

Ext.define("TrackCar.view.import.ImportTelphone",{
    extend: "TrackCar.view.import.Import",

    requires: [
        "TrackCar.view.import.ImportTelphoneController",
        "TrackCar.view.import.ImportTelphoneModel"
    ],

    controller: "import-importtelphone",
    viewModel: {
        type: "import-importtelphone"
    }
});

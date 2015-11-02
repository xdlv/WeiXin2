Ext.define("TrackCar.view.importA.ImportDz",{
    extend: "TrackCar.view.importA.Import",

    requires: [
        "TrackCar.view.importA.ImportDzController",
        "TrackCar.view.importA.ImportDzModel"
    ],

    controller: "import-importdz",
    viewModel: {
        type: "import-importdz"
    },

    html: "Hello, World!!"
});

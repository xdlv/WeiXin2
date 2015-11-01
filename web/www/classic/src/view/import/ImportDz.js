Ext.define("TrackCar.view.import.ImportDz",{
    extend: "TrackCar.view.import.ImportA",

    requires: [
        "TrackCar.view.import.ImportDzController",
        "TrackCar.view.import.ImportDzModel"
    ],

    controller: "import-importdz",
    viewModel: {
        type: "import-importdz"
    },

    html: "Hello, World!!"
});

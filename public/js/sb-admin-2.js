/*!
 * Start Bootstrap - SB Admin 2 v3.3.7+1 (http://startbootstrap.com/template-overviews/sb-admin-2)
 * Copyright 2013-2016 Start Bootstrap
 * Licensed under MIT (https://github.com/BlackrockDigital/startbootstrap/blob/gh-pages/LICENSE)
 */
$(function() {
    $('#side-menu').metisMenu();
});

//Loads the correct sidebar on window load,
//collapses the sidebar on window resize.
// Sets the min-height of #page-wrapper to window size
$(function() {
    $(window).bind("load resize", function() {
        var topOffset = 50;
        var width = (this.window.innerWidth > 0) ? this.window.innerWidth : this.screen.width;
        if (width < 768) {
            $('div.navbar-collapse').addClass('collapse');
            topOffset = 100; // 2-row-menu
        } else {
            $('div.navbar-collapse').removeClass('collapse');
        }

        var height = ((this.window.innerHeight > 0) ? this.window.innerHeight : this.screen.height) - 1;
        height = height - topOffset;
        if (height < 1) height = 1;
        if (height > topOffset) {
            $("#page-wrapper").css("min-height", (height) + "px");
        }
    });

    var url = window.location;
    // var element = $('ul.nav a').filter(function() {
    //     return this.href == url;
    // }).addClass('active').parent().parent().addClass('in').parent();
    var element = $('ul.nav a').filter(function() {
        return this.href == url;
    }).addClass('active').parent();

    while (true) {
        if (element.is('li')) {
            element = element.parent().addClass('in').parent();
        } else {
            break;
        }
    }
});
google.charts.load('current', {packages: ['corechart', 'line']});
google.charts.setOnLoadCallback(drawCurveTypes);

function drawCurveTypes() {
    var data = new google.visualization.DataTable();
    data.addColumn('number', 'X');
    data.addColumn('number', 'Unleaded');
    data.addColumn('number', 'Diesel');

    data.addRows([
        [0, 3119, 8499],    [1, 2771, 7855],   [2, 1278, 9259],  [3, 1889, 8988],   [4,2859 , 8892],  [5, 2748, 8046],
        [6, 1290, 8889],   [7, 1975, 8917],  [8, 1515, 7424],  [9, 2503, 9257],  [10, 1683, 8096], [11, 2731, 7770],
        [12, 2996, 7886], [13, 1444, 8219], [14, 2399, 9210], [15, 2033, 7407], [16,2361 , 8193], [17,2905 ,7573 ],
        [18, 1490, 8478], [19, 1716, 8890], [20,3054 , 8962], [21,1302 , 9284], [22, 2158, 8388], [23, 2557, 8513],
        [24, 2876, 8806], [25, 2850, 9129], [26, 2882, 8483], [27, 2231, 8683], [28, 2951, 8739], [29, 3177, 9311],
        [30, 1756, 8224], [31, 2621, 9035], [32,2313 , 8141], [33,3106 , 8369], [34, 2663, 8442], [35,3042 , 9196],
        [36, 2275, 7920], [37, 1388, 9265], [38, 2271, 9184], [39,1850 , 8451], [40, 1672, 7673], [41, 2802, 8594],
        [42, 2271, 7699], [43, 1501, 8624], [44, 2114, 8964], [45, 1556, 8709], [46, 2357, 8528], [47, 1536, 8089],
        [48, 2007, 7524], [49, 2977, 5828], [50, 3099, 7559], [51, 2766, 9139], [52, 2924, 8358]
    ]);

    var options = {
        hAxis: {
            title: 'Week'
        },
        vAxis: {
            title: 'Sales'
        },
        series: {
            1: {curveType: 'function'}
        }
    };

    var chart = new google.visualization.LineChart(document.getElementById('chart_div'));
    chart.draw(data, options);
}

google.charts.load('current', {'packages':['corechart']});
google.charts.setOnLoadCallback(drawChart);

function drawChart() {

    var data = google.visualization.arrayToDataTable([
        ['Fuel Type', 'Percentage of Sales'],
        ['Unleaded',     14],
        ['Diesel',      10],

    ]);

    var options = {
        title: 'Unleaded Vs Diesel Sales'
    };

    var chart = new google.visualization.PieChart(document.getElementById('piechart'));

    chart.draw(data, options);
}

function drawVisualization() {
    // Create and populate the data table.
    var data = google.visualization.arrayToDataTable([
        ['Month', 'Unleaded', 'Diesel'],
        ['January',  9588,    24480],
        ['February',  11276,    26788],
        ['March',  13137,    26939],
        ['April',  9986,    24513],
        ['May',  12908,    27523],
        ['June',  11778,    26438],
        ['July',  11339,    26886],
        ['August',  13802,    27847],
        ['September',  10743,    25977],
        ['October',  13898,    26645],
        ['November',  10082,    25199],
        ['December',  12973,    25793],
    ]);

    // Create and draw the visualization.
    new google.visualization.ColumnChart(document.getElementById('barchart')).
    draw(data,
        {title:"Diesel vs Unleaded Sales",
            width:900, height:500,
            vAxis: {title: "Sales"}, isStacked: true,
            hAxis: {title: "Month"}}
    );
}

google.load("visualization", "1", {packages:["corechart"]});
google.setOnLoadCallback(drawVisualization);


google.charts.load('current', {packages: ['corechart', 'line']});
google.charts.setOnLoadCallback(drawCurveTypes);






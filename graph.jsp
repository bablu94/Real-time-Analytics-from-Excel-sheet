
<%@page import="java.util.ArrayList"%>
<%@page import="com.google.gson.JsonObject"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!doctype html>
<html>

<head>
    
    <script src="./js/Chart.bundle.js"></script>
    <script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
      <script src="http://cdn.anychart.com/js/7.10.1/anychart-bundle.min.js"></script>
        <link rel="stylesheet" href="https://cdn.anychart.com/css/latest/anychart-ui.min.css" />
         <script src ="http://cdn.anychart.com/js/7.10.1/anychart-bundle.min.js"></script>
    <link rel="stylesheet" href="https://cdn.anychart.com/css/latest/anychart-ui.min.css" />
</head>

<body>
     <%//out.println(request.getParameter("value1"));%>
    <%// out.println("<br><br>"); %>
      <%
         String delims = "[, ]";
        // out.println(str);
         //out.println(str.length());
        // out.println("<br><br>");
        // int i=0;
        
         String[] words=(request.getParameter("value2")).split(delims);  
         //out.println(words);
         for(String w:words){ 
          
         //out.println(w);
         //out.println("<br>");
         }
         //out.println(words.length);
          for(int i = 0;i<words.length;i++)
          { 
//              out.println(words[i]);
          } 
        // String ignore= null;
        try{
      // out.println(words[0].charAt(0));
        }
        catch(StringIndexOutOfBoundsException e){}
         String datas[]=new String[200] ;
         String label[]=new String[200];
   for(int i = 0;i<words.length;i++)
    {  //char ch= words.charAt[i];
        try{
             int j=words[i].charAt(0);
         
       if(j>=48 && j<=57 )
       {    try{
           int k = words[i].length();
            if(words[i].charAt(k-1)==']')
            datas[i]= words[i].substring(0, k-1);
         else
          datas[i]=words[i]; 
         // out.println(datas[i]);
       }
       catch(NullPointerException e){out.println(e);}
             
       }
       else if(j>=91 && j<=96 ) 
       {
          label[i]= words[i].substring(1);
           //out.println(label[i]);
       }
       else {
           label[i]=words[i];
           //out.println(label[i]);
       }
       }
         catch(StringIndexOutOfBoundsException e){}
    }
        %>
        <script type="text/javascript">
         anychart.onDocumentReady(function() {
  // create data set on our data
  var dataSet = anychart.data.set([
     <% for(int i=0;i<label.length;i++)
       {
            if(label[i]!=null){
            out.print("['"+label[i]+"\',");}
            for(int j=0;i<datas.length ; j++){
            if(datas[i]!=null){
        out.println(""+datas[i]+"],");}
       break;
       }}
   %>
  
  ]);

  // map data for the first series, take x from the zero column and value from the first column of data set
  var seriesData_1 = dataSet.mapAs({x: [0], value: [1]});

  // map data for the second series, take x from the zero column and value from the second column of data set
  var seriesData_2 = dataSet.mapAs({x: [0], value: [2]});

  // map data for the third series, take x from the zero column and value from the third column of data set
  var seriesData_3 = dataSet.mapAs({x: [0], value: [3]});

  // create line chart
  chart = anychart.line();

  // turn on chart animation
  chart.animation(true);

  // turn on the crosshair
  chart.crosshair().enabled(true).yLabel().enabled(false);
  chart.crosshair().yStroke(null);

  // set tooltip mode to point
  chart.tooltip().positionMode('point');

  // set chart title text settings
  chart.title('Line chart');
  chart.title().padding([0,0,5,0]);
  
  // set yAxis title
  chart.yAxis().title('Population of Cities');
  chart.xAxis().labels().padding([5]);

  // create first series with mapped data
  var series_1 = chart.line(seriesData_1);
  series_1.name('Population');
  series_1.hoverMarkers().enabled(true).type('circle').size(4);
  series_1.tooltip().position('right').anchor('left').offsetX(5).offsetY(5);

  // create second series with mapped data


  // turn the legend on
  chart.legend().enabled(true).fontSize(12).padding([0,0,10,0]);

  // set container id for the chart and set up paddings
  chart.container('container');
  chart.padding([10,20,5,20]);

  // initiate chart drawing
  chart.draw();
});   
        </script>
        
        <script type="text/javascript">
         anychart.onDocumentReady(function() {
  // create data set on our data
  var dataSet = anychart.data.set([
     
   <% for(int i=0;i<label.length;i++)
       {
            if(label[i]!=null){
            out.print("['"+label[i]+"\',");}
            for(int j=0;i<datas.length ; j++){
            if(datas[i]!=null){
        out.println(""+datas[i]+"],");}
       break;
       }}
   %>
              
  ]);

  // map data for the first series, take x from the zero column and value from the first column of data set
  var seriesData_1 = dataSet.mapAs({x: [0], value: [1]});

  // create column chart
  chart = anychart.column();

  // turn on chart animation
  chart.animation(true);

  // set chart title text settings
  chart.title('Column Chart');

  chart.yAxis().labels().textFormatter("{%Value}");

  // set titles for Y-axis
  chart.yAxis().title('Population');
  // chart.xAxis().labels().textFormatter("{%value}");
  chart.xAxis().title('City');

  // helper function to setup label settings for all series
  var setupSeriesLabels = function(series, name) {
    var seriesLabels = series.labels();
    series.hoverLabels().enabled(false);
    seriesLabels.enabled(true);
    seriesLabels.position('top');
    seriesLabels.textFormatter(function(){
      return this.value.toLocaleString();
    });
    series.name(name);
    seriesLabels.anchor('bottom');
    series.tooltip().titleFormatter(function () {
      return this.x;
    });
    series.tooltip().textFormatter(function () {
      return this.seriesName + ':' + parseInt(this.value).toLocaleString();
    });
    series.tooltip().position('top').anchor('bottom').offsetX(0).offsetY(5);
  };

  // temp variable to store series instance
  var series;

  // create first series with mapped data
  series = chart.column(seriesData_1);
  setupSeriesLabels(series, 'Population');

  // turn on legend and tune it
  chart.legend().enabled(true).fontSize(13).padding([0,0,20,0]);

  // interactivity settings and tooltip position
  chart.interactivity().hoverMode('single');
  chart.tooltip().positionMode('point');

  // set container id for the chart
  chart.container('container1');

  // initiate chart drawing
  chart.draw();
});
        </script>
        
        <div style="width:100%;height:auto;">
            <div style="width:50%;float: left;">                
                <div id="canvas-holder" style="width: 300px;">
                    <canvas id="chart-area2" width="300" height="300" />
                </div>
                <div id="container" style="width:100%;height: 400px;"></div>
            </div>
            <div style="width:50%;float: left;">
                <div id="container1" style="width:100%;height: 400px;"></div>    
                
                    
            </div>
        </div>
   
        

    <div id="chartjs-tooltip"></div>
   
    <script>
    Chart.defaults.global.tooltips.custom = function(tooltip) {

    	// Tooltip Element
      var tooltipEl = $('#chartjs-tooltip');

      if (!tooltipEl[0]) {
        $('body').append('<div id="chartjs-tooltip"></div>');
        tooltipEl = $('#chartjs-tooltip');
      }

      // Hide if no tooltip
      if (!tooltip.opacity) {
        tooltipEl.css({
          opacity: 0
        });
        $('.chartjs-wrap canvas')
          .each(function(index, el) {
            $(el).css('cursor', 'default');
          });
        return;
      }

      $(this._chart.canvas).css('cursor', 'pointer');

      // Set caret Position
      tooltipEl.removeClass('above below no-transform');
      if (tooltip.yAlign) {
        tooltipEl.addClass(tooltip.yAlign);
      } else {
        tooltipEl.addClass('no-transform');
      }

      // Set Text
      if (tooltip.body) {
        var innerHtml = [
          (tooltip.beforeTitle || []).join('\n'), (tooltip.title || []).join('\n'), (tooltip.afterTitle || []).join('\n'), (tooltip.beforeBody || []).join('\n'), (tooltip.body || []).join('\n'), (tooltip.afterBody || []).join('\n'), (tooltip.beforeFooter || [])
          .join('\n'), (tooltip.footer || []).join('\n'), (tooltip.afterFooter || []).join('\n')
        ];
        tooltipEl.html(innerHtml.join('\n'));
      }

      // Find Y Location on page
      var top = 0;
      if (tooltip.yAlign) {
        if (tooltip.yAlign == 'above') {
          top = tooltip.y - tooltip.caretHeight - tooltip.caretPadding;
        } else {
          top = tooltip.y + tooltip.caretHeight + tooltip.caretPadding;
        }
      }

      var position = $(this._chart.canvas)[0].getBoundingClientRect();

      // Display, position, and set styles for font
      tooltipEl.css({
        opacity: 1,
        width: tooltip.width ? (tooltip.width + 'px') : 'auto',
        left: position.left + tooltip.x + 'px',
        top: position.top + top + 'px',
        fontFamily: tooltip._fontFamily,
        fontSize: tooltip.fontSize,
        fontStyle: tooltip._fontStyle,
        padding: tooltip.yPadding + 'px ' + tooltip.xPadding + 'px',
      });
    };
      
    var config = {
        type: 'pie',
        data: {
            datasets: [{
                data: [ <% for(int i=0;i<datas.length ; i++){if(datas[i]!=null)out.println("\""+datas[i]+"\",");}%>],
            
                       
                backgroundColor: [
                    "#F7464A",
                    "#D6BFBD",
                    "#BDB45C",
                    "#949FB1",
                    "#FDB78D",
                    "#A7433B"
                ],
            }],
            labels: [
                        <% for(int i=0;i<label.length;i++){if(label[i]!=null)out.println("\""+label[i]+"\",");}%>
            ]
            
        },
        options: {
            responsive: true,
            legend: {
                display: false
            },
            tooltips: {
                enabled: false,
            }
        }
    };

    window.onload = function() {
        

        var ctx2 = document.getElementById("chart-area2").getContext("2d");
        window.myPie = new Chart(ctx2, config);
    };
    </script>
    
      
     
        
   
</body>

</html>

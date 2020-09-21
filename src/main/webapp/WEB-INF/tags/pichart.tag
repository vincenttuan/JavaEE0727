<%@tag description="put the tag description here" pageEncoding="UTF-8"%>
<%@attribute name="title" required="true" rtexprvalue="true" %>
<%@attribute name="task" required="true" rtexprvalue="true" %>
<%@attribute name="work" required="true" rtexprvalue="true" %>
<%@attribute name="eat" required="true" rtexprvalue="true" %>
<%@attribute name="mobile" required="true" rtexprvalue="true" %>
<%@attribute name="tv" required="true" rtexprvalue="true" %>
<%@attribute name="sleep" required="true" rtexprvalue="true" %>
<html>
  <head>
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
      google.charts.load('current', {'packages':['corechart']});
      google.charts.setOnLoadCallback(drawChart);

      function drawChart() {

        var data = google.visualization.arrayToDataTable([
          ['Task', '${task}'],
          ['工作',     ${work}],
          ['飲食',      ${eat}],
          ['手機',  ${mobile}],
          ['電視', ${tv}],
          ['睡覺',    ${sleep}]
        ]);

        var options = {
          title: '${title}',
          is3D: true
        };

        var chart = new google.visualization.PieChart(document.getElementById('piechart'));

        chart.draw(data, options);
      }
    </script>
  </head>
  <body>
    <div id="piechart" style="width: 900px; height: 500px;"></div>
  </body>
</html>

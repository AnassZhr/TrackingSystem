<!DOCTYPE html>
<html>
<title>W3.CSS</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<body>

<% float f=(float) request.getAttribute("progression");%>
<div class="w3-container">

<h2>La Progression de votre dossier est:<%=f*100%>:</h2>
<p>/</p>
<p>/</p>

<div class="w3-light-grey">
  <div class="w3-container w3-green w3-center" style="width:<%=f*100%>%"><%=f*100%>%</div>
</div><br>



</div>
</body>
</html>

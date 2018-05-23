<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>Archivos</title>
</head>
<body>
<form action="./guardar.php" method="post" id="usrform">
  <br>Ruta: 
  <br><input type="text" name="nombre" required>
  <br>Contenido :
  <br><textarea name="contenido" rows="40" cols="80" required ></textarea >
  <br><br><input type="submit">
</form>


<br>
<br>
<br>
<br>
<br>
<h1>Lista de archivos</h1>
<?php
  $directorio = './archivos/';
  $ficheros1  = scandir($directorio);
  
  foreach($ficheros1 as $archivo){
    if($archivo!="." && $archivo!=".." && $archivo!=".DS_Store" && $archivo!="index.html"  && $archivo!="default.json"){
    echo "<br>";
    echo '<a href="./api.php?get='.substr($archivo, 0, -5).'" target="_blank">'.$archivo.'</a>';
    }
  }
?>
</body>
</html>


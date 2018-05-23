<?php
    $archivo = "./archivos/".$_GET['get'] . ".json";

    if (!file_exists($archivo)) {
      $archivo = "./archivos/default.json";
    }
  
    $fp = fopen($archivo, "r");
    $linea = "";
    while(!feof($fp)) {
      $linea .= fgets($fp);
    }
  
    fclose($fp);
  
    header('Content-Type: application/json');
    echo $linea;
?>
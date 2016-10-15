<?php

include 'server.php';

  $result = $conn->query("SELECT * FROM PointsLookup;");

  while ($row = $result->fetch_assoc()) {
      echo var_dump($row) . "<br>";
  }

  $result->close();
?>

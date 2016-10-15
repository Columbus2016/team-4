<?php

include 'server.php';

  $result = $conn->query("SELECT * FROM PointsLookup;");

  while ($row = mysql_fetch_array($result, MYSQL_NUM)) {
      echo $row . "<br>";
  }

  $result->close();
?>

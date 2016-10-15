<?php

include 'server.php';
include 'jsonify.php';

  $result = $conn->query("SELECT * FROM PointsLookup;");

  to_json($result);

  $conn->close();
?>

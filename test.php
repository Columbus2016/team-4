<?php

  include 'server.php';

  echo "Hello!!";

  if ($result = $conn->query("SELECT * FROM PersonalInfo;")) {
    printf("Select returned %d rows.\n", $result->num_rows);
    $result->close();
  }
  else echo "Query failed.";

?>

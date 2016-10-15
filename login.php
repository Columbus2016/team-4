<?php
    /*include 'server.php';

    $sql = "SELECT * FROM PersonalInfo;";

    $result = $conn->query($sql);

    while($row = $result->fetch_assoc()){
        $keys = array_keys($row);
        for($i = 0; $i < count($keys); $i++){
            echo $row[$keys[$i]] . " ";
        }
        echo "<br>";
    }

    $result->close();*/
    include 'server.php';
  $result = $conn->query("SELECT * FROM PointsLookup;");
  while ($row = $result->fetch_assoc()) {
	$keys = array_keys($row);
	for ($i = 0; $i < count($keys); $i++)
		echo $row[$keys[$i]] . " ";
	echo "<br>";
  }
  $result->close();
 ?>

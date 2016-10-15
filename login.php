<?php
    include 'server.php';

    $sql = "SELECT *
            FROM PersonalInfo";

    $result = $conn->query($sql);

    while($row = $result->fetch_assoc()){
        $keys = array_keys($row);
        for($i = 0; $i < count($keys); $i += 1){
            echo $row[$keys[$i]] . " ";
        }
        echo "<br>";
    }

    $conn->close();
 ?>

<?php
    include 'server.php';
    include 'jsonify.php';

    $sql = "SELECT *
            FROM PersonalInfo;";

    $result = $conn->query($sql);

    to_json($result);

    $rconn->close();
 ?>

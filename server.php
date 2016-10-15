<?php

$servername = "localhost";
$username = "JPhacker";
$password = "JPhacker";
$dbname = "codeForGood";
$port = "3306";

$conn = new mysqli($servername, $username, $password, $dbname, $port);

if ($conn->connect_error) die("Connection failed: " . $conn->connect_error);

//echo phpinfo();

?>


<?php

function to_json($result) {
  echo "[";
  $num = $result->num_rows;
  for ($i = 0; $i < $num; $i++) {
    $row = $result->fetch_assoc();
    echo "{";
    $keys = array_keys($row);
    $numCol = count($keys);
    for ($j = 0; $j < $numCol; $j++) {
        echo "\"" . $keys[$j] . "\":";
        echo "\"" . $row[$keys[$j]] . "\"";
        if ($j != $numCol - 1) echo ",";
    }
    echo "}";
    if ($i != $num - 1) echo ",";
  }
  echo "]";
}

?>

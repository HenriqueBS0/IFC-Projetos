<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="<?= public_path('bootstrap/css/bootstrap.min.css') ?>">
    <link rel="stylesheet" href="<?= public_path("awesome/css/all.css")?>">
    <link rel="stylesheet" href="<?= public_path('css/base.css')?>">
    <link rel="shortcut icon" href="<?= public_path('img/keep.svg')?>" type="image/x-icon">
    <?php
        foreach ($data['css'] as $path) {
            echo "<link rel='stylesheet' href='{$path}'>\n";
        }
    ?>
    <title>Keep</title>
</head>
<body>
<?php
    foreach ($data['js'] as $path) {
        echo "<script type='module' src='{$path}'></script>";
    }
?>
<script src="<?= public_path('bootstrap/js/bootstrap.bundle.min.js')?>"></script>
<script src="<?= public_path('bootstrap/js/bootstrap.min.js')?>"></script>
</body>
</html>
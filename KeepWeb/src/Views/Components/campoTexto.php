<?php
    $name = $data['name'];
    $id = isset($data['id']) ? $data['id'] : $name;
    $type = isset($data['type']) ? $data['type'] : 'text';
    $label = isset($data['label']) ? $data['label'] : ucfirst($name);
    $placeholder = isset($data['placeholder']) ? $data['placeholder'] : "Informe o {$name}";
?>
<div class="mb-3" id="container-<?= $id ?>">
    <label for="<?= $id ?>" class="form-label <?= $class ?>"><?= $label ?></label>
    <input type="<?= $type ?>" name="<?= $name ?>" id="<?= $id ?>" class="form-control" placeholder="<?= $placeholder ?>">
    <div id="feedback-<?= $id ?>"></div>
</div>
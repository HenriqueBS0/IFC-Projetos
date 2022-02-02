<nav class="navbar navbar-light bg-white border-bottom border-1">
    <div class="container-fluid">
        <button class="navbar-toggler d-block d-lg-none d-md-none d-sm-none" type="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvasNavbar" aria-controls="offcanvasNavbar">
            <span class="navbar-toggler-icon"></span>
        </button>
        <a class="navbar-brand">
            <img src="<?= public_path("img/keep.svg") ?>" alt="" height="30" class="d-inline-block align-text-top">
            <span>Keep</span>
        </a>
        <form id="filtro-navbar" class="w-75 d-none d-lg-flex d-md-flex d-sm-flex align-items-center">
            <?php componente('Components/filtroNotas', ['sufixo' => 'descktop']); ?>
        </form>
        <div class="btn-group">
            <button type="button" class="btn btn-light dropdown-toggle" data-bs-toggle="dropdown" data-bs-display="static" aria-expanded="false">
                <i class="fas fa-user"></i>
            </button>
            <ul class="dropdown-menu dropdown-menu-end">
                <li id="dropdown-perfil"><span class="dropdown-item" >Perfil</span></li>
                <li id="dropdown-endereco"><span class="dropdown-item" >Endereço</span></li>
                <li><a class="dropdown-item" href="<?= project_url('sair')?>">Sair</a></li>
            </ul>
        </div>
        <div class="offcanvas offcanvas-start" tabindex="-1" id="offcanvasNavbar" aria-labelledby="offcanvasNavbarLabel">
            <div class="offcanvas-header">
                <h5 class="offcanvas-title" id="offcanvasNavbarLabel">Menu</h5>
                <button type="button" class="btn-close text-reset" data-bs-dismiss="offcanvas" aria-label="Close"></button>
            </div>
            <div class="offcanvas-body">
                <form id="filtro-menu" class="d-grid gap-2">
                    <?php componente('Components/filtroNotas', ['sufixo' => 'mobile']); ?>
                </form>
                <hr>
                <nav class="nav flex-column">
                    <div id="menu-mobile-itens-container" class="d-grid gap-2">
                        <?php componente('Components/menuItems'); ?>
                    </div>
                </nav>
            </div>
        </div>
    </div>
</nav>
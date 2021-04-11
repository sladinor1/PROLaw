<template>
  <div>
    <h2>Iniciar sesión</h2>
    <p>Ingresa la siguiente información para acceder</p>
    <div class="mb-3">
        <label for="exampleInputEmail1" class="form-label">Correo eléctronico<span class="text-danger">*</span></label>
        <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Tu dirección de correo electónico">                          
    </div>
    <div class="mb-3">
        <label for="exampleInputPassword1" class="form-label">Contraseña<span class="text-danger">*</span></label>
        <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Ingresa tu contraseña">
    </div>      
    <a href="#">¿Olvidaste tu contraseña?</a>
    <div class="mb-3 form-check">
        <input type="checkbox" class="form-check-input" id="exampleCheck1">
        <label class="form-check-label" for="exampleCheck1">Recordarme</label>
    </div>
    <div class="d-grid gap-2">
        <button class="btn btn-primary" type="submit">Iniciar Sesión</button>
        <router-link to="/Register" tag="button" class="btn btn-primary" type="submit">Registrarse</router-link> 
        <div class="col-12 bg-light">
            <router-view />
        </div>
    </div>
  </div>
</template>

<script>

</script>

<style>
</style>

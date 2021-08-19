<template>
  <div>
    <div>
      <div class="nav-container ">
        <nav class="navbar navbar-dark">
          <!-- Navbar content -->
          <TabMenu :model="items" :style="{align: 'middle'}" />
          <router-view />
        </nav>
      </div>
      <div>
        
      </div>
    </div>
  <div class="home-container">
    <div class="row">
      <div class="col-xl">
        <div class="firma-container">
          <div class="row">
            <div class="col-xl"><p class="p .text-wrap"> Muñoz Tamayo y Asociados es una firma
               internacional que trabaja con clientes en más de 30 países.
               Los abogados de MTA manejan 
               transacciones con facilidad.</p></div>
            <div class="col-xl">
              <br>
              <br>
              <br>
              <img v-bind:src="image1" :style="{ width: '200px' }">
            </div>
          </div>
        </div>
      </div>
      <div class="col-xl">
        <div class="firma-container">
          <div class="row">
            <div class="col-xl"><p class="p .text-wrap">López y López, abogados, es una firma de abogados en Bogotá,
               profesionales especializados en distintas ramas del derecho, 
               evitando contratiempos en el desarrollo de sus labores administrativas y comerciales.</p></div>
            <div class="col-xl">
              <img v-bind:src="image2" :style="{ width: '200px' }">
            </div>
          </div>
        </div>
      </div>
    </div>
    <div class="row">
      <div class="col-xl">
        <div class="firma-container">
          <div class="row">
            <div class="col-xl">
              <br>
              <br>
              <img v-bind:src="image3" :style="{ width: '200px' }">
            </div>
            <div class="col-xl"><p class="p .text-wrap">Somos una firma de carácter privado, 
              conformada por profesionales altamente cualificados para prestar sus servicios 
              de asesoría y consultoría en las áreas del Derecho, las Finanzas y los Proyectos,
              a personas naturales y jurídicas, de carácter públicas y privadas.</p>
            </div>
          </div>
        </div>
      </div>
      <div class="col-xl">
        <div class="firma-container">
          <div class="row">
            <div class="col-xl">
              <br>
              <br>
              <img v-bind:src="image4" :style="{ width: '200px' }">
            </div>
            <div class="col-xl"><p class="p .text-wrap">Chapman y Asociados es la firma de 
              abogados más grande de la costa Caribe de Colombia. 
              Brindamos asesoría con los más altos estándares de calidad en el mercado 
              a empresas colombianas e internacionales.</p>
            </div>
          </div>
        </div>
      </div>
    </div>  
  </div>
  </div>
</template>

<script>
import img from'@/assets/mta.png';
import img2 from'@/assets/lopez.png';
import img3 from'@/assets/medallo.png';
import img4 from'@/assets/ch.png';
export default{
  name: 'Home',
  data (){
    return{
      image1: img,
      image2: img2,
      image3: img3,   
      image4: img4,
      display: true,
      items: [
        { label: 'Tramites', icon: '', to: '/tramites'},
        //{ label: 'Entidades', icon: '', to: '/perfil'},
        { label: 'Glosario', icon: '', to: '/glosario'},
        { label: 'Foro', icon: '', to: '/foros'},
      ]
    }
  }
}
</script>

<style scoped>
@import "https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"; 
/*@import "https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js";
@import "https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js";
@import "https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js";*/
.tabmenudemo-content {
    margin: auto;
    margin-top: 15px;
    width: 48%;
    background: rgb(255, 255, 255);
    padding: 30px;
    border-radius: 5px;
    box-shadow: 0px 0px 5px 0px #000;
}
</style>
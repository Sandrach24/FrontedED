/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/reactjs.jsx to edit this template
 */

const imagenes= document.querySelector('.img-galeria');
const imageneslight=document.querySelector('.agregar-imagen');
const contenedorLight=document.querySelector('.imagen-light');

imagenes.forEach(imagenes=>{
    imagenes.addEventListener('click',()=>{
        aparecerImagenes(imagenes.getAttribute('src'));
         });
});

const aparecerImagenes=(imagenes)=>{
    imageneslight.src=imagenes;
    contenedorLight.classlist.toggle('show');
    imageneslight.classlist.toggle('showImage');
}




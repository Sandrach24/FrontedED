/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/reactjs.jsx to edit this template
 */

const menu =document.querySelector('.menu');
const menu=document.querySelector('.menu-navegacion');

console.log(menu);

menu.addEventListener('click',()=>{
    menu.classList.toggle("spread");
    
});

        
window.addEventListener('click',e=>{ 
    if(menu.classList.contains('spread')
            && e.target !== menu && e.target!== menu){
        menu.classList.toggle("spread");
    }
});
      

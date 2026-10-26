const aboutButton = document.getElementById("cta-home");

if(aboutButton){
aboutButton.addEventListener("click" ,function() {
    window.location.href = "about.html";
});
}


const projectButton = document.getElementById("about-me-btn");
if (projectButton) {
  projectButton.addEventListener("click", function () {
    window.location.href = "projects.html";
  });
}